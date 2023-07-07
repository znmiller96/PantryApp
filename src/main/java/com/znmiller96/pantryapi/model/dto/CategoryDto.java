package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CategoryDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private final int id;
    private final String category;

    private CategoryDto(Builder builder) {
        this.id = builder.id;
        this.category = builder.category;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private int id;
        private String category;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withCategory(String category) {
            this.category = category;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(this);
        }
    }
}
