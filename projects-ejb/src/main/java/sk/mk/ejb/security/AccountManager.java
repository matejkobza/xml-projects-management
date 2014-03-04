package sk.mk.ejb.security;

import sk.mk.persistence.entity.User;

import java.util.List;

public interface AccountManager {

    /**
     * Looking for user? Here's your solution
     * @param username - this is ID of user
     * @return User user
     */
    public User find(String username);

    /**
     * Will add user to the system
     * @param u user to be registered
     * @return User registered user
     */
    public void register(User u);

    /**
     * how about to use infinispan here
     * @return
     */
    public List<User> list();
}