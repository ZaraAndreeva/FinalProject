package com.example.controller;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/addPromotion/{productId}", method = RequestMethod.GET)
	public ModelAndView addPromotion(@PathVariable("productId") String productId, Model model, HttpServletRequest request){

		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		model.addAttribute("product", product);
		if(request.getParameter("newPrice").isEmpty() || request.getParameter("newPrice") == null){
			model.addAttribute("message", "Моля, въведете цена.");
		}
		else{
			double newPrice = Double.valueOf(request.getParameter("newPrice"));
			if(newPrice < 0){
				model.addAttribute("message", "Моля, въведете положително число за цена.");
			}
			else{
				if(newPrice < product.getPrice()){
				
					product.setPromoPrice(newPrice);		
					dao.addPromotion(newPrice, Long.parseLong(productId));
					
					ArrayList<Integer> users = dao.checkForFavProducts(product);
					for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
						for (Integer i : users) {	
							if(e.getValue().getUserId() == i){
								MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Промяна на артикул", "Продукт с артикулен номер " + product.getProductId() + " и име " + product.getName() + " е на цена " + newPrice + " лв.");
								mailSender.start();
							}
						}
					}
					model.addAttribute("message", "Успешно добавихте промоция на продукт с артикулен номер: " + Long.parseLong(productId));
				}
				else{
					model.addAttribute("message", "Цената, която сте въвели е по-висока от текущата цена на продукта.");
				}
			}
		}

		return new ModelAndView("forward:/product/viewProductPage/" + productId);
	}
	
	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("productId") String productId, Model model){
		//TODO da ne se pokazva stranicata na produkta sled kato veche e iztrit !!!!!!!!!!!!!!!!!!!!!
		Product p = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		dao.deleteProduct(p);				
		
		if(!dao.checkForFavProducts(p).isEmpty()){
			ArrayList<Integer> users = dao.checkForFavProducts(p);
			for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
				for (Integer i : users) {	
					if(e.getValue().getUserId() == i){
						MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Няма наличност", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " вече не е наличен.");
						mailSender.start();
					}
				}
			}
		}
		model.addAttribute("message", "Успешно премахнахте продукт с артикулен номер: " + productId);
		return new ModelAndView("forward:/product/viewProductPage/" + productId);
	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("productId") String productId, HttpServletRequest request, Model model){
		Product p = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		int quantity = -1;
		double price = 0;
		String description = "";
		String name = "";
	
		try {			
		   quantity = Integer.valueOf(request.getParameter("quantity"));
	   }catch (NumberFormatException e){
		   quantity = p.getQuantity();   
	   } 
		try {
			price = Double.valueOf(request.getParameter("price"));
		 }catch (NumberFormatException e){
			 price = p.getPrice();
		 }
		try {
			description = request.getParameter("description");
		 }catch (NumberFormatException e){
			 description = p.getDescription();
		 }
		try {
			name = request.getParameter("name");
		 }catch (NumberFormatException e){
			 name = p.getName();
		 }
		
		ArrayList<Integer> users = dao.checkForFavProducts(p);
		for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
			for (Integer i : users) {	
				if(e.getValue().getUserId() == i){
					MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Промяна на артикул", "Продукт с артикулен номер " + p.getProductId()  + " и име " + p.getName() +  " е променен.");
					mailSender.start();
				}
			}
		}
		
		dao.editProduct(Long.parseLong(productId), quantity, price, name, description);
		model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));

		return new ModelAndView("forward:/product/viewProductPage/" + productId);
	}
	
	@RequestMapping(value = "/removePromotion/{productId}", method = RequestMethod.GET)
	public ModelAndView removePromotion(@PathVariable("productId") String productId, Model model){	
		Product p = dao.getAllProducts().get(Long.parseLong(productId));
		dao.removePromotion(Long.parseLong(productId));
		ArrayList<Integer> users = dao.checkForFavProducts(p);
		for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
			for (Integer i : users) {	
				if(e.getValue().getUserId() == i){
					MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Премахване на промоция", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " вече не е в промоция.");
					mailSender.start();
				}
			}
		}
		model.addAttribute("message", "Успешно премахнахте промоцията от продукт с артикулен номер: " + productId);

		return new ModelAndView("forward:/product/viewProductPage/" + productId);
	}

}
