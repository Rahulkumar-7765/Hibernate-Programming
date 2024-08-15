package org.jsp.HibernateProjJPA;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Query;

public class FindPhoneNumbers 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select m.phone from Merchant m" );
		List<Long> lp =q.getResultList();
		if(lp.size()>0) {
			for (Long lo : lp) {
				System.out.println(lo);
				
			}
		}
		else {
			System.out.println("no phone Numbers");
		}
		
	}

}
