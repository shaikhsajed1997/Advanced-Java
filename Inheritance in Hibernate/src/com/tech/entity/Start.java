package com.tech.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tech.util.HibernateUtil;

public class Start {

	SessionFactory sf = HibernateUtil.getSessionFactory();
//this method is to save data in database
	public void saveData() {
		Session sn = sf.openSession();

		Transaction tr = sn.beginTransaction();

		Vehicle v = new Vehicle();
		v.setV_Name("Car");

		TwoWheeler t = new TwoWheeler();
		t.setV_Name("Yamaha R-15");
		t.setV_Price(122000);
		t.setColour("Carbon Black");

		FourWheeler f = new FourWheeler();
		f.setV_Name("Verna");
		f.setV_Price(2800000);
		f.setColour("Black");

		sn.save(v);
		sn.save(t);
		sn.save(f);

		tr.commit();

		sn.close();
		sf.close();

	}
	
	public void get() {
		Session sn = sf.openSession();
		
//		Vehicle vc=sn.get(Vehicle.class, 1);
//		
//		System.out.println(vc.getV_Id());
//		System.out.println(vc.getV_Name());
		
//		TwoWheeler t=sn.get(TwoWheeler.class, 2);
//		
//		System.out.println(t.getV_Id());
//		System.out.println(t.getV_Name());
//		System.out.println(t.getV_Price());
		
//		FourWheeler f=sn.get(FourWheeler.class, 3);
//		
//		System.out.println(f.getV_Id());
//		System.out.println(f.getV_Name());
//		System.out.println(f.getV_Price());
		
		//Query q=sn.createQuery("from Vehicle");
		Query q1=sn.createQuery("from Vehicle where v_Id between :id and :id1");
		q1.setParameter("id", 2);
		q1.setParameter("id1", 5);
		
		List<Vehicle> l=q1.list();
		for(Vehicle v:l) {
			System.out.println(v.getV_Id());
			System.out.println(v.getV_Name());
		}
		
		
		sn.close();
		sf.close();
	}

	public static void main(String[] args) {

		Start st= new Start();
		//st.saveData();
		st.get();
	}

}
