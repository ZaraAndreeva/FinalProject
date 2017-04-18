package main.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import main.model.Order;

import java.util.HashSet;
import java.util.LinkedHashSet;

import main.model.Product;
import main.model.User;


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
		String sql = "INSERT INTO orders (date, status, user_id, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address) values (?, ?, (select user_id from users where user_id = user_id), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1,  Date.valueOf(o.getDate()));
			st.setString(2, o.getStatus());
			st.setInt(3, (int) u.getUserId());

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
			
			res = st.getGeneratedKeys();
			res.next();
			long orderId = res.getLong(1);
			o.setOrderId(orderId);
			//TODO
			
			
		} catch(SQLException e){
			System.out.println("addOrder: " + e.getMessage());

		}
		finally {
			if(st != null){
				try {
					st.close();
				} catch (SQLException e2) {
					System.out.println("oops " + e2.getMessage());
				}
			}
			if(res != null){
				try {
					res.close();
				} catch (SQLException e2) {
					System.out.println("oops " + e2.getMessage());
					
				}
			}

		}
		
		if(!allOrders.containsKey(u.getUserId())){
			allOrders.put(u.getUserId(), new LinkedHashSet<>());
		}
		
		allOrders.get(u.getUserId()).add(o);
	}


	public synchronized HashMap<Long, LinkedHashSet<Order>> getAllOrders(){
		if(allOrders.isEmpty()){
			String sql = "SELECT order_id, date, status, email, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address FROM orders";
			PreparedStatement st = null;
			ResultSet res = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				res = st.executeQuery();
				
				while(res.next()){
					long orderId = res.getInt("order_id");
					LocalDate date = res.getDate("date").toLocalDate();
					String status = res.getString("status");
					
					long userId = res.getInt("user_id");
					
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
					
					String sql2 = "SELECT product_id "
								+ "FROM products p"
								+ "JOIN ordered_products op ON (p.product_id = op.product_id)"
								+ "WHERE op.order_id = " + orderId;
					PreparedStatement st2 = DBManager.getInstance().getConnection().prepareStatement(sql2);
					ResultSet res2 = st2.executeQuery();
					HashMap<Long, Product> allProducts = ProductDAO.getInstance().getAllProducts();
					LinkedHashSet<Product> productsForThisOrder = new LinkedHashSet<>();
					while(res2.next()){
						long productId = res2.getInt("product_id");
						Product p = allProducts.get(productId);
						productsForThisOrder.add(p);
					}
					
					Order o = new Order(date, status, userId, price, name, familyName,
							phone, town, street, block, entrance, floor, apartment,
							descriptionAddress, productsForThisOrder);
					
					if(!allOrders.containsKey(userId)){
						allOrders.put(userId, new LinkedHashSet<>());
					}
					
					allOrders.get(userId).add(o);
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
				if(res != null){
					try {
						res.close();
					} catch (SQLException e) {
						System.out.println("oops " + e.getMessage());
						
					}
				}
			}
		}
		return allOrders;
	}

}
