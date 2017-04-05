package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.Product;

public class ProductDAO {
	
	private static ProductDAO instance;
	public static final HashMap<Long, Product> allProducts = new HashMap<>();
	
	public ProductDAO() {
	
	}

	public synchronized static ProductDAO getInstance(){
		if(instance == null){
			instance = new ProductDAO();
		}
		return instance;
	}
	
	public synchronized void addProduct(Product p){
		//TODO if is admin
		String sql = "INSERT INTO products (category, sub_category, sub_sub_category, descrition, quantity, price, promo_price, specifications, brand, picture_url) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getCategory());
			st.setString(2, p.getSubCategory());
			st.setString(3, p.getSubSubCategory());
			st.setString(4, p.getDescription());
			st.setInt(5, p.getQuantity());
			st.setDouble(6, p.getPrice());
			st.setDouble(7, p.getPromoPrice());
			st.setString(8, p.getSpecifications());
			st.setString(9, p.getBrand());
			st.setString(10, p.getPictureUrl());
			res = st.getGeneratedKeys();
			res.next();
			long productId = res.getLong(1);
			p.setProductId(productId);
			allProducts.put(productId, p);
		} catch (SQLException e) {
				System.out.println("addProduct: " + e.getMessage());
		}
	}
	
	public HashMap<Long, Product> getAllProducts(){
		if(allProducts.isEmpty()){
			String sql = "SELECT product_id, category, sub_category, sub_sub_category, descrition, quantity, price, promo_pprice, specifications, brand, picture_url FROM products";
			PreparedStatement st = null;
			ResultSet set = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				set = st.executeQuery();
				
				while(set.next()){
					long productId = set.getInt("product_id");
					String category = set.getString("category");
					String subCategory = set.getString("sub_category");
					String subSubCategory = set.getString("sub_sub_category");
					String description = set.getString("descrition");
					int quantity = set.getInt("quantity");
					double price = set.getDouble("price");
					double promoPrice = set.getDouble("promo_price");
					String specifications = set.getString("specifications");
					String brand = set.getString("brand");
					String pictureUrl = set.getString("picture_url");	
					
					Product p = new Product(category, subCategory, subSubCategory, description, quantity, price, promoPrice, specifications, brand, pictureUrl);
					p.setProductId(productId);
					
					allProducts.put(productId, p);	
				}
			} catch(SQLException e){
				System.out.println("getAllProducts: " + e.getMessage());
			}
		}
		return allProducts;
	}
	
}
