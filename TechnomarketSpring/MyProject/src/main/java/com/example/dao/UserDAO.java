package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;


import com.example.krasiModel.Product;
import com.example.krasiModel.User;

public class UserDAO {
	private static UserDAO instance;
	private static final HashMap<String, User> allUsers = new HashMap<>();
	
	private UserDAO(){
		
	}
	
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	
	public void addUser(User u){
		String sql = "INSERT into users (email, password, name, family_name, gender, birth_date, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, u.getEmail());
			st.setString(2, u.getPassword());
			st.setString(3, u.getName());
			st.setString(4, u.getFamilyName());
			st.setString(5, u.getGender());
			st.setDate(6, Date.valueOf(u.getBirthDate()));
			st.setBoolean(7, u.isAdmin());
			
			synchronized (this) {
				st.execute();
			}
			
			ResultSet res = st.getGeneratedKeys();
			res.next();
			long user_id = res.getLong(1);
			u.setUserId(user_id);
			
		} catch (SQLException e) {
			System.out.println("oops " + e.getMessage());
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
		
		allUsers.put(u.getEmail(), u);
	}
	
//	public synchronized String getEmailById(long id){
//		String sql = "SELECT email FROM users WHERE user_id = " + id;
//		PreparedStatement st = null;
//		try {
//			st = DBManager.getInstance().getConnection().prepareStatement(sql);
//		} catch (SQLException e) {
//			System.out.println("oops " + e.getMessage());
//		}
//	}
	
	public synchronized HashMap<String, User> getAllUsers(){
		if(allUsers.isEmpty()){
			String sql = "SELECT user_id, email, password, name, family_name, gender, birth_date, is_admin FROM users" ;
			PreparedStatement st;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = st.executeQuery();
				while(res.next()){
					String name = res.getString("name");
					String familyName = res.getString("family_name");
					String email = res.getString("email");
					String password = res.getString("password");
					String gender = res.getString("gender");
					LocalDate birthDate = res.getDate("birth_date").toLocalDate();
					boolean isAdmin = res.getBoolean("is_admin");
					
					User u = new User(name, familyName, email, password, gender, birthDate, isAdmin);
					
					u.setUserId(res.getLong("user_id"));
					
					
					fillFavProducts(u);
					u.setOrders(OrderDAO.getInstance().getAllOrders().get(u.getUserId()));
					
					allUsers.put(u.getEmail(), u);
				}
			} catch (SQLException e) {
				System.out.println("getUsers: " + e.getMessage());
			}
		}
		return allUsers;
	}
	
	public synchronized boolean validLogin(String email, String password){
		if(getAllUsers().containsKey(email)){
			return getAllUsers().get(email).getPassword().equals(password);
		}
		return false;
	}
	
	
	public void addFavProducts(User u, Product p){
		String sql = "INSERT into favourite_products (user_id, product_id) VALUES "
				+ "((SELECT user_id from users where user_id = ?), "
				+ "(SELECT product_id from products where product_id = ?))";
		PreparedStatement st = null;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, (int)u.getUserId());
			st.setInt(2, (int)p.getProductId());

			synchronized (this) {
				st.execute();
			}
			
			ResultSet res = st.getGeneratedKeys();
			res.next();
			
			u.addFavouriteProduct(p);

			
			System.out.println("*****************************************************************");
			System.out.println(p);
			for (Product pr : u.getFavouriteProducts()) {
				System.out.println(pr);
			}
			System.out.println("*****************************************************************");
			
		} catch (SQLException e) {
			System.out.println("addFavProducts " + e.getMessage());
		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("addFavProducts " + e.getMessage());
				}
			}
		}
	}
	
	public void fillFavProducts(User u){
		String sql = "SELECT product_id FROM favourite_products where user_id = ?" ;
		PreparedStatement st = null;
		ResultSet res = null;
		try {
			st = DBManager.getInstance().getConnection().prepareStatement(sql);
			st.setInt(1, (int) u.getUserId());
			res = st.executeQuery();
			while(res.next()){
				long productId = (long) res.getInt("product_id");
				System.out.println(u.getUserId() + " - " + productId);
				
				Product p = ProductDAO.getInstance().getAllProducts().get(productId);
				
				System.out.println("*********");
				for (Entry<Long, Product> e : ProductDAO.getInstance().getAllProducts().entrySet()) {
					if(e.getKey() == productId){
						u.addFavouriteProduct(e.getValue());
						System.out.println("kjdnaskjdnsakjn");
						System.out.println(e.getValue());
						System.out.println("kjdnaskjdnsakjn");
						p = e.getValue();
					}
				}
				System.out.println("*********");
				
				u.addFavouriteProduct(p);
				System.out.println(u);
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			System.out.println("fillFavProducts: " + e.getMessage());
		}
	}
	
}
