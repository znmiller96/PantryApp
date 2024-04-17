package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.znmiller96.pantryapi.util.QuantityLevel;
import jakarta.annotation.Nullable;

import java.util.Date;

@JsonDeserialize(builder = PantryDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PantryDto {

    private final int pantryItemId;
    private final String name;
    private final QuantityLevel quantityLevel;
    private final Boolean favorite;
    @JsonFormat(pattern="yyyy-MM-dd")
    private final Date dayAdded;
    //type could be categories like spices, pasta, rice, bread, etc...
    private final String category;
    private final String location;
    @Nullable
    @JsonFormat(pattern="yyyy-MM-dd")
    private final Date expirationDate;
    @Nullable
    private final MeasurementDto measurement;

    private PantryDto(Builder builder) {
        this.pantryItemId = builder.pantryItemId;
        this.name = builder.name;;
        this.quantityLevel = builder.quantityLevel;
        this.favorite = builder.favorite;
        this.dayAdded = builder.dayAdded;
        this.category = builder.category;
        this.location = builder.location;
        this.expirationDate = builder.expirationDate;
        this.measurement = builder.measurement;
    }

    public int getPantryItemId() {
        return pantryItemId;
    }

    public String getName() {
        return name;
    }

    public QuantityLevel getQuantityLevel() {
        return quantityLevel;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public Date getDayAdded() {
        return dayAdded;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public MeasurementDto getMeasurement() {
        return measurement;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int pantryItemId;
        private String name;
        private QuantityLevel quantityLevel;
        private Boolean favorite;
        private Date dayAdded;
        private String category;
        private String location;
        private Date expirationDate;
        private MeasurementDto measurement;

        public Builder withPantryItemId(int pantryItemId) {
            this.pantryItemId = pantryItemId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withQuantityLevel(QuantityLevel quantityLevel) {
            this.quantityLevel = quantityLevel;
            return this;
        }

        public Builder withFavorite(Boolean favorite) {
            this.favorite = favorite;
            return this;
        }

        public Builder withDayAdded(Date dayAdded) {
            this.dayAdded = dayAdded;
            return this;
        }

        public Builder withCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder withMeasurement(MeasurementDto measurement) {
            this.measurement = measurement;
            return this;
        }

        public PantryDto build() {
            return new PantryDto(this);
        }
    }
}
