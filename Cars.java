package com.ebaad.HibernateDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
/* Above we are writing @Entity as we are trying to save the object of Cars. So we need to specify that the Cars class is allowed
 * to store its object inside the database by using this annotation. */
public class Cars {
	@Id // Here @Id specifies a primary key as every table in hibernate should have a primary key
	private int year;
	private int kmsDriven;
	private String brand;
	private String model;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getKmsDriven() {
		return kmsDriven;
	}
	public void setKmsDriven(int kmsDriven) {
		this.kmsDriven = kmsDriven;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	

}
