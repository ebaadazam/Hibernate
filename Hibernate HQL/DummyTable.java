package com.ebaad.HibernateHQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DummyTable {
	@Id
	private int id;
	private String name;
	private int score;
	
	@Override
	public String toString() {
		return "Id=" + id + ", Name=" + name + ", Score=" + score;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

