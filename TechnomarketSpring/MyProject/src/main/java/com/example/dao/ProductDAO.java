package com.example.dao;

import java.sql.Connection;
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

		int subCategoryId = SubCategoryDAO.getInstance().getAllSubCategories().get(p.getSubCategory());
		String sql = "INSERT INTO products (description, quantity, price, promo_price, brand, name, sub_category) values (?, ?, ?, ?, ?, ?,(SELECT sub_category_id from sub_categories where sub_category_id = ?))";
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			st.setString(1, p.getDescription());
			st.setInt(2, p.getQuantity());
			st.setDouble(3, p.getPrice());
			st.setDouble(4, p.getPromoPrice());
			st.setString(5, p.getBrand());
			st.setString(6, p.getName());
			st.setInt(7, subCategoryId);
			
			synchronized(this){
				st.execute();
			}
			
			res.next();
			long productId = res.getLong(1);
			
			p.setProductId(productId);
			allProducts.put(productId, p);
		} catch (SQLException e) {
				System.out.println("addProduct: " + e.getMessage());
		}
	}
	
	public void addFavouriteProduct(Product p, User u){
 		String sql = "insert into favourite_products (user_id, product_id) values ((select user_id from users where user_id = user_id),"
 				+ "(select product_id from products where product_id = product_id))";
 		
 		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
 			st.setLong(1, u.getUserId());
			st.setLong(2, p.getProductId());
 			res.next();
 			u.addFavouriteProduct(p);
 		} catch (SQLException e) {
 			System.out.println("addFavouriteProduct: " + e.getMessage());
 		}
 		
	}
	
	public HashMap<Long, Product> getAllProducts(){
		if(allProducts.isEmpty()){
			String sql = "SELECT product_id, description, quantity, price, promo_price, brand, name, sub_category FROM products";

			try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql); ResultSet set = st.executeQuery();){
				
				while(set.next()){
					long productId = set.getInt("product_id");
					String subCategory = set.getString("sub_category");
					String description = set.getString("description");
					int quantity = set.getInt("quantity");
					double price = set.getDouble("price");
					double promoPrice = set.getDouble("promo_price");
					String brand = set.getString("brand");
					String name = set.getString("name");	
					
					String subCategoryString = new String();
					for (Entry<String, Integer> e : SubCategoryDAO.getInstance().getAllSubCategories().entrySet()) {
						if(e.getValue() == Integer.parseInt(subCategory)){
							subCategoryString = e.getKey();
						}
					}
					
					Product p = new Product(subCategoryString, description, quantity, price, promoPrice, brand, name);
					p.setProductId(productId);
					
					allProducts.put(productId, p);	
				}
			} catch(SQLException e){
				System.out.println("getAllProducts: " + e.getMessage());
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
		
		return generatedProducts;
	}
	
	public List<Product> searchProduct(String search){
		ArrayList<Product> searchResults = new ArrayList<>();
		getAllProducts();
		for(Product p : allProducts.values()){
			if(p.getDescription() != null && p.getSubCategory() != null && p.getBrand() != null && p.getName() != null){
				if(p.getDescription().contains(search) || p.getSubCategory().contains(search) || p.getBrand().contains(search) || p.getName().contains(search)){
					searchResults.add(p);
				}
			}
			else{
				if(p.getBrand() == null){
					if(p.getDescription().contains(search) || p.getSubCategory().contains(search) || p.getName().contains(search)){
						searchResults.add(p);
					}
				}
			}
		}
		return Collections.unmodifiableList(searchResults);
	}
	
	public void deleteProduct(Product p){
		String sql = "DELETE from products WHERE product_id = ?";
		Connection con = DBManager.getInstance().getConnection();
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			con.setAutoCommit(false);
			st.setLong(1, p.getProductId());
			synchronized(this){
				st.execute();
			}
			res.next();
			allProducts.remove(p.getProductId());
			con.commit();
		} catch (SQLException e2) {
			p.setQuantity(0);
			allProducts.remove(p.getProductId());
			String sql2 = "UPDATE products set quantity = 0 WHERE product_id = ?";
			try(PreparedStatement st2 = DBManager.getInstance().getConnection().prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS); ResultSet res2 = st2.getGeneratedKeys();){
				st2.setLong(1, p.getProductId());
				synchronized(this){
					st2.execute();
				}
				res2.next();
			} catch (SQLException e) {
					System.out.println("deleteProduct: " + e.getMessage());
			}
			try {
				con.rollback();
			} catch (SQLException e) {
				System.out.println("deleteProduct: " + e.getMessage());
			}
		}
		finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println("deleteProduct: " + e.getMessage());
			}
		}
	}
	
	public void addPromotion(double newPrice, long artNomer){
		String sql = "UPDATE products set promo_price = ? WHERE product_id = ?";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			st.setDouble(1, newPrice);
			st.setLong(2, artNomer);
			synchronized(this){
				st.execute();
			}
			res.next();
		} catch (SQLException e) {
				System.out.println("addPromotion: " + e.getMessage());
		}

	}
	
	public void removePromotion(long artNomer){
		String sql = "UPDATE products set promo_price = 0 WHERE product_id = ?";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			st.setLong(1, artNomer);
			synchronized(this){
				st.execute();
			}
			res.next();
			allProducts.get(artNomer).setPromoPrice(0.0);
		} catch (SQLException e) {
				System.out.println("removePromotion: " + e.getMessage());
		}
	}
	
	public void editProduct(long artikulenNomer, int quantity, double price, String name, String description){
		String sql = "UPDATE products set description = ?, quantity = ?, price = ?, name = ?  WHERE product_id = ?";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			st.setString(1, description);
			st.setInt(2, quantity);
			st.setDouble(3, price);
			st.setString(4, name);
			st.setLong(5, artikulenNomer);
			synchronized(this){
				st.execute();
			}
			res.next();
			allProducts.get(artikulenNomer).setDescription(description);
			allProducts.get(artikulenNomer).setName(name);
			allProducts.get(artikulenNomer).setPrice(price);
			allProducts.get(artikulenNomer).setQuantity(quantity);
		} catch (SQLException e) {
				System.out.println("editProduct: " + e.getMessage());
		}
	}
	
	public ArrayList<Integer> checkForFavProducts(Product p){
		String sql = "select user_id from favourite_products where product_id = ?";
		ArrayList<Integer> users = new ArrayList<>();
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.executeQuery();){
			st.setLong(1, p.getProductId());
			while(res.next()){
				int userId = res.getInt("user_id");
				users.add(userId);
			}
			
		} catch (SQLException e) {
			System.out.println("checkForFavProducts" + e.getMessage());
		}
		
		return users;
	}
	
}
