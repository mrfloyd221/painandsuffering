package com.painandsuffering.model;



import java.io.Serializable;


/**
 * Created by mrflo on 26.05.2017.
 */
public class Order{
    private int id;
    private int userId;
    private int positionId;
    private boolean complete;

    public Order(int id, int user, int position, boolean complete) {

        this.id = id;
        this.userId = user;
        this.positionId = position;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
