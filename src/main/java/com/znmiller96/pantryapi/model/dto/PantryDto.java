package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.znmiller96.pantryapi.util.QuantityLevel;
import jakarta.annotation.Nullable;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PantryDto {

    private int id;
    private String name;
    private QuantityLevel quantityLevel;
    private Boolean favorite;
    private Boolean used;
    private Date dayAdded;
    //type could be categories like spices, pasta, rice, bread, etc...
    private CategoryDto category;
    private LocationDto location;
    @Nullable
    private Date expirationDate;
    @Nullable
    private Date usedDate;
    @Nullable
    private MeasurementDto measurement;

    private PantryDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;;
        this.quantityLevel = builder.quantityLevel;
        this.favorite = builder.favorite;
        this.used = builder.used;
        this.dayAdded = builder.dayAdded;
        this.category = builder.category;
        this.location = builder.location;
        this.expirationDate = builder.expirationDate;
        this.usedDate = builder.usedDate;
        this.measurement = builder.measurement;
    }

    public int getId() {
        return id;
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

    public Boolean getUsed() {
        return used;
    }

    public Date getDayAdded() {
        return dayAdded;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public LocationDto getLocation() {
        return location;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getUsedDate() {
        return usedDate;
    }

    public MeasurementDto getMeasurement() {
        return measurement;
    }

    public static class Builder {

        private int id;
        private String name;
        private QuantityLevel quantityLevel;
        private Boolean favorite;
        private Boolean used;
        private Date dayAdded;
        private CategoryDto category;
        private LocationDto location;
        private Date expirationDate;
        private Date usedDate;
        private MeasurementDto measurement;

        public Builder withId(int id) {
            this.id = id;
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

        public Builder withUsed(Boolean used) {
            this.used = used;
            return this;
        }

        public Builder withDayAdded(Date dayAdded) {
            this.dayAdded = dayAdded;
            return this;
        }

        public Builder withCategory(CategoryDto category) {
            this.category = category;
            return this;
        }

        public Builder withLocation(LocationDto location) {
            this.location = location;
            return this;
        }

        public Builder withExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder withUsedDate(Date usedDate) {
            this.usedDate = usedDate;
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
