package com.painandsuffering.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.painandsuffering.controller.Views;

import java.io.Serializable;

/**
 * Created by mrflo on 26.05.2017.
 */
public class Position{
    @JsonView(Views.Public.class)
    private int id;
    @JsonView(Views.Public.class)
    private String name;

    public Position(){}
    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
