package org.jsp.Hibernateprojjpa;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FindUserById 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id which tou want to fecth");
		int id = sc.nextInt();
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	try {
    	User u = ses.load(User.class, id);
    	System.out.println(u);
    	}catch (Exception e) {
			System.err.println("Enter valid id to find");
		
	}

}
}
