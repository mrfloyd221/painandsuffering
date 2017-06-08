package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by mrflo on 08.06.2017.
 */
@Primary
@Repository
public class OrderDbRepository implements OrderDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDbRepository(DataSource dataSource) {
       try{
           Class.forName("org.postgresql.Driver");
       }catch (Exception ex){
           System.out.println(ex.getMessage());
       }

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
        String sql;
        sql = "SELECT * FROM orders;";
        List<Order> listContact = jdbcTemplate.query(sql, new RowMapper<Order>() {

            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order aOrder = new Order();

                aOrder.setId(rs.getInt("id"));
                aOrder.setUserId(rs.getInt("user_id"));
                aOrder.setPositionId(rs.getInt("position_Id"));
                aOrder.setComplete(rs.getBoolean("complete"));


                return aOrder;
            }

        });

        return listContact;
    }

    @Override
    public List<Order> getCompletedOrders() {
        return null;
    }

    @Override
    public List<Order> getUnCompletedOrders() {
        return null;
    }

    @Override
    public boolean Add(Order order) {
        return false;
    }

    @Override
    public boolean Update(int id, Order order) {
        return false;
    }

    @Override
    public void DeleteById(int id) {

    }
}
