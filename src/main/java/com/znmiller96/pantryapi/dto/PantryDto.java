package com.znmiller96.pantryapi.dto;

import com.znmiller96.pantryapi.util.QuantityLevel;

import java.util.Date;

public class PantryDto {

    private int id;
    private String name;
    private String amount;
    private QuantityLevel quantityLevel;
    //type could be categories like spices, pasta, rice, bread, etc...
    private String type;
    private String location;
    private Date dayAdded;
    private Date expirationDate;
}
