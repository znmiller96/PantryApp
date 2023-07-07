package com.znmiller96.pantryapi.model.request.body;

import java.util.List;

public class AddCategoryRequestBody {

    private int id;

    private List<String> categoryList;

    public AddCategoryRequestBody() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
}
