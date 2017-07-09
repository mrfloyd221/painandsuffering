package com.painandsuffering.controller;

import com.painandsuffering.dao.OrderDAO;
import com.painandsuffering.model.Order;
import com.painandsuffering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    @Autowired
    OrderController(OrderService service){
        orderService = service;
    }
    @RequestMapping(value ="/shop/orders/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @RequestMapping(value ="/shop/orders/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Order>> addNewOrder(@RequestBody Order order){
        if(orderService.createOrder(order))
            return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.CREATED);
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/orders/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Order> getOrderById(@PathVariable int id){
        try{
            return new ResponseEntity<Order>(orderService.getOrder(id), HttpStatus.OK);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value="/shop/orders/", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Order> updateOrderById(@RequestBody Order order){
        if(orderService.updateOrder(order))
            return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
        return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value="/shop/orders/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResponseEntity removeOrderById(@PathVariable int id){
        orderService.deleteOrder(id);
        return new ResponseEntity(HttpStatus.OK);
    }








}
