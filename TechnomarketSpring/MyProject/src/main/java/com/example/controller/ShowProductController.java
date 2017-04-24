package com.example.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;
import com.example.krasiModel.Product;

@Controller
public class ShowProductController {
	
	
	@RequestMapping(value = "/televizori", method = RequestMethod.GET)
	public String showTelevizori(Model model){
		
		ArrayList<Product> products = ProductDAO.getInstance().giveProductsByTag("Телевизори");
		Collection<Product> allProducts = ProductDAO.getInstance().getAllProducts().values();
		
		for (Product product : allProducts) {
			System.out.println(product);
		}
		
		model.addAttribute("products", products);
		
		return "new";
	}
}
