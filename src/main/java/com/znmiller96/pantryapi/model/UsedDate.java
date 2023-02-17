package com.znmiller96.pantryapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class UsedDate {

    //this is same as pantry id
    @Id
    private Integer id;

    private Date usedDate;
}
