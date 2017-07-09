package com.painandsuffering.dao;

import com.painandsuffering.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.painandsuffering.model.Position;
import com.painandsuffering.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class OrderRepository implements OrderDAO{
    private List<Order> orders;
    public OrderRepository(){
        User jason = new User(1, "jason", new ArrayList<Order>());
        User yurii = new User(2, "yurii", new ArrayList<Order>());
        User alex = new User(3, "alex", new ArrayList<Order>());
        User darkstalker = new User(4, "darkstalker", new ArrayList<Order>());
        Position cofee = new Position(1,"cofee", 100);
        Position rolton = new Position(2,"rolton", 90);
        Position sausage = new Position(3,"sausage", 160);
        orders = new ArrayList<Order>();
        orders.add(new Order(0,jason,cofee, false));
        orders.add(new Order(1,alex,rolton, false));
        orders.add(new Order(2,alex,sausage, false));
        orders.add(new Order(3,darkstalker,cofee, false));
        orders.add(new Order(4,yurii,cofee, true));
    }
    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }
    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getUser().getId() == userId)
                result.add(order);
        }
        return result;
    }


    public List<Order> getOrdersByPositionId(int positionId) {
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getPosition().getId() == positionId)
                result.add(order);
        }
        return result;
    }

    public List<Order> getCompletedOrders(){
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.isComplete())
                result.add(order);
        }
        return result;
    }

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
    @Override
    public boolean createOrder(Order order){
        return orders.add(order);
    }
    @Override
    public boolean deleteOrder(int id){

        orders.remove(id);
        return true;
    }
    @Override
    public boolean updateOrder( Order order){
        int id = order.getId();
        if(orders.get(id) != null){
            orders.get(id).setPosition(order.getPosition());
            orders.get(id).setUser(order.getUser());
            orders.get(id).setComplete(order.isComplete());
            return true;
        }
        return false;

    }
}
