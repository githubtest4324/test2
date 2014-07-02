package test2.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Role {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	private String name;
	@ManyToMany(mappedBy = User.ROLES)
	private Set<User> users;

	public static final String ID = "id";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static final String NAME = "name";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static final String USERS = "users";

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
