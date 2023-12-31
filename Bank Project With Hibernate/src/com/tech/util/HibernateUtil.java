package com.tech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.tech.entity.Account;
import com.tech.entity.AccountTransaction;
import com.tech.entity.Account_Info;


public class HibernateUtil {

	private static StandardServiceRegistry rgs;
	private static SessionFactory sf;
	public static SessionFactory getSessionFactory()
	{
		Map<String, Object> set= new HashMap<>();
		set.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		set.put(Environment.URL, "jdbc:mysql://localhost:3306/savingaccount");
		set.put(Environment.USER, "root");
		set.put(Environment.PASS, "root");
		
		set.put(Environment.HBM2DDL_AUTO, "update");
		//set.put(Environment.SHOW_SQL, "true");
		set.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
		
		rgs=new StandardServiceRegistryBuilder().applySettings(set).build();
		
		MetadataSources msd= new MetadataSources(rgs).addAnnotatedClass(Account.class)
				.addAnnotatedClass(Account_Info.class)
				.addAnnotatedClass(AccountTransaction.class);
		
		Metadata md= msd.getMetadataBuilder().build();
		
		sf=md.getSessionFactoryBuilder().build();
		
		return sf;
		
	}
}
