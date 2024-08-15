package org.jsp.hibernateproject;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllEmployees 
{
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Query<Employee>q=ses.createQuery("Select e from Employee e");
		List<Employee> emplist=q.getResultList();
		if(emplist.size()>0) {
			for(Employee emp : emplist) {
				System.out.println(emp);
			}
		}
		else {
			System.out.println("no Employee information is found");
		}
	}

}
