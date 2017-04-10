package model;

import java.util.HashMap;

public class Product {
	
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


	
}
