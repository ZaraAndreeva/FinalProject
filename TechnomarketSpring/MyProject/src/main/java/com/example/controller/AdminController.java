package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
