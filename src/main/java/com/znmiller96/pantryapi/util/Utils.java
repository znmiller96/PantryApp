package com.znmiller96.pantryapi.util;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dao.Location;
import com.znmiller96.pantryapi.model.dao.Measurement;
import com.znmiller96.pantryapi.model.dao.UsedDate;
import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.model.dto.LocationDto;
import com.znmiller96.pantryapi.model.dto.MeasurementDto;
import com.znmiller96.pantryapi.model.dto.PantryDto;
import com.znmiller96.pantryapi.model.dao.Pantry;
import com.znmiller96.pantryapi.model.request.body.PantryItemRequestBody;

import java.util.Date;

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

    public static PantryDto pantryItemRequestBodyToDto(PantryItemRequestBody pantryItemRequestBody) {
        PantryDto.Builder pantryBuilder = new PantryDto.Builder()
                .withId(pantryItemRequestBody.getPantryItemId())
                .withName(pantryItemRequestBody.getName())
                .withQuantityLevel(pantryItemRequestBody.getQuantityLevel())
                .withFavorite(pantryItemRequestBody.getFavorite())
                .withUsed(pantryItemRequestBody.getUsed())
                .withDayAdded(pantryItemRequestBody.getDayAdded())
                .withCategory(new CategoryDto.Builder()
                        .withId(pantryItemRequestBody.getCategory().getId())
                        .withCategory(pantryItemRequestBody.getCategory().getCategory())
                        .build())
                .withLocation(new LocationDto.Builder()
                        .withId(pantryItemRequestBody.getLocation().getId())
                        .withLocation(pantryItemRequestBody.getLocation().getLocation())
                        .build());

        if (pantryItemRequestBody.getExpirationDate() != null) {
            pantryBuilder.withExpirationDate(pantryItemRequestBody.getExpirationDate());
        }
        if (pantryItemRequestBody.getUsedDate() != null) {
            pantryBuilder.withUsedDate(pantryItemRequestBody.getUsedDate());
        }
        if (pantryItemRequestBody.getMeasurement() != null) {
            pantryBuilder.withMeasurement(pantryItemRequestBody.getMeasurement());
        }

        return pantryBuilder.build();
    }

    public static Pantry pantryDtoToDaoWithUserId(int userId, PantryDto pantryDto) {
        Pantry pantryItem = new Pantry.Builder()
                .withUserId(userId)
                .withName(pantryDto.getName())
                .withQuantityLevel(pantryDto.getQuantityLevel().name())
                .withFavorite(pantryDto.getFavorite())
                //if value exist use given value, otherwise use default
                .withUsed(pantryDto.getUsed() != null ? pantryDto.getUsed() : false)
                .withDayAdded(pantryDto.getDayAdded() != null ? pantryDto.getDayAdded() : new Date())
                .withCategory(categoryDtoToDao(pantryDto.getCategory()))
                .withLocation(locationDtoToDao(pantryDto.getLocation()))
                .build();

        if (pantryDto.getExpirationDate() != null) {
            ExpirationDate expirationDate = new ExpirationDate.Builder()
                    .withExpirationDate(pantryDto.getExpirationDate())
                    .build();

            pantryItem.setExpirationDate(expirationDate);
            expirationDate.setPantry(pantryItem);
        }

        if (pantryDto.getUsedDate() != null) {
            UsedDate usedDate = new UsedDate.Builder()
                    .withUsedDate(pantryDto.getUsedDate())
                    .build();

            pantryItem.setUsedDate(usedDate);
            usedDate.setPantry(pantryItem);
        }

        if (pantryDto.getMeasurement() != null) {
            Measurement measurement = new Measurement.Builder()
                    .withValue(pantryDto.getMeasurement().getValue())
                    .withUnit(pantryDto.getMeasurement().getUnit().name())
                    .build();

            pantryItem.setMeasurement(measurement);
            measurement.setPantry(pantryItem);
        }

        return pantryItem;
    }

    public static Category categoryDtoToDao(CategoryDto categoryDto) {
        return new Category.Builder()
                .withId(categoryDto.getId())
                .withCategory(categoryDto.getCategory())
                .build();
    }

    public static Location locationDtoToDao(LocationDto locationDto) {
        return new Location.Builder()
                .withId(locationDto.getId())
                .withLocation(locationDto.getLocation())
                .build();
    }

    //TODO Dto To Dao methods

}
