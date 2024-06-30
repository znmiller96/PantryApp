package com.znmiller96.pantryapi.model.request.body;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AddLocationRequestBody {

    private int userId;

    private List<String> locationList;

    public AddLocationRequestBody() {
    }

    //TODO builder class
}
