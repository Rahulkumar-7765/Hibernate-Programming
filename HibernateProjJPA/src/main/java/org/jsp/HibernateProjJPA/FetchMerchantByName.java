package org.jsp.HibernateProjJPA;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
import javax.persistence.Query;

public class FetchMerchantByName 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Merchant to find Merchant Name");
		String nm=sc.next();
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select m from Merchant m where m.name=?1");
		q.setParameter(1, nm);
		List<Merchant> lm=q.getResultList();
		if(lm.size()>0) {
			for(Merchant mer:lm) {
				System.out.println(mer);
			}
		}
		else {
			System.out.println("no Merchant found");
		}
		
		
	}

}
