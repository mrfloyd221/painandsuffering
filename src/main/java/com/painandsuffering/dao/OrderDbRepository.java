package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public OrderDbRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order getOrderById(int id){
        Order result = jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id=?", new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapOrder(resultSet);
            }
        }, id);
        return result;
    }

    private Order mapOrder(ResultSet rs) throws SQLException{
        Order aOrder = new Order();
        aOrder.setId(rs.getInt("id"));
        aOrder.setUserId(rs.getInt("user_id"));
        aOrder.setPositionId(rs.getInt("position_Id"));
        aOrder.setComplete(rs.getBoolean("complete"));
        return aOrder;
    }
    @Override
    public List<Order> getAllOrders() {
        String sql;
        sql = "SELECT * FROM orders;";
        List<Order> listContact = jdbcTemplate.query(sql, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapOrder(rs);
            }
        });
        return listContact;
    }



    @Override
    public boolean Add(Order order) {
        String sql;
        sql = String.format("INSERT INTO orders(user_id,position_id,complete) VALUES (%d,%d,%s)" ,order.getUserId(),order.getPositionId(), order.isComplete());
        this.jdbcTemplate.update("INSERT INTO orders(user_id,position_id,complete) VALUES (?, ?, ?)" ,order.getUserId(),order.getPositionId(), order.isComplete());
        return true;
    }

    @Override
    public boolean Update(int id, Order order) {
        String sql;
        sql ="UPDATE orders SET user_id = ?,position_id = ?, complete = ? WHERE id=?;";
        this.jdbcTemplate.update(sql, order.getUserId(), order.getPositionId(), order.isComplete(), id);
        return true;

    }

    @Override
    public void DeleteById(int id) {
        String sql;
        sql = "DELETE FROM orders WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
}
