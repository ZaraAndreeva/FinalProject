package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.Order;

public class OrderDAO {
	
	private static OrderDAO instance;
	private HashMap<String, Order> allOrders;
	
	public OrderDAO() {
	
	}

	public synchronized static OrderDAO getInstance(){
		if(instance == null){
			instance = new OrderDAO();
		}
		return instance;
	}
	
	public void addOrder(Order o){
		
		String sql = "INSERT INTO orders (date, status, email, price, name, family_name, phone, town, street, block, entrance, floor, apartment, description_address) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1,  Date.valueOf(o.getDate()));
			st.setString(2, o.getStatus());
			st.setString(3, o.getEmail());
			st.setDouble(4, o.getPrice());
			st.setString(5, o.getName());
			st.setString(6, o.getFamilyName());
			st.setString(7, o.getPhone());
			st.setString(8, o.getTown());
			st.setString(9, o.getStreet());
			st.setInt(10, o.getBlock());
			st.setString(11, o.getEntrance());
			st.setInt(12, o.getFloor());
			st.setString(13, o.getApartment());
			st.setString(14, o.getDescriptionAddress());
			res = st.getGeneratedKeys();
			res.next();
			long orderId = res.getLong(1);
			o.setOrderId(orderId);
			//TODO
		} catch(SQLException e){
			System.out.println("addOrder: " + e.getMessage());
		}
		
	}

	public HashMap<String, Order> getAllOrders() {
		if(allOrders.isEmpty()){
			//TODO
			
		}
		return allOrders;
	}
	

	

}
