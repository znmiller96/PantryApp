package com.znmiller96.pantryapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private int userId;
    private String name;

    //TODO similar to expiration date have display of low amount of item
    private String quantityLevel;
    //type could be categories like spices, pasta, rice, bread, etc...
    private String category;

    //TODO location db to store all locations user has
    private String locationId;
    private Boolean favorite;
    //to store old items to process data to suggest grocery lists?
    private Boolean used;

    private Date dayAdded;
    //expiration date adn used date are in separate table because they can be null

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
