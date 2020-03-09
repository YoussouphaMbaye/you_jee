package com.uadb.utils;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
public class AbstractPersistent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@PrePersist
	public void InitDate() {
		this.date=new Date();
	}
	
}
