package com.painandsuffering.controller;

import com.painandsuffering.dao.OrderDAO;
import com.painandsuffering.dao.OrderRepository;
import com.painandsuffering.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderDAO orderRepository;
    @Autowired
    OrderController(OrderDAO dao){
        orderRepository = dao;
    }
    @RequestMapping(value ="/shop/orders/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
    @RequestMapping(value ="/shop/orders/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Order>> addNewOrder(@RequestBody Order order){
        if(orderRepository.Add(order))
            return new ResponseEntity<List<Order>>(orderRepository.getAllOrders(), HttpStatus.CREATED);
        return new ResponseEntity<List<Order>>(orderRepository.getAllOrders(), HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/orders/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Order> getOrderById(@PathVariable int id){
        try{
            return new ResponseEntity<Order>(orderRepository.getOrderById(id), HttpStatus.OK);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value="/shop/orders/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Order> updateOrderById(@PathVariable int id, @RequestBody Order order){
        if(orderRepository.Update(id, order))
            return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
        return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/orders/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Order> deleteOrderById(@PathVariable int id){
        try{
            orderRepository.DeleteById(id);
            return new ResponseEntity<Order>(orderRepository.getOrderById(id), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }



    }



}
