package test2.services.security;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test2.model.User;

@Service
public class LoginService {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public boolean isValidLogin(String username, String password) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq(User.USER_NAME, username)).add(Restrictions.eq(User.PASSWORD, password));
		List<User> list = crit.list();
		if (list.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

}
