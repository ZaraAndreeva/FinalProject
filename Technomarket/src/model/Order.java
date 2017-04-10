package model;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Order {
	
	private long orderId;
	private LocalDate date;
	private String status;
	private long userId;
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
	private LinkedHashSet<Product> products;
	
	public Order(LocalDate date, String status, long userId, double price, String name, String familyName,
			String phone, String town, String street, int block, String entrance, int floor, int apartment,
			String descriptionAddress, LinkedHashSet<Product> products) {
		//TODO validate
		this.date = date;
		this.status = status;
		this.userId = userId;
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
		this.products = products;
		
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

	public LinkedHashSet<Product> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apartment;
		result = prime * result + block;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descriptionAddress == null) ? 0 : descriptionAddress.hashCode());
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
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		if (userId != other.userId)
			return false;
		return true;
	}

	
	
	
	

}
