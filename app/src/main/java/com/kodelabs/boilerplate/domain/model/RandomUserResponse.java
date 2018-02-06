package com.kodelabs.boilerplate.domain.model;

import java.util.List;

/**
 * Created by jsivianes on 5/2/18.
 */

public class RandomUserResponse {

    private List<User> results;
    private Info info;

    public RandomUserResponse() {
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}