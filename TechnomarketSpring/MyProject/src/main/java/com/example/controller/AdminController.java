package com.example.controller;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;
import com.example.dao.UserDAO;
import com.example.krasiModel.Product;
import com.example.krasiModel.User;

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
	
	@RequestMapping(value = "/viewProductByArtN", method = RequestMethod.POST)
	public String viewProductByArtN(Model model){
		return("");
	}
	
	@RequestMapping(value = "/addPromotion", method = RequestMethod.POST)
	public String addPromotion(HttpServletRequest request, Model model){
		long artikulenNomer = 0;
		double newPrice = 0;
		if(!request.getParameter("artikulenNomer").isEmpty() && !request.getParameter("newPrice").isEmpty()){
			artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
			if(Double.valueOf(request.getParameter("newPrice")) < ProductDAO.getInstance().getAllProducts().get(artikulenNomer).getPrice()){
				
				newPrice = Double.valueOf(request.getParameter("newPrice"));
				if(dao.getAllProducts().containsKey(artikulenNomer)){
					if(newPrice <= 0){
						model.addAttribute("message", "Цената трябва да е положително число.");
					}
					else{
						if(dao.getAllProducts().get(artikulenNomer).getPromoPrice() == 0){
							dao.getAllProducts().get(artikulenNomer).setPromoPrice(newPrice);		
							dao.addPromotion(newPrice, artikulenNomer);
							
							Product p = ProductDAO.getInstance().getAllProducts().get(artikulenNomer);
							ArrayList<Integer> users = dao.checkForFavProducts(p);
							for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
								for (Integer i : users) {	
									if(e.getValue().getUserId() == i){
										MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Промяна на артикул", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " е на цена " + newPrice + " лв.");
										mailSender.start();
									}
								}
							}
							model.addAttribute("message", "Успешно добавихте промоция на продукт с артикулен номер: " + artikulenNomer);
						}
						else{
							model.addAttribute("message", "Този продукт вече е в промоция.");
						}
					}
				}
				else{
					model.addAttribute("message", "Не съществува продукт с този артикулен номер.");
				}
			}
			else{
				model.addAttribute("message", "Цената, която сте въвели е по-висока от текущата цена на продукта.");
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
				
				Product p = ProductDAO.getInstance().getAllProducts().get(artikulenNomer);
				ArrayList<Integer> users = dao.checkForFavProducts(p);
				for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
					for (Integer i : users) {	
						if(e.getValue().getUserId() == i){
							MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Няма наличност", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " вече не е наличен.");
							mailSender.start();
						}
					}
				}
				
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
	public String editProduct(HttpServletRequest request, Model model){
		long artikulenNomer = 0;
		int quantity = -1;
		double price = 0;
		String description = "";
		String name = "";
		
		if(!request.getParameter("artikulenNomer").isEmpty()){
			artikulenNomer = Long.valueOf(request.getParameter("artikulenNomer"));
			if(dao.getAllProducts().containsKey(artikulenNomer)){

				try {
					quantity = Integer.valueOf(request.getParameter("quantity"));
			   }catch (NumberFormatException e){
				   quantity = dao.getAllProducts().get(artikulenNomer).getQuantity();   
			   } 
				try {
					price = Double.valueOf(request.getParameter("price"));
				 }catch (NumberFormatException e){
					 price = dao.getAllProducts().get(artikulenNomer).getPrice();
				 }
				try {
					//TODO ne razchita kirilica
					description = request.getParameter("description");
				 }catch (NumberFormatException e){
					 description = dao.getAllProducts().get(artikulenNomer).getDescription();
				 }
				try {
					//TODO ne razchita kirilica
					name = request.getParameter("name");
				 }catch (NumberFormatException e){
					 name = dao.getAllProducts().get(artikulenNomer).getName();
				 }
				
				Product p = ProductDAO.getInstance().getAllProducts().get(artikulenNomer);
				ArrayList<Integer> users = dao.checkForFavProducts(p);
				for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
					for (Integer i : users) {	
						if(e.getValue().getUserId() == i){
							MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Промяна на артикул", "Продукт с артикулен номер " + p.getProductId()  + " и име " + p.getName() +  " е променен.");
							mailSender.start();
						}
					}
				}
				
				dao.editProduct(artikulenNomer, quantity, price, name, description);
				model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + artikulenNomer);
			}
			else{
				model.addAttribute("message", "Не съществува продукт с този артикулен номер.");
			}
		}
		else{
			model.addAttribute("message", "Не сте въвели артикулен номер.");
		}
		
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
					
					Product p = ProductDAO.getInstance().getAllProducts().get(artikulenNomer);
					ArrayList<Integer> users = dao.checkForFavProducts(p);
					for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
						for (Integer i : users) {	
							if(e.getValue().getUserId() == i){
								MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Премахване на промоция", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " вече не е в промоция и е на цена от " + price + " лв.");
								mailSender.start();
							}
						}
					}
					
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
