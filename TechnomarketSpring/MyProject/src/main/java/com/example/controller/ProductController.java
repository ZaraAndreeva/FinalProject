package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.TreeSet;

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
			if(name.length() > 50){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "nameError");
				error.addProperty("errorMessege", "Името е прекалено дълго!");
				errorsArray.add(error);
			}
			if(brand.length() > 45){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "brandError");
				error.addProperty("errorMessege", "Името е прекалено дълго!");
				errorsArray.add(error);
			}
			if(description.length() > 2000){
				JsonObject error = new JsonObject();
				error.addProperty("errorPlace", "descriptionError");
				error.addProperty("errorMessege", "Описанието е твърде дълго!");
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
	
	@ResponseBody
	@RequestMapping(value = "/sortProductsByName/{subCategory}", method = RequestMethod.POST)
	public String sortProducts(Model model, @PathVariable("subCategory") String subCategory, HttpServletRequest req){
		System.out.println("HELLO");
		
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with get min and max price in sortProductsByName" + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		double minPrice = Double.parseDouble(obj.get("minPrice").getAsString());
		double maxPrice = Double.parseDouble(obj.get("maxPrice").getAsString());
		
		ArrayList<Product> products = ProductDAO.getInstance().giveProductsBySubCategory(subCategory);
		TreeSet<Product> prodByName = new TreeSet<>(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		for(Product p : products){
			if(p.getPrice() >= minPrice && p.getPrice() <= maxPrice){
				prodByName.add(p);
			}
		}

//		model.addAttribute("categorySearch", true);
//		model.addAttribute("products", prodByName);
		
		
		JsonObject respJson = new JsonObject();
		JsonArray productsArray = new JsonArray();
		for (Product product : prodByName) {
			JsonObject productObj = new JsonObject();
			productObj.addProperty("id", product.getProductId());
			productObj.addProperty("name", product.getName());
			productObj.addProperty("price", product.getPrice());
			productObj.addProperty("promoPrice", product.getPromoPrice());
			productObj.addProperty("viewProductLink", "http://localhost:8080/TechnomarketSpring/product/viewProductPage/" + product.getProductId());
			productObj.addProperty("viewProductImage", "/TechnomarketSpring/image/" + product.getProductId());
			productObj.addProperty("inPromotion", (product.getPromoPrice() > 0)? true : false);
			productsArray.add(productObj);
		}
		respJson.add("products", productsArray);
		
		return respJson.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/sortProductsByPriceAsc/{subCategory}", method = RequestMethod.POST)
	public String sortProductsByPriceVuz(Model model, @PathVariable("subCategory") String subCategory, HttpServletRequest req){

		
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with get min and max price in sortProductsByName" + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		double minPrice = Double.parseDouble(obj.get("minPrice").getAsString());
		double maxPrice = Double.parseDouble(obj.get("maxPrice").getAsString());
		
		ArrayList<Product> products = ProductDAO.getInstance().giveProductsBySubCategory(subCategory);
		TreeSet<Product> prodByPriceAsc = new TreeSet<>(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				if(o1.getPromoPrice() != 0 && o2.getPromoPrice() != 0){
					return o1.getPromoPrice() < o2.getPromoPrice() ? -1 : o1.getPromoPrice() == o2.getPromoPrice() ? 0 : 1;
				}
				else{
					if(o1.getPromoPrice() != 0 && o2.getPromoPrice() == 0){
						return o1.getPromoPrice() < o2.getPrice() ? -1 : o1.getPromoPrice() == o2.getPrice() ? 0 : 1;
					}
					else{
						if(o1.getPromoPrice() == 0 && o2.getPromoPrice() != 0){
							return o1.getPrice() < o2.getPromoPrice() ? -1 : o1.getPrice() == o2.getPromoPrice() ? 0 : 1;
						}
						else{
							return o1.getPrice() < o2.getPrice() ? -1 : o1.getPrice() == o2.getPrice() ? 0 : 1;
						}
					}
				}
			}
		});

		for(Product p : products){
			if(p.getPrice() >= minPrice && p.getPrice() <= maxPrice){
				prodByPriceAsc.add(p);
				
			}
			
		}

//		model.addAttribute("categorySearch", true);
//		model.addAttribute("products", prodByPriceAsc);
		
		JsonObject respJson = new JsonObject();
		JsonArray productsArray = new JsonArray();
		for (Product product : prodByPriceAsc) {
			JsonObject productObj = new JsonObject();
			productObj.addProperty("id", product.getProductId());
			productObj.addProperty("name", product.getName());
			productObj.addProperty("price", product.getPrice());
			productObj.addProperty("promoPrice", product.getPromoPrice());
			productObj.addProperty("viewProductLink", "http://localhost:8080/TechnomarketSpring/product/viewProductPage/" + product.getProductId());
			productObj.addProperty("viewProductImage", "/TechnomarketSpring/image/" + product.getProductId());
			productObj.addProperty("inPromotion", (product.getPromoPrice() > 0)? true : false);
			productsArray.add(productObj);
		}
		respJson.add("products", productsArray);
		
		return respJson.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/sortProductsByPriceDesc/{subCategory}", method = RequestMethod.POST)
	public String sortProductsByPriceNiz(Model model, @PathVariable("subCategory") String subCategory, HttpServletRequest req){
		Scanner sc = null;
		try {
			sc = new Scanner(req.getInputStream());
		} catch (IOException e) {
			System.out.println("problem with get min and max price in sortProductsByName" + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()){
			sb.append(sc.nextLine());
		}
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();
		
		double minPrice = Double.parseDouble(obj.get("minPrice").getAsString());
		double maxPrice = Double.parseDouble(obj.get("maxPrice").getAsString());
		
		ArrayList<Product> products = ProductDAO.getInstance().giveProductsBySubCategory(subCategory);
		TreeSet<Product> prodByPriceDesc = new TreeSet<>(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				if(o1.getPromoPrice() != 0 && o2.getPromoPrice() != 0){
					return o2.getPromoPrice() < o1.getPromoPrice() ? -1 : o1.getPromoPrice() == o2.getPromoPrice() ? 0 : 1;
				}
				else{
					if(o1.getPromoPrice() != 0 && o2.getPromoPrice() == 0){
						return o2.getPrice() < o1.getPromoPrice() ? -1 : o1.getPromoPrice() == o2.getPrice() ? 0 : 1;
					}
					else{
						if(o1.getPromoPrice() == 0 && o2.getPromoPrice() != 0){
							return o2.getPromoPrice() < o1.getPrice() ? -1 : o1.getPrice() == o2.getPromoPrice() ? 0 : 1;
						}
						else{
							return o2.getPrice() < o1.getPrice() ? -1 : o1.getPrice() == o2.getPrice() ? 0 : 1;
						}
					}
				}
			}
		});

		for(Product p : products){
			if(p.getPrice() >= minPrice && p.getPrice() <= maxPrice){
				prodByPriceDesc.add(p);
				
			}
		}
		
//		model.addAttribute("categorySearch", true);
//		model.addAttribute("products", prodByPriceNiz);
//		
//		return "new";
		
		
		
		JsonObject respJson = new JsonObject();
		JsonArray productsArray = new JsonArray();
		
		for (Product product : prodByPriceDesc) {
			JsonObject productObj = new JsonObject();
			productObj.addProperty("id", product.getProductId());
			productObj.addProperty("name", product.getName());
			productObj.addProperty("price", product.getPrice());
			productObj.addProperty("promoPrice", product.getPromoPrice());
			productObj.addProperty("viewProductLink", "http://localhost:8080/TechnomarketSpring/product/viewProductPage/" + product.getProductId());
			productObj.addProperty("viewProductImage", "/TechnomarketSpring/image/" + product.getProductId());
			productObj.addProperty("inPromotion", (product.getPromoPrice() > 0)? true : false);
			productsArray.add(productObj);
		}
		respJson.add("products", productsArray);
		
		return respJson.toString();

	}
	
}
