package sk.mk.web.controller;

import sk.mk.ejb.security.AccountManager;
import sk.mk.persistence.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 19:54
 */
@ManagedBean
@ViewScoped
public class HomeBean implements Serializable {

    private static final long serialVersionUID = -1434424510456252777L;

    @EJB(name = "accountManager")
    private AccountManager accountManager;

    private List<User> users;

    @PostConstruct
    public void init() {
        this.users = accountManager.list();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
