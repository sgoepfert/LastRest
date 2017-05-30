package com.sabel.lastrest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Service {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public Service() {
		emf = Persistence.createEntityManagerFactory("Person");
		em = emf.createEntityManager();
	}
	
	
	public Person getPerson(int id){
		return em.find(Person.class, id);
	}
	
	public List<Person> getPersons(){
		Query query = em.createQuery("select p from Person p");
		return query.getResultList();
	}
	
	public Person newPerson(String name, String vorname, int age){
		Person person = new Person();
		person.setName(name);
		person.setVorname(vorname);
		person.setAge(age);
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		return person;
	}
	
	public Person deletePerson(int id){
		Person person = getPerson(id);
		if (person !=null) {
			em.getTransaction().begin();
			em.remove(person);
			em.getTransaction().commit();
		}
		return person;
	}
	
	public void addPerson(Person person){
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}
	
	
}
