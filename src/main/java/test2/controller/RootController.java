package test2.controller;

import static test2.utils.controller.ControllerUtils.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import test2.services.security.UserPrincipal;

/**
 * Docs: http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html
 */
@Controller
@RequestMapping(RootController.URL)
public class RootController {
	public final static String URL = "/";

	@RequestMapping(URL)
	public String main(ModelMap model, @ModelAttribute("principal") @Validated UserPrincipal principal, BindingResult result) {
		return redirect(HomeController.URL);
	}
}
