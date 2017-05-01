package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.CategoryDAO;

@Component
@Controller
public class MyController implements ServletContextAware {
	@Autowired
    private ServletContext servletContext;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView sayHi(Model viewModel, HttpServletRequest request) {
		request.setAttribute("search", "");
		return new ModelAndView("forward:/search/search");
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
		servletContext.setAttribute("entriesForAllCategories", CategoryDAO.getInstance().getAllCategories().entrySet());
	}

}
