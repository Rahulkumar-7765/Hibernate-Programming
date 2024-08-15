package org.jsp.hibernateproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee 
{
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which tou want to delete");
		int id = sc.nextInt();
		
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Transaction tran=ses.getTransaction();
    	tran.begin();
    	
    	Employee e = ses.get(Employee.class, id);
    	if(e!=null)
    	{
    		ses.delete(e);
    		tran.commit();
    	}
    	else
    	{
    		System.out.println("You have eneterd the wrong id");
    	}
	}

}
