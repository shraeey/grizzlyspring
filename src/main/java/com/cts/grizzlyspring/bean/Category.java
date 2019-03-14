package com.cts.grizzlyspring.bean;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Category {
	@Id
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
