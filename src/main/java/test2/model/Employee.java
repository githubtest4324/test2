package test2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import test2.interceptors.InterceptorEntity;
import test2.interceptors.InterceptorProxy;



@Entity
public class Employee implements Serializable, InterceptorEntity {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(Employee.class.getName());
	private static final long	serialVersionUID	= 1L;
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String name;
	private Integer age;
	@ManyToOne(targetEntity=Department.class)
	private Department department;
	
	@Embedded
	private TraceInformation traceable;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	
	public TraceInformation getTraceable() {
		return traceable;
	}
	public void setTraceable(TraceInformation traceable) {
		this.traceable = traceable;
	}
	public boolean beforeSave() {
		logger.info("EMPLOYEE ON SAVE");
		if(this.traceable==null){
			this.traceable = new TraceInformation();
		}
		this.traceable.setLastUpdateDate(new Date());
		return true;
	}
	public void onUpdate(InterceptorProxy proxy) {
		proxy.changeProperty("lastUpdateDate", new Date());
	}
	public void onCreate(InterceptorProxy proxy) {
		TraceInformation tr = new TraceInformation();
		tr.setCreationDate(new Date());
		proxy.changeProperty("traceable", tr);
	}
	
	
}
