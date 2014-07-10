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

	public static class AccessDeniedException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public AccessDeniedException(String message) {
			super(message);
		}
	}

	/**
	 * Tells whether username is allowed to perform actions as roleName.
	 * 
	 * @throws AccessDeniedException
	 *             If user is not allowed.
	 */
	@Transactional
	public void allowed(String username, String roleName) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.createCriteria(User.ROLES).add(Restrictions.eq(Role.NAME, roleName));
		crit.add(Restrictions.eq(User.USERNAME, username));
		@SuppressWarnings("unchecked")
		List<User> list = crit.list();
		if (list.size() == 1) {
			return;
		} else {
			throw new AccessDeniedException(String.format("User %s cannot acces functionality in role %s.", username, roleName));
		}

	}
}
