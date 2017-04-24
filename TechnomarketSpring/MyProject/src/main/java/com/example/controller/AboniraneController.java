package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/abonirane")
public class AboniraneController {
	
	@RequestMapping(value = "/abonirane", method = RequestMethod.POST)
	protected String sendMail(HttpServletRequest request){
		//TODO da vzemem artikulniya nomer na suotvetniya produkt
//		new MailSender("Абониране", "Вие се абонирахте за продукт: " +  + ".");
		
		return "new";
	}

}
