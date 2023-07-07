package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LocationDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {

    private final int id;
    private final String location;

    private LocationDto(Builder builder) {
        this.id = builder.id;
        this.location = builder.location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int id;
        private String location;

        public Builder withId(int id) {
            this.id = id;
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
