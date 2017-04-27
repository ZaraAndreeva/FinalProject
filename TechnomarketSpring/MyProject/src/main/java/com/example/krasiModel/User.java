package com.example.krasiModel;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;

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
		if(validate(name)){
			this.name = name;
		}
		if(validate(familyName)){
			this.familyName = familyName;
		}
		if(validate(email)){
			this.email = email;
		}
		if(validate(password)){
			this.password = password;
		}
		if(validate(gender)){
			this.gender = gender;
		}
		if(birthDate != null){
			this.birthDate = birthDate;
		}
		this.isAdmin = isAdmin;
		this.cart = new LinkedHashSet<>();
		this.favouriteProducts = new LinkedHashSet<>();
		this.orders = new LinkedHashSet<>();
	}
	
	private boolean validate(String word){
		if(word == null){
			return false;
		}
		return !word.trim().isEmpty();
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

	public LinkedHashSet<Order> getOrders() {
		return orders;
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
		return favouriteProducts;
	}
	
	public void removeFavProduct(Product p){
		if(p != null){
			favouriteProducts.remove(p);
		}
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

	public void setOrders(LinkedHashSet<Order> orders) {
		if(orders != null && !orders.isEmpty()){
			this.orders = orders;
		}
	}

	
	public void addOrder(Order o){
		if(o == null){
			return;
		}
		this.orders.add(o);
	}
}
