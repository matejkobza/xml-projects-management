package sk.mk.persistence.dao;

import sk.mk.persistence.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:34
 */
public class UserDAOImpl implements UserDAO {

    private List<User> users = new ArrayList<User>();

    /**
     * This is strongly against Kerckhoffs's principle (http://en.wikipedia.org/wiki/Kerckhoffs's_principle)
     *
     * Dummy credentials initializer
     */
    public UserDAOImpl() {
        User u = new User();
        u.setUsername("admin");
        u.setName("Dummy User");
        u.setPassword("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
        users.add(u);
        u = new User();
        u.setUsername("tutuc");
        u.setName("Matej Kobza");
        u.setPassword("649790ab6cdf30c39c34736da3c9bc7269b2652236b50a363e022cf88bc618e4");
        users.add(u);
    }

    @Override
    public User findUserByUsername(String username) {
        User u = new User();
        u.setUsername(username);
        int index = this.users.indexOf(u);
        if (index == -1) {
            return null;
        }
        return this.users.get(this.users.indexOf(u));
    }

    @Override
    public void create(User u) {
        this.users.add(u);
    }

    @Override
    public List<User> listAll() {
        return this.users;
    }
}
