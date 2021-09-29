package com.revature.services;

import com.revature.dao.UsersDao;

public class LoginServices {
	
	UsersDao uDao = new UsersDao();
	
	public boolean login(String username, String password) {
		
		return uDao.verifyUsernamePassword(username, password);
		
	}

}