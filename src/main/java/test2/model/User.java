package test2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import test2.interceptors.InterceptorEntity;
import test2.interceptors.InterceptorProxy;
import test2.utils.ModelUtils;

@Entity
public class User implements Serializable, InterceptorEntity, ITraceable {
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(Employee.class.getName());
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	private String username;
	private String password;
	private String name;
	@ManyToMany(targetEntity = Role.class)
	private Set<Role> roles;
	@Embedded
	private TraceInformation traceable;

	@Transient
	private UserComputed computed;

	public User() {
		computed = new UserComputed();
	}

	public void onUpdate(InterceptorProxy proxy) {
		ModelUtils.onUpdate(proxy, this);
	}

	public void onCreate(InterceptorProxy proxy) {
		TraceInformation tr = new TraceInformation();
		tr.setCreationDate(new Date());
		proxy.changeProperty("traceable", tr);
	}

	public static final String ID = "id";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static final String USER_NAME = "username";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static final String PASSWORD = "password";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static final String NAME = "name";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static final String TRACEABLE = "traceable";

	public TraceInformation getTraceable() {
		return traceable;
	}

	public void setTraceable(TraceInformation traceable) {
		this.traceable = traceable;
	}

	public static final String ROLES = "roles";

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserComputed getComputed() {
		return computed;
	}

}
