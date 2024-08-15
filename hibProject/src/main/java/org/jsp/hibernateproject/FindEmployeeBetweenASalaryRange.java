package org.jsp.hibernateproject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeBetweenASalaryRange
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter min salary range of employee");
		Double min = sc.nextDouble();
		
		System.out.println("Enter max salary range of employee");
		Double max=sc.nextDouble();
		
		
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<Employee> q=ses.createQuery("select e from Employee e where e.salary between=?1 and ?2");
    	q.setParameter(1, min);
    	q.setParameter(2, max);
    	
    	List<Employee> lemp=q.getResultList();
    	if(lemp.size()<0) {
    		for(Employee emp:lemp) {
    			System.out.println(emp);
    		}
    	}
	}

}
