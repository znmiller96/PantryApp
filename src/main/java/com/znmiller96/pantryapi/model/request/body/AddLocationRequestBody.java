package com.znmiller96.pantryapi.model.request.body;

import java.util.List;

public class AddLocationRequestBody {

    private int id;

    private List<String> locationList;

    public AddLocationRequestBody() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
    }
}
