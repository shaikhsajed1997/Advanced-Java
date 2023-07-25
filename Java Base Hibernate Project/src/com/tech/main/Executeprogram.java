package com.tech.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech.entity.Customer;
import com.tech.util.HibernateUtil;

public class Executeprogram {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public String saveData() {
		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		Customer cs = new Customer();
		cs.setcId(106);
		cs.setcName("Akash");
		cs.setAddress("Nashik");
		cs.setMobileNo("9874562210");

		s.save(cs);
		t.commit();
		s.close();
		sf.close();
		return "Data save into DataBase Successful";

	}

	public String getAllData() {
		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		
		List<Customer> customers = s.createQuery("from Customer where cId>103").list();

		for (Customer cust : customers) {
			System.out.println(cust.getcId());
			System.out.println(cust.getcName());
			System.out.println(cust.getMobileNo());
			System.out.println(cust.getAddress());
			System.out.println("-------------");
		}
		s.close();
		sf.close();

		return "Customer data found in Database";

	}

	public String getData() {
		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		Customer cust = s.get(Customer.class, 105);
		if (cust != null) {
			System.out.println(cust.getcId());
			System.out.println(cust.getcName());
			System.out.println(cust.getMobileNo());
			System.out.println(cust.getAddress());
			s.close();
			sf.close();
			return "record found ";
		} else {
			return "record not found";
		}
	}

	public static void main(String[] args) {

		Executeprogram e = new Executeprogram();
		String s=e.saveData();
		System.out.println(s);

		String s2 = e.getData();
		System.out.println(s2);

		String s1=e.getAllData();
		System.out.println(s1);
	

	}

}
