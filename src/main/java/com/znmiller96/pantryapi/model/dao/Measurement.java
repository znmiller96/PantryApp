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

@Entity
@JsonDeserialize(builder = Measurement.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @Column(name = "pantryItemId")
    private int pantryItemId;
    private float value;
    private String unit;

    @OneToOne
    @JoinColumn(name = "pantryItemId")
    @MapsId
    private Pantry pantry;

    public Measurement() {
    }

    private Measurement(Builder builder) {
        this.pantryItemId = builder.pantryItemId;
        this.value = builder.value;
        this.unit = builder.unit;
        this.pantry = builder.pantry;
    }

    public int getPantryItemId() {
        return pantryItemId;
    }

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private float value;
        private String unit;
        private int pantryItemId;
        private Pantry pantry;

        public Builder withValue(float value) {
            this.value = value;
            return this;
        }

        public Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder withPantryItemId(int pantryItemId) {
            this.pantryItemId = pantryItemId;
            return this;
        }

        public Builder withPantry(Pantry pantry) {
            this.pantry = pantry;
            return this;
        }

        public Measurement build() {
            return new Measurement(this);
        }
    }
}
