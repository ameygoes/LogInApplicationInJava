package model;

import java.sql.SQLException;

import bo.ProductBO;

public class Product implements Runnable {
    Long id;
    String name;
    Brand brand;
    String color;
    String material;
    Double price;
    Boolean active;
    Integer quantity;
    ProductType productType;
    ProductCategory productCategory;

    public Product() {
    }

    public Product(Long id, String name, Brand brand, String color, String material, Double price, Boolean active, Integer quantity, ProductType productType, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.price = price;
        this.active = active;
        this.quantity = quantity;
        this.productType = productType;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public Boolean equals(Product product) {
		if(product.getName().equals(this.name) &&
				product.getBrand().getName().equals(this.brand.getName()) && 
				product.getColor().equals(this.color) &&
				product.getMaterial().equals(this.material)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("%-20d %-20s %-20s %-20s %-20s %-20.2f %-20d %-20s %-20s",this.id, this.name, brand.getName(), color, material,price,quantity,productType.getName(),productCategory.getName());
				
	}
	@Override
	public void run() {
		this.active=true;
    	try {
			new ProductBO().updateProduct(this);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
