package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.dto.CategoryDto;
import com.znmiller96.pantryapi.dto.LocationDto;
import com.znmiller96.pantryapi.dto.PantryDto;
import com.znmiller96.pantryapi.model.ExpirationDate;
import com.znmiller96.pantryapi.service.PantryPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //TODO POST add pantry list
    @PostMapping
    public void addPantryItem()
    {

    }

    //TODO GET get list of pantry items
    @GetMapping("/l")
    public List<LocationDto> getLocations() {
        return pantryPageService.getPantryLocations(1001);
    }

    @GetMapping("/c")
    public List<CategoryDto> getCategories() {
        return pantryPageService.getPantryCategories(1001);
    }

    @GetMapping("/p")
    public List<PantryDto> getPantry() {
        return pantryPageService.getPantryItems(1001);
    }

    @GetMapping("/e")
    public Date getExpirationDate() {
        List<ExpirationDate> expirationDates = pantryPageService.getExpirationDate(1000);
        return expirationDates.get(0).getExpirationDate();
    }
}
