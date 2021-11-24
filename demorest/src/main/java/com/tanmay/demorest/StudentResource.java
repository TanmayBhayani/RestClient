package com.tanmay.demorest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	

	
		StudentRepository studentrepo=new StudentRepository();
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Student> getPersons() {
			
			return studentrepo.getStudents();
		}
		@GET
		@Path("student/{name}")
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Student> getPerson(@PathParam("name") String name) {
			return studentrepo.getStudentByName(name);
		}
		@POST
		@Path("student")
		public void createStudent(Student p) {
			System.out.println(p);
			studentrepo.createStudent(p);
		}
		@PUT
		@Path("student")
		public void updateStudent(Student p) {
			if(studentrepo.getStudentById(p.getId())!=null)
				studentrepo.updateStudent(p);
			else
				studentrepo.createStudent(p);
		}
		
		@DELETE
		@Path("student/{id}")
		public void deleteStudent(@PathParam("id") int id) {
			if(studentrepo.getStudentById(id)!=null)
				studentrepo.deleteStudent(id);
		}
	

}
