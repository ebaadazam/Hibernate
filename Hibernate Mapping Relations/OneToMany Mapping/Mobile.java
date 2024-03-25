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

