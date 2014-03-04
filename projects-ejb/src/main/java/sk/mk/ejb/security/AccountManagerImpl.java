package sk.mk.ejb.security;

import sk.mk.persistence.dao.UserDAO;
import sk.mk.persistence.entity.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("accountManager")
@Stateless
@Remote
public class AccountManagerImpl implements AccountManager {
	
	@Inject
	private UserDAO userDao;
	
	/* (non-Javadoc)
	 * @see sk.mk.ejb.security.AccountManager#find(sk.mk.persistence.entity.User)
	 */
    @Override
    public User find(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User register(User u) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

