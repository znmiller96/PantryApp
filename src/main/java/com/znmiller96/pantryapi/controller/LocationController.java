package com.znmiller96.pantryapi.controller;

import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.request.body.AddLocationRequestBody;
import com.znmiller96.pantryapi.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/location")
public class LocationController {

    private final LocationService locationService;

    //TODO update and delete

    @PostMapping("/add")
    public void addLocation(@RequestBody AddLocationRequestBody addLocationRequestBody) {
        locationService.addLocation(addLocationRequestBody.getUserId(), addLocationRequestBody.getLocationList());
    }

    @GetMapping("/get")
    public List<LocationDto> getLocations(@RequestParam int userId) {
        return locationService.getLocations(userId);
    }
}
