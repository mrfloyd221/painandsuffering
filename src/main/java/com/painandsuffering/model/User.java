package com.painandsuffering.model;

/**
 * Created by mrflo on 26.05.2017.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class User{
    private Integer id;
    private String name;
    private List<Integer> orders;
    public User(int id, String name){
        this.id = id;
       this.name = name;
        orders= new ArrayList<Integer>();
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAllOrdersId(){
        return orders;
    }

}
