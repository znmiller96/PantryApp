package com.znmiller96.pantryapi.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 * Customers' personalized categories for sorting food
 */
@Entity
@JsonDeserialize(builder = Category.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    @Id
//    @SequenceGenerator(
//            name = "category_id_sequence",
//            sequenceName = "category_id_sequence",
//            allocationSize = 1,
//            initialValue = 1000
//    )
    @GenericGenerator(
            name = "category_id_generator",
            strategy = "com.znmiller96.pantryapi.util.IdGenerator"
    )
    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
            generator = "category_id_generator"
    )
//    @Column(name = "id")
    private String categoryId;
    private int userId;
    private String category;

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.userId = builder.userId;
        this.category = builder.category;
    }

    public Category() {}

    public String getCategoryId() {
        return categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private String categoryId;
        private int userId;
        private String category;
        public Builder withCategoryId(String categoryId) {
            this.categoryId = categoryId;
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

        public Category build() {
            return new Category(this);
        }
    }
}
