package sk.mk.ejb.security;

import sk.mk.persistence.dao.UserDAO;
import sk.mk.persistence.entity.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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
    public void register(User u) {
        userDao.create(u);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> list() {
        return userDao.listAll();
    }
}

