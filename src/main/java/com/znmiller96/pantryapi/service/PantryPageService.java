package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.ExpirationDateRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.util.Utils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("PantryService")
public class PantryPageService {

    private final PantryRepository pantryRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final ExpirationDateRepository expirationDateRepository;

    public PantryPageService(
            PantryRepository pantryRepository,
            LocationRepository locationRepository,
            CategoryRepository categoryRepository,
            ExpirationDateRepository expirationDateRepository) {
        this.pantryRepository = pantryRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
        this.expirationDateRepository = expirationDateRepository;
    }


    //TODO get Pantry page info

    public List<PantryDto> getPantryItems(int userid) {
        return pantryRepository.findAll()
                .stream().map(Utils::pantryDaoToDto)
                .collect(Collectors.toList());
    }

    public List<LocationDto> getPantryLocations(int userId) {
        return locationRepository.findAllByUserid(userId)
                .stream().map(Utils::locationDaoToDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDto> getPantryCategories(int userId) {
        return categoryRepository.findAllByUserid(userId)
                .stream().map(Utils::categoryDaoToDto)
                .collect(Collectors.toList());
    }

    public List<ExpirationDate> getExpirationDate(int id) {
        return expirationDateRepository.findAllById(id);
    }
}
