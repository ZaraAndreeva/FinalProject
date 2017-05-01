package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.example.krasiModel.Order;

import java.util.LinkedHashSet;
import java.util.Map.Entry;

import com.example.krasiModel.Product;
import com.example.krasiModel.User;


public class OrderDAO {
	
	private static OrderDAO instance;
	private static final HashMap<Long, LinkedHashSet<Order>> allOrders = new HashMap<>();
	
	public OrderDAO() {
		
	}

	public synchronized static OrderDAO getInstance(){
		if(instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	
	public synchronized void addOrder(Order o, User u){
		String sql = "INSERT INTO orders (date, status, email, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); ResultSet res = st.getGeneratedKeys();){		
			st.setDate(1,  Date.valueOf(o.getDate()));
			st.setString(2, o.getStatus());
			st.setString(3, u.getEmail());	
			st.setDouble(4, o.getPrice());
			
			st.setString(5, o.getName());
			st.setString(6, o.getFamilyName());
			st.setString(7, o.getPhone());
			st.setString(8, o.getTown());
			st.setString(9, o.getStreet());
			st.setInt(10, o.getBlock());
			st.setString(11, o.getEntrance());
			st.setInt(12, o.getFloor());
			st.setInt(13, o.getApartment());
			st.setString(14, o.getDescriptionAddress());
			
			st.execute();
			
			res.next();
			long orderId = res.getLong(1);
			o.setOrderId(orderId);
			
			addToOrderedProducts(o);
		} catch(SQLException e){
			System.out.println("addOrder: " + e.getMessage());
		}
		
		u.addOrder(o);
		
		if(!allOrders.containsKey(u.getUserId())){
			allOrders.put(u.getUserId(), new LinkedHashSet<>());
		}
		
		allOrders.get(u.getUserId()).add(o);
	}

	private void addToOrderedProducts(Order o){
		LinkedHashMap<Product, Integer> productsInThisOrder = o.getProducts();
		for (Entry<Product, Integer> entry : productsInThisOrder.entrySet()) {
			String sql = "INSERT INTO ordered_products (product_id, order_id, quantity) values (?, ?, ?)";
			try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql); ){
				st.setInt(1,  (int) entry.getKey().getProductId());
				st.setInt(2, (int) o.getOrderId());
				st.setInt(3, entry.getValue());
				
				st.execute();
			
			} catch(SQLException e){
				System.out.println("addOrder: " + e.getMessage());
			}

		}
	}
	
//	public synchronized HashMap<Long, LinkedHashSet<Order>> getAllOrders(){
//		if(allOrders.isEmpty()){
//			String sql = "SELECT order_id, date, status, email, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address FROM orders";
//			PreparedStatement st = null;
//			ResultSet res = null;
//			try {
//				st = DBManager.getInstance().getConnection().prepareStatement(sql);
//				res = st.executeQuery();
//				
//				while(res.next()){
//					long orderId = res.getInt("order_id");
//					LocalDate date = res.getDate("date").toLocalDate();
//					String status = res.getString("status");
//
//					String email = res.getString("email");
//					//User user = UserDAO.getInstance().getAllUsers().get(email);
//					
//					double price = res.getDouble("price");
//					String name = res.getString("name");
//					String familyName = res.getString("family_name");
//					String phone = res.getString("phone");
//					String town = res.getString("town");
//					String street = res.getString("street");
//					int block = res.getInt("block");
//					String entrance = res.getString("entrance");
//					int floor = res.getInt("floor");
//					int apartment = res.getInt("apartment");
//					String descriptionAddress = res.getString("description_address");
//					
//					String sql2 = "SELECT product_id "
//								+ "FROM products p"
//								+ "JOIN ordered_products op ON (p.product_id = op.product_id)"
//								+ "WHERE op.order_id = ?";
//					PreparedStatement st2 = DBManager.getInstance().getConnection().prepareStatement(sql2);
//					st2.setInt(1, (int) orderId);
//					ResultSet res2 = st2.executeQuery();
//					HashMap<Long, Product> allProducts = ProductDAO.getInstance().getAllProducts();
//					LinkedHashSet<Product> productsForThisOrder = new LinkedHashSet<>();
//					while(res2.next()){
//						long productId = res2.getInt("product_id");
//						Product p = allProducts.get(productId);
//						productsForThisOrder.add(p);
//					}
//					
//					Order o = new Order(date, status, email, price, name, familyName,
//							phone, town, street, block, entrance, floor, apartment,
//							descriptionAddress, productsForThisOrder);
//					
//					if(!allOrders.containsKey(user.getUserId())){
//						allOrders.put(user.getUserId(), new LinkedHashSet<>());
//					}
//					
//					allOrders.get(user.getUserId()).add(o);
//				}
//			} catch(SQLException e){
//				System.out.println("getAllOrders: " + e.getMessage());
//			}
//			finally {
//				if(st != null){
//					try {
//						st.close();
//					} catch (SQLException e) {
//						System.out.println("getAllOrders " + e.getMessage());
//					}
//				}
//				if(res != null){
//					try {
//						res.close();
//					} catch (SQLException e) {
//						System.out.println("getAllOrders " + e.getMessage());
//						
//					}
//				}
//			}
//		}
//		return allOrders;
//	}
	
	public void addToAllOrders(Order o){
		
	}
	
}
