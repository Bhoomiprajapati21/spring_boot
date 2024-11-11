package com.example.CarCrud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  
public class Car {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String brand;
	private String model1;
	private String price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel1() {
		return model1;
	}
	public void setModel1(String model1) {
		this.model1 = model1;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}