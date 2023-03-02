package com.znmiller96.pantryapi.dto;

public class CategoryDto {

    private int id;
    private String category;

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
