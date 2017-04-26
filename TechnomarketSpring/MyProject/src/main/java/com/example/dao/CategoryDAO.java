package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class CategoryDAO {
	private static CategoryDAO instance;
	private static final HashMap<String, ArrayList<String>> allCategories = new HashMap<>();
	
	public CategoryDAO() {
		
	}

	public synchronized static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}
	
	public synchronized HashMap<String, ArrayList<String>> getAllCategories(){
		if(allCategories.isEmpty()){
			String sql = "SELECT category_id, name FROM categories";
			PreparedStatement st = null;
			ResultSet res = null;
			try {
				st = DBManager.getInstance().getConnection().prepareStatement(sql);
				res = st.executeQuery();
				
//				int x = 1;
				while(res.next()){
					String category = res.getString("name");
					int categoryId = res.getInt("category_id");
					
					String sql2 = "SELECT name FROM sub_categories WHERE category_id = ?";
					PreparedStatement st2 = null;
					ResultSet res2 = null;
					st2 = DBManager.getInstance().getConnection().prepareStatement(sql2);
					st2.setInt(1, categoryId);
					res2 = st2.executeQuery();
					ArrayList<String> subCategories = new ArrayList<>();
					while(res2.next()){
						subCategories.add(res2.getString("name"));
					}
					
					allCategories.put(category, subCategories);
				}
			} catch(SQLException e){
				System.out.println("getAllCategories: " + e.getMessage());
			}
		}  
		
		for (Entry<String, ArrayList<String>> e : allCategories.entrySet()) {
			System.out.println(e.getKey());
			for (String subCategoryName : e.getValue()) {
				System.out.println("    " + subCategoryName);
			}
		}

		return allCategories;
	}
}
