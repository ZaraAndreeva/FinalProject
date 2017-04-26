package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.example.krasiModel.Product;
import com.example.krasiModel.User;

public class ProductDAO {
	
	private static ProductDAO instance;
	private static final HashMap<Long, Product> allProducts = new HashMap<>();
	
	public ProductDAO() {
	
	}

	public synchronized static ProductDAO getInstance(){
		if(instance == null){
			instance = new ProductDAO();
		}
		return instance;
	}
	
	public void addProduct(Product p){
		
		//TODO if is admin

		int subCategoryId = SubCategoryDAO.getInstance().getAllSubCategories().get(p.getSubCategory());
		String sql = "INSERT INTO products (description, quantity, price, promo_price, brand, picture_url, sub_category, sub_sub_category) "
				+ "values (?, ?, ?, ?, ?, ?, "
				+ "(SELECT sub_category_id from sub_categories where sub_category_id = " + subCategoryId + "), "
				+ "(SELECT sub_sub_category_id from  sub_sub_categories where sub_sub_category_id = 2))";

		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getDescription());
			st.setInt(2, p.getQuantity());
			st.setDouble(3, p.getPrice());
			st.setDouble(4, p.getPromoPrice());
			st.setString(5, p.getBrand());
			st.setString(6, p.getPictureUrl());

//			st.setString(7, p.getSubCategory());
//			st.setString(8, p.getSubSubCategory());
			
			synchronized(this){
				st.execute();
			}
			
			res = st.getGeneratedKeys();
			res.next();
			long productId = res.getLong(1);
			p.setProductId(productId);
			allProducts.put(productId, p);
		} catch (SQLException e) {
				System.out.println("addProduct: " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("oops " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("oops " + e.getMessage());
					
				}
			}
		}
	}
	
	public void addFavouriteProduct(Product p, User u){
 		String sql = "insert into favourite_products (user_id, product_id) values ((select user_id from users where user_id = user_id),(select product_id from products where product_id = product_id))";
 		PreparedStatement st = null;
 		ResultSet res = null;
 		try{
 			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
 			st.setLong(1, u.getUserId());
			st.setLong(2, p.getProductId());
 			res = st.getGeneratedKeys();
 			res.next();
 			u.addFavouriteProduct(p);
 		} catch (SQLException e) {
 			System.out.println("addProduct: " + e.getMessage());
 		}
 		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("oops " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("oops " + e.getMessage());
					
				}
			}
		}
	}
	
	public HashMap<Long, Product> getAllProducts(){
		if(allProducts.isEmpty()){
			String sql = "SELECT product_id, description, quantity, price, promo_price, brand, picture_url, sub_category, sub_sub_category FROM products";
			PreparedStatement st = null;
			ResultSet set = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				set = st.executeQuery();
				
				while(set.next()){
					long productId = set.getInt("product_id");
					String subCategory = set.getString("sub_category");
					String subSubCategory = set.getString("sub_sub_category");
					String description = set.getString("description");
					int quantity = set.getInt("quantity");
					double price = set.getDouble("price");
					double promoPrice = set.getDouble("promo_price");
					String brand = set.getString("brand");
					String pictureUrl = set.getString("picture_url");	
					
					String subCategoryString = new String();
					for (Entry<String, Integer> e : SubCategoryDAO.getInstance().getAllSubCategories().entrySet()) {
						if(e.getValue() == Integer.parseInt(subCategory)){
							subCategoryString = e.getKey();
						}
					}
					
					Product p = new Product(subCategoryString, subSubCategory, description, quantity, price, promoPrice, brand, pictureUrl);
					p.setProductId(productId);
					
					allProducts.put(productId, p);	
				}
			} catch(SQLException e){
				System.out.println("getAllProducts: " + e.getMessage());
			}
			finally {
				if(st != null){
					try {
						st.close();
					} catch (SQLException e) {
						System.out.println("oops " + e.getMessage());
					}
				}
			}
		}

		return allProducts;
	}
	
	public synchronized ArrayList<Product> giveProductsBySubCategory(String subCategory){
		ArrayList<Product> generatedProducts = new ArrayList<>();
		
		getAllProducts();
		
		for (Product product : allProducts.values()) {
			if(product.sameSubCategory(subCategory)){
				generatedProducts.add(product);
			}
		}
		
		if(generatedProducts.isEmpty()){
			return null;
		}
		
//		return generatedProducts;
		return generatedProducts;
	}
	
	public List<Product> searchProduct(String search){
		ArrayList<Product> searchResults = new ArrayList<>();
		getAllProducts();
		for(Product p : allProducts.values()){
			//TODO
			if(p.getDescription().contains(search) || p.getSubCategory().contains(search) || p.getBrand().contains(search)){
				searchResults.add(p);
			}
		}
		return Collections.unmodifiableList(searchResults);
	}
	
	public void deleteProduct(Product p){
		String sql = "DELETE from products WHERE product_id = ?";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, p.getProductId());
			synchronized(this){
				st.execute();
			}
			res = st.getGeneratedKeys();
			res.next();
			allProducts.remove(p.getProductId());
		} catch (SQLException e) {
				System.out.println("deleteProduct: " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("deleteProduct " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("deleteProduct " + e.getMessage());
					
				}
			}
		}
	}
	
	public void addPromotion(double newPrice, long artNomer){
		String sql = "UPDATE products set promo_price = ? WHERE product_id = ?";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setDouble(1, newPrice);
			st.setLong(2, artNomer);
			synchronized(this){
				st.execute();
			}
			res = st.getGeneratedKeys();
			res.next();
		} catch (SQLException e) {
				System.out.println("addPromotion: " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("addPromotion: " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("addPromotion: " + e.getMessage());
					
				}
			}
		}
	}
	
	public void removePromotion(double price, long artNomer){
		String sql = "UPDATE products set price = ?, promo_price = 0 WHERE product_id = ?";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setDouble(1, price);
			st.setLong(2, artNomer);
			synchronized(this){
				st.execute();
			}
			res = st.getGeneratedKeys();
			res.next();
			allProducts.get(artNomer).setPromoPrice(0.0);
			allProducts.get(artNomer).setPrice(price);
		} catch (SQLException e) {
				System.out.println("addPromotion: " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("addPromotion: " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("addPromotion: " + e.getMessage());
					
				}
			}
		}
	}
	
	public void editProduct(long artikulenNomer, int quantity, double price){
		String sql = "UPDATE products set quantity = ?, price = ? WHERE product_id = ?";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, quantity);
			st.setDouble(2, price);
			st.setLong(3, artikulenNomer);
			synchronized(this){
				st.execute();
			}
			res = st.getGeneratedKeys();
			res.next();
		} catch (SQLException e) {
				System.out.println("editProduct: " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("editProduct " + e.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e) {
					System.out.println("editProduct " + e.getMessage());
					
				}
			}
		}
	}

}
