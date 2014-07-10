package test2.controller;

import java.util.Locale;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import test2.model.User;
import test2.services.security.UserPrincipal;
import test2.utils.controller.BaseController;
import test2.utils.controller.ControllerUtils;

/**
 * Docs: http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html
 */
@Controller
@RequestMapping(HomeController.URL)
@SessionAttributes("principal")
public class HomeController extends BaseController {
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(HomeController.class.getName());
	public final static String URL = "/home";
	public final static String MAIN = "main";

	@RequestMapping(MAIN)
	public String main(ModelMap model, @ModelAttribute("principal") @Validated UserPrincipal principal, BindingResult result) {
		ControllerUtils.onBeforeRender(model, bundles.getMessage("nav.home", new Object[] {}, Locale.getDefault()), URL);

		return "home";
	}

	@RequestMapping()
	public String home() {
		return ControllerUtils.redirect(URL, MAIN);
	}

}
