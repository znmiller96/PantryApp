package com.znmiller96.pantryapi.model.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Measurement {

    //this is same as pantry id
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
    @Column(name = "id")
    private int id;
    private float value;
    private String unit;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Pantry pantry;

    public Measurement() {
    }

    public Measurement(float value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Measurement(int id, float value, String unit, Pantry pantry) {
        this.id = id;
        this.value = value;
        this.unit = unit;
        this.pantry = pantry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }
}
