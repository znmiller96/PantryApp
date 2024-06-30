package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dao.Measurement;
import com.znmiller96.pantryapi.model.dao.Pantry;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dto.PantryMainPageDto;
import com.znmiller96.pantryapi.repository.ExpirationDateRepository;
import com.znmiller96.pantryapi.repository.MeasurementRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.util.QuantityLevel;
import com.znmiller96.pantryapi.util.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component("PantryService")
public class PantryPageService {

    Logger logger = LoggerFactory.getLogger(PantryPageService.class);

    private final PantryRepository pantryRepository;
    private final ExpirationDateRepository expirationDateRepository;
    private final MeasurementRepository measurementRepository;

    private final CategoryService categoryService;

    private final LocationService locationService;

    public PantryMainPageDto getPantryMainPage(int userId) {
        //TODO Add a color value for each pantry item based on status (ex. close to expiration, expired, low quantity, etc.)
        logger.info("Getting home page for user:" + userId);
        return new PantryMainPageDto.Builder()
                .withLocations(locationService.getLocations(userId))
                .withCategories(categoryService.getCategories(userId))
                .withPantry(pantryRepository.findByUserId(userId)
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

        Pantry pantryItem = Utils.pantryDtoToDaoWithoutExpDateMeasurement(userId, pantryDto);

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

        pantryRepository.save(pantryItem);
    }

    public List<PantryDto> getPantryItems(int userid) {
        logger.info("Getting pantry for user:" + userid);
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

    public void deletePantryItem(String pantryItemId, String reasonDelete, boolean addToGroceryList) {
        pantryRepository.deleteById(pantryItemId);
        //TODO send reasonDelete and pantryItem to api for analyzing
    }
}
