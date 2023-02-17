package com.znmiller96.pantryapi.model;

import jakarta.persistence.*;

/**
 * Customers' locations in kitchen
 */
@Entity
public class Location {

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
    private Integer id;

    private Integer userid;
    private String location;
}
