package com.uadb.rest;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.print.attribute.standard.Media;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uadb.entities.Student;
import com.uadb.service.StudentService;

@Path("student")
public class StudentRs {
	@EJB
	private StudentService studentService;
	
	@GET
	@Path("findById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student findById( @PathParam("id") Long id) {
		return studentService.findById(id);
	}
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(Student student) {
		studentService.create(student);
	}
    
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(@PathParam("id") Long id) {
		Student student=studentService.findById(id);
		studentService.delete(student);
		return student;
	}
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student) {
		studentService.update(student);
		return student;
	}


}
