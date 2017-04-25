package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDAO;

@Controller
@RequestMapping(value="/forgotPass")
public class ForgotPasswordController {
	
	@RequestMapping(value = "/forgotPass", method = RequestMethod.POST)
	protected String sendMail(HttpServletRequest request, Model model){
		String email = request.getParameter("email");
		if(!email.isEmpty()){
			if(!UserDAO.getInstance().getAllUsers().containsKey(email)) {
				model.addAttribute("message", "Не съществува такъв email.");
			} 
			else{
				String password = UserDAO.getInstance().getAllUsers().get(email).getPassword();
				new MailSender(email, "Забравена парола", "Вашата парола е " + password + ".");
				model.addAttribute("message", "Паролата Ви беше изпратена на email.");
			}
		}
		else{
			model.addAttribute("message", "Не сте въвели email.");
		}
		return("technomarket_forgotPass");
	}
	
	@RequestMapping(value = "/forgotPassSend", method = RequestMethod.GET)
	protected String sendEmail(){
		return("technomarket_forgotPass");
	}


}
