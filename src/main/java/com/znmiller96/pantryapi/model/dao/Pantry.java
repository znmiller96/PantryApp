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
    private int id;
    //user this item belongs to

    //TODO remove capital letters to use built in queries
    private int userid;
    private String name;
    private String quantitylevel;
    private Boolean favorite;
    //to store old items to process data to suggest grocery lists?
    private Boolean used;
    private Date dayadded;
    //expiration date adn used date are in separate table because they can be null


    //type could be categories like spices, pasta, rice, bread, etc...
    @ManyToOne
    private Category category;
    @ManyToOne
    private Location location;

    @OneToOne(mappedBy = "pantry", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ExpirationDate expirationdate;

    @OneToOne(mappedBy = "pantry", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UsedDate useddate;

    @OneToOne(mappedBy = "pantry", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Measurement measurement;


    public Pantry() {}

    public Pantry(Builder builder) {
        this.userid = builder.userId;
        this.name = builder.name;
        this.quantitylevel = builder.quantityLevel;
        this.favorite = builder.favorite;
        this.used = builder.used;
        this.dayadded = builder.dayAdded;
        this.category = builder.category;
        this.location = builder.location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantityLevel() {
        return quantitylevel;
    }

    public void setQuantityLevel(String quantityLevel) {
        this.quantitylevel = quantityLevel;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Date getDayAdded() {
        return dayadded;
    }

    public void setDayAdded(Date dayAdded) {
        this.dayadded = dayAdded;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location locationId) {
        this.location = locationId;
    }

    public ExpirationDate getExpirationDate() {
        return expirationdate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationdate = expirationDate;
    }

    public UsedDate getUsedDate() {
        return useddate;
    }

    public void setUsedDate(UsedDate usedDate) {
        this.useddate = usedDate;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public static class Builder {

        private int userId;
        private String name;
        private String quantityLevel;
        private Boolean favorite;
        private Boolean used;
        private Date dayAdded;
        private Category category;
        private Location location;

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

        public Builder withUsed(Boolean used) {
            this.used = used;
            return this;
        }

        public Builder withDayAdded(Date dayAdded) {
            this.dayAdded = dayAdded;
            return this;
        }

        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public Pantry build() {
            return new Pantry(this);
        }
    }
}
