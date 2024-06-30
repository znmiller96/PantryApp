package com.znmiller96.pantryapi.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 * Customers' locations in kitchen
 */
@Entity
@JsonDeserialize(builder = Location.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @Id
//    @SequenceGenerator(
//            name = "location_id_sequence",
//            sequenceName = "location_id_sequence",
//            allocationSize = 1,
//            initialValue = 1000
//    )
    @GenericGenerator(
            name = "location_id_generator",
            strategy = "com.znmiller96.pantryapi.util.IdGenerator"
    )
    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
            generator = "location_id_generator"
    )
    private String locationId;
    private int userId;
    private String location;

    public Location(Builder builder) {
        this.locationId = builder.locationId;
        this.userId = builder.userId;
        this.location = builder.location;
    }

    public Location() {}

    public String getLocationId() {
        return locationId;
    }

    public int getUserId() {
        return userId;
    }

    public String getLocation() {
        return location;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int userId;
        private String location;
        private String locationId;
        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withLocationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
