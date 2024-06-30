package com.znmiller96.pantryapi.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@JsonDeserialize(builder = ExpirationDate.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpirationDate {

    //this is same as pantry id
    @Id
//    @SequenceGenerator(
//            name = "pantry_id_sequence",
//            sequenceName = "pantry_id_sequence",
//            allocationSize = 1,
//            initialValue = 1000
//    )
    @GenericGenerator(
            name = "pantry_id_generator",
            strategy = "com.znmiller96.pantryapi.util.IdGenerator"
    )
    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
            generator = "pantry_id_generator"
    )
    @Column(name = "pantryItemId")
    private String pantryItemId;
    private Date expirationDate;
    @OneToOne
    @JoinColumn(name = "pantryItemId")
    @MapsId
    private Pantry pantry;

    public ExpirationDate() {
    }

    private ExpirationDate(Builder builder) {
        this.pantryItemId = builder.pantryItemId;
        this.expirationDate = builder.expirationDate;
        this.pantry = builder.pantry;
    }

    public String getPantryItemId() {
        return pantryItemId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Pantry getPantry() {
        return pantry;
    }

    //Need to keep this set method
    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private Date expirationDate;
        private String pantryItemId;
        private Pantry pantry;

        public Builder withExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder withPantryItemId(String pantryItemId) {
            this.pantryItemId = pantryItemId;
            return this;
        }

        public Builder withPantry(Pantry pantry) {
            this.pantry = pantry;
            return this;
        }

        public ExpirationDate build() {
            return new ExpirationDate(this);
        }
    }
}
