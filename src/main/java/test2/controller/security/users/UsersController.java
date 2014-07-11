package test2.controller.security.users;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import test2.model.User;
import test2.services.security.UserPrincipal;
import test2.services.security.UserService;
import test2.services.security.UserService.CannotDeleteOwnUser;
import test2.utils.controller.BaseController;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(UsersController.URL)
@SessionAttributes("principal")
public class UsersController extends BaseController {
	private static final String CANCEL_ADD = "cancelAdd";
	private static final String DELETE_CONFIRMATION = "deleteConfirmation";
	private static final String REFRESH = "refresh";
	private static final String DELETE = "delete";
	private static final String ADD = "add";
	private static final String GO_TO_ADD = "goToAdd";
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(UsersController.class.getName());
	public final static String URL = "/security/users";
	// public final static String MAIN = "main";
	// public final static String LIST = "list";

	@Autowired
	private UserService userService;

	@RequestMapping()
	public String list(ModelMap model) {
		ControllerUtils.onBeforeRender(model, bundles.getMessage("nav.users", new Object[] {}, Locale.getDefault()), URL);

		List<User> users = userService.listUsers(null, null);
		model.addAttribute("users", users);

		User criteria = new User();
		model.addAttribute("criteria", criteria);

		return "security/users/listUsers";
	}

	@RequestMapping(params = { DELETE_CONFIRMATION })
	public String deleteConfirmationAction(@RequestParam(required = true) String confirmDeleteUserIds, ModelMap model) {
		if (!StringUtils.isEmpty(confirmDeleteUserIds)) {
			String[] idList = confirmDeleteUserIds.split(",");
			StringBuilder userNames = new StringBuilder();
			for (String id : idList) {
				if (userNames.length() > 0) {
					userNames.append(", ");
				}
				User user = userService.getById(id);
				userNames.append(user.getName());
			}
			model.addAttribute("userNames", userNames);
			model.addAttribute("userIds", confirmDeleteUserIds);
			model.addAttribute("deleteUserValidation", true);
		}
		return list(model);
	}

	@RequestMapping(params = { DELETE })
	public String delete(ModelMap model, @ModelAttribute("principal") UserPrincipal principal,
			@RequestParam(required = true) String deleteUserIds) {
		if (!StringUtils.isEmpty(deleteUserIds)) {
			String[] idList = deleteUserIds.split(",");
			try {
				userService.delete(idList, principal);
			} catch (CannotDeleteOwnUser e) {
				model.addAttribute("error",
						this.bundles.getMessage("users.error.cannotDeleteOwnUser", new Object[] {}, Locale.getDefault()));
				return list(model);
			}
		}
		return ControllerUtils.redirect(URL);
	}

	@RequestMapping(params = { REFRESH })
	public String refreshAction(ModelMap model) {
		return ControllerUtils.redirect(URL);
	}

	@RequestMapping(params = { GO_TO_ADD })
	public String addAction(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "security/users/addUser";
	}

	@RequestMapping(params = { ADD })
	public String add(ModelMap model, @ModelAttribute("user") User user, BindingResult result) {
		// Validations
		if (!StringUtils.equals(user.getPassword(), user.getComputed().getRetypePassword())) {
			result.rejectValue(User.PASSWORD, "users.error.passwordDoesNotCorrespond");
		}
		if (StringUtils.isEmpty(user.getName())) {
			result.rejectValue(User.NAME, "mandatory");
		}
		if (StringUtils.isEmpty(user.getUsername())) {
			result.rejectValue(User.USERNAME, "mandatory");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			result.rejectValue(User.PASSWORD, "mandatory");
		}

		// Add user in db
		if (!result.hasErrors()) {
			try {
				userService.add(user);
			} catch (DataIntegrityViolationException e) {
				result.rejectValue(User.USERNAME, "alreadyExists");
			}
		}

		if (!result.hasErrors()) {
			return ControllerUtils.redirect(URL);
		} else {
			return "security/users/addUser";
		}
	}

	@RequestMapping(params = { CANCEL_ADD })
	public String cancelAdd(ModelMap model) {
		return ControllerUtils.redirect(URL);
	}

}
