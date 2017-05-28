package com.painandsuffering.dao;

import com.painandsuffering.model.User;

import java.util.List;
import org.springframework.stereotype.Repository;
/**
 * Created by mrflo on 28.05.2017.
 */
@Repository
public class UserRepository implements UserDAO{
    @Override
    public User getUserByName(String Name) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
