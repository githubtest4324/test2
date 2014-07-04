package test2.services.security;

import java.util.List;

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

	void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> listUsers(String critName, String critUsername) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		if (critName != null) {
			crit.add(Restrictions.like(User.NAME, "%" + critName + "%"));
		}
		if (critUsername != null) {
			crit.add(Restrictions.like(User.USER_NAME, "%" + critUsername + "%"));
		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUser(String id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq(User.ID, id));

		return (List<User>) CriteriaUtils.findSingleResult(crit);
	}

}
