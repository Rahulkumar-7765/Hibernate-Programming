package org.jsp.HibernateProjJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchant 
{
	public static void main(String[] args) {
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Merchant m=new Merchant();
		m.setName("Rocky");
		m.setEmail("rocky@gmail.com");
		m.setPassword("rocky@1234");
		m.setGst_number("ABCD12345");
		m.setPhone(7631029089l);
		man.persist(m);
		tran.commit();
	}

}
