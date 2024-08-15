//package org.jsp.HibernateProjJPA;
//
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.*;
//import javax.persistence.Query;
//
//public class FindMerchantByGst_Number 
//{
//	public static void main(String[] args) 
//	{
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Merchant id to find gst number");
//		String gm=sc.next();
//		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
//		EntityManager man=fac.createEntityManager();
//		Query q=man.createQuery("select m from Merchant m where m.gst_number=?1");
//		q.setParameter(1, gm);
//		try {
//			Merchant m=(Merchant) q.getSingleResult();
//		} catch (NoResultException e) {
//			System.out.println("gst_number no found");
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//}
