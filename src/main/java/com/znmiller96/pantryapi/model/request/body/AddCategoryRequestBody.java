package com.znmiller96.pantryapi.model.request.body;

import java.util.List;

public class AddCategoryRequestBody {

    private int userId;

    private List<String> categoryList;

    public AddCategoryRequestBody() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    //TODO builder class
}
