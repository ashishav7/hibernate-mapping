package com.comviva.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.comviva.model.Product;
import com.comviva.model.ProductDetails;

public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	public static SessionFactory buildSessionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(ProductDetails.class)
				.buildSessionFactory();
		return factory;
	}

}
