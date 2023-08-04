package com.tech.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Teacher {
	@Id
	private String t_Id;
	
	private String t_Name;
	
	private String subject;
	
	@ManyToMany
	private List<Student> student;

	public String getT_Id() {
		return t_Id;
	}

	public void setT_Id(String t_Id) {
		this.t_Id = t_Id;
	}

	public String getT_Name() {
		return t_Name;
	}

	public void setT_Name(String t_Name) {
		this.t_Name = t_Name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
}
