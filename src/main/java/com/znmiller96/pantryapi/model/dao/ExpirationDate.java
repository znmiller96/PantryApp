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

import java.util.Date;

@Entity
public class ExpirationDate {

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
    private Date expirationDate;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Pantry pantry;

    public ExpirationDate() {
    }

    public ExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ExpirationDate(int id, Date expirationDate, Pantry pantry) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.pantry = pantry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }
}
