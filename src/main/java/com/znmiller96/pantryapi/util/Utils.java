package com.znmiller96.pantryapi.util;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dao.Location;
import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.dto.MeasurementDto;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dao.Pantry;

public class Utils {

    public static PantryDto pantryDaoToDto(Pantry pantry) {
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

        if (pantry.getExpirationDate() != null) {
            pantryBuilder.withExpirationDate(pantry.getExpirationDate().getExpirationDate());
        }
        if (pantry.getUsedDate() != null) {
            pantryBuilder.withUsedDate(pantry.getUsedDate().getUsedDate());
        }
        if (pantry.getMeasurement() != null) {
            pantryBuilder.withMeasurement(new MeasurementDto.Builder()
                    .withValue(pantry.getMeasurement().getValue())
                    .withUnit(MeasurementUnit.valueOf(pantry.getMeasurement().getUnit()))
                    .build());
        }

        return pantryBuilder.build();
    }
    public static LocationDto locationDaoToDto(Location location) {
        return new LocationDto.Builder()
                .withId(location.getId())
                .withLocation(location.getLocation())
                .build();
    }

    public static CategoryDto categoryDaoToDto(Category category) {
        return new CategoryDto.Builder()
                .withId(category.getId())
                .withCategory(category.getCategory())
                .build();
    }

    //TODO Dto To Dao methods

}
