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
    @Column(name = "id")
    private int id;
    private Date usedDate;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Pantry pantry;

    public UsedDate() {
    }

    private UsedDate(Builder builder) {
        this.id = builder.id;
        this.usedDate = builder.usedDate;
        this.pantry = builder.pantry;
    }

    public int getId() {
        return id;
    }

    public Date getUsedDate() {
        return usedDate;
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
        private int id;
        private Pantry pantry;

        public Builder withUsedDate(Date usedDate) {
            this.usedDate = usedDate;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
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
