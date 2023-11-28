package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dto.PantryMainPageDto;
import com.znmiller96.pantryapi.repository.PantryRepository;
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
                .map(pantryItem -> Utils.pantryDtoToDaoWithUserId(userId, pantryItem))
                .toList());
    }

    public void updatePantryItem(int userId, PantryDto pantryDto) {
        pantryRepository.save(Utils.pantryDtoToDaoWithUserId(userId, pantryDto));
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
