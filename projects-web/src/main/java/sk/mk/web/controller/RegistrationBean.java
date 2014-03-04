package sk.mk.web.controller;

import sk.mk.ejb.security.AccountManager;

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

}
