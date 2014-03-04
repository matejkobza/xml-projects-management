package sk.mk.web.controller;

import sk.mk.ejb.security.AccountManager;
import sk.mk.persistence.entity.User;
import sk.mk.web.core.WebApplication;
import sk.mk.web.util.PasswordUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 16:28
 */
@ManagedBean
@ViewScoped
public class RegistrationBean implements Serializable {

    private static final long serialVersionUID = 1077908288928826453L;

    @EJB(name = "AccountManager")
    private AccountManager accountManager;

    private User user;
    private String password2;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void register() {
        if (password2.equals("") || password2 == null) {
            WebApplication.getReference().addErrorMessage("Error", "Password cant be empty!");
        } else if (user.getPassword().equals(password2)) {
            user.setPassword(PasswordUtils.hash(password2));
            accountManager.register(user);
            WebApplication.getReference().addInfoMessage("Success", "User registered.");
        } else {
            WebApplication.getReference().addErrorMessage("Error", "Password does not match!");
        }
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
