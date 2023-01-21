package com.mertnamsal.repository;

import java.util.List;

import org.hibernate.Session;

import com.mertnamsal.util.HibernateUtils;

public interface ICrud<T> {

	void save(T t);
	
	void update(T t,long tc);
	
	void delete(int tc);
	
	
	default Session databaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
		
	}
	
	
}
