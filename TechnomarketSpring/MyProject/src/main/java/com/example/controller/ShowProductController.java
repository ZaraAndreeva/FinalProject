package com.example.controller;

import java.util.ArrayList;

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
		model.addAttribute("category", subCategory);
		model.addAttribute("categorySearch", true);
		//TODO remove from another place also
//		Collection<Product> allProducts = ProductDAO.getInstance().getAllProducts().values();
		
//		for (Product product : allProducts) {
//			System.out.println(product);
//		}
		double minPrice = products.get(0).getPrice();
		double maxPrice = products.get(0).getPrice();
		for (Product product : products) {
			if(product.getPrice() < minPrice){
				minPrice = product.getPrice(); 
			}
			if(product.getPrice() > maxPrice){
				maxPrice = product.getPrice(); 
			}
		}
		model.addAttribute("products", products);
		model.addAttribute("minPrice", minPrice);
		model.addAttribute("maxPrice", maxPrice);
		return "new";
	}
}
