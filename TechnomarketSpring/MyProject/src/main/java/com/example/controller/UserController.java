package com.example.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;
import com.example.krasiModel.User;



@Controller
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
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request){
		String name = request.getParameter("name");
		String familyName = request.getParameter("family_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthdate");
	
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.parse(birthDate, formatter);
		
		User u = new User(name, familyName, email, password, gender, date, false);
		UserDAO.getInstance().addUser(u);
		//TODO
//		response.sendRedirect("uspeshnaRegistraciya.html");
		return ("redirect:uspeshnaRegistraciya.html");
	}
	
	
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

}
