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

import java.util.Date;

@Entity
@JsonDeserialize(builder = UsedDate.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsedDate {

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
    private Date useddate;

    @OneToOne
    @JoinColumn(name = "pantryItemId")
    @MapsId
    private Pantry pantry;

    public UsedDate() {
    }

    private UsedDate(Builder builder) {
        this.pantryItemId = builder.pantryItemId;
        this.useddate = builder.usedDate;
        this.pantry = builder.pantry;
    }

    public int getPantryItemId() {
        return pantryItemId;
    }

    public Date getUsedDate() {
        return useddate;
    }

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private Date usedDate;
        private int pantryItemId;
        private Pantry pantry;

        public Builder withUsedDate(Date usedDate) {
            this.usedDate = usedDate;
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

        public UsedDate build() {
            return new UsedDate(this);
        }
    }
}
