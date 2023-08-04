package com.tech.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech.util.HibernateUtil;

public class Run {

	SessionFactory sf=HibernateUtil.getSessionFactory();
	
	//by using this method we can save data into database table
	public void saveData() {
		
		Session sn=sf.openSession();
		Transaction tr=sn.beginTransaction();
		
		Student s1= new Student();
		s1.setsId(101);
		s1.setsName("Laxman");
		s1.setMarks(75);
		s1.setAddress("Pune");
		
		Student s2= new Student();
		s2.setsId(102);
		s2.setsName("Sajed");
		s2.setMarks(74);
		s2.setAddress("Mumbai");
		
		Student s3= new Student();
		s3.setsId(103);
		s3.setsName("Mayur");
		s3.setMarks(70);
		s3.setAddress("Yeola");
		
		Teacher t1= new Teacher();
		t1.setT_Name("Nikam Sir");
		t1.setT_Id("T-100");
		t1.setSubject("Java");
		
		Teacher t2= new Teacher();
		t2.setT_Name("Pawar Sir");
		t2.setT_Id("T-101");
		t2.setSubject("English");
		
		Teacher t3= new Teacher();
		t3.setT_Name("Kale Sir");
		t3.setT_Id("T-103");
		t3.setSubject("Physics");
		
		List<Student> l1=new ArrayList<>();
		l1.add(s1);
		l1.add(s2);
		l1.add(s3);
		
		List<Teacher> l2=new ArrayList<>();
		l2.add(t1);
		l2.add(t2);
		l2.add(t3);
		
		s1.setTeacher(l2);
		s2.setTeacher(l2);
		s3.setTeacher(l2);
		
		t1.setStudent(l1);
		t2.setStudent(l1);
		t3.setStudent(l1);
		
		sn.save(s1);
		sn.save(s2);
		sn.save(s3);
		
		sn.save(t1);
		sn.save(t2);
		sn.save(t3);
		
		tr.commit();
		System.out.println("Data saved successfully");
		sn.close();
		sf.close();
	}
	//get data from database by using student table primary key
	public void getData() {
		
		Session sn=sf.openSession();
		
		Student st=sn.get(Student.class, 101);
		System.out.println("Student name:"+st.getsName());
		System.out.println("Assign teacher name:");
		for(Teacher s:st.getTeacher()) {
			
			System.out.println(s.getT_Name());
			
		}
		sn.close();
		sf.close();
	}

	//get records from database using teacher table
	public void getRecord() {
		Session sn=sf.openSession();
		
		Teacher tr=sn.get(Teacher.class, "T-101");
		
		System.out.println("Teacher name:"+tr.getT_Name());
		for(Student st:tr.getStudent()) {
			System.out.println("Student name: "+st.getsName());
			System.out.println("Students Marks: "+st.getMarks());
			System.out.println("------");
		}
		sn.close();
		sf.close();
	}
	
	public static void main(String[] args) {
		
		Run r= new Run();
		//r.saveData();
		//r.getData();
		r.getRecord();

	}

}
