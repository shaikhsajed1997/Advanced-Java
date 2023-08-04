package com.tech.onetoone_relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech.util.HibernateUtil;

public class Execute {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public String saveData() {

		Session sn = sf.openSession();

		Transaction tr = sn.beginTransaction();

		Teacher t = new Teacher();
		t.setT_Id("T_101");
		t.settName("Jadhav Sir");
		t.setSubject("History");

		Student s = new Student();
		s.setsId(102);
		s.setsName("Mayur");
		s.setAddrs("Pune");
		s.setMarks(85);
		s.setTeacher(t);
		t.setStudent(s);

		sn.save(s);
		sn.save(t);

		tr.commit();

		sn.close();
		sf.close();
		return "Data saved successfuly";
	}

	// get data by using student table
	public void getData() {

		Session sn = sf.openSession();

		Student st = sn.get(Student.class, 101);

		System.out.println(st.getsName());
		System.out.println(st.getMarks());
		System.out.println(st.getTeacher().gettName());
		System.out.println(st.getTeacher().getSubject());

		sn.close();
		sf.close();
	}

	// get data from database by using teacher table
	public void getRecords() {

		Session sn = sf.openSession();

		Teacher t = sn.get(Teacher.class, "T_102");

		System.out.println(t.gettName());
		System.out.println(t.getSubject());
		System.out.println(t.getStudent().getsName());
		System.out.println(t.getStudent().getAddrs());
		sn.close();
		sf.close();
	}

	public static void main(String[] args) {

		Execute e = new Execute();
		e.saveData();
		// e.getData();
		// e.getRecords();

	}

}
