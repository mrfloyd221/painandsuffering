package com.painandsuffering.dao;

import com.painandsuffering.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mrflo on 06.07.2017.
 */
/*public class UserHibernateRepository implements UserDAO {
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

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}*/
@Repository
@Primary
interface UserHibernateRepository extends CrudRepository<User, Integer>{

}