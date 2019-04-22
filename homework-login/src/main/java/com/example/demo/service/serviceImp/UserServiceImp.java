package com.example.demo.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(User user) {
		int flag=userDao.insertUser(user);
		return flag;
	}

	@Override
	public int selectUser(User user) {
		int flag=userDao.selectUser(user);
		return flag;
	}

	@Override
	public List<User> selectAllUser() {
		List<User> list=userDao.selectAllUser();
		return list;
	}

	@Override
	public int selectUsername(User user) {
		int flag=userDao.selectUsername(user);
		return flag;
	}

}
