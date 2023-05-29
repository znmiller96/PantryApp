package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.request.body.AddLocationRequestBody;
import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.service.PantryPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/pantry")
public class PantryController {

    private final PantryPageService pantryPageService;

    public PantryController(PantryPageService pantryPageService) {
        this.pantryPageService = pantryPageService;

    }


    @PostMapping
    public void addPantryItem() {

    }

    //TODO addPantryItemList

    //TODO addLocation
    @PostMapping("/Location")
    public AddLocationRequestBody addLocation(@RequestBody AddLocationRequestBody location) {
        return location;
    }

    //TODO addCategory

    //TODO updatePantryItem

    //TODO updatePantryItemList

    //TODO updateLocation

    //TODO updateCategory

    //TODO deletePantryItem

    //TODO deletePantryItemList

    //TODO deleteLocation

    //TODO deleteCategory

    //TODO getPantryPage sends formatted info for the user's pantry page

    @GetMapping("/Locations")
    public List<LocationDto> getLocations(@RequestParam int id) {
        return pantryPageService.getPantryLocations(id);
    }

    @GetMapping("/Categories")
    public List<CategoryDto> getCategories(@RequestParam int id) {
        return pantryPageService.getPantryCategories(id);
    }

    @GetMapping("/Pantry")
    public List<PantryDto> getPantry(@RequestParam int id) {
        return pantryPageService.getPantryItems(id);
    }

    @GetMapping("/e")
    public Date getExpirationDate() {
        List<ExpirationDate> expirationDates = pantryPageService.getExpirationDate(1000);
        return expirationDates.get(0).getExpirationDate();
    }
}
