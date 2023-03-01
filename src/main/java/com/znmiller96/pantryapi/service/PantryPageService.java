package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.dto.LocationDto;
import com.znmiller96.pantryapi.model.Location;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("PantryService")
public class PantryPageService {

    private final PantryRepository pantryRepository;
    private final LocationRepository locationRepository;

    public PantryPageService(
            PantryRepository pantryRepository,
            LocationRepository locationRepository) {
        this.pantryRepository = pantryRepository;
        this.locationRepository = locationRepository;
    }


    //TODO get Pantry page info

    //TODO get list of locations

    public List<LocationDto> getPantryLocations() {
        return locationRepository.findAllByUserid(1001).stream().map(x -> new LocationDto.Builder()
                                                                                    .withId(x.getId())
                                                                                    .withLocation(x.getLocation())
                                                                                    .build())
                                                                                        .collect(Collectors.toList());
    }
}
