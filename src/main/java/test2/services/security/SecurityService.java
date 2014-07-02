package test2.services.security;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test2.model.Role;
import test2.model.User;

@Service
public class SecurityService {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Returns true if current user is part of role.
	 */
	@Transactional
	public boolean hasRole(String username, String roleName) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.createCriteria(User.ROLES).add(Restrictions.eq(Role.NAME, roleName));
		crit.add(Restrictions.eq(User.USER_NAME, username));
		@SuppressWarnings("unchecked")
		List<User> list = crit.list();
		if (list.size() == 1) {
			return true;
		} else {
			return false;
		}

	}
}
