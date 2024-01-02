package com.znmiller96.pantryapi.util;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dao.Location;
import com.znmiller96.pantryapi.model.dao.Measurement;
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
                .withPantryItemId(pantry.getPantryItemId())
                .withName(pantry.getName())
                .withQuantityLevel(QuantityLevel.valueOf(pantry.getQuantityLevel()))
                .withFavorite(pantry.getFavorite())
                .withDayAdded(pantry.getDayAdded())
                .withCategory(new CategoryDto.Builder()
                        .withCategoryId(pantry.getCategory().getCategoryId())
                        .withCategory(pantry.getCategory().getCategory())
                        .build())
                .withLocation(new LocationDto.Builder()
                        .withLocationId(pantry.getLocation().getLocationId())
                        .withLocation(pantry.getLocation().getLocation())
                        .build());

        if (pantry.getExpirationDate() != null) {
            pantryBuilder.withExpirationDate(pantry.getExpirationDate().getExpirationDate());
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
                .withLocationId(location.getLocationId())
                .withLocation(location.getLocation())
                .build();
    }

    public static CategoryDto categoryDaoToDto(Category category) {
        return new CategoryDto.Builder()
                .withCategoryId(category.getCategoryId())
                .withCategory(category.getCategory())
                .build();
    }

    public static PantryDto pantryItemRequestBodyToDto(PantryItemRequestBody pantryItemRequestBody) {
        PantryDto.Builder pantryBuilder = new PantryDto.Builder()
                .withPantryItemId(pantryItemRequestBody.getPantryItemId())
                .withName(pantryItemRequestBody.getName())
                .withQuantityLevel(pantryItemRequestBody.getQuantityLevel())
                .withFavorite(pantryItemRequestBody.getFavorite())
                .withDayAdded(pantryItemRequestBody.getDayAdded())
                .withCategory(new CategoryDto.Builder()
                        .withCategoryId(pantryItemRequestBody.getCategory().getCategoryId())
                        .withCategory(pantryItemRequestBody.getCategory().getCategory())
                        .build())
                .withLocation(new LocationDto.Builder()
                        .withLocationId(pantryItemRequestBody.getLocation().getLocationId())
                        .withLocation(pantryItemRequestBody.getLocation().getLocation())
                        .build());

        if (pantryItemRequestBody.getExpirationDate() != null) {
            pantryBuilder.withExpirationDate(pantryItemRequestBody.getExpirationDate());
        }
        if (pantryItemRequestBody.getMeasurement() != null) {
            pantryBuilder.withMeasurement(pantryItemRequestBody.getMeasurement());
        }

        return pantryBuilder.build();
    }

    public static Pantry pantryDtoToDaoWithoutItemId(int userId, PantryDto pantryDto) {
        Pantry pantryItem = new Pantry.Builder()
                .withUserId(userId)
                .withName(pantryDto.getName())
                .withQuantityLevel(pantryDto.getQuantityLevel().name())
                .withFavorite(pantryDto.getFavorite())
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

    public static Pantry pantryDtoToDaoWithoutExpDateMeasurement(int userId, PantryDto pantryDto) {

        return new Pantry.Builder()
                .withPantryItemId(pantryDto.getPantryItemId())
                .withUserId(userId)
                .withName(pantryDto.getName())
                .withQuantityLevel(pantryDto.getQuantityLevel().name())
                .withFavorite(pantryDto.getFavorite())
                .withDayAdded(pantryDto.getDayAdded() != null ? pantryDto.getDayAdded() : new Date())
                .withCategory(categoryDtoToDao(pantryDto.getCategory()))
                .withLocation(locationDtoToDao(pantryDto.getLocation()))
                .build();
    }

    public static ExpirationDate pantryDtoToExpirationDateDaoWithoutPantry(PantryDto pantryDto) {

        return new ExpirationDate.Builder()
                .withPantryItemId(pantryDto.getPantryItemId())
                .withExpirationDate(pantryDto.getExpirationDate())
                .build();
    }

    public static Measurement pantryDtoToMeasurementDaoWithoutPantry(PantryDto pantryDto) {

        return new Measurement.Builder()
                .withPantryItemId(pantryDto.getPantryItemId())
                .withValue(pantryDto.getMeasurement().getValue())
                .withUnit(pantryDto.getMeasurement().getUnit().name())
                .build();
    }

    public static Category categoryDtoToDao(CategoryDto categoryDto) {
        return new Category.Builder()
                .withCategoryId(categoryDto.getCategoryId())
                .withCategory(categoryDto.getCategory())
                .build();
    }

    public static Location locationDtoToDao(LocationDto locationDto) {
        return new Location.Builder()
                .withLocationId(locationDto.getLocationId())
                .withLocation(locationDto.getLocation())
                .build();
    }

}
