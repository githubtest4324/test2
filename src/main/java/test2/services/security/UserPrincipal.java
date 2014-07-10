package test2.services.security;

import java.security.Principal;

import test2.model.User;

/**
 * Holds information about logged in user.
 */
public class UserPrincipal implements Principal {
	private User user;

	public UserPrincipal() {
	}

	public UserPrincipal(User user) {
		this.user = user;
	}

	@Override
	public String getName() {
		return user.getUsername();
	}

	public boolean isLoggedIn() {
		return user != null;
	}

	public User getUser() {
		return user;
	}
}
