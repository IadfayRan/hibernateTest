package com.zkj.hibernate.bll;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zkj.hibernate.bean.TestUser;
import com.zkj.hibernate.dao.HibernateUtils;

public class FirstCache {
	public void testFirstCache() {

		SessionFactory sf = HibernateUtils.sf;
		Session session = sf.openSession();
		// Transaction ts = session.beginTransaction();
		TestUser user1 = (TestUser) session.get(TestUser.class, 3);
		System.out.println(user1);
		TestUser user2 = (TestUser) session.get(TestUser.class, 3);
		System.out.println(user2);

	}

	/**
	 * 持久态对象会自动更新到数据库
	 */
	public void chiJiuTaiTeXing() {
		SessionFactory sf = HibernateUtils.sf;
		Session se = sf.openSession();
		Transaction ta = se.beginTransaction();
		ta.begin();
		TestUser user = (TestUser) se.get(TestUser.class, 3);
		user.setName("周远根");
		ta.commit();

	}

	/**
	 * hibernate 事务
	 */
	public void hibernateTran() {
		SessionFactory sf = HibernateUtils.sf;
		Session session = null;
		Transaction ts = null;
		try {
			session = sf.openSession();
			ts = session.beginTransaction();
			ts.begin();
			//
			TestUser user = (TestUser) session.get(TestUser.class, 3);
			user.setName("zkj");
			session.save(user);
			int i = 1 / 0;
			ts.commit();

		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
