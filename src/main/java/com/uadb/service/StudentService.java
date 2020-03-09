package com.uadb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ConversationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uadb.entities.Student;

@Stateless
public class StudentService {
	@PersistenceContext(unitName="pu-student")
	private EntityManager em;
	public Long create(Student student) {
		em.persist(student);
		return student.getIdStudent();
	}
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	public void update(Student student) {
		em.merge(student);
	}
	public void delete(Student student) {
		student=em.merge(student);
		em.remove(student);
	}
	public List<Student>getAll(){
		Query query=em.createNamedQuery(Student.Studen_All);
		return query.getResultList();
	}
	

}
