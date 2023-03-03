package com.znmiller96.pantryapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Measurement {

    @Id
    private int id;
    private int measurement;
    private String measurementUnit;
}
