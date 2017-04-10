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
		String sql = "INSERT INTO products (description, quantity, price, promo_price, specifications, brand, picture_url, sub_category, sub_sub_category) values (?, ?, ?, ?, ?, ?, ?, (SELECT sub_category from  sub_category where sub_category = sub_category_id), (SELECT sub_sub_category from  sub_sub_category where sub_sub_category = sub_sub_category_id))";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getDescription());
			st.setInt(2, p.getQuantity());
			st.setDouble(3, p.getPrice());
			st.setDouble(4, p.getPromoPrice());
			st.setString(5, p.getSpecifications());
			st.setString(6, p.getBrand());
			st.setString(7, p.getPictureUrl());
			st.setString(8, p.getSubCategory());
			st.setString(9, p.getSubSubCategory());
			res = st.getGeneratedKeys();
			res.next();
			long productId = res.getLong(1);
			p.setProductId(productId);
			allProducts.put(productId, p);
		} catch (SQLException e) {
				System.out.println("addProduct: " + e.getMessage());
		}
	}
	
	public void addFavouriteProduct(Product p){
		String sql = "";
		PreparedStatement st = null;
		ResultSet res = null;
		try{
			st = DBManager.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			res = st.getGeneratedKeys();
			res.next();
		} catch (SQLException e) {
			System.out.println("addProduct: " + e.getMessage());
		}
	}
	
	public HashMap<Long, Product> getAllProducts(){
		if(allProducts.isEmpty()){
			String sql = "SELECT product_id, description, quantity, price, promo_price, specifications, brand, picture_url, sub_category, sub_sub_category FROM products";
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
					String description = set.getString("description");
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
