package com.zkj.hibernate.bll;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zkj.hibernate.bean.TestUser;
import com.zkj.hibernate.dao.HibernateUtils;

public class AddUser {

	public void addUser() {

		SessionFactory sf2 = HibernateUtils.sf;
		Session session = sf2.openSession();
		Transaction ts = session.beginTransaction();
		ts.begin();
		// TestUser
		TestUser user = new TestUser();
		user.setName("zkj");
		user.setAge(25);
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = df.parse("1992-00-00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setBirthday(date);
		session.save(user);
		ts.commit();
		session.close();
		sf2.close();
	}

}
