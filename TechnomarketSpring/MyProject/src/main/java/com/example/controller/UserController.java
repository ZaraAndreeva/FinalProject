package com.example.controller;

import java.time.LocalDate;

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
import com.example.dao.OrderDAO;
import com.example.dao.ProductDAO;
import com.example.dao.UserDAO;
import com.example.krasiModel.Order;
import com.example.krasiModel.Product;
import com.example.krasiModel.User;




import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model){
//		String email = request.getParameter("email").trim();
//		String password = request.getParameter("password").trim();
//		
//		if(UserDAO.getInstance().validLogin(email, password)){
//			User u = UserDAO.getInstance().getAllUsers().get(email);
//			HttpSession session = request.getSession();
//			session.setAttribute("user", u);
//			session.setMaxInactiveInterval(3000);
//			session.setAttribute("logged", true);
//			//TODO
////			response.sendRedirect("index.jsp");
////			return "new";
//			request.setAttribute("search", "");
//			return new ModelAndView("forward:/search/search");
//			
//		}
//		else{
//			model.addAttribute("message", "Въвели сте грешно потребителско име или парола.");
////			return "technomarket_login";
//			
//			return new ModelAndView("forward:/user/loginPage");
//			
//		}
		
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with login user " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		JsonObject respJSON = new JsonObject();
	
		String email = obj.get("email").getAsString().trim();
		String password = obj.get("password").getAsString().trim();
		
		if(!UserDAO.getInstance().validLogin(email, password)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			JsonObject error = new JsonObject();
			error.addProperty("errorPlace", "emailError");
			error.addProperty("errorMessege", "Невалиден e-mail или парола!");
			errorsArray.add(error);	
			
			respJSON.add("errors", errorsArray);
			
			return respJSON.toString();
		}
		else{
			respJSON.addProperty("error", false);
			User u = UserDAO.getInstance().getAllUsers().get(email);
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			session.setMaxInactiveInterval(3000);
			session.setAttribute("logged", true);
			req.setAttribute("search", "");
		}
		
		return respJSON.toString();
		
	}
	
	@RequestMapping(value = "/loginPage", method = {RequestMethod.GET, RequestMethod.POST})
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
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.setAttribute("logged", false);
		request.getSession().invalidate();
//		return ("new");
		return new ModelAndView("forward:/user/loginPage");
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
	public String ordersPage(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			return "technomarket_register";
		}
		else{
			if(!(Boolean)session.getAttribute("logged") || session.getAttribute("logged") == null){
				return "technomarket_register";
			}
		}
		model.addAttribute("orders", user.getOrders().values());
		
		
		
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
		
		String name = obj.get("name").getAsString().trim();
		String familyName = obj.get("familyName").getAsString().trim();
		String email = obj.get("email").getAsString().trim();
		String passwordFirst = obj.get("passwordFirst").getAsString().trim();
		String passwordSecond = obj.get("passwordSecond").getAsString().trim();
		String sex = (obj.get("sex")!= null)?  obj.get("sex").getAsString() : "0";
//		String birthDate = obj.get("birthDate").getAsString();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//        LocalDate date = LocalDate.parse(birthDate, formatter);
		

