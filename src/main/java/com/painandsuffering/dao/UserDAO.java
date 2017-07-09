package com.painandsuffering.dao;
import com.painandsuffering.model.User;
import java.util.List;
/**
 * Created by mrflo on 28.05.2017.
 */
public interface UserDAO {
    User getUserByName(String Name);
    User getUserById(int id);
    List<User> getAllUsers();
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
