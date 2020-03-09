package com.uadb.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import com.uadb.entities.Student;
import com.uadb.service.StudentService;

@ConversationScoped
@Named("studentControler")
public class StudentControler implements Serializable {
	
	@EJB
	private StudentService studentService;
	
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@PostConstruct
	public void init() {
		this.student=new Student();
		
	}
	public void createStudent() {
		studentService.create(student);
		student=new Student();
	}
	public String editStudent(Student student) {
		   this.student=student;
		   return "editStudent.xhtml";
	   }
   public String editStudent() {
	   studentService.update(student);
	   return "studentList.xhtml";
   }
  public void deleteStudent(Student student) {
	  studentService.delete(student);
  }
  public List<Student>getListStudent(){
	  return studentService.getAll();
  }

}
