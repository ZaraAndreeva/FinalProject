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
	private static final HashMap<Long, Order> allOrders = new HashMap<>();
	
	public OrderDAO() {
		
	}

	public synchronized static OrderDAO getInstance(){
		if(instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	
	public synchronized void addOrder(Order order, User user){
		String sql = "INSERT INTO orders (date, status, email, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ResultSet res = null;
		try (PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){		
			st.setDate(1,  Date.valueOf(order.getDate()));
			st.setString(2, order.getStatus());
			st.setString(3, user.getEmail());	
			st.setDouble(4, order.getPrice());			
			st.setString(5, order.getName());
			st.setString(6, order.getFamilyName());
			st.setString(7, order.getPhone());
			st.setString(8, order.getTown());
			st.setString(9, order.getStreet());
			st.setInt(10, order.getBlock());
			st.setString(11, order.getEntrance());
			st.setInt(12, order.getFloor());
			st.setInt(13, order.getApartment());
			st.setString(14, order.getDescriptionAddress());
			
			st.execute();
			res = st.getGeneratedKeys();
			
			res.next();
			long orderId = res.getLong(1);
			order.setOrderId(orderId);
			
			addToOrderedProducts(order);
		} catch(SQLException e){
			System.out.println("addOrder: " + e.getMessage());
		}
		
		user.addOrder(order);
		allOrders.put(order.getOrderId(), order);
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
	
	public void updateOrderStatus(String status, long orderId){
		if(status == null){
			return;
		}
		if(status.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET status=? WHERE order_id=?";
		makeUpdate(sql, "String", status, orderId);
	}
	
	public void updateOrderName(String name, long orderId){
		if(name == null){
			return;
		}
		if(name.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET name=? WHERE order_id=?";
		makeUpdate(sql, "String", name, orderId);
	}
	
	public void updateOrderFamilyName(String familyName, long orderId){
		if(familyName == null){
			return;
		}
		if(familyName.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET family_name=? WHERE order_id=?";
		makeUpdate(sql, "String", familyName, orderId);
	}
	
	public void updateOrderPhone(String phone, long orderId){
		if(phone == null){
			return;
		}
		if(phone.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET phone=? WHERE order_id=?";
		makeUpdate(sql, "String", phone, orderId);
	}
	
	public void updateOrderTown(String town, long orderId){
		if(town == null){
			return;
		}
		if(town.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET town=? WHERE order_id=?";
		makeUpdate(sql, "String", town, orderId);
	}
	
	public void updateOrderStreet(String street, long orderId){
		if(street == null){
			return;
		}
		if(street.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET street=? WHERE order_id=?";
		makeUpdate(sql, "String", street, orderId);
	}
	
	public void updateOrderBlock(int block, long orderId){
		if(block < 1){
			return;
		}
		String sql = "UPDATE orders SET block=? WHERE order_id=?";
		makeUpdate(sql, "int", new Integer(block).toString(), orderId);
	}
	
	public void updateOrderEntrance(String entrance, long orderId){
		if(entrance == null){
			return;
		}
		if(entrance.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET entrance=? WHERE order_id=?";
		makeUpdate(sql, "String", entrance, orderId);
	}
	
	public void updateOrderFloor(int floor, long orderId){
		if(floor < 0){
			return;
		}
		String sql = "UPDATE orders SET floor=? WHERE order_id=?";
		makeUpdate(sql, "int", new Integer(floor).toString(), orderId);
	}
	
	public void updateOrderApartment(int apartment, long orderId){
		if(apartment < 1){
			return;
		}
		String sql = "UPDATE orders SET apartment=? WHERE order_id=?";
		makeUpdate(sql, "int", new Integer(apartment).toString(), orderId);
	}

	public void updateOrderDescriptionAddress(String descriptionAddress, long orderId){
		if(descriptionAddress == null){
			return;
		}
		if(descriptionAddress.trim().isEmpty()){
			return;
		}
		String sql = "UPDATE orders SET description_address=? WHERE order_id=?";
		makeUpdate(sql, "String", descriptionAddress, orderId);
		
	}
	
	public void makeUpdate(String sql, String dataType, String newData, long orderId){
		
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(sql);){
			if(dataType.equals("int")){
				st.setInt(1, Integer.parseInt(newData));
				
			}
			else{
				st.setString(1, newData);
				
			}
			st.setLong(2, orderId);
			
			st.execute();
		
		} catch(SQLException e){
			System.out.println("update order error: " + e.getMessage());
		}
	}
	
	public synchronized void addToAllOrders(Order order){
		allOrders.put(order.getOrderId(), order);
	}
}
