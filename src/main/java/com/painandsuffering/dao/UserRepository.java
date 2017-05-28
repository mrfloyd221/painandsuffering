package com.painandsuffering.dao;

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
        users.add(new User(0,"Jhon"));
        users.add(new User(1,"Peter"));
        users.add(new User(2,"David"));
        users.add(new User(3,"Pepe"));
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
}
