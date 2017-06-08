package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by mrflo on 08.06.2017.
 */
@Primary
@Component
public class OrderDbRepository implements OrderDAO{

    private final JdbcTemplate jdbcTemplate;
    private ArrayList<Order> orders;
    @Autowired
    public OrderDbRepository() {
        String url = "jdbc:postgresql://http://192.168.99.100:32774/";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByPositionId(int positionId) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getCompletedOrders() {
        return null;
    }

    @Override
    public List<Order> getUnCompletedOrders() {
        return null;
    }

}
