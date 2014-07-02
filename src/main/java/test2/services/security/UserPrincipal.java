package test2.services.security;

import java.security.Principal;

/**
 * Holds information about logged in user.
 */
public class UserPrincipal implements Principal {
	private String username;

	public UserPrincipal() {
	}

	public UserPrincipal(String username) {
		this.username = username;
	}

	public String getName() {
		return username;
	}

	public boolean isLoggedIn() {
		return username != null;
	}
}
