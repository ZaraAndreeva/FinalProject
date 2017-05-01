package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import com.example.dao.CategoryDAO;

@Component
@Controller
public class MyController implements ServletContextAware {
	@Autowired
    private ServletContext servletContext;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String sayHi(Model viewModel) {
		// talk with model
		 
		// @formatter:on

		viewModel.addAttribute("Text","Hello");

		return "new";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model viewModel	) {
		servletContext.setAttribute("entriesForAllCategories", CategoryDAO.getInstance().getAllCategories().entrySet());
	
		servletContext.setAttribute("mama", "Mamaaaa");
		return "test";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		servletContext.setAttribute("entriesForAllCategories", CategoryDAO.getInstance().getAllCategories().entrySet());
	}

}
