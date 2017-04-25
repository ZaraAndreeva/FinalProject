package com.example.krasiModel;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;

import com.example.dao.SubCategoryDAO;
import com.example.dao.UserDAO;

public class User {
	private long userId;
	private String name;
	private String familyName;
	private String email;
	private String password;
	private String gender;
	private LocalDate birthDate;
	private boolean isAdmin;
	private LinkedHashSet<Product> cart;
	private LinkedHashSet<Product> favouriteProducts;
	private LinkedHashSet<Order> orders;
	
	public User(String name, String familyName, String email, String password, String gender, LocalDate birthDate, boolean isAdmin) {
		this.name = name;
		this.familyName = familyName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.isAdmin = isAdmin;
		this.cart = new LinkedHashSet<>();
		this.favouriteProducts = new LinkedHashSet<>();
		this.orders = new LinkedHashSet<>();
	}

	public String getName() {
		return name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setUserId(long userId) {
		if(userId <= 0){
			return;
		}
		this.userId = userId;
	}
	
	public void addToCart(Product p){
		if(p == null){
			return;
		}
		this.cart.add(p);
	}
	
	public void addFavouriteProduct(Product p){
		if(p == null){
			return;
		}
		this.favouriteProducts.add(p);
	}

	public LinkedHashSet<Product> getCart() {
		return (LinkedHashSet<Product>) Collections.unmodifiableSet(cart);
	}

	public LinkedHashSet<Product> getFavouriteProducts() {
		return (LinkedHashSet<Product>) Collections.unmodifiableSet(favouriteProducts);
	}
	
	public LinkedHashSet<Order> getOrders() {
		return (LinkedHashSet<Order>) Collections.unmodifiableSet(orders);
	}

  
	public long getUserId() {
		return userId;
	}

	public static boolean validText(String name) {
		return name != null && !name.isEmpty();
	}

	public static boolean validEmail(String email) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(regex) && !UserDAO.getInstance().getAllUsers().containsKey(email);
	}
	
	public static boolean validPassword(String passwordFirst) {
		// TODO password regex
		return !passwordFirst.isEmpty() && passwordFirst != null;
	}
	
	public static boolean validPasswords(String passwordFirst, String passwordSecond) {
		// TODO password regex
		if(!validPassword(passwordFirst) || !validPassword(passwordSecond)){
			return false;
		}
		return passwordFirst.equals(passwordSecond);
	}

	public static boolean validSex(String sex) {
		// TODO password regex
		if(sex == null){
			return false;
		}
		if(sex.isEmpty()){
			return false;
		}
		return Integer.parseInt(sex) == 1 || Integer.parseInt(sex) == 2;
	}
	
	public static boolean validUser(String name, String familyName, String email, String passwordFirst,
			String passwordSecond, String sex) {
		return validText(name) && validText(familyName) && validEmail(email) && validPassword(passwordFirst)
				&& validPassword(passwordSecond) && validPasswords(passwordFirst, passwordSecond)
				&& validSex(sex);
	}

	
}
