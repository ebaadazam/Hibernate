package com.ebaad.HibernateFetchData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
/* Above we are writing @Entity as we are trying to save the object of Cars. So we need to specify that the Cars class is allowed
 * to store its object inside the database by using this annotation. */

@Table(name="CarsTable")
public class Cars {
	@Id // Here @Id specifies a primary key as every table in hibernate should have a primary key
	private int year;
	private int kmsDriven;
	private String brand;
	private String model;
	
	// Setters and Getters
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
	
	// Here we are overriding the toString() method as we want to fetch the row values or data.
	@Override
	public String toString() {
		return "Cars Table [Year:" + year + ", KmsDriven:" + kmsDriven + ", Brand:" + brand + ", Model:" + model + "]";
	}
}

