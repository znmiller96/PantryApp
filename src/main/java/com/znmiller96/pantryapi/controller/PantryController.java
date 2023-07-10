package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.request.body.AddCategoryRequestBody;
import com.znmiller96.pantryapi.model.request.body.AddLocationRequestBody;
import com.znmiller96.pantryapi.model.request.body.PantryItemRequestBody;
import com.znmiller96.pantryapi.service.PantryPageService;
import com.znmiller96.pantryapi.util.Utils;
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

    @PostMapping("/add/location")
    public void addLocation(@RequestBody AddLocationRequestBody addLocationRequestBody) {
        pantryPageService.addPantryLocation(addLocationRequestBody.getUserId(), addLocationRequestBody.getLocationList());
        //return addLocationRequestBody;
    }

    @PostMapping("/add/category")
    public void addCategory(@RequestBody AddCategoryRequestBody addCategoryRequestBody) {
        pantryPageService.addPantryCategory(addCategoryRequestBody.getUserId(), addCategoryRequestBody.getCategoryList());
    }

    @PostMapping("/add/pantryItem")
    public void addPantryItem(@RequestParam int userId, @RequestBody List<PantryItemRequestBody> pantryItemRequestBody) {
        List<PantryDto> pantryList = pantryItemRequestBody.stream().map(Utils::pantryItemRequestBodyToDto).toList();
        pantryPageService.addPantryItem(userId, pantryList);
    }

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
    public List<LocationDto> getLocations(@RequestParam int userId) {
        return pantryPageService.getPantryLocations(userId);
    }

    @GetMapping("/Categories")
    public List<CategoryDto> getCategories(@RequestParam int userId) {
        return pantryPageService.getPantryCategories(userId);
    }

    @GetMapping("/Pantry")
    public List<PantryDto> getPantry(@RequestParam int userId) {
        return pantryPageService.getPantryItems(userId);
    }

    @GetMapping("/e")
    public Date getExpirationDate() {
        List<ExpirationDate> expirationDates = pantryPageService.getExpirationDate(1000);
        return expirationDates.get(0).getExpirationDate();
    }
}
