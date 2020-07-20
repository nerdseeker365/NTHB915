package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=true;
		//Activate Hibernate Software(BootStrap Hibernate)
		cfg=new Configuration();
		System.out.println(cfg.getProperties());
		System.out.println("-----------------------------------------");
		//Supply  hibernate cfg file as input file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		System.out.println(cfg.getProperties());
		//Build SessionFactory
		factory=cfg.buildSessionFactory();
		//Open session
		ses=factory.openSession();
		//create Entity object  to save with DB software
		prod=new Product();
		prod.setPid(119);
		prod.setPname("Battery");
		prod.setPrice(32.34f);
		prod.setQly(2);
		try {
			tx=ses.beginTransaction();//Internally calls con.setAutoCommit(false) to begin the tx
			System.out.println("tx object class name::"+tx.getClass());
			//Save Object
			ses.save(prod);
			System.out.println("1");
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			//Commit or Rollback TX
			if(flag==true) {
				System.out.println("2");
				tx.commit();//internally calls con.commit()
				System.out.println("3");
				System.out.println("Object is Saved");
			}
			else {
				tx.rollback();//internally calls con.rollback()
				System.out.println("Object is not Saved");
			}
			//close Session object 
			ses.close();
			//close SessionFactory
			factory.close();
		}
	}

}
