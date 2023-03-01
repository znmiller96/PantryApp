package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.dto.LocationDto;
import com.znmiller96.pantryapi.model.Location;
import com.znmiller96.pantryapi.model.Pantry;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.service.PantryPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pantry")
public class PantryController {

    private final PantryRepository pantryRepository;
    private final PantryPageService pantryPageService;

    public PantryController(PantryRepository pantryRepository,
                            PantryPageService pantryPageService) {
        this.pantryRepository = pantryRepository;
        this.pantryPageService = pantryPageService;

    }

    //TODO POST add pantry list
    @PostMapping
    public void addPantryItem()
    {
        Pantry pantry = new Pantry();
        pantry.setName("test");
        pantry.setUserId(102);

        pantryRepository.save(pantry);
    }

    //TODO GET get list of pantry items
    @GetMapping
    public List<LocationDto> getPantry()
    {
        return pantryPageService.getPantryLocations();
        //return pantryRepository.findAll();
    }

    //TODO
}