//		System.out.println("************");
//		System.out.println(name);
//		System.out.println(familyName);
//		System.out.println(email);
//		System.out.println(passwordFirst);
//		System.out.println(passwordSecond);
//		System.out.println(sex);
//		System.out.println("***********");
		
		
		if(!User.validUser(name, familyName, email, passwordFirst, passwordSecond, sex)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(!User.validText(name)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Моля, въведете име!");
				errorsArray.add(error);
			}
			if(!User.validText(familyName)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "familyNameError");
				error.addProperty("errorMessege", "Моля, въведете фамилно име!");
				errorsArray.add(error);
				
			}
			if(!User.validEmail(email)){
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
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "sexError");
				error.addProperty("errorMessege", "Моля, въведете пол!");
				errorsArray.add(error);
				
			}
			
			if(name.length() > 45){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Името е прекалено дълго!");
				errorsArray.add(error);
			}
			if(familyName.length() > 45){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "familyNameError");
				error.addProperty("errorMessege", "Името е прекалено дълго!");
				errorsArray.add(error);
			}
			if(passwordFirst.length() > 45){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "passwordFirstError");
				error.addProperty("errorMessege", "Паролата е твърде дълга!");
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
		}
		
		User user = new User(name, familyName, email, passwordFirst, sex, LocalDate.now(), false);
		System.out.println(user);
		
		UserDAO.getInstance().addUser(user);
		
		return respJSON.toString();
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage(){
		return("technomarket_register");
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
			UserDAO.getInstance().fillFavProducts(u);
//			LinkedHashSet<Product> favProducts = ProductDAO.getInstance().viewFavProducts(u);
			LinkedHashSet<Product> favProducts = u.getFavouriteProducts();
			if(favProducts.isEmpty()){
				model.addAttribute("message123", "Няма налични любими продукти.");
			}
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
//				LinkedHashSet<Product> favProducts = ProductDAO.getInstance().viewFavProducts(u);
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
		System.out.println(session.getAttribute("cartPrice"));
		
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
	
	@ResponseBody
	@RequestMapping(value = "/setNewQuantity/{productId}/{quantity}", method = RequestMethod.POST)
	public String setNewQuantity(Model model, HttpServletRequest request, 
								@PathVariable("productId") String productId,
								@PathVariable("quantity") String quantity){
		String regex = "[0-9]+";
		if(!quantity.matches(regex)){
			quantity = "0";
		}
		int newQuantity = Integer.parseInt(quantity);
		HttpSession session = request.getSession();	
		LinkedHashMap<Product, Integer> cartProducts = (LinkedHashMap<Product, Integer>) session.getAttribute("cartProducts");
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		int oldCntProduct = cartProducts.get(product);
		cartProducts.put(product, newQuantity);
		
		double newCartPrice = 0.0;
		for (Entry<Product, Integer> entry : cartProducts.entrySet()) {
			newCartPrice += (entry.getKey().getPrice() * entry.getValue());
		}
		
		JsonObject respJSON = new JsonObject();
		JsonArray respArray = new JsonArray();
		JsonObject change1 = new JsonObject();
		change1.addProperty("place", "total_product_price_"+productId);
		change1.addProperty("messege", product.getPrice() * cartProducts.get(product));
		JsonObject change2 = new JsonObject();
		change2.addProperty("place", "total_cart_price");
		change2.addProperty("messege", newCartPrice);
		respArray.add(change1);
		respArray.add(change2);
		
		respJSON.add("changes", respArray);
		
		return respJSON.toString();
	}
	
	
	@RequestMapping(value = "/orderPage/{orderId}", method = RequestMethod.GET)
	public String orderPage(Model model, HttpServletRequest request, @PathVariable("orderId") String orderId){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(session.getAttribute("user") != null){
			Order order = user.getOrders().get(Long.parseLong(orderId));
			
//			for (Order o : user.getOrders().values()) {
//				if(o.getOrderId() == Long.parseLong(orderId)){
//					order = o;
//					break;
//				}
//			}
			
			
			for (Entry<Product, Integer> entry : order.getProducts().entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
			
			model.addAttribute("order", order);
			
			return "technomarket_order";
		}
		else{
			model.addAttribute("message", "Моля, влезте в профила си, за да завършите поръчката.");
			return "technomarket_cart";
		}
	}
	
	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public String addOrder(HttpServletRequest request){
		HttpSession session = request.getSession();
		LinkedHashMap<Product, Integer> cartProducts = (LinkedHashMap<Product, Integer>) session.getAttribute("cartProducts");
		
		User user = (User) session.getAttribute("user");
		String userEmail = user.getEmail();
		double cartPrice = 0;
		LinkedHashMap<Product, Integer> productsForOrder = new LinkedHashMap<>();
		for (Entry<Product, Integer> entry : cartProducts.entrySet()) {
			productsForOrder.put(entry.getKey(), entry.getValue());
			
			cartPrice += (entry.getKey().getPrice() * entry.getValue());
		}
		
		Order order = new Order(LocalDate.now(), "Непотвърдена", userEmail, cartPrice, "", "", "", "", "", 0, "", 0, 0, "", productsForOrder);
		System.out.println(order);
		OrderDAO.getInstance().addOrder(order, user);
		session.removeAttribute("cartProducts");
		return("technomarket_register");
	}
	
	@ResponseBody
	@RequestMapping(value = "/finishOrder/{orderId}", method = RequestMethod.POST)
	public String finishOrder(HttpServletRequest request, @PathVariable("orderId") String orderId){
		Scanner sc = null;
		try {
			sc = new Scanner(request.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with finishOrder" + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		JsonObject respJSON = new JsonObject();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int orderIdInt = Integer.parseInt(orderId);
//		Order order = OrderDAO.getInstance().getAllOrders().get((long)orderIdInt);
		Order order = user.getOrders().get((long)orderIdInt);
		
//		for (Order userOrder : user.getOrders()) {
//			if(userOrder == order){
//				System.out.println("yeeeeeeeeeeeeeeeeeeeees");
//			}
//		}
		
		String name = obj.get("name").getAsString();
		String familyName = obj.get("familyName").getAsString();
		String phone = obj.get("phone").getAsString();
		String town = obj.get("city").getAsString();
		String street = obj.get("street").getAsString();
		
		if(!Order.validOrder(name, familyName, phone, town, street)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(!User.validText(name)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Моля, въведете име!");
				errorsArray.add(error);
				
			}
			if(!User.validText(familyName)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "familyNameError");
				error.addProperty("errorMessege", "Моля, въведете фамилно име!");
				errorsArray.add(error);
				
			}
			if(!Order.validPhone(phone)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "phoneError");
				error.addProperty("errorMessege", "Моля, въведете валиден телефонен номер(в момента поддържаме български и американски формат)!");
				errorsArray.add(error);
			}
			if(!User.validText(town)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "cityError");
				error.addProperty("errorMessege", "Моля, въведете град!");
				errorsArray.add(error);
			}
			if(!User.validText(street)){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "streetError");
				error.addProperty("errorMessege", "Моля, въведете улица!");
				errorsArray.add(error);
			}
			
			respJSON.add("errors", errorsArray);
			System.out.println(respJSON);
			return respJSON.toString();
		}
		else{
			respJSON.addProperty("error", false);
		}
		
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, name, "name", "String");
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, familyName, "familyName", "String");
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, phone, "phone", "String");
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, city, "town", "String");
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, street, "street", "String");
//		OrderDAO.getInstance().updateOrderIntColumn(orderIdInt, status, "status", "Изчакване");
		
		OrderDAO.getInstance().updateOrderName(name, orderIdInt);
		order.setName(name);
		OrderDAO.getInstance().updateOrderFamilyName(familyName, orderIdInt);
		order.setFamilyName(familyName);
		OrderDAO.getInstance().updateOrderPhone(phone, orderIdInt);
		order.setPhone(phone);
		OrderDAO.getInstance().updateOrderTown(town, orderIdInt);
		order.setTown(town);
		OrderDAO.getInstance().updateOrderStreet(street, orderIdInt);
		order.setStreet(street);
		OrderDAO.getInstance().updateOrderStatus("Потвърдена", orderIdInt);
		order.setStatus("Потвърдена");
		System.out.println("order");
		System.out.println(order);
		System.out.println("order");
		
		
		
		if(obj.get("block") != null){
			if(!obj.get("block").getAsString().trim().isEmpty()){
				int block = Integer.parseInt(obj.get("block").getAsString());
				OrderDAO.getInstance().updateOrderBlock(block, orderIdInt);;
				order.setBlock(block);
			}
		}
		if(obj.get("entrance") != null){
			if(!obj.get("entrance").getAsString().trim().isEmpty()){
				String entrance = obj.get("entrance").getAsString();
				OrderDAO.getInstance().updateOrderEntrance(entrance, orderIdInt);;
				order.setEntrance(entrance);
			}
		}
		if(obj.get("floor") != null){
			if(!obj.get("floor").getAsString().trim().isEmpty()){
				int floor = Integer.parseInt(obj.get("floor").getAsString());
				OrderDAO.getInstance().updateOrderFloor(floor, orderIdInt);;
				order.setFloor(floor);
			}
		}
		if(obj.get("apartment") != null){
			if(!obj.get("apartment").getAsString().trim().isEmpty()){
				int apartment = Integer.parseInt(obj.get("apartment").getAsString());
				OrderDAO.getInstance().updateOrderApartment(apartment, orderIdInt);;
				order.setApartment(apartment);
			}
		}
		if(obj.get("descriptionAddress") != null){
			if(!obj.get("descriptionAddress").getAsString().trim().isEmpty()){
				System.out.println("hello");
				String descriptionAddress = obj.get("descriptionAddress").getAsString();
				OrderDAO.getInstance().updateOrderDescriptionAddress(descriptionAddress, orderIdInt);;
				order.setDescriptionAddress(descriptionAddress);
			}
		}
		
		return respJSON.toString();
	}
	
	
	
	
	
}
