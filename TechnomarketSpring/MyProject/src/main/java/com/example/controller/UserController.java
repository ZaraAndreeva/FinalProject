package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.ProductDAO;
import com.example.dao.UserDAO;
import com.example.krasiModel.Product;
import com.example.krasiModel.User;




import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(){
		return "technomarket_register";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(UserDAO.getInstance().validLogin(email, password)){
			User u = UserDAO.getInstance().getAllUsers().get(email);
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			session.setMaxInactiveInterval(3000);
			session.setAttribute("logged", true);
			//TODO
//			response.sendRedirect("index.jsp");
			return "new";
		}
		else{
			model.addAttribute("message", "Въвели сте грешно потребителско име или парола.");
			return "technomarket_login";
		}
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(){
		return("technomarket_login");
	}
	
	@RequestMapping(value = "/openProfile", method = RequestMethod.GET)
	public String openProfile(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null || !(Boolean)session.getAttribute("logged")){
			return("technomarket_login");
		}
		return("technomarket_profile");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.setAttribute("logged", false);
		request.getSession().invalidate();
		return ("new");
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String register(HttpServletRequest request){
//		String name = request.getParameter("name");
//		String familyName = request.getParameter("family_name");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		String gender = request.getParameter("gender");
//		String birthDate = request.getParameter("birthdate");
//	
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
//        LocalDate date = LocalDate.parse(birthDate, formatter);
//		
//		User u = new User(name, familyName, email, password, gender, date, false);
//		UserDAO.getInstance().addUser(u);
//		//TODO
////		response.sendRedirect("uspeshnaRegistraciya.html");
//		return ("redirect:uspeshnaRegistraciya.html");
//	}
	
	
	@RequestMapping(value = "/ordersPage", method = RequestMethod.GET)
	public String ordersPage(){
		return("technomarket_orders");
	}
	
	@RequestMapping(value = "/cartPage", method = RequestMethod.GET)
	public String cartPage(){
		return("technomarket_cart");
	}

//		response.sendRedirect("index.jsp");
	
	
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest req){
//		String name = request.getParameter("name");
//		String familyName = request.getParameter("family_name");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
//		String gender = request.getParameter("gender");
//		String birthDate = request.getParameter("birthdate");
	
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
//        LocalDate date = LocalDate.parse(birthDate, formatter);
//		
//		User u = new User(name, familyName, email, password, gender, date, false);
//		UserDAO.getInstance().addUser(u);
//		//TODO
////		response.sendRedirect("uspeshnaRegistraciya.html");
//		return ("redirect:uspeshnaRegistraciya.html");
		
		
		
		
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with register user " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		JsonObject respJSON = new JsonObject();
		
//		
//		name: document.getElementById("fos_user_registration_form_first_name").value,	  		
//		familyName: document.getElementById("fos_user_registration_form_last_name").value,
//		email: document.getElementById("fos_user_registration_form_email").value,
//		passwordFirst: document.getElementById("fos_user_registration_form_plainPassword_first").value,
//		passwordSecond: document.getElementById("fos_user_registration_form_plainPassword_second").value,
		
		String name = obj.get("name").getAsString();
		String familyName = obj.get("familyName").getAsString();
		String email = obj.get("email").getAsString();
		String passwordFirst = obj.get("passwordFirst").getAsString();
		String passwordSecond = obj.get("passwordSecond").getAsString();
		String sex = (obj.get("sex")!= null)?  obj.get("sex").getAsString() : "0";
//		String birthDate = obj.get("birthDate").getAsString();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//        LocalDate date = LocalDate.parse(birthDate, formatter);
		
		System.out.println("************");
		System.out.println(name);
		System.out.println(familyName);
		System.out.println(email);
		System.out.println(passwordFirst);
		System.out.println(passwordSecond);
		System.out.println(sex);
//		System.out.println(birthDate);
		System.out.println("***********");
		
		
		if(!User.validUser(name, familyName, email, passwordFirst, passwordSecond, sex)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(!User.validText(name)){
//				errorsArray.add(new JsonPrimitive("descriptionError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Моля, въведете име!");
				errorsArray.add(error);
				
			}
			if(!User.validText(familyName)){
//				errorsArray.add(new JsonPrimitive("quantityError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "familyNameError");
				error.addProperty("errorMessege", "Моля, въведете фамилно име!");
				errorsArray.add(error);
				
			}
			if(!User.validEmail(email)){
//				errorsArray.add(new JsonPrimitive("priceError"));
				if(UserDAO.getInstance().getAllUsers().containsKey(email)){
					JsonObject error = new JsonObject();
					error.addProperty("errorPlace", "emailError");
					error.addProperty("errorMessege", "Въведеният email вече е зает!");
					errorsArray.add(error);	
				}
				else{
					JsonObject error = new JsonObject();
					error.addProperty("errorPlace", "emailError");
					error.addProperty("errorMessege", "Моля, въведете валиден email!");
					errorsArray.add(error);
				}
				
			}
			if(!User.validPassword(passwordFirst)){
//				errorsArray.add(new JsonPrimitive("brandError"));	
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "passwordFirstError");
				error.addProperty("errorMessege", "Моля, въведете парола!");
				errorsArray.add(error);
			}
			else{
				if(passwordSecond == null || passwordSecond.isEmpty()){
					JsonObject error = new JsonObject();
					error.addProperty("errorPlace", "passwordSecondError");
					error.addProperty("errorMessege", "Моля, въведете паролата отново!");
					errorsArray.add(error);
				}
				else if (!passwordFirst.equals(passwordSecond)){
					JsonObject error = new JsonObject();
					error.addProperty("errorPlace", "passwordSecondError");
					error.addProperty("errorMessege", "Паролите не съвпадат!");
					errorsArray.add(error);
				}
			}
			if(Integer.parseInt(sex) == 0){
//				errorsArray.add(new JsonPrimitive("urlError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "sexError");
				error.addProperty("errorMessege", "Моля, въведете пол!");
				errorsArray.add(error);
				
			}
			
//			if(birthDate == null){
//				JsonObject error = new JsonObject();
//				error.addProperty("errorPlace", "dateError");
//				error.addProperty("errorMessege", "Моля, въведете дата на раждане!");
//				errorsArray.add(error);
//			}
			
			respJSON.add("errors", errorsArray);
			
			return respJSON.toString();
		}
		else{
			respJSON.addProperty("error", false);
//			try {
//				resp.getWriter().append(respJSON.toString());
//			} catch (IOException e) {
//				System.out.println("oops " + e.getMessage());
//			}
		}
		
		
		User user = new User(name, familyName, email, passwordFirst, sex, LocalDate.now(), false);
		System.out.println(user);
		
		UserDAO.getInstance().addUser(user);
		
		return respJSON.toString();
		
		
//		User u = new User(name, familyName, email, password, gender, birthDate, isAdmin);
	}
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage(){
		return("technomarket_register");
	}
	
	@RequestMapping(value = "/abonirane/{productId}", method = RequestMethod.GET)
	public String sendMail(@PathVariable("productId") String productId, Model model, HttpServletRequest request){
		//TODO da vzemem artikulniya nomer na suotvetniya produkt
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		model.addAttribute("product", product);
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			User u = (User) session.getAttribute("user");
			if(u.getFavouriteProducts().contains(product)){
//				new MailSender(u.getEmail() ,"Абониране", "Успешно се абонирахте за продукт с артикулен номер: + productId +.");
				model.addAttribute("message", "Вие вече сте абонирани за този продукт.");
			}
			else{
				model.addAttribute("message", "Първо трябва да добавите този продукт в любими.");
			}
		}
		else{
			model.addAttribute("message", "Трябва да влезете в профила си, за да се абонирате.");
		}
		return "technomarket_viewProduct";
	}
	
	@RequestMapping(value = "/addFavProd/{productId}", method = RequestMethod.GET)
	public String addFavProd(@PathVariable("productId") String productId, Model model, HttpServletRequest request){
		
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			User u = (User) session.getAttribute("user");
			if(u.getFavouriteProducts().contains(product)){
				model.addAttribute("message", "Този продукт вече е добавен в любими.");
			}
			else{
				UserDAO.getInstance().addFavProducts(u, product);
				new MailSender(u.getEmail() ,"Абониране", "Вие се абонирахте за продукт с артикулен номер: " + productId + ".");
//				model.addAttribute("message", "Успешно добавихте този продукт в любими.");
				model.addAttribute("message", "Успешно добавихте този продукт в любими и се абонирахте за него.");
			}
		}
		else{
			model.addAttribute("message", "Трябва да влезете в профила си, за да добавяте в любими.");
		}
		
		model.addAttribute("product", product);
		return "technomarket_viewProduct";
	}
	
	@RequestMapping(value = "/viewFavProd", method = RequestMethod.GET)
	public String viewFavProd(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			User u = (User) session.getAttribute("user");
			LinkedHashSet<Product> favProducts = u.getFavouriteProducts();
			model.addAttribute("products", favProducts);
			model.addAttribute("favPr", true);
		}
		return "new";
	}
	
	@RequestMapping(value = "/removeFavProd/{productId}", method = RequestMethod.GET)
	public String removeFavProd(@PathVariable("productId") String productId, Model model, HttpServletRequest request){
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			User u = (User) session.getAttribute("user");
			if(u.getFavouriteProducts().contains(product)){
				UserDAO.getInstance().removeFavProducts(u, product);
				LinkedHashSet<Product> favProducts = u.getFavouriteProducts();
				model.addAttribute("products", favProducts);
				model.addAttribute("favPr", true);
			}
		}
		return "new";
	}
	
	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
	public String addToCart(Model model, HttpServletRequest request, @PathVariable("productId") String productId){
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cartProducts") == null){
			session.setAttribute("cartProducts", new LinkedHashMap<Product, Integer>());
		}
		
		LinkedHashMap<Product, Integer> cartProducts = (LinkedHashMap<Product, Integer>) session.getAttribute("cartProducts");
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		
		if(!cartProducts.containsKey(product)){
			cartProducts.put(product, 0);
		}
		int oldCntProduct = cartProducts.get(product);
		cartProducts.put(product, oldCntProduct+1);
		
		for (Entry<Product, Integer> e : cartProducts.entrySet()) {
			e.getValue();
		}
		return "technomarket_cart";
	}
	
	@RequestMapping(value = "/removeFromCart/{productId}", method = RequestMethod.POST)
	public String removeFromCart(HttpServletRequest request, @PathVariable("productId") String productId){
		HttpSession session = request.getSession();
		LinkedHashMap<Product, Integer> cartProducts = (LinkedHashMap<Product, Integer>) session.getAttribute("cartProducts");
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		cartProducts.remove(product);
		return "technomarket_cart";
	}
	
	@RequestMapping(value = "/setNewQuantity/{productId}/{quantity}", method = RequestMethod.POST)
	public void setNewQuantity(Model model, HttpServletRequest request, 
								@PathVariable("productId") String productId,
								@PathVariable("quantity") String quantity
								){
		
		int newQuantity = Integer.parseInt(quantity);
		HttpSession session = request.getSession();	
		LinkedHashMap<Product, Integer> cartProducts = (LinkedHashMap<Product, Integer>) session.getAttribute("cartProducts");
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		cartProducts.put(product, newQuantity);
	}
	
	
	@RequestMapping(value = "/orderPage", method = RequestMethod.GET)
	public String orderPage(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			return "technomarket_order";
		}
		else{
			model.addAttribute("message", "Моля, влезте в профила си, за да завършите поръчката.");
			return "technomarket_cart";
		}
	}
	
	
	
}
