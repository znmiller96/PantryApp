package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.dto.CategoryDto;
import com.znmiller96.pantryapi.dto.LocationDto;
import com.znmiller96.pantryapi.dto.PantryDto;
import com.znmiller96.pantryapi.model.ExpirationDate;
import com.znmiller96.pantryapi.model.Pantry;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.ExpirationDateRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.util.QuantityLevel;
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
                .stream().map(this::pantryToDto)
                .collect(Collectors.toList());
    }

    private PantryDto pantryToDto(Pantry pantry) {
        PantryDto.Builder pantryBuilder = new PantryDto.Builder()
                .withId(pantry.getId())
                .withName(pantry.getName())
                .withQuantityLevel(QuantityLevel.valueOf(pantry.getQuantityLevel()))
                .withFavorite(pantry.getFavorite())
                .withUsed(pantry.getUsed())
                .withDayAdded(pantry.getDayAdded())
                .withCategory(new CategoryDto.Builder()
                        .withId(pantry.getCategory().getId())
                        .withCategory(pantry.getCategory().getCategory())
                        .build())
                .withLocation(new LocationDto.Builder()
                        .withId(pantry.getLocation().getId())
                        .withLocation(pantry.getLocation().getLocation())
                        .build());

        if(pantry.getExpirationDate() != null) {
            pantryBuilder.withExpirationDate(pantry.getExpirationDate().getExpirationDate());
        }
        //TODO used date and measurement logic

        return pantryBuilder.build();
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

    public List<ExpirationDate> getExpirationDate(int id) {
        return expirationDateRepository.findAllById(id);
    }
}
