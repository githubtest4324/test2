package test2.controller.security.users;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import test2.model.User;
import test2.services.security.UserService;
import test2.utils.controller.BaseController;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(UsersController.URL)
@SessionAttributes("principal")
public class UsersController extends BaseController {
	private static final String ADD = "add";
	private static final String ADD_ACTION = "addAction";
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(UsersController.class.getName());
	public final static String URL = "/security/users";
	// public final static String MAIN = "main";
	public final static String LIST = "list";

	@Autowired
	private UserService userService;

	@RequestMapping(LIST)
	public String main(ModelMap model) {
		ControllerUtils.onBeforeRender(model, bundles.getMessage("nav.users", new Object[] {}, Locale.getDefault()), URL);

		List<User> users = userService.listUsers(null, null);
		model.addAttribute("users", users);

		User criteria = new User();
		model.addAttribute("criteria", criteria);

		return "security/users/listUsers";
	}

	@RequestMapping(ADD_ACTION)
	public String addAction(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "security/users/addUser";
	}

	@RequestMapping(ADD)
	public String add(ModelMap model, @ModelAttribute("user") User user, BindingResult result) {
		// Validations
		if (!StringUtils.equals(user.getPassword(), user.getComputed().getRetypePassword())) {
			result.rejectValue(User.PASSWORD, "users.error.passwordDoesNotCorrespond");
		}
		if (StringUtils.isEmpty(user.getName())) {
			result.rejectValue(User.NAME, "mandatory");
		}
		if (StringUtils.isEmpty(user.getUsername())) {
			result.rejectValue(User.USER_NAME, "mandatory");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			result.rejectValue(User.PASSWORD, "mandatory");
		}

		// Add user in db
		if (!result.hasErrors()) {
			try {
				userService.add(user);
			} catch (DataIntegrityViolationException e) {
				result.rejectValue(User.USER_NAME, "alreadyExists");
			}
		}

		if (!result.hasErrors()) {
			return ControllerUtils.redirect(URL, LIST);
		} else {
			return "security/users/addUser";
		}
	}

	@RequestMapping()
	public String logout(SessionStatus session) {
		return ControllerUtils.redirect(URL, LIST);
	}

}
