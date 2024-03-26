package com.ebaad.HibernateCaching2;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity // An entity defines a separate table in the database
@Cacheable // This entity allows the class to get cached
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)  // Specify the strategy of Cache
public class Humans {
	
	@Id // id is the primary key
	private int id;
	private String name;
	private String designation;
	
	@Override
	public String toString() {
		return "Humans [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
