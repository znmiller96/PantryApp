package com.znmiller96.pantryapi.model.dao;

import jakarta.persistence.*;

import java.util.List;

/**
 * Customers' locations in kitchen
 */
@Entity
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

    private int userid;
    private String location;

    @OneToMany(mappedBy = "location")
    private List<Pantry> pantry;

    public Location(int userid, String location) {
        this.userid = userid;
        this.location = location;
    }

    public Location() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
