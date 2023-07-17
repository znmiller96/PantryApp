package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dao.Location;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.util.Utils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("LocationService")
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation(int userId, List<String> locations) {
        locationRepository.saveAll(
                locations.stream()
                        .map(location -> new Location.Builder()
                                .withUserId(userId)
                                .withLocation(location)
                                .build())
                        .toList());
    }

    public List<LocationDto> getLocations(int userId) {
        return locationRepository.findByUserId(userId)
                .stream().map(Utils::locationDaoToDto)
                .toList();
    }
}
