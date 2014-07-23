package test2.services.security;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test2.model.User;
import test2.utils.CriteriaUtils;

@Service
public class UserService {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SecurityService securityService;

	void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUsers(String name, String username) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		if (!StringUtils.isEmpty(name)) {
			crit.add(Restrictions.like(User.NAME, "%" + name + "%"));
		}
		if (!StringUtils.isEmpty(username)) {
			crit.add(Restrictions.like(User.USERNAME, "%" + username + "%"));
		}

		return crit.list();
	}

	@Transactional
	public User getById(String id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq(User.ID, id));

		return (User) CriteriaUtils.findSingleResult(crit);
	}

	@Transactional
	public User getByUsername(String username) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq(User.USERNAME, username));

		return (User) CriteriaUtils.findSingleResult(crit);
	}

	@Transactional
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public static class CannotDeleteOwnUser extends Exception {
		private static final long serialVersionUID = 1L;
	}

	@Transactional
	public void delete(String id, UserPrincipal principal) throws CannotDeleteOwnUser {
		securityService.allowed(principal.getUser().getUsername(), "admin");
		if (StringUtils.equals(id, principal.getUser().getId())) {
			throw new CannotDeleteOwnUser();
		}
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	// TODO: seems it starts a new transaction even if multiple users are deleted. Example: delete multiple users and one of them is the current users. Some will be deleted, until it gets to the current user.
	@Transactional
	public void delete(String[] ids, UserPrincipal principal) throws CannotDeleteOwnUser {
		for (String id : ids) {
			delete(id, principal);
		}
	}

	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

}
