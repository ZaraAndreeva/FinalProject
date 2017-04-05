package model;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Order {
	
	private long orderId;
	private LocalDate date;
	private String status;
	private String email;
	private double price;
	private String name;
	private String familyName;
	private String phone;
	private String town;
	private String street;
	private int block;
	private String entrance;
	private int floor;
	private String apartment;
	private String descriptionAddress;
	private LinkedHashSet<Product> products;
	
	public Order(LocalDate date, String status, String email, double price, String name, String familyName,
			String phone, String town, String street, int block, String entrance, int floor, String apartment,
			String descriptionAddress) {
		//TODO validate
		this.date = date;
		this.status = status;
		this.email = email;
		this.price = price;
		this.name = name;
		this.familyName = familyName;
		this.phone = phone;
		this.town = town;
		this.street = street;
		this.block = block;
		this.entrance = entrance;
		this.floor = floor;
		this.apartment = apartment;
		this.descriptionAddress = descriptionAddress;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public String getEmail() {
		return email;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getPhone() {
		return phone;
	}

	public String getTown() {
		return town;
	}

	public String getStreet() {
		return street;
	}

	public int getBlock() {
		return block;
	}

	public String getEntrance() {
		return entrance;
	}

	public int getFloor() {
		return floor;
	}

	public String getApartment() {
		return apartment;
	}

	public String getDescriptionAddress() {
		return descriptionAddress;
	}

	public LinkedHashSet<Product> getProducts() {
		return products;
	}
	
	
	

}
