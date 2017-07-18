package com.painandsuffering.dao;

import com.painandsuffering.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.painandsuffering.model.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class OrderRepository implements OrderDAO{
    private List<Order> orders;
    public OrderRepository(){
        User jason = new User(1, "jason");
        User yurii = new User(2, "yurii");
        User alex = new User(3, "alex");
        User darkstalker = new User(4, "darkstalker");
        Product cofee = new Product(1,"cofee", 100);
        Product rolton = new Product(2,"rolton", 90);
        Product sausage = new Product(3,"sausage", 160);
        orders = new ArrayList<Order>();
        orders.add(new Order(0,jason,cofee, OrderStatus.PROCESSING));
        orders.add(new Order(1,alex,rolton, OrderStatus.ACCEPTED));
        orders.add(new Order(2,alex,sausage, OrderStatus.COMPLETE));
        orders.add(new Order(3,darkstalker,cofee, OrderStatus.COMPLETE));
        orders.add(new Order(4,yurii,cofee, OrderStatus.DENY));
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
            if(order.getProduct().getId() == positionId)
                result.add(order);
        }
        return result;
    }

    public List<Order> getCompletedOrders(){
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getStatus() == OrderStatus.COMPLETE)
                result.add(order);
        }
        return result;
    }

    public List<Order> getUnCompletedOrders(){
        List<Order> result = new ArrayList<Order>();
        for(Order order : orders){
            if(order.getStatus() != OrderStatus.COMPLETE)
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
            orders.get(id).setProduct(order.getProduct());
            orders.get(id).setUser(order.getUser());
            orders.get(id).setStatus(order.getStatus());
            return true;
        }
        return false;

    }
}
