package com.revature.services;

import com.revature.dao.UsersDao;

public class LoginServices {
	
	UsersDao uDao = new UsersDao();
	
	public boolean login(String username, String password) {
		
		return uDao.verifyUsernamePassword(username, password);
		
	}
	
	public int getRoleId(String username, String password) {
		
		return uDao.getRoleId(username, password);
		
	}

	public int getUserId(String username, String password) {
		
		return uDao.getUserId(username, password);
		
	}

}
