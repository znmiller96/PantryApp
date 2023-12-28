package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dao.Measurement;
import com.znmiller96.pantryapi.model.dao.Pantry;
import com.znmiller96.pantryapi.model.dao.UsedDate;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dto.PantryMainPageDto;
import com.znmiller96.pantryapi.repository.ExpirationDateRepository;
import com.znmiller96.pantryapi.repository.MeasurementRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.repository.UsedDateRepository;
import com.znmiller96.pantryapi.util.QuantityLevel;
import com.znmiller96.pantryapi.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Component("PantryService")
public class PantryPageService {

    private final PantryRepository pantryRepository;
    private final ExpirationDateRepository expirationDateRepository;
    private final MeasurementRepository measurementRepository;
    private final UsedDateRepository usedDateRepository;

    private final CategoryService categoryService;

    private final LocationService locationService;

    //TODO get Pantry page info

    public PantryMainPageDto getPantryMainPage(int userId) {
        return new PantryMainPageDto.Builder()
                .withLocations(locationService.getLocations(userId))
                .withCategories(categoryService.getCategories(userId))
                .withPantry(pantryRepository.findByUserIdAndUsedFalse(userId)
                        .stream().map(Utils::pantryDaoToDto)
                        .toList())
                .build();
    }

    public void addPantryItem(int userId, List<PantryDto> pantryDto) {
        pantryRepository.saveAll(pantryDto.stream()
                .map(pantryItem -> Utils.pantryDtoToDaoWithoutItemId(userId, pantryItem))
                .toList());
    }

    public void updatePantryItem(int userId, PantryDto pantryDto) {

        Pantry pantryItem = Utils.pantryDtoToDaoWithoutExpDateMeasurementUsedDate(userId, pantryDto);
        //pantryRepository.save(pantryItem);

        if (pantryDto.getExpirationDate() != null) {
            if (expirationDateRepository.existsById(pantryDto.getPantryItemId())) {
                expirationDateRepository.save(Utils.pantryDtoToExpirationDateDaoWithoutPantry(pantryDto));
            }
            else {
                ExpirationDate expirationDate = new ExpirationDate.Builder()
                        .withExpirationDate(pantryDto.getExpirationDate())
                        .build();

                pantryItem.setExpirationDate(expirationDate);
                expirationDate.setPantry(pantryItem);
            }
        }

        if (pantryDto.getMeasurement() != null) {
            if (measurementRepository.existsById(pantryDto.getPantryItemId())) {
                measurementRepository.save(Utils.pantryDtoToMeasurementDaoWithoutPantry(pantryDto));
            }
            else {
                Measurement measurement = new Measurement.Builder()
                        .withValue(pantryDto.getMeasurement().getValue())
                        .withUnit(pantryDto.getMeasurement().getUnit().name())
                        .build();

                pantryItem.setMeasurement(measurement);
                measurement.setPantry(pantryItem);
            }
        }

        if (pantryDto.getUsedDate() != null) {
            if (usedDateRepository.existsById(pantryDto.getPantryItemId())) {
                usedDateRepository.save(Utils.pantryDtoToUsedDateDaoWithoutPantry(pantryDto));
            }
            else {
                UsedDate usedDate = new UsedDate.Builder()
                        .withUsedDate(pantryDto.getUsedDate())
                        .build();

                pantryItem.setUsedDate(usedDate);
                usedDate.setPantry(pantryItem);
            }
        }

        pantryRepository.save(pantryItem);
    }

    public List<PantryDto> getPantryItems(int userid) {
        return pantryRepository.findByUserId(userid)
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }

    public List<PantryDto> getPantryItemsByQuantityLevels(int userid, QuantityLevel quantityLevel) {
        return pantryRepository.findByUserIdAndQuantityLevelEqualsIgnoreCase(userid, quantityLevel.name())
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }

    public List<PantryDto> getPantryItemsByExpirationDate(int userid, Date expirationDate) {
        return pantryRepository.findByUserIdAndExpirationDate_ExpirationDateBefore(userid, expirationDate)
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }
}
