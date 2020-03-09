package com.uadb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.uadb.utils.AbstractPersistent;
import com.uadb.utils.StudenType;

@NamedQueries({
	@NamedQuery(name=Student.Studen_All,query="select s from Student s"),
	@NamedQuery(name=Student.Student_By_Name,query="select s from Student s where s.lastName=:name")
})
@Entity
public class Student extends AbstractPersistent implements Serializable{
	public static final String Studen_All="Studen_All";
	public static final String Student_By_Name="Student_By_Name";
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Enumerated(EnumType.STRING)
	private StudenType type;
	
	@Column(name="last_name",length=50)
	private String lastName;
	
	private String adress;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public StudenType getType() {
		return type;
	}
	public void setType(StudenType type) {
		this.type = type;
	}
	

}
