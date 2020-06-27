package com.capgemini.springmvcc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView showMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/views/message.jsp");
		return modelAndView;
		
	}
	@RequestMapping(path = "/getEmp", method = RequestMethod.GET)
	public String getEmp(@RequestParam(name = "emId") int empId, HttpServletRequest req) {
		req.setAttribute("emId", empId);
		return "/WEB-INF/views/getEmp.jsp";
	}

}
