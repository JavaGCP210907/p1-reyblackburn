package com.revature.dao;

public interface UsersDaoInterface {
	
	//Login verification
	public boolean verifyUsernamePassword(String username, String password);
	
	public int getRoleId(String username, String password);
	
}
