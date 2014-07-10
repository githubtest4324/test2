package test2.utils.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;

import test2.model.User;
import test2.services.security.UserPrincipal;

public class BaseController {
	@Autowired
	protected MessageSource bundles;

	public void setMessageSource(MessageSource messageSource) {
		this.bundles = messageSource;
	}

	/**
	 * Called only if principal is not defined at session level.
	 */
	@ModelAttribute("principal")
	public UserPrincipal instantiateEmptyUser(HttpServletRequest request) {
		UserPrincipal principal = (UserPrincipal) request.getSession().getAttribute("principal");
		if (principal == null) {
			User user = new User();
			user.setUsername("guest");
			user.setName("Guest");
			user.setId(UUID.randomUUID().toString());
			principal = new UserPrincipal(user);
		}
		return principal;
	}

}
