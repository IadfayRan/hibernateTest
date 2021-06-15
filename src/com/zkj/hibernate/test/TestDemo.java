package com.zkj.hibernate.test;

import org.junit.Test;

import com.zkj.hibernate.bll.AddUser;
import com.zkj.hibernate.bll.FirstCache;

public class TestDemo {

	@Test
	public void test1() {
		AddUser addUser = new AddUser();
		addUser.addUser();
	}
	
	@Test
	public void test2() {
		FirstCache fc=new FirstCache();
		fc.chiJiuTaiTeXing();
	
	}
	
	@Test
	public void test3() {
		FirstCache fc=new FirstCache();
		fc.hibernateTran();
	
	}
	
	
}
