package com.painandsuffering.dao;
import com.painandsuffering.model.Order;
import java.util.List;
/**
 * Created by mrflo on 28.05.2017.
 */
public interface OrderDAO {
    Order getOrderById(int id);
    List<Order> getAllOrders();
    boolean createOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(int id);
    List<Order>  getOrdersByUserId(int userId);
}
