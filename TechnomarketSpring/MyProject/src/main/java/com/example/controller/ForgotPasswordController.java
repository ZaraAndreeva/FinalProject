package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDAO;

@RestController
@RequestMapping(value="/forgotPass")
public class ForgotPasswordController {
	
	@RequestMapping(value = "/forgotPass", method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String email = request.getParameter("email");
		String htmlFile="";
		if(!UserDAO.getInstance().getAllUsers().containsKey(email)) {
			htmlFile="forgotPassword.html";
		} 
		else{
			htmlFile="index.html";
			String password = UserDAO.getInstance().getAllUsers().get(email).getPassword();
			new MailSender(email, "Забравена парола", "Вашата парола е " + password + ".");
		}
		request.getRequestDispatcher(htmlFile).forward(request, response);
		
	}


}
