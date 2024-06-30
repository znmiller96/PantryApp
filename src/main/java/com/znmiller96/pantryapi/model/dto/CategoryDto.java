package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CategoryDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private final String categoryId;
    private final String category;

    private CategoryDto(Builder builder) {
        this.categoryId = builder.categoryId;
        this.category = builder.category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private String categoryId;
        private String category;

        public Builder withCategoryId(String categoryId) {
            this.categoryId = categoryId;
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
