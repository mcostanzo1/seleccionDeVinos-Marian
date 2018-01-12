package com.dp3.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletResponse response) {
			ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView start(HttpServletResponse response) {
		return new ModelAndView("stock");
	}
}