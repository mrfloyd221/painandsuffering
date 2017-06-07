package com.painandsuffering.dao;

import com.painandsuffering.model.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class OrderRepository implements OrderDAO{
    private List<Order> orders;
    public OrderRepository(){
        orders = new ArrayList<Order>();
        orders.add(new Order(0,1,1, false));
        orders.add(new Order(1,2,1, false));
        orders.add(new Order(2,1,2, false));
        orders.add(new Order(3,3,1, false));
        orders.add(new Order(4,0,3, true));
    }
    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }
    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getUserId() == userId)
                result.add(order);
        }
        return result;
    }

    @Override
    public List<Order> getOrdersByPositionId(int positionId) {
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getPositionId() == positionId)
                result.add(order);
        }
        return result;
    }
    @Override
    public List<Order> getCompletedOrders(){
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.isComplete())
                result.add(order);
        }
        return result;
    }
    @Override
    public List<Order> getUnCompletedOrders(){
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(!order.isComplete())
                result.add(order);
        }
        return result;
    }
    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
    public boolean Add(Order order){
        return orders.add(order);
    }
    public void DeleteById(int id){

        orders.remove(id);
    }
    public boolean Update(int id, Order order){
        if(orders.get(id) != null){
            orders.get(id).setPositionId(order.getPositionId());
            orders.get(id).setUserId(order.getUserId());
            orders.get(id).setComplete(order.isComplete());
            return true;
        }
        return false;

    }
}
