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
		
//		return "home";
//		return "technomarket_addProduct";
		servletContext.setAttribute("entriesForAllCategories", CategoryDAO.getInstance().getAllCategories().entrySet());
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
	}
	
	
//	@RequestMapping(value="/mindex", method=RequestMethod.GET)
//	public String sayBye(Model viewModel) {
//		// talk with model
//		Product product = new Product("Kiselo zele", 50);
//		
//		List<Product> products = new ArrayList<Product>();
//		products.add(product);
//		products.add(new Product("Kisela krastavica", 13));
//		products.add(new Product("Kisel portokal", 83));
//		products.add(new Product("Kisel limon", 73));
//		products.add(new Product("Kisel greipfrut", 13));
//		products.add(new Product("Kisel banan", 43));
//		products.add(new Product("Kiselo mlqko", 33));
//		
//		viewModel.addAttribute("Text","Bye");
//		viewModel.addAttribute("products", products);
//		
//		viewModel.addAttribute(new Product("", 0));
//		
//		return "listproducts";
//	}
//	
//	@RequestMapping(value="/mindex", method=RequestMethod.POST)
//	public String addProduct(@ModelAttribute Product product) {
//		// add to DAO
//		System.out.println(product);
//		
//		return "listproducts";
//	}
	
}
