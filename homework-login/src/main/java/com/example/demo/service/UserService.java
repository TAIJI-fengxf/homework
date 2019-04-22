package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface UserService {
	
	int insertUser(User user);
	int selectUser(User user);
	List<User> selectAllUser();
	int selectUsername(User user);

}
