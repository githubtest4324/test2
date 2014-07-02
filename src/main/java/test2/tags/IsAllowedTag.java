package test2.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import test2.services.security.SecurityService;
import test2.services.security.UserPrincipal;

/**
 * Security check for sections of view.
 */
@Component
public class IsAllowedTag extends SimpleTagSupport {

	@Autowired
	SecurityService securityService;

	/**
	 * Comma separated list of roles.
	 */
	private String roles;

	@Override
	public void doTag() throws JspException, IOException {
		ServletContext servletContext = ((PageContext) getJspContext()).getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory factory = context.getAutowireCapableBeanFactory();
		factory.autowireBean(this);

		StringWriter jspBodyContent = new StringWriter();
		JspWriter out = getJspContext().getOut();
		JspFragment jspBody = getJspBody();
		jspBody.invoke(jspBodyContent);

		UserPrincipal principal = (UserPrincipal) getJspContext().findAttribute("principal");
		if (principal == null) {
			throw new RuntimeException("Principal is not found");
		} else {
			String[] rolesArray = roles.split(",");
			boolean hasRole = false;
			for (String role : rolesArray) {
				if (securityService.hasRole(principal.getName(), role.trim())) {
					hasRole = true;
				}
			}

			if (hasRole) {
				out.append(jspBodyContent.toString());
			}
		}
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
