package com.alc.alcchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ahmed on 05/03/2017.
 */

public class UsersResponse {

    //This helps to serialised the JSON Object received into a java object

    @SerializedName("total_count")
    private int total_count;
    @SerializedName("incomplete_results")
    private boolean incomplete_results;
    @SerializedName("items")
    private List<User> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
