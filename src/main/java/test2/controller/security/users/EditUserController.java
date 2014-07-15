package test2.controller.security.users;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import test2.model.User;
import test2.services.security.UserService;
import test2.utils.controller.BaseController;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(EditUserController.URL)
@SessionAttributes(value = { "principal" })
public class EditUserController extends BaseController {
	private static final String UPDATE = "update";
	private static final String CANCEL_EDIT = "cancelEdit";
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(EditUserController.class.getName());
	public final static String URL = "/security/users/edit";

	@Autowired
	private UserService userService;

	@RequestMapping()
	public String main(ModelMap model, @ModelAttribute User userEdit, BindingResult result) {
		ControllerUtils.onBeforeRender(model, bundles.getMessage("nav.users", new Object[] {}, Locale.getDefault()), URL);

		return "security/users/editUser";
	}

	@RequestMapping(params = { CANCEL_EDIT })
	public String cancelEdit(ModelMap model) {
		return ControllerUtils.redirect(UsersController.URL);
	}

	@RequestMapping(params = { UPDATE })
	public String update(ModelMap model, @ModelAttribute User userEdit, BindingResult result) {
		if (StringUtils.isEmpty(userEdit.getName())) {
			result.rejectValue(User.NAME, "mandatory");
		}
		if (StringUtils.isEmpty(userEdit.getUsername())) {
			result.rejectValue(User.USERNAME, "mandatory");
		}

		if (!result.hasErrors()) {
			User user = userService.getById(userEdit.getId());
			user.setName(userEdit.getName());
			user.setUsername(userEdit.getUsername());
			userService.save(user);
			return ControllerUtils.redirect(UsersController.URL);
		} else {
			return URL;
		}

	}

}
