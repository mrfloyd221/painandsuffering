package com.painandsuffering.model;

import java.io.Serializable;

/**
 * Created by mrflo on 26.05.2017.
 */
public class Position implements Serializable{
    private int id;
    private String name;

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
    @Override
    public String toString(){
        return"{\"id\":" + this.id + ",\"name\":"+this.name+"}";

    }
}
