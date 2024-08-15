package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FindEmployeeByID 
{
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which tou want to fecth");
		int id = sc.nextInt();
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	try {
    	Employee e = ses.load(Employee.class, id);
    	System.out.println(e);
    	}catch (Exception e) {
			System.err.println("Enter valid id");
		}
	}

}
