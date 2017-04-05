package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;

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
	
	public User(String name, String familyName, String email, String password, String gender, LocalDate birthDate, boolean isAdmin) {
		this.name = name;
		this.familyName = familyName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.isAdmin = isAdmin;
		this.cart = new LinkedHashSet<>();
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
}
