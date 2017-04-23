package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;

@Controller
@RequestMapping(value="/forgotPass")
public class ForgotPasswordController {
	
	@RequestMapping(value = "/forgotPass", method = RequestMethod.POST)
	protected String sendMail(HttpServletRequest request){
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
//		request.getRequestDispatcher(htmlFile).forward(request, response);
		return("forward:" + htmlFile);
	}
	
	@RequestMapping(value = "/forgotPassSend", method = RequestMethod.GET)
	protected String sendEmail(){
		return("technomarket_forgotPass");
	}


}
