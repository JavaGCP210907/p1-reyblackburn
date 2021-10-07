package com.revature.dao;

import com.revature.models.Users;

public interface UsersDaoInterface {
	
	//Login verification
	public boolean verifyUsernamePassword(String username, String password);
	
	public int getRoleId(String username, String password);
	
	public Users getUserById(int id);
	
}
