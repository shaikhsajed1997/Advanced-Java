package com.tech.onetoone_relationship;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teachers_info")
public class Teacher {
	
	@Id
	@Column(name="T_id")
	private String t_Id;
	@Column(name="teacherName")
	private String tName;
	@Column(name="Subject")
	private String subject;
	
	@OneToOne(mappedBy= "teacher")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getT_Id() {
		return t_Id;
	}

	public void setT_Id(String t_Id) {
		this.t_Id = t_Id;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
