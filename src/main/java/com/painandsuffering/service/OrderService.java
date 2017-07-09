package com.painandsuffering.service;

import com.painandsuffering.dao.OrderDAO;
import com.painandsuffering.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrflo on 04.07.2017.
 */
@Service
public class OrderService {

    private OrderDAO orderDao;
    @Autowired
    public OrderService(OrderDAO dao){
        orderDao = dao;
    }
    public Order getOrder(int id){
        return orderDao.getOrderById(id);
    }
    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }
    public boolean createOrder(Order order){
        return orderDao.createOrder(order);
    }
    public boolean updateOrder(Order order){
        return orderDao.updateOrder(order);
    }
    public boolean deleteOrder(int id){
        return orderDao.deleteOrder(id);
    }
    public List<Order> getOrdersByUserId(int userId){
        return orderDao.getOrdersByUserId(userId);
    }
    public boolean contains(Order order){
        List<Order> list = orderDao.getAllOrders();
        for(Order o : list){
            if(o.getUser().getId() == order.getUser().getId() && o.getPosition().getId() == order.getPosition().getId() && o.isComplete() == order.isComplete())
                return true;
        }
        return false;
    }

}
