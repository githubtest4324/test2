package test2.controller.employees;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import test2.model.Employee;
import test2.services.Test1Service;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(AddEmployeeController.url)
public class AddEmployeeController {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(AddEmployeeController.class.getName());
	public final static String url = "/employees/add";
	public final static String title = "Add employee";
	public final static String main = "main";
	public final static String add = "add";

	@Autowired
	private Test1Service test1Servirce;
	
	@RequestMapping(main)
	public String main(ModelMap map)
	{
		ControllerUtils.onBeforeRender(map, title, url);
		map.addAttribute("employee", new Employee());
		return "employees/addEmployee";
	}

	@RequestMapping(add)
	public String add(@ModelAttribute("employee") Employee employee2, BindingResult result)
	{
		test1Servirce.createEmployee(employee2.getName(), employee2.getAge(), null);
		return ControllerUtils.redirect(EmployeeListController.url, EmployeeListController.main);
	}

}
