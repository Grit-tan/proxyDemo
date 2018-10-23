package com.grit.learn.cglibProxy;

/**
 * 使用cglib包实现动态代理
 * 需求：
 * 1.启动事务
 * 2.进行增删改查，数据库操作。
 * 3.提交事务
 */
public class PersonDaoTest {

	public static void main(String[] args) {
		Transaction transaction = new Transaction();
		PersonDaoImpl target = new PersonDaoImpl();
		PersonDaoInteceptor inteceptor = new PersonDaoInteceptor(transaction, target);
		PersonDaoImpl proxy = (PersonDaoImpl)inteceptor.createProxy();
		proxy.updatePerson();
//		proxy.deletePerson();
	}
}
