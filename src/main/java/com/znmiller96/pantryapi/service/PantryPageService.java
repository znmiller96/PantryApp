package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dao.Location;
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

    public void addPantryLocation(int userid, List<String> locations) {
        locationRepository.saveAll(
                locations.stream()
                .map(x -> new Location.Builder().withUserid(userid).withLocation(x).build())
                .toList());
    }

    public void addPantryCategory(int userid, List<String> categories) {
        categoryRepository.saveAll(
                categories.stream()
                .map(x -> new Category.Builder()
                        .withUserid(userid)
                        .withCategory(x)
                        .build())
                .toList());
    }

    public void addPantryItem(List<PantryDto> pantryDto) {

    }

    public List<PantryDto> getPantryItems(int userid) {
        return pantryRepository.findAll()
                .stream().map(Utils::pantryDaoToDto)
                .toList();
    }

    public List<LocationDto> getPantryLocations(int userId) {
        return locationRepository.findAllByUserid(userId)
                .stream().map(Utils::locationDaoToDto)
                .toList();
    }

    public List<CategoryDto> getPantryCategories(int userId) {
        return categoryRepository.findAllByUserid(userId)
                .stream().map(Utils::categoryDaoToDto)
                .toList();
    }

    public List<ExpirationDate> getExpirationDate(int id) {
        return expirationDateRepository.findAllById(id);
    }
}
