package org.jsp.Hibernateprojjpa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUser 
{
	public static void main(String[] args) 
	{
		

		
		        // Configure Hibernate and create a SessionFactory
		        Configuration conf = new Configuration();
		        conf.configure();
		        SessionFactory sef = conf.buildSessionFactory(); // created the jdbc connection
		        Session ses = sef.openSession();

		        // Fetch all users
		        Query<User> q = ses.createQuery(" select u from User u", User.class);
		        List<User> users = q.getResultList();

		        if (users.isEmpty()) {
		            System.err.println("No users found.");
		        } else {
		            for (User user : users) {
		                System.out.println(user);
		            }
		        }

//		        // Close the session and factory
//		        ses.close();
//		        fac.close();
		    }


		
	}


