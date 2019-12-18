package com.main.test;

import javax.persistence.EntityManager;
import java.util.*;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import antlr.collections.List;

public class PersonDao implements ServicePerson{
	
	//EntityManager entitymanager;
	@Inject
	Provider<EntityManager> entitymanager;
	
	
	
	

	@Override
	@Transactional
	public void addPerson(Person person) {
		
		entitymanager.get().persist(person);
	}
	
	@Override
	@Transactional
	public void deletePerson(int id) {
		
		Person p=entitymanager.get().find(Person.class,id);
		entitymanager.get().remove(p);
		
		
	}
	@Override
	@Transactional
	public void updatePerson(Person person, int id) {
		   
		   Person p=entitymanager.get().find(Person.class,id);
		   p.setName(person.getName());
		  
		
	}
	@Override
	@Transactional
	public java.util.List<Person> DisplayPerson() {
		java.util.List<Person> l= entitymanager.get().createQuery("Select p FROM Person p",Person.class).getResultList();		
		return l;
	}

	
	
	
	
	

}
