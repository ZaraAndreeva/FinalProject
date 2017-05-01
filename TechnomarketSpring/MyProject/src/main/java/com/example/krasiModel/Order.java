package com.example.krasiModel;

import java.time.LocalDate;
import java.util.LinkedHashMap;
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
	private int apartment;
	private String descriptionAddress;
	private LinkedHashMap<Product, Integer> products;
	
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", name=" + name + ", familyName=" + familyName
				+ ", phone=" + phone + ", town=" + town + ", street=" + street + ", block=" + block + ", entrance="
				+ entrance + ", floor=" + floor + ", apartment=" + apartment + ", descriptionAddress="
				+ descriptionAddress + "]";
	}

	public Order(LocalDate date, String status, String email, double price, String name, String familyName,
			String phone, String town, String street, int block, String entrance, int floor, int apartment,
			String descriptionAddress, LinkedHashMap<Product, Integer> products) {
		//TODO validate
		if(date != null){
			this.date = date;
		}
		if(validate(status)){
			this.status = status;
		}
		if(validate(email)){
			this.email = email;
		}
		if(price > 0){
			this.price = price;
		}
		if(validate(name)){
			this.name = name;
		}
		if(validate(familyName)){
			this.familyName = familyName;
		}
		if(validate(phone)){
			this.phone = phone;
		}
		if(validate(town)){
			this.town = town;
		}
		if(validate(street)){
			this.street = street;
		}
		if(block > 0){
			this.block = block;
		}
		if(validate(entrance)){
			this.entrance = entrance;
		}
		if(floor > 0){
			this.floor = floor;
		}
		if(apartment > 0){
			this.apartment = apartment;
		}
		if(validate(descriptionAddress)){
			this.descriptionAddress = descriptionAddress;
		}
		if(!products.isEmpty()){
			this.products = products;
		}
	}
	
	private boolean validate(String word){
		if(word == null){
			return false;
		}
//		return !word.trim().isEmpty();
		return true;
//		this.date = date;
//		this.status = status;
//		this.email = email;
//		this.price = price;
//		this.name = name;
//		this.familyName = familyName;
//		this.phone = phone;
//		this.town = town;
//		this.street = street;
//		this.block = block;
//		this.entrance = entrance;
//		this.floor = floor;
//		this.apartment = apartment;
//		this.descriptionAddress = descriptionAddress;
//		this.products = products;
		
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		if(orderId > 0){
			this.orderId = orderId;
		}
	}

	public LocalDate getDate() {
		return date;
	}

	public String getStatus() {
		return status;
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

	public int getApartment() {
		return apartment;
	}

	public String getDescriptionAddress() {
		return descriptionAddress;
	}

	public LinkedHashMap<Product, Integer> getProducts() {
		return products;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apartment;
		result = prime * result + block;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descriptionAddress == null) ? 0 : descriptionAddress.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entrance == null) ? 0 : entrance.hashCode());
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + floor;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (apartment != other.apartment)
			return false;
		if (block != other.block)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (descriptionAddress == null) {
			if (other.descriptionAddress != null)
				return false;
		} else if (!descriptionAddress.equals(other.descriptionAddress))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (entrance == null) {
			if (other.entrance != null)
				return false;
		} else if (!entrance.equals(other.entrance))
			return false;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (floor != other.floor)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderId != other.orderId)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public void setDescriptionAddress(String descriptionAddress) {
		this.descriptionAddress = descriptionAddress;
	}

	public static boolean validPhone(String phone) {
		String bgPhoneRegex = "/08[7-9][0-9]{7}/";
		String usPhoneRegex = "[\\(]?\\d{3}[\\)]?([-.]?)\\s*\\d{3}\\1\\s*\\d{4}";
		
		if(phone == null){
			return false;
		}
		String trimmedNumber = phone.trim();
		return !trimmedNumber.isEmpty() && (trimmedNumber.matches(bgPhoneRegex) || trimmedNumber.matches(usPhoneRegex));
		
	}

	public static boolean validOrder(String name, String familyName, String phone, String city, String street) {
		return User.validText(name) && User.validText(familyName) && Order.validPhone(phone) && 
			 User.validText(city) && User.validText(street);
	}

	

	

	
	
	
	

}
