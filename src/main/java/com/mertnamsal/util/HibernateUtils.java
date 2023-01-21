package com.mertnamsal.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.mertnamsal.entity.Musteri;
import com.mertnamsal.entity.MusteriDetay;

public class HibernateUtils {
	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Musteri.class);
			configuration.addAnnotatedClass(MusteriDetay.class);
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	
}
