package com.main.test;

import java.awt.List;

public interface ServicePerson {
	
	public void addPerson(Person person);
	public void updatePerson(Person person,int id);
	public void deletePerson(int id);
	public java.util.List<Person> DisplayPerson();
	

}
