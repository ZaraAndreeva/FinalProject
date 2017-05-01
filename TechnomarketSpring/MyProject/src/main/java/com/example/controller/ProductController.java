package com.example.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.example.dao.ProductDAO;
import com.example.krasiModel.Product;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@ResponseBody
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model,  HttpServletRequest req, HttpServletResponse resp){
		
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
		
		String description = obj.get("description").getAsString().trim();
		String quantity = obj.get("quantity").getAsString().trim();
		String price = obj.get("price").getAsString().trim();
		String brand = obj.get("brand").getAsString().trim();
		String name = obj.get("name").getAsString().trim();
		String subCategory = obj.get("subCategory").getAsString().trim();
		
		
		if(!Product.validProduct(description, quantity, price, brand, "ddd", subCategory, 
				name)){
			respJSON.addProperty("error", true);
			JsonArray errorsArray = new JsonArray();
			if(!Product.validText(description)){
//				errorsArray.add(new JsonPrimitive("descriptionError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "descriptionError");
				error.addProperty("errorMessege", "Моля, въведете описание!");
				errorsArray.add(error);
				
			}
			if(!Product.validQuantity(quantity)){
//				errorsArray.add(new JsonPrimitive("quantityError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "quantityError");
				error.addProperty("errorMessege", "Моля, въведете положително число!");
				errorsArray.add(error);
				
			}
			if(!Product.validPrice(price)){
//				errorsArray.add(new JsonPrimitive("priceError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "priceError");
				error.addProperty("errorMessege", "Моля, въведете положително число за цена!");
				errorsArray.add(error);
				
			}
			if(!Product.validText(brand)){
//				errorsArray.add(new JsonPrimitive("brandError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "brandError");
				error.addProperty("errorMessege", "Моля, въведете марка!");
				errorsArray.add(error);
				
			}
			if(!Product.validText(name)){
//				errorsArray.add(new JsonPrimitive("urlError"));
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Моля, въведете име!");
				errorsArray.add(error);
				
			}
			if(!Product.validSubCategory(subCategory)){
//				errorsArray.add(new JsonPrimitive("subCategoryError"));
				System.out.println(subCategory);
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "subCategoryError");
				error.addProperty("errorMessege", "Такава подкатегория не съществува!");
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
		
		Product p = new Product(subCategory, description, 
				Integer.parseInt(quantity), Double.parseDouble(price), 0, brand, name);
		
		System.out.println(p);
		
		ProductDAO.getInstance().addProduct(p);
		
		System.out.println(sb);
		
		respJSON.addProperty("productId", p.getProductId());
	
		return respJSON.toString();
	}
	
	@RequestMapping(value = "/viewProductPage/{productId}", method = RequestMethod.GET)
	public String viewProduct(@PathVariable("productId") String productId, Model model){
		//TODO validating if productId is Integer
		Product product = ProductDAO.getInstance().getAllProducts().get(Long.parseLong(productId));
		model.addAttribute("product", product);
		return "technomarket_viewProduct";
	}
	
}
