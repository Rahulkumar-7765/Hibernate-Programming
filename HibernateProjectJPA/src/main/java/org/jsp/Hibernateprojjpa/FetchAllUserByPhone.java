package org.jsp.Hibernateprojjpa;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUserByPhone 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone number of user");
        Long phone = sc.nextLong();

        // Configure Hibernate and create a SessionFactory
        Configuration conf = new Configuration();
        conf.configure();
        SessionFactory sef = conf.buildSessionFactory(); // created the jdbc connection
        Session ses = sef.openSession();

        // Fetch users by phone number
        Query<User> q = ses.createQuery(" select u from User u where u.phone", User.class);
        q.setParameter("phone", phone);
        List<User> users = q.getResultList();

        if (users.isEmpty()) {
            System.err.println("No users found with the given phone number.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
		
	}

}
