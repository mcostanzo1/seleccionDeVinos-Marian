package com.dp3.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	final String log = "método invocado: {}";
	
	@GetMapping(path="/")
	public ModelAndView getMapping() {
		LOGGER.info(log, "getMapping");
		return new ModelAndView("index");
	}
	
}