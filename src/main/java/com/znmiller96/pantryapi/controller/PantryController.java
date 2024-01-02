package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dto.PantryMainPageDto;
import com.znmiller96.pantryapi.model.request.body.PantryItemRequestBody;
import com.znmiller96.pantryapi.service.PantryPageService;
import com.znmiller96.pantryapi.util.QuantityLevel;
import com.znmiller96.pantryapi.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/pantry")
public class PantryController {

    private final PantryPageService pantryPageService;

    @PostMapping("/add/pantryItem")
    public void addPantryItem(@RequestParam int userId, @RequestBody List<PantryItemRequestBody> pantryItemRequestBody) {
        List<PantryDto> pantryList = pantryItemRequestBody.stream().map(Utils::pantryItemRequestBodyToDto).toList();
        pantryPageService.addPantryItem(userId, pantryList);
    }

    @PostMapping("/update/pantryItem")
    public void updatePantryItem(@RequestParam int userId, @RequestBody PantryItemRequestBody pantryItemRequestBody) {
        PantryDto pantryDto = Utils.pantryItemRequestBodyToDto(pantryItemRequestBody);
        pantryPageService.updatePantryItem(userId, pantryDto);
    }

    @GetMapping("/Pantry/MainPage")
    public PantryMainPageDto getPantryMainPage(@RequestParam int userId) {
        return pantryPageService.getPantryMainPage(userId);
    }

    @GetMapping("/Pantry")
    public List<PantryDto> getPantry(@RequestParam int userId) {
        return pantryPageService.getPantryItems(userId);
    }

    @GetMapping("/Pantry/Quantity")
    public List<PantryDto> getPantryByQuantity(@RequestParam int userId, @RequestParam String quantityLevel) {
        return pantryPageService.getPantryItemsByQuantityLevels(userId, QuantityLevel.valueOf(quantityLevel));
    }

    @GetMapping("/Pantry/ExpirationDate")
    public List<PantryDto> getPantryByExpirationDate(@RequestParam int userId, @RequestParam String expirationDate) throws ParseException {
        Date formattedExpirationDate =new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
        return pantryPageService.getPantryItemsByExpirationDate(userId, formattedExpirationDate);
    }

    @PostMapping("/delete/pantryItem")
    public void deletePantryItem(@RequestParam int pantryItemId, @RequestParam String reasonDelete, @RequestParam boolean addToGroceryList) {
        pantryPageService.deletePantryItem(pantryItemId, reasonDelete, addToGroceryList);
    }
}
