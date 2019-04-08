package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot1ApplicationTests {
	@Autowired
	private JdbcDao jd;
	
	@Test
	public void contextLoads() {
		jd.setDataSource();
		jd.demo2();
		jd.demo3();
		jd.demo4();
		jd.demo5();
		jd.demo6();
		jd.insertUser("Chali", 34);
		jd.updateUser("Lin", 7);
		System.out.println(jd.countOfActorsByFirstName("jonn"));
		User user=new User();
		user.setName("jonn");
		user.setAge(1);
		System.out.println(jd.countOfActors(user));
		System.out.println(jd.countOfActorsByFirstName1("jonn", 1));
	}

}
