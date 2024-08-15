package org.jsp.HibernateProjJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantBySQL 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createNativeQuery("select * from Merchant",Merchant.class);
		List<Merchant> lm=q.getResultList();
		if(lm.size()>0) {
			for(Merchant mer:lm) {
				System.out.println(mer);
				
			}
		}
		else {
			System.out.println("No Merchant found");
		}
		
		
	}

}
