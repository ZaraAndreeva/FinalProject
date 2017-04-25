package com.example.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;
import com.example.krasiModel.Product;




@Controller
@RequestMapping(value = "/search")
public class SearchController {
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(HttpServletRequest request, Model model){
		
		String search = request.getParameter("search");
		
		Collection<Product> searchProd = ProductDAO.getInstance().searchProduct(search);
		
		if(!searchProd.isEmpty()){
			for (Product product : searchProd) {
				System.out.println(product);
			}
			
			model.addAttribute("products", searchProd);
		}
		else{
			model.addAttribute("message", "Няма намерени продукти.");
		}
			return "new";
		
	}
	
}