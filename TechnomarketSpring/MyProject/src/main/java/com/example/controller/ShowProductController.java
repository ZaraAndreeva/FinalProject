package com.example.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;
import com.example.krasiModel.Product;

@Controller
@RequestMapping(value = "/showProduct", method = RequestMethod.GET)
public class ShowProductController {
	
	
	@RequestMapping(value = "/{subCategory}", method = RequestMethod.GET)
	public String showTelevizori(Model model, @PathVariable("subCategory") String subCategory){
		
		ArrayList<Product> products = ProductDAO.getInstance().giveProductsBySubCategory(subCategory);
		if(products == null){
			model.addAttribute("error", "Все още няма такива продукти");
			return "new";
		}
		
		//TODO remove from another place also
//		Collection<Product> allProducts = ProductDAO.getInstance().getAllProducts().values();
		
//		for (Product product : allProducts) {
//			System.out.println(product);
//		}
		
		model.addAttribute("products", products);
		
		return "new";
	}
}
