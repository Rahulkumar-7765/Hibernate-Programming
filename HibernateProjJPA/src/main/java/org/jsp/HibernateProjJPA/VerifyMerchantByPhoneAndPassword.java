package org.jsp.HibernateProjJPA;

import java.util.Scanner;

import javax.persistence.*;
import javax.persistence.Query;

public class VerifyMerchantByPhoneAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Merchant Phone no");
		long ph=sc.nextLong();
		
		System.out.println("Enter Merchant password");
		String pw=sc.next();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, ph);
		q.setParameter(2, pw);
		try {
		Merchant m=(Merchant) q.getSingleResult();
		System.out.println("Merchant is Verified");
		}catch(NoResultException e) {
			System.out.println("Merchant not Found");
		}
		
		
		
	}

}
