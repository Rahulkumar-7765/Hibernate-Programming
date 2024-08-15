package org.jsp.hibernateproject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByName 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name of employee");
		String nm = sc.next();
		
		
		
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<Employee> q=ses.createQuery("select e from Employee e where e.name=?1");
    	q.setParameter(1, nm);
    	List<Employee>lemp=q.getResultList();
//    	if(lemp.size()<0) {
//    		for(Employee emp:lemp) {
//    			System.out.println(emp);
//    		}
//    	}
    	
    	
    	try {
			Employee result = (Employee) q.getResultList();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Invalid Creadential");
		}
	}

}
