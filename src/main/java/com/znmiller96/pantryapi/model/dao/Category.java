package com.znmiller96.pantryapi.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import java.util.List;

/**
 * Customers' personalized categories for sorting food
 */
@Entity
@JsonDeserialize(builder = Category.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )
    private int id;
    private int userId;
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Pantry> pantry;

    private Category(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.category = builder.category;
        this.pantry = builder.pantry;
    }

    public Category() {}

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int id;
        private int userId;
        private String category;
        private List<Pantry> pantry;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder withCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder withPantry(List<Pantry> pantry) {
            this.pantry = pantry;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
