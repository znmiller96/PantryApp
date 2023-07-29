package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dto.PantryDto;
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

    //TODO get Pantry page info

    public void addPantryItem(int userId, List<PantryDto> pantryDto) {
        pantryRepository.saveAll(pantryDto.stream()
                .map(pantryItem -> Utils.pantryDtoToDaoWithUserId(userId, pantryItem))
                .toList());
    }

    public List<PantryDto> getPantryItems(int userid) {
        return pantryRepository.findByUserId(userid)
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }

    public List<PantryDto> getPantryItemsByQuantityLevels(int userid, QuantityLevel quantityLevel) {
        return pantryRepository.findByUserIdAndAndQuantityLevelEqualsIgnoreCase(userid, quantityLevel.name())
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }

    public List<PantryDto> getPantryItemsByExpirationDate(int userid, Date expirationDate) {
        return pantryRepository.findByUserIdAndAndExpirationDate_ExpirationDateBefore(userid, expirationDate)
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }
}
