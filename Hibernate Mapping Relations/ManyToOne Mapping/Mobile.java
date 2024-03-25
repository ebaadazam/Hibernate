package com.ebaad.HibernateMappingRelations;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity // An entity defines a separate table in the database
public class Mobile {
	
	@Id // As mid is the primary key in Mobile Table so in Person Table we will have mid as the foreign key
	private int mid;
	private String mname;

	// What's New 
	// Now there should be a link between Person and Mobile coz multiple persons will have one mobile
	// Now Lets create a ManyToOne Relationship(Multiple persons one mobile) and generate its setters and getters
	@ManyToOne
	private Person person;
  
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
  }

	@Override
	public String toString() {
		return "Mobile [mid=" + mid + ", mname=" + mname + "]";
	}
  
	public int getMid() {
		return mid;
	}	
	public void setMid(int mid) {
		this.mid = mid;
	}	
	public String getMname() {
		return mname;
	}	
	public void setMname(String mname) {
		this.mname = mname;
	}
}

