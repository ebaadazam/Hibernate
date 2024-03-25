package com.ebaad.HibernateMappingRelations;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity // An entity defines a separate table in the database
public class Person {
	
	@Id // rollno is the primary key
	private int rollno;
	private String name;
	private String course;
	
	// ManyToMany relationship where multiple persons have mutiple mobiles
	@ManyToMany(mappedBy = "person")
	private List<Mobile> mobile = new ArrayList<>();
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
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
