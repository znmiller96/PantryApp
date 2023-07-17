package com.znmiller96.pantryapi.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

import java.util.List;

/**
 * Customers' locations in kitchen
 */
@Entity
@JsonDeserialize(builder = Location.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @Id
    @SequenceGenerator(
            name = "location_id_sequence",
            sequenceName = "location_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "location_id_sequence"
    )
    private int id;

    private int userId;
    private String location;

    @OneToMany(mappedBy = "location")
    private List<Pantry> pantry;

    public Location(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.location = builder.location;
        this.pantry = builder.pantry;
    }

    public Location() {}

    public int getId() {
        return id;
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
        private int id;
        private List<Pantry> pantry;

        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPantry(List<Pantry> pantry) {
            this.pantry = pantry;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
