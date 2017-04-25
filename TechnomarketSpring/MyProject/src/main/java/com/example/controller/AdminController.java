package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	ProductDAO dao = ProductDAO.getInstance();
	
	@RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
	public String addProductPage(){
		return("technomarket_addProduct");
	}
	
	@RequestMapping(value = "/removeProductPage", method = RequestMethod.GET)
	public String removeProductPage(){
		return("technomarket_removeProduct");
	}
	
	@RequestMapping(value = "/editProductPage", method = RequestMethod.GET)
	public String editProductPage(){
		return("technomarket_editProduct");
	}
	
	@RequestMapping(value = "/addPromotionPage", method = RequestMethod.GET)
	public String addPromotionPage(){
		return("technomarket_addPromotion");
	}
	
	@RequestMapping(value = "/removePromotionPage", method = RequestMethod.GET)
	public String removePromotionPage(){
		return("technomarket_removePromotion");
	}
	
	@RequestMapping(value = "/addPromotion", method = RequestMethod.POST)
	public String addPromotion(HttpServletRequest request, Model model){
		long artikulenNomer = 0;
		double newPrice = 0;
		if(!request.getParameter("artikulenNomer").isEmpty() && !request.getParameter("newPrice").isEmpty()){
			artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
			newPrice = Double.valueOf(request.getParameter("newPrice"));
			if(dao.getAllProducts().containsKey(artikulenNomer)){
				if(newPrice <= 0){
					model.addAttribute("message", "Цената трябва да е положително число.");
				}
				else{
					dao.getAllProducts().get(artikulenNomer).setPromoPrice(newPrice);		
					dao.addPromotion(newPrice, artikulenNomer);
					model.addAttribute("message", "Успешно добавихте промоция на продукт с артикулен номер: " + artikulenNomer);
				}
			}
			else{
				model.addAttribute("message", "Не съществува продукт с този артикулен номер.");
			}
		}
		else{
			model.addAttribute("message", "Не сте въвели артикулен номер или цена.");
		}
		return "technomarket_addPromotion";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request, Model model){
		long artikulenNomer = 0;
		if(!request.getParameter("artikulenNomer").isEmpty()){
			artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
			if(dao.getAllProducts().containsKey(artikulenNomer)){
				dao.deleteProduct(dao.getAllProducts().get(artikulenNomer));
				model.addAttribute("message", "Успешно премахнахте продукт с артикулен номер: " + artikulenNomer);
			}
			else{
				model.addAttribute("message", "Не съществува продукт с този артикулен номер.");
			}
		}
		else{
			model.addAttribute("message", "Не сте въвели артикулен номер.");
		}
		return "technomarket_removeProduct";
	}

	
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request){
		//TODO
		long artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		double price = Double.valueOf(request.getParameter("price"));
		String description = request.getParameter("description");
		
		dao.editProduct(artikulenNomer, quantity, price);

		return "technomarket_editProduct";
	}
	
	
	@RequestMapping(value = "/removePromotion", method = RequestMethod.POST)
	public String removePromotion(HttpServletRequest request, Model model){
		long artikulenNomer = 0;
		double price = 0;
		if(!request.getParameter("artikulenNomer").isEmpty() && !request.getParameter("price").isEmpty()){
			artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
			price = Double.valueOf(request.getParameter("price"));	
			if(dao.getAllProducts().containsKey(artikulenNomer)){
				if(dao.getAllProducts().get(artikulenNomer).getPromoPrice() != 0){
					dao.removePromotion(price, artikulenNomer);
					model.addAttribute("message", "Успешно премахнахте промоцията от продукт с артикулен номер: " + artikulenNomer);
				}
				else{
					model.addAttribute("message", "Този продукт не е в промоция.");
				}
			}
			else{
				model.addAttribute("message", "Не съществува продукт с този артикулен номер.");
			}
		}
		else{
			model.addAttribute("message", "Не сте въвели артикулен номер или цена.");
		}
		return "technomarket_removePromotion";
	}

}
