package org.jsp.HibernateProjJPA;

import javax.persistence.*;

public class UpdateByMerge 
{
	public static void main(String[] args)
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Merchant m=new Merchant();
		m.setId(55);
		m.setName("Chhotu");
		m.setEmail("chhotu@gmail.com");
		man.merge(m);
		tran.commit();
		
	}

}
