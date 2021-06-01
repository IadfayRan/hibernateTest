package com.zkj.hibernate.test;

import org.junit.Test;

import com.zkj.hibernate.bll.AddUser;

public class TestDemo {

	@Test
	public void test1() {
		AddUser addUser = new AddUser();
		addUser.addUser();
	}
}
