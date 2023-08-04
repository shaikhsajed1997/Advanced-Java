package com.tech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import com.tech.onetoone_relationship.Student;
import com.tech.onetoone_relationship.Teacher;

public class HibernateUtil {
	
	private static StandardServiceRegistry rgs;
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		Map<String , Object> m=new HashMap<>();
		m.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		m.put(Environment.URL, "jdbc:mysql://localhost:3306/relationaldb");
		m.put(Environment.USER, "root");
		m.put(Environment.PASS,"root");
		
		m.put(Environment.HBM2DDL_AUTO, "create");
		m.put(Environment.SHOW_SQL, "true");
		m.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
		
		rgs=new StandardServiceRegistryBuilder().applySettings(m).build();
		
		MetadataSources msd=new MetadataSources(rgs).addAnnotatedClass(Student.class).addAnnotatedClass(Teacher.class);
		
		Metadata md=msd.getMetadataBuilder().build();
		sf=md.getSessionFactoryBuilder().build();
		return sf;
		
	}

}
