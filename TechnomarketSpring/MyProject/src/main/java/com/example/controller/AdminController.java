package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.ProductDAO;
import com.example.dao.UserDAO;
import com.example.krasiModel.Product;
import com.example.krasiModel.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	ProductDAO dao = ProductDAO.getInstance();
	
	@RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
	public String addProductPage(){
		return("technomarket_addProduct");
	}

	@ResponseBody
	@RequestMapping(value = "/addPromotion/{productId}", method = RequestMethod.POST)
	public String addPromotion(@PathVariable("productId") String productId, HttpServletRequest req){

		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));

		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with addPromotion " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		JsonObject respJSON = new JsonObject();
	
		String newPrice = obj.get("newPrice").getAsString().trim();
		
		if(!Product.validThePrice(newPrice, product.getProductId())){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(newPrice.trim().isEmpty() || newPrice == null){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "newPriceError");
				error.addProperty("errorMessege", "Моля, въведете цена!");
				errorsArray.add(error);	
			}
			else{
				if(Double.parseDouble(newPrice) >= product.getPrice()){
					JsonObject error = new JsonObject();
					error.addProperty("errorPlace", "newPriceError");
					error.addProperty("errorMessege", "Въведената цена е по-висока от текущата!");
					errorsArray.add(error);	
				}
				else{
					if(Double.parseDouble(newPrice) <= 0){
						JsonObject error = new JsonObject();
						error.addProperty("errorPlace", "newPriceError");
						error.addProperty("errorMessege", "Моля, въведете положително число!");
						errorsArray.add(error);	
					}
				}
			}
			
			respJSON.add("errors", errorsArray);
			
			return respJSON.toString();
		}
		else{
			respJSON.addProperty("error", false);
			product.setPromoPrice(Double.parseDouble(newPrice));		
			dao.addPromotion(Double.parseDouble(newPrice), Long.parseLong(productId));
		}
		
		return respJSON.toString();
	}
	
	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") String productId, Model model){
		Product p = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
				
		//ako e v liubimi i ne e poruchvan -> triem go ot liubimi i ot produkti
		//ako e v liubimi i e poruchvan -> triem go ot liubimi i setQuantity(0)
		if(!dao.checkForFavProducts(p).isEmpty()){
			ArrayList<Integer> users = dao.checkForFavProducts(p);
			for(Entry<String, User> e : UserDAO.getInstance().getAllUsers().entrySet()){
				for (Integer i : users) {	
					if(e.getValue().getUserId() == i){
						if(dao.checkForOrderedProducts(p).isEmpty()){
							dao.deleteProduct(p, e.getValue());	
						}
						else{
							dao.deleteProduct2(p, e.getValue());
						}
						MailSender mailSender = new MailSender(e.getValue().getEmail() ,"Няма наличност", "Продукт с артикулен номер " + p.getProductId() + " и име " + p.getName() + " вече не е наличен.");
						mailSender.start();
					}
				}
			}
		}
		//ako ne e v liubimi i ne e poruchvan -> triem go ot produkt
		//ako ne e v liubimi i e poruchvan -> setQuantity(0)
		else{
			if(dao.checkForOrderedProducts(p).isEmpty()){
				dao.deleteProduct3(p);
			}
			else{
				dao.deleteProduct4(p);
			}
		}

		model.addAttribute("messageDelete", "Успешно премахнахте продукт с артикулен номер: " + productId);
		model.addAttribute("deleteTrue", true);
		return "new";
	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("productId") String productId, HttpServletRequest request, Model model){
		Product p = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));

		if(request.getParameter("quantity") != null){
			if(!request.getParameter("quantity").trim().isEmpty()){
				int quantity = Integer.valueOf(request.getParameter("quantity"));
				if(quantity > 0){
					ProductDAO.getInstance().editQuantity(p.getProductId(), quantity);
					model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));
				}
				else{
					model.addAttribute("messageErrorQ", "Количеството трябва да е положително число.");
				}
			}
		}
		if(request.getParameter("price") != null){
			if(!request.getParameter("price").trim().isEmpty()){
				double price = Double.valueOf(request.getParameter("price"));
				if(price > 0){
					if(p.getPromoPrice() != 0){
						if(price > p.getPromoPrice()){
							ProductDAO.getInstance().editPrice(p.getProductId(), price);
							model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));
						}
						else{
							model.addAttribute("messageErrorP", "Продуктът вече е в промоция, цената трябва да е по-висока от тази на промоцията.");
						}
					}
					else{
						ProductDAO.getInstance().editPrice(p.getProductId(), price);
						model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));
					}
				}
				else{
					model.addAttribute("messageErrorP", "Цената трябва да е положително число.");
				}
			}
		}
		if(request.getParameter("description") != null){
			if(!request.getParameter("description").trim().isEmpty()){
				String description = request.getParameter("description");
				if(description.length() < 2000){
					ProductDAO.getInstance().editDescription(p.getProductId(), description);
					model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));
				}
				else{
					model.addAttribute("messageErrorD", "Описанието е прекалено дълго.");
				}
			}
		}
		if(request.getParameter("name") != null){
			if(!request.getParameter("name").trim().isEmpty()){
				String name = request.getParameter("name");
				if(name.length() < 50){
					ProductDAO.getInstance().editName(p.getProductId(), name);
					model.addAttribute("message", "Успешно променихте продукт с артикулен номер: " + Long.parseLong(productId));
				}
				else{
					model.addAttribute("messageErrorN", "Името е прекалено дълго.");
				}
			}
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
