package com.painandsuffering.dao;
import com.painandsuffering.model.Order;
import java.util.List;
/**
 * Created by mrflo on 28.05.2017.
 */
public interface OrderDAO {
    Order getOrderById(int id);
    List<Order> getOrdersByUserId(int userId);
    List<Order> getOrdersByPositionId(int positionId);
    List<Order> getAllOrders();
    List<Order> getCompletedOrders();
    List<Order> getUnCompletedOrders();
    boolean Add(Order order);
    boolean Update(int id, Order order);
    void DeleteById(int id);
}
