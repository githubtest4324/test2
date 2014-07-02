package test2.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test2.model.Ord;

@Service
public class OrdService {
    @Autowired
    private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Ord> getOrders(){
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Ord.class);
		List<Ord> list = crit.list();
		return list;
	}
	
	@Transactional
	public void createOrder(String referenceNo){
		Ord ord = new Ord();
		ord.setReferenceNo(referenceNo);
		sessionFactory.getCurrentSession().save(ord);
	}
	
}
