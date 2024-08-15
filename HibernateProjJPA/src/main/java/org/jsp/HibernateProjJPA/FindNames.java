package org.jsp.HibernateProjJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class FindNames 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=(Query) man.createNamedQuery("findNames");
		List<String> ln=q.getResultList();
		if(ln.size()>0) {
			for(String str:ln) {
				System.out.println(str);
			}
		}
		else {
			System.out.println("No merchant found");
		}

	}


}
