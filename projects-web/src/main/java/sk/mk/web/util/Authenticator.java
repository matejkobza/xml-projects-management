package sk.mk.web.util;

import org.jboss.seam.security.BaseAuthenticator;
import org.jboss.seam.security.Credentials;
import org.picketlink.idm.impl.api.PasswordCredential;
import sk.mk.web.core.WebApplication;
import sk.mk.persistence.entity.User;
import sk.mk.ejb.security.AccountManager;

import javax.ejb.EJB;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 6/20/13
 * Time: 7:09 PM
 *
 * Extension to SEAM Security framework. We would rather use good working practice than reveal wheel again.
 */
public class Authenticator extends BaseAuthenticator implements org.jboss.seam.security.Authenticator {

    @EJB(name = "AccountManager")
    private AccountManager accountManager;

    @Inject
    private Credentials credentials;

    private User user;

    /**
     * basic authentication for our small application
     */
    @Override
    public void authenticate() {
        User tmpUser = accountManager.find(credentials.getUsername());
        if (tmpUser == null) {
            WebApplication.getReference().addErrorMessage("Login service", "Login failed. No such user.");
            setStatus(AuthenticationStatus.FAILURE);
            return;
        }
        if (!(credentials.getCredential() instanceof PasswordCredential)) {
            WebApplication.getReference().addErrorMessage("Login service", "Internal application error. Please contact administrator.");
            setStatus(AuthenticationStatus.FAILURE);
            return;
        }
        String pHash = PasswordUtils.hash(((PasswordCredential) credentials.getCredential()).getValue());
        if (tmpUser.getPassword().equals(pHash)) {
            setStatus(AuthenticationStatus.SUCCESS);
            setUser(tmpUser);
        } else {
            WebApplication.getReference().addErrorMessage("Login service", "wrong password.<br />Form Hash:" + pHash + "<br />DB Hash:" + tmpUser.getPassword());
        }
    }

    @Override
    public void postAuthenticate() {
        // todo log event - user has authenticated succesfully (whois)
        //this.authenticated = true;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
