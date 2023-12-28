package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LocationDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {

    private final int locationId;
    private final String location;

    private LocationDto(Builder builder) {
        this.locationId = builder.locationId;
        this.location = builder.location;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getLocation() {
        return location;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int locationId;
        private String location;

        public Builder withLocationId(int locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public LocationDto build() {
            return new LocationDto(this);
        }
    }
}
