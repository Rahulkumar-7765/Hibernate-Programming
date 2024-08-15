package org.jsp.Hibernateprojjpa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchAllUserByEmail 
{
	public static void main(String[] args) 
	{
		
		        // Configure Hibernate and create a SessionFactory
		        Configuration conf = new Configuration();
		        conf.configure();
		        SessionFactory sef = conf.buildSessionFactory(); // created the jdbc connection
		        Session ses = sef.openSession();

		        // Fetch email addresses of all users
		        Query<String> q = ses.createQuery("select u.email from User u", String.class);
		        List<String> emails = q.getResultList();

		        if (emails.isEmpty()) {
		            System.err.println("No users found.");
		        } else {
		            for (String email : emails) {
		                System.out.println(email);
		            }
		        }

		       
		    }
		

		
	}


