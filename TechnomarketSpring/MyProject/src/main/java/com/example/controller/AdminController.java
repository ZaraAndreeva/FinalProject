package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
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
	
	@RequestMapping(value = "/addPromotion", method = RequestMethod.POST)
	public String addPromotion(HttpServletRequest request){
		long artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
		double newPrice = Double.valueOf(request.getParameter("newPrice"));
		ProductDAO.getInstance().getAllProducts().get(artikulenNomer).setPromoPrice(newPrice);		
		ProductDAO.getInstance().addPromotion(newPrice, artikulenNomer);
		
		return "new";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request){
		long artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
		ProductDAO.getInstance().deleteProduct(ProductDAO.getInstance().getAllProducts().get(artikulenNomer));		

		return "new";
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request){
		//TODO
		long artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		double price = Double.valueOf(request.getParameter("price"));
		String description = request.getParameter("description");
		
		ProductDAO.getInstance().editProduct(artikulenNomer, quantity, price);

		return "new";
	}
	
	@RequestMapping(value = "/removePromotionPage", method = RequestMethod.GET)
	public String removePromotionPage(){
		return("technomarket_removePromotion");
	}
	
	@RequestMapping(value = "/removePromotion", method = RequestMethod.POST)
	public String removePromotion(HttpServletRequest request){
		long artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
		double price = Double.valueOf(request.getParameter("price"));	
		ProductDAO.getInstance().removePromotion(price, artikulenNomer);
		
		return "new";
	}

}
