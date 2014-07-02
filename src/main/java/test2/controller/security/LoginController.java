package test2.controller.security;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import test2.controller.HomeController;
import test2.model.User;
import test2.services.security.LoginService;
import test2.services.security.UserPrincipal;
import test2.utils.controller.BaseController;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(LoginController.URL)
@SessionAttributes("principal")
public class LoginController extends BaseController {
	private static final String PERFORM_LOGIN = "performLogin";
	private final static Logger logger = Logger.getLogger(LoginController.class.getName());
	public final static String URL = "/login";
	public final static String MAIN = "main";
	private static final String LOGOUT = "logout";

	@Autowired
	private LoginService loginService;

	@RequestMapping(PERFORM_LOGIN)
	public String login(ModelMap model, @ModelAttribute("user") User user, BindingResult result) {
		logger.info(String.format("Login using user: %s, pass: %s", user.getUsername(), user.getPassword()));
		if (loginService.isValidLogin(user.getUsername(), user.getPassword())) {
			logger.info("Login successfull");
			model.addAttribute("principal", new UserPrincipal(user.getUsername()));
			return ControllerUtils.redirect(HomeController.URL, HomeController.MAIN);
		} else {
			model.addAttribute("outcome", false);
			logger.info("Wrong username or password");
			return "login";
		}

	}

	@RequestMapping(MAIN)
	public String main(ModelMap model) {
		ControllerUtils.onBeforeRender(model, bundles.getMessage("nav.login", new Object[] {}, Locale.getDefault()), URL);
		model.addAttribute("user", new User());

		return "login";
	}

	@RequestMapping()
	public String home(ModelMap model) {
		model.addAttribute("user", new User());

		return ControllerUtils.redirect(URL, MAIN);
	}

	@RequestMapping(LOGOUT)
	public String logout(SessionStatus session) {
		session.setComplete();
		return ControllerUtils.redirect(HomeController.URL);
	}

}
