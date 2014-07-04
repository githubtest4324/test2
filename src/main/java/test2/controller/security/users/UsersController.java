package test2.controller.security.users;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

		return "security/users/userList";
	}

	@RequestMapping()
	public String logout(SessionStatus session) {
		return ControllerUtils.redirect(URL, LIST);
	}

}
