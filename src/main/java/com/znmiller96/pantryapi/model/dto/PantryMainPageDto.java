package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;


@JsonDeserialize(builder = PantryDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PantryMainPageDto {

    private final List<CategoryDto> categories;

    private final List<LocationDto> locations;

    private final List<PantryDto> pantry;

    public PantryMainPageDto(Builder builder) {
        this.categories = builder.categories;
        this.locations = builder.locations;
        this.pantry = builder.pantry;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public List<LocationDto> getLocations() {
        return locations;
    }

    public List<PantryDto> getPantry() {
        return pantry;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private List<CategoryDto> categories;

        private List<LocationDto> locations;

        private List<PantryDto> pantry;

        public Builder withCategories(List<CategoryDto> categories) {
            this.categories = categories;
            return this;
        }

        public Builder withLocations(List<LocationDto> locations) {
            this.locations = locations;
            return this;
        }

        public Builder withPantry(List<PantryDto> pantry) {
            this.pantry = pantry;
            return this;
        }

        public PantryMainPageDto build() {
            return new PantryMainPageDto(this);
        }
    }



}
