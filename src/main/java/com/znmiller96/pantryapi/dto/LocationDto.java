package com.znmiller96.pantryapi.dto;

public class LocationDto {

    private int id;
    private String location;

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
