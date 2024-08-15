package org.jsp.HibernateProjJPA;

import java.util.Scanner;

import javax.persistence.*;

public class UpdateMerchantByFetching 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Merchant id to update Merchant");
		int id=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Merchant m=man.find(Merchant.class, id);
		if(m!=null) {
			m.setName("Badal");
			m.setPhone(887252037414l);
			m.setGst_number("Xyz1234");
			tran.commit();
//			System.out.println(m);
		}
		else {
			System.out.println("Merchant not found");
		}
		
	
	
	}
}
