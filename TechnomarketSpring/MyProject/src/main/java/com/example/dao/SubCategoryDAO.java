package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashSet;

import com.example.krasiModel.Order;
import com.example.krasiModel.Product;
import com.example.krasiModel.User;

public class SubCategoryDAO {

	private static SubCategoryDAO instance;
	private static final HashMap<String, Integer> allSubCategories = new HashMap<>();
	
	public SubCategoryDAO() {
		
	}

	public synchronized static SubCategoryDAO getInstance(){
		if(instance == null){
			instance = new SubCategoryDAO();
		}
		return instance;
	}
	
	
	public synchronized HashMap<String, Integer> getAllSubCategories(){
		if(allSubCategories.isEmpty()){
			String sql = "SELECT sub_category_id, name FROM sub_categories";
			PreparedStatement st = null;
			ResultSet res = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				res = st.executeQuery();
				
				int x = 1;
				while(res.next()){
					String subCategory = res.getString("name");
					int subCategoryId = res.getInt("sub_category_id");
					
					allSubCategories.put(subCategory, subCategoryId);
				}
			} catch(SQLException e){
				System.out.println("getAllProducts: " + e.getMessage());
			}
		}  
		

		return allSubCategories;
	}

}
