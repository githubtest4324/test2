package test2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test2.utils.controller.BaseController;

@Controller
@RequestMapping(HomeController.URL)
public class HomeController extends BaseController {
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(HomeController.class.getName());
	public final static String URL = "/";

	@RequestMapping()
	public String home() {
		return "main";
	}

}
