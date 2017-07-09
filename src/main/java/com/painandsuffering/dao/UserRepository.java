package com.painandsuffering.dao;

import com.painandsuffering.model.Order;
import com.painandsuffering.model.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class UserRepository implements UserDAO{
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<User>();
        users.add(new User(0,"Jhon", new ArrayList<Order>()));
        users.add(new User(1,"Peter", new ArrayList<Order>()));
        users.add(new User(2,"David", new ArrayList<Order>()));
        users.add(new User(3,"Pepe", new ArrayList<Order>()));
    }

    @Override
    public User getUserByName(String name) {
        for(User user : users){
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
    public void Add(User user){
        users.add(user);
    }
    public void DeleteById(int id){
        users.remove(id);
    }
    public void DeleteByName(String name){
        for(User user : users){
            if(user.getName().equals(name))
                users.remove(user);
        }
    }

    @Override
    public boolean createUser(User user) {

            users.add(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if(users.contains(user)){
            users.add(user.getId(), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        users.remove(id);
        return true;
    }
}
