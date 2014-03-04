package sk.mk.persistence.dao;

import sk.mk.persistence.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:25
 */
public interface UserDAO {

    public User findUserByUsername(String username);

    public void create(User u);

    public List<User> listAll();
}
