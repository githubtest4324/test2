package test2.controller.employees;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test2.model.Employee;
import test2.services.Test1Service;
import test2.utils.controller.ControllerUtils;

/**
 * Docs: http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html
 */
@Controller
@RequestMapping(EmployeeListController.url)
public class EmployeeListController {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(EmployeeListController.class.getName());
	public final static String url = "/employees/list";
	public final static String main = "main";
	public final static String refresh = "refresh";
	public final static String add = "add";
	public final static String add2 = "add2";

	@Autowired
	private Test1Service test1Servirce;
	
	@RequestMapping(value = add, method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") Employee employee, BindingResult result)
	{
		test1Servirce.createEmployee(employee.getName(), employee.getAge(), null);
		return ControllerUtils.redirect("/");
	}	

	@RequestMapping(value = add2)
	public String add(ModelMap map)
	{
		return ControllerUtils.redirect(AddEmployeeController.url, AddEmployeeController.main);
	}
	
	@RequestMapping(value = refresh)
	public String refresh(ModelMap map)
	{
		return ControllerUtils.redirect(main);
	}
	
	@RequestMapping(main)
	public String listEmployees(ModelMap map)
	{
		try{
			List<Employee> employees = test1Servirce.getEmployees();
			map.addAttribute("employeeList", employees);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "employees/editEmployeeList";
	}
}
