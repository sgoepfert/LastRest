package com.sabel.lastrest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persons")
public class Ressource {
	private Service service=new Service();

	@GET
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	@Path("/id{id}")
	public Person getPerson(@PathParam("id")int id) {
		return service.getPerson(id);
	}

	@GET
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	public List<Person> getPersons() {
		return service.getPersons();
	}

	@POST
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/new")
	public Person newPerson(@FormParam("name")String name, @FormParam("vorname")String vorname, @FormParam("age")int age) {
		return service.newPerson(name, vorname, age);
	}

	@DELETE
	@Path("/id{id}")
	public Person deletePerson(@PathParam("id")int id) {
		return service.deletePerson(id);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/time")
	public String getTime(){
		return "Die Aktuelle Zeit ist: "+new Date().toString();
	}

}
