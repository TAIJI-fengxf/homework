package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;
@Repository
public interface UserDao {
	
	@Insert("insert into user(username,password,rolename) values(#{username},#{password},#{rolename})")
	public int insertUser(User user);
	@Select("select count(*) from user where username=#{username} and password=#{password}")
	public int selectUser(User user);
	@Select("select * from user")
	public List<User> selectAllUser();
	@Select("select count(*) from user where username=#{username}")
	public int selectUsername(User user);

}
