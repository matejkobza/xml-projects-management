package sk.mk.persistence.dao;

import sk.mk.persistence.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:25
 */
public interface UserDAO {

    public User findUserByUsername(String username);
}
