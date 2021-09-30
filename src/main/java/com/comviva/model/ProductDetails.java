package com.comviva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ecom_product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "product_desc")
	private String description;
	
	@Column(name = "product_dimension")
	private String dimension;
	
	@Column(name = "product_brand")
	private String brand;
	
	@Column(name = "product_weight")
	private int weight;
	
	@Column(name = "product_stock")
	private int stock;

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", description=" + description + ", dimension=" + dimension + ", brand="
				+ brand + ", weight=" + weight + ", stock=" + stock + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetails( String description, String dimension, String brand, int weight, int stock) {
		super();
		this.description = description;
		this.dimension = dimension;
		this.brand = brand;
		this.weight = weight;
		this.stock = stock;
	}

}
