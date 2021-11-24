package com.tanmay.demorest;
//
//import java.util.List;
//
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//@Path("persons")
//public class PersonResource {
//	PersonRepository personrepo=new PersonRepository();
//	@GET
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public List<Person> getPersons() {
//		
//		return personrepo.getPersons();
//	}
//	@GET
//	@Path("person/{name}")
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public List<Person> getPerson(@PathParam("name") String name) {
//		return personrepo.getPersonByName(name);
//	}
//	@POST
//	@Path("person")
//	public void createPerson(Person p) {
//		System.out.println(p);
//		personrepo.createPerson(p);
//	}
//	@PUT
//	@Path("person")
//	public void updatePerson(Person p) {
//		if(personrepo.getPersonById(p.getId())!=null)
//			personrepo.updatePerson(p);
//		else
//			personrepo.createPerson(p);
//	}
//	
//	@DELETE
//	@Path("person/{id}")
//	public void deletePerson(@PathParam("id") int id) {
//		if(personrepo.getPersonById(id)!=null)
//			personrepo.deletePerson(id);
//	}
//}
