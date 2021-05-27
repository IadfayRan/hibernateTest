package com.zkj.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static Configuration cfg = null;
	public static SessionFactory sf = null;

	static {
		cfg = new Configuration();
		cfg.configure();
		sf = cfg.buildSessionFactory();

	}
}
