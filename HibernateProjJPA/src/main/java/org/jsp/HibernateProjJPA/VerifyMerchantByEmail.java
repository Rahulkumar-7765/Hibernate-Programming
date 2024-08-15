package org.jsp.HibernateProjJPA;

import java.util.Scanner;

import javax.persistence.*;
import javax.persistence.Query;

public class VerifyMerchantByEmail 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Merchant  to verify email");
		String em=sc.next();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createNamedQuery("verifyMerchantByEmail");
		q.setParameter(1, em);
		try {
			Merchant m=(Merchant) q.getSingleResult();
			System.out.println("Verification is Successful!!");
		} catch (NoResultException e) {
			System.out.println("Merchant is not verified");
		
		
		
	}

	}
}
