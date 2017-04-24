package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;
import com.example.krasiModel.User;




import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDAO;
import com.example.krasiModel.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request){
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
			//TODO
//			response.sendRedirect("errorLogin.html");
			return ("redirect:errorLogin.html");
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
	
	@RequestMapping(value = "/favProductsPage", method = RequestMethod.GET)
	public String favouriteProductsPage(){
		return("technomarket_favProducts");
	}
	
	@RequestMapping(value = "/cartPage", method = RequestMethod.GET)
	public String cartPage(){
		return("technomarket_cart");
	}

//		response.sendRedirect("index.jsp");
	
	
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest req){
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
		
		System.out.println("************");
		System.out.println(name);
		System.out.println(familyName);
		System.out.println(email);
		System.out.println(passwordFirst);
		System.out.println(passwordSecond);
		System.out.println(sex);
		System.out.println("***********");
		
		
//		User u = new User(name, familyName, email, password, gender, birthDate, isAdmin);
	}
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage(){
		return("technomarket_register");
	}
	
}
