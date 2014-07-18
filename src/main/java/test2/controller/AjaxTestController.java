package test2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test2.model.User;

@Controller
@RequestMapping("/ajax")
public class AjaxTestController {
	@RequestMapping("getInfo")
	@ResponseBody
	public User getUserInfo() {
		User user = new User();
		user.setId("id1");
		user.setName("Adgh");
		user.setUsername("adgh");

		return user;
	}

	@RequestMapping("getUsers")
	@ResponseBody
	public List<User> getUsers() {
		User user;
		List<User> users = new ArrayList<User>();
		user = new User();
		user.setId("id1");
		user.setName("N1");
		user.setUsername("U1");
		users.add(user);

		user = new User();
		user.setId("id2");
		user.setName("N2");
		user.setUsername("U2");
		users.add(user);

		user = new User();
		user.setId("id3");
		user.setName("N3");
		user.setUsername("U3");
		users.add(user);

		return users;
	}
}
