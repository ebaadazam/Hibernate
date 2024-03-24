package com.ebaad.HibernateMappingRelations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // An entity defines a separate table in the database
public class Person {
	
	@Id // rollno is the primary key
	private int rollno;
	private String name;
	private String course;
	
	// What's New 
	// Now there should be a link between Person and Mobile coz every person will have a mobile
	// So lets create a object of mobile here and generate its setters and getters
	@OneToOne
	private Mobile mobile;
	
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [rollno=" + rollno + ", name=" + name + ", course=" + course + "]";
	}

	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

}

