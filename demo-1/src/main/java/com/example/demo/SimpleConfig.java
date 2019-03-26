package com.example.demo;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.AbcBean;

@Configuration
public class SimpleConfig {
	@Bean
	public AbcBean abcBean() {
		AbcBean ab=new AbcBean();
		ab.setName("aa");
		ab.setAge(12);
		ab.setTel("112344");
		ab.setAddress("cross");
		return ab;
	}
	@Bean
	DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("app");
		ds.setPassword("app");
		ds.setUrl("jdbc:mysql://localhost:3306/app?useUnicode=true&characterEncoding=utf-8");
		return ds;
	}

}
