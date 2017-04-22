package com.example.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.example.dao.ProductDAO;
import com.example.krasiModel.Product;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@ResponseBody
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model,  HttpServletRequest req, HttpServletResponse resp){

//	System.out.println("hello");
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("oops " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		JsonObject respJSON = new JsonObject();
		
		String description = obj.get("description").getAsString();
		String quantity = obj.get("quantity").getAsString();
		String price = obj.get("price").getAsString();
		String brand = obj.get("brand").getAsString();
		String pictureUrl = obj.get("pictureUrl").getAsString();
		String subCategory = obj.get("subCategory").getAsString();
		String subSubCategory = obj.get("subSubCategory").getAsString();
		
		
		if(!Product.validProduct(description, quantity, price, brand, pictureUrl, subCategory, 
				subSubCategory)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(!Product.validText(description)){
//				errorsArray.add(new JsonPrimitive("descriptionError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "descriptionError");
				error.addProperty("errorMessege", "Please, add a description!");
				errorsArray.add(error);
				
			}
			if(!Product.validQuantity(quantity)){
//				errorsArray.add(new JsonPrimitive("quantityError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "quantityError");
				error.addProperty("errorMessege", "Please, enter a valid quantity!");
				errorsArray.add(error);
				
			}
			if(!Product.validPrice(price)){
//				errorsArray.add(new JsonPrimitive("priceError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "priceError");
				error.addProperty("errorMessege", "Please, add a valid price!");
				errorsArray.add(error);
				
			}
			if(!Product.validText(brand)){
//				errorsArray.add(new JsonPrimitive("brandError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "brandError");
				error.addProperty("errorMessege", "Please, add a valid brand!");
				errorsArray.add(error);
				
			}
			if(!Product.validPictureUrl(pictureUrl)){
//				errorsArray.add(new JsonPrimitive("urlError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "urlError");
				error.addProperty("errorMessege", "Please, add a valid picture url!");
				errorsArray.add(error);
				
			}
			if(!Product.validSubCategory(subCategory)){
//				errorsArray.add(new JsonPrimitive("subCategoryError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "subCategoryError");
				error.addProperty("errorMessege", "Please, add an existing sub-category!");
				errorsArray.add(error);
				
			}
			respJSON.add("errors", errorsArray);
//			try {
//				resp.getWriter().append(respJSON.toString());
//			} catch (IOException e) {
//				System.out.println("oops " + e.getMessage());
//			}
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
		
		//TODO
//		if(!User.validSubSubCategory(subSubCategory)){
//			
//		}

		
		
		Product p = new Product(subCategory, subSubCategory, description, 
				Integer.parseInt(quantity), Double.parseDouble(price), 0, brand, pictureUrl);
		System.out.println(p);
		
		ProductDAO.getInstance().addProduct(p);
		
		System.out.println(sb);
		
		
		return respJSON.toString();
	}
	
}
