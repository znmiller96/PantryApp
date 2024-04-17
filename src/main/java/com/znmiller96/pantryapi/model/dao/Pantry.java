package com.znmiller96.pantryapi.model.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;

import java.util.Date;

@Entity
public class Pantry {

    @Id
    @SequenceGenerator(
            name = "pantry_id_sequence",
            sequenceName = "pantry_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pantry_id_sequence"
    )
    private int pantryItemId;
    private int userId;
    private String name;
    private String quantityLevel;
    private Boolean favorite;
    private Date dayAdded;
    private String category;
    private String location;

    @OneToOne(mappedBy = "pantry", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ExpirationDate expirationDate;

    @OneToOne(mappedBy = "pantry", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Measurement measurement;


    public Pantry() {}

    public Pantry(Builder builder) {
        this.pantryItemId = builder.pantryItemId;
        this.userId = builder.userId;
        this.name = builder.name;
        this.quantityLevel = builder.quantityLevel;
        this.favorite = builder.favorite;
        this.dayAdded = builder.dayAdded;
        this.category = builder.category;
        this.location = builder.location;
    }

    public int getPantryItemId() {
        return pantryItemId;
    }

    public void setPantryItemId(int id) {
        this.pantryItemId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantityLevel() {
        return quantityLevel;
    }

    public void setQuantityLevel(String quantityLevel) {
        this.quantityLevel = quantityLevel;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Date getDayAdded() {
        return dayAdded;
    }

    public void setDayAdded(Date dayAdded) {
        this.dayAdded = dayAdded;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categoryId) {
        this.category = categoryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String locationId) {
        this.location = locationId;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public static class Builder {

        private int pantryItemId;
        private int userId;
        private String name;
        private String quantityLevel;
        private Boolean favorite;
        private Date dayAdded;
        private String category;
        private String location;

        public Builder withPantryItemId(int pantryItemId) {
            this.pantryItemId = pantryItemId;
            return this;
        }

        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withQuantityLevel(String quantityLevel) {
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

        public Pantry build() {
            return new Pantry(this);
        }
    }
}
