package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import com.painandsuffering.model.Position;
import com.painandsuffering.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Created by mrflo on 08.06.2017.
 */

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
        aOrder.setUser(((User)rs.getObject("userId")));
        aOrder.setPosition((Position)rs.getObject("positionId"));
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
    public boolean createOrder(Order order) {
        this.jdbcTemplate.update("INSERT INTO orders(user_id,position_id,complete) VALUES (?, ?, ?)" ,order.getUser().getId(),order.getPosition().getId(), order.isComplete());
        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        String sql;
        sql ="UPDATE orders SET user_id = ?,position_id = ?, complete = ? WHERE id=?;";
        this.jdbcTemplate.update(sql, order.getUser().getId(), order.getPosition().getId(), order.isComplete(), order.getId());
        return true;

    }

    @Override
    public boolean deleteOrder(int id) {
        String sql;
        sql = "DELETE FROM orders WHERE id=?;";
        jdbcTemplate.update(sql, id);
        return true;
    }
    @Override
    public List<Order> getOrdersByUserId(int userId){
        List<Order> lisrOrders = jdbcTemplate.query("SELECT * FROM orders WHERE userId=?", new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapOrder(rs);
            }
        });
        return lisrOrders;
    }
}
