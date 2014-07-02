package test2.services;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test2.model.Department;
import test2.model.Employee;
import test2.model.TraceInformation;

@Service
public class Test1Service {
    @Autowired
    private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getEmployees(){
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List<Employee> list = crit.list();
		return list;
	}
	
	@Transactional
	public void createEmployee(String name, int age, Department d){
		Employee e = new Employee();
		e.setName(name);
		e.setAge(age);
//		e.setTraceable(new Traceable());
//		e.getTraceable().setLastUpdateDate(new Date());
		
		if(d!=null){
			e.setDepartment(d);
		}
		sessionFactory.getCurrentSession().save(e);
	}
	
}
