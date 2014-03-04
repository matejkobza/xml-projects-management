package sk.mk.web.controller;

import org.jboss.seam.security.IdentityImpl;
import sk.mk.persistence.entity.User;
import sk.mk.ejb.security.AccountManager;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * @author matejkobza
 */
@ManagedBean
@SessionScoped
@Alternative
public class IdentityBean extends IdentityImpl {

    @EJB(name = "AccountManager")
    private AccountManager accountManager;

    private User user;

    public User getUser() {
        if(this.user == null) {
            this.user = (User)super.getUser();
        }
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
