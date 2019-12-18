package com.main.test;

import javax.persistence.*;

@Entity
public class Person {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int Id;
	
	private String name;

	public Person() {
		super();
	}

	public Person(String name) {
		super();		
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
		return "Person [Id" + getId() + ", Name=" + getName() + "]";
	}
	
}
