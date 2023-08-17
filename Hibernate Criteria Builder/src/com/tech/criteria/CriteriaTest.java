package com.tech.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tech.entity.Student;
import com.tech.util.HibernateUtil;

public class CriteriaTest {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session sn = sf.openSession();

//		Student s=new Student();
//		s.setsId(106);
//		s.setsName("Sajed");
//		s.setAddress("Mumbai");
//		s.setMarks(71);

		Criteria cq = sn.createCriteria(Student.class);

		//if we want to get data on some condition then
		//1. get records where sId=102
		//cq.add(Restrictions.eq("sId", 102));
		
		//2. get records where sId>102
//		cq.add(Restrictions.gt("sId", 102));
		
		//3. get records where sId<104
		//cq.add(Restrictions.lt("sId", 104));
		
		//4. get records where student marks is between 65 and 80
		//cq.add(Restrictions.between("marks", 65.0, 80.0));
		
		//5. get records where address start with 'M'
		//cq.add(Restrictions.like("address", "M%"));
		
		//6. get records where address end with 'e'
		//cq.add(Restrictions.like("address", "%e"));
		
		//7.get records where sName contains 'e' character
		//cq.add(Restrictions.like("sName", "%e%"));
		
		//8.get records where sName contains 'M' character
		//cq.add(Restrictions.ilike("sName", "%M%"));
		
		//9. to check marks property isnull or notnull
		boolean b=cq.add(Restrictions.isNull("marks")) != null;
		System.out.println(b);
		
		//10.
		
		cq.add(Restrictions.or(null));
		
		List<Student> st = cq.list();
		
		for(Student s:st) {
			
			System.out.println("Student Id: "+s.getsId());
			System.out.println("Student Name: "+s.getsName());
			System.out.println("Student Addrs: "+s.getAddress());
			System.out.println("Student Marks: "+s.getMarks());
			System.out.println("-------------");
		}

		sn.close();
		sf.close();

	}

}
