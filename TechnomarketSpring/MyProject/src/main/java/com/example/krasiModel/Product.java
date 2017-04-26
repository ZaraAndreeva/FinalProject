package com.example.krasiModel;

import java.util.HashMap;


import com.example.dao.SubCategoryDAO;

public class Product {
	
	private String name;
	private String category;
	private String subCategory;
	private String subSubCategory;
	private long productId;
	private String description;
	private int quantity;
	private double price;
	private double promoPrice;
	private String brand;
	private String pictureUrl;
	private HashMap<String, String> specifications;
	
	public Product(String subCategory, String subSubCategory, String description, int quantity,
			double price, double promoPrice, String brand, String pictureUrl) {
		
//		if(name != null && !name.isEmpty()){
//			this.name = name;
//		}
		
//		if(category != null && !category.isEmpty()){
//			this.category = category;
//		}
		if(subCategory != null && !subCategory.isEmpty()){
			this.subCategory = subCategory;
		}
		this.subSubCategory = subSubCategory;
		if(description != null && !description.isEmpty()){
			this.description = description;
		}
		if(quantity > 0){
			this.quantity = quantity;
		}
		if(price > 0){
			this.price = price;
		}
		if(price >= 0){
			this.promoPrice = promoPrice;
		}
		if(brand != null && !brand.isEmpty()){
			this.brand = brand;
		}
		if(pictureUrl != null && !pictureUrl.isEmpty()){
			this.pictureUrl = pictureUrl;
		}
		this.specifications = new HashMap<>();
	}
	
	public String getName(){
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public String getSubSubCategory() {
		return subSubCategory;
	}

	public long getProductId() {
		return productId;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public double getPromoPrice() {
		return promoPrice;
	}

	public String getBrand() {
		return brand;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		temp = Double.doubleToLongBits(promoPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((subSubCategory == null) ? 0 : subSubCategory.hashCode());
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
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (Double.doubleToLongBits(promoPrice) != Double.doubleToLongBits(other.promoPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (subSubCategory == null) {
			if (other.subSubCategory != null)
				return false;
		} else if (!subSubCategory.equals(other.subSubCategory))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [category=" + category + ", subCategory=" + subCategory + ", subSubCategory=" + subSubCategory
				+ ", productId=" + productId + ", description=" + description + ", quantity=" + quantity + ", price="
				+ price + ", promoPrice=" + promoPrice + ", brand=" + brand + ", pictureUrl=" + pictureUrl + "]";
	}

	public static boolean validProduct(String description, String quantity, String price, String brand,
			String pictureUrl, String subCategory, String subSubCategory) {
		//TODO validSubSubCategory()
		return validText(description) && validQuantity(quantity) && validPrice(price)
				&& validText(brand) && validPictureUrl(pictureUrl) && validSubCategory(subCategory);
		
	}
	
	public static boolean validText(String text) {
		return !text.trim().isEmpty() && text != null;
	}

	public static boolean validQuantity(String quantity) {
		if(isInteger(quantity)){
			return Integer.parseInt(quantity) > 0;
		}
		
		return false;
	}

	public static boolean validPrice(String price) {
		if(isDouble(price)){
			return Double.parseDouble(price) > 0;
		}
		
		return false;
	}

	public static boolean validPictureUrl(String pictureUrl) {
		//TODO regex
//		String pattern = "(http(s?):/)(/[^/]+)+" + "/.(?:jpg|gif|png)";
//		return pictureUrl.matches(pattern);
//		return true;
//		return pictureUrl.matches("http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])");
		return true;
	}

	public static boolean validSubCategory(String subCategory) {
		return SubCategoryDAO.getInstance().getAllSubCategories().containsKey(subCategory);
	}

	public static boolean isInteger(String text) {
		return text.matches("^[0-9]*$") && text != null && !text.isEmpty();
	}
	
	public static boolean isDouble(String text) {
		return text.matches("^[0-9.]*$") && text != null && !text.isEmpty();
	}

	
	public boolean sameSubCategory(String tag){
		//TODO category.contains(tag)?
		return subCategory.contains(tag);						
	}

	public HashMap<String, String> getSpecifications() {
		return specifications;
	}

	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	
	
	
	
	
	
	
}
