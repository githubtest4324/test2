package test2.controller.orders.orders;

import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import test2.model.Ord;
import test2.services.OrdService;
import test2.utils.controller.ControllerUtils;

@Controller
@RequestMapping(ListOrdersController.URL)
public class ListOrdersController {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(ListOrdersController.class.getName());
	public final static String URL = "/orders/orders/list";
	public final static String MAIN = "main";
	public final static String TITLE = "Orders";
	public final static String REFRESH = "refresh";
	public final static String CREATE = "create";

	@Autowired
	private OrdService ordServirce;

	@RequestMapping(value = CREATE)
	public String add(ModelMap map)
	{
		return ControllerUtils.redirect(CreateOrderController.URL, CreateOrderController.MAIN);
	}

	@RequestMapping(value = REFRESH)
	public String refresh(ModelMap map)
	{
		return ControllerUtils.redirect(MAIN);
	}

	@RequestMapping(MAIN)
	public String main(ModelMap map)
	{
		ControllerUtils.onBeforeRender(map, TITLE, URL);
		List<Ord> employees = ordServirce.getOrders();
		map.addAttribute("ordList", employees);
		return "orders/orders/listOrders";
	}
}
