package test2.utils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class BaseController {
	@Autowired
	protected MessageSource bundles;

	public void setMessageSource(MessageSource messageSource) {
		this.bundles = messageSource;
	}

}
