package org.jsp.HibernateProjJPA;

import java.util.Scanner;

import javax.persistence.*;

public class DeleteMerchantByRemove 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter merchant id which you want to remove");
		int id=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Merchant m=man.find(Merchant.class, id);
		if(m!=null) {
			man.remove(m);
			tran.commit();
		}
		else {
			System.err.println("No Merchant id found since you have entered wrong id");
		}
		
	}

}
