package test2.controller.orders.orders;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import test2.model.Ord;
import test2.services.OrdService;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(CreateOrderController.URL)
public class CreateOrderController {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(CreateOrderController.class.getName());
	public final static String URL = "/orders/orders/create";
	public final static String TITLE = "Create new order";
	public final static String MAIN = "main";
	public final static String CREATE = "create";

	@Autowired
	private OrdService ordServirce;
	
	@RequestMapping(MAIN)
	public String main(ModelMap model)
	{
		ControllerUtils.onBeforeRender(model, TITLE, URL);
		model.addAttribute("order", new Ord());
		return "orders/orders/createOrder";
	}
	
	@RequestMapping(CREATE)
	public String create(@ModelAttribute("order") Ord ord, BindingResult result)
	{
		ordServirce.createOrder(ord.getReferenceNo());
		return ControllerUtils.redirect(ListOrdersController.URL, ListOrdersController.MAIN);
	}
	
}
