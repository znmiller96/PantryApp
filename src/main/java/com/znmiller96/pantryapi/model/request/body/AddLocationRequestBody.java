package com.znmiller96.pantryapi.model.request.body;

import java.util.List;

public class AddLocationRequestBody {

    private int userId;

    private List<String> locationList;

    public AddLocationRequestBody() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
    }

    //TODO builder class
}
