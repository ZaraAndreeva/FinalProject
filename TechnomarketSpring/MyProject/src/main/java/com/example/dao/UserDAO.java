package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.example.krasiModel.Order;
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

		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();) {

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
			
			
			res.next();
			long user_id = res.getLong(1);
			u.setUserId(user_id);
			
		} catch (SQLException e) {
			System.out.println("oops " + e.getMessage());
		}
		
		allUsers.put(u.getEmail(), u);
	}
	
	public synchronized HashMap<String, User> getAllUsers(){
		if(allUsers.isEmpty()){
			String sql = "SELECT user_id, email, password, name, family_name, gender, birth_date, is_admin FROM users" ;
			
			try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql); ResultSet res = st.executeQuery();){

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
					//u.setOrders(OrderDAO.getInstance().getAllOrders().get(u.getUserId()));
					fillOrders(u);
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

		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();) {

			st.setInt(1, (int)u.getUserId());
			st.setInt(2, (int)p.getProductId());

			synchronized (this) {
				st.execute();
			}
			
			res.next();
			
			u.addFavouriteProduct(p);

		} catch (SQLException e) {
			System.out.println("addFavProducts " + e.getMessage());
		}
	}
	
	public void fillFavProducts(User u){
		String sql = "SELECT product_id FROM favourite_products where user_id = ?" ;
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql); ResultSet res =  st.executeQuery();) {
			st.setInt(1, (int) u.getUserId());
			while(res.next()){
				long productId = (long) res.getInt("product_id");
				System.out.println(u.getUserId() + " - " + productId);
				
				Product p = ProductDAO.getInstance().getAllProducts().get(productId);
				
				u.addFavouriteProduct(p);
				System.out.println(u);
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			System.out.println("fillFavProducts: " + e.getMessage());
		}
	}
	
	public void removeFavProducts(User u, Product p){
		String sql = "delete from favourite_products where product_id = ? and user_id = ?;";

		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){
			st.setInt(1, (int)p.getProductId());
			st.setInt(2, (int)u.getUserId());

			synchronized (this) {
				st.execute();
			}
			
			res.next();
			
			u.removeFavProduct(p);

		} catch (SQLException e) {
			System.out.println("addFavProducts " + e.getMessage());
		}
	}
	
	private void fillOrders(User user){
		String sql = "SELECT order_id, date, status, email, price, name, family_name, phone, town, street, block, entrance, floor,"
				+ " apartment, description_address FROM orders";

		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql); ResultSet res = st.executeQuery();){

			while(res.next()){
				long orderId = res.getInt("order_id");
				LocalDate date = res.getDate("date").toLocalDate();
				String status = res.getString("status");

				String email = res.getString("email");
				//User user = UserDAO.getInstance().getAllUsers().get(email);
				
				double price = res.getDouble("price");
				String name = res.getString("name");
				String familyName = res.getString("family_name");
				String phone = res.getString("phone");
				String town = res.getString("town");
				String street = res.getString("street");
				int block = res.getInt("block");
				String entrance = res.getString("entrance");
				int floor = res.getInt("floor");
				int apartment = res.getInt("apartment");
				String descriptionAddress = res.getString("description_address");
				
				String sql2 = "SELECT product_id, quantity FROM ordered_products WHERE order_id = ?";
				PreparedStatement st2 = DBManager.getInstance().getConnection().prepareStatement(sql2);
				st2.setInt(1, (int) orderId);
				ResultSet res2 = st2.executeQuery();
				HashMap<Long, Product> allProducts = ProductDAO.getInstance().getAllProducts();
//				LinkedHashSet<Product> productsForThisOrder = new LinkedHashSet<>();
				LinkedHashMap<Product, Integer> productsForThisOrder = new LinkedHashMap<>();
				while(res2.next()){
					long productId = res2.getInt("product_id");
					int quantity = res2.getInt("quantity");
					Product p = allProducts.get(productId);
					productsForThisOrder.put(p, quantity);
				}
				
				Order o = new Order(date, status, email, price, name, familyName,
						phone, town, street, block, entrance, floor, apartment,
						descriptionAddress, productsForThisOrder);
				
				o.setOrderId(orderId);	
				
				user.addOrder(o);
			}
		} catch(SQLException e){
			System.out.println("getAllOrders: " + e.getMessage());
		
		}
	
	}
}
