package org.jsp.Hibernateprojjpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteUserbyId
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which tou want to delete");
		int id = sc.nextInt();
		
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Transaction tran=ses.getTransaction();
    	tran.begin();
    	
    	User u = ses.get(User.class, id);
    	if(u!=null)
    	{
    		ses.delete(u);
    		tran.commit();
    	}
    	else
    	{
    		System.err.println("You have eneterd the wrong id");
    	}
		
	}

}
