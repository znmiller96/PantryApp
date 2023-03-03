package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.dto.CategoryDto;
import com.znmiller96.pantryapi.dto.LocationDto;
import com.znmiller96.pantryapi.model.Pantry;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("PantryService")
public class PantryPageService {

    private final PantryRepository pantryRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;

    public PantryPageService(
            PantryRepository pantryRepository,
            LocationRepository locationRepository,
            CategoryRepository categoryRepository) {
        this.pantryRepository = pantryRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
    }


    //TODO get Pantry page info

    public List<Pantry> getPantryItems(int userid) {
        return pantryRepository.findAll();
    }

    public List<LocationDto> getPantryLocations(int userId) {
        return locationRepository.findAllByUserid(userId)
                .stream().map(x ->
                        new LocationDto.Builder()
                                .withId(x.getId())
                                .withLocation(x.getLocation())
                                .build())
                .collect(Collectors.toList());
    }

    public List<CategoryDto> getPantryCategories(int userId) {
        return categoryRepository.findAllByUserid(userId)
                .stream().map(x ->
                        new CategoryDto.Builder()
                                .withId(x.getId())
                                .withCategory(x.getCategory())
                                .build())
                .collect(Collectors.toList());
    }
}
