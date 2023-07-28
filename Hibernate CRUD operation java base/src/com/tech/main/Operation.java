package com.tech.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tech.entity.Employee;
import com.tech.util.HibernateUtil;

public class Operation {

	SessionFactory sf = HibernateUtil.getSessionFact();
	Scanner sc = new Scanner(System.in);

	public String saveData() {

		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			System.out.println("Eneter Emp_name:");
			String empName = sc.next();
			System.out.println("Enter Emp_address:");
			String empAddrss = sc.next();
			System.out.println("Enter Emp_Salary:");
			double salary = sc.nextDouble();

			Employee e = new Employee();
			e.seteName(empName);
			e.setAddrs(empAddrss);
			e.seteSalary(salary);

			s.save(e);
			t.commit();
			s.close();
			sf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Data saved in Database successfully";

	}

	public void getAllData() {
		try {

			Session s = sf.openSession();
			// Transaction t=s.beginTransaction();
			List<Employee> l = s.createQuery("from Employee").list();

			for (Employee emp : l) {
				System.out.println(emp.geteId());
				System.out.println(emp.geteName());
				System.out.println(emp.getAddrs());
				System.out.println(emp.geteSalary());
				System.out.println("---------");
			}
			s.close();
			sf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateData() {
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			System.out.println("Enter Emp_Id:");
			int eid = sc.nextInt();
			System.out.println("Eneter Emp_name:");
			String empName = sc.next();
			System.out.println("Enter Emp_address:");
			String empAddrss = sc.next();

			Query hql = s.createQuery("update  Employee set Emp_Name=:ename,Emp_Address=:eaddress where Emp_Id=:eid");
			hql.setParameter("eid", eid);
			hql.setParameter("ename", empName);
			hql.setParameter("eaddress", empName);

			hql.executeUpdate();
			t.commit();
			System.out.println("Data update Successfuly in Database");
			s.close();
			sf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void daleteData() {
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			System.out.println("Enter Emp_Id:");
			int eid = sc.nextInt();

			Employee emp = s.get(Employee.class, eid);
			if (emp != null) {
				s.delete(emp);
				System.out.println("Emp_Id " + emp.geteId() + " record delete successfuly");
			} else {
				System.out.println("Emp_Id " + emp.geteId() + " record not found");
			}
			s.close();
			sf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
