package com.znmiller96.pantryapi.model.request.body;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AddCategoryRequestBody {

    private int userId;

    private List<String> categoryList;

    public AddCategoryRequestBody() {
    }

    //TODO builder class
}
