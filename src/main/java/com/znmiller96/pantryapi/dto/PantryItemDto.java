package com.znmiller96.pantryapi.dto;

import java.util.Date;

public class PantryItemDto {

    private Integer id;
    private String name;
    private String amount;
    //type could be categories like spices, pasta, rice, bread, etc...
    private String type;
    private String location;
    private Date dayAdded;
    private Date expirationDate;
}
