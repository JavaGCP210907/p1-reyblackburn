package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class UsersDao implements UsersDaoInterface {

	@Override
	public boolean verifyUsernamePassword(String username, String password) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select username, password from users where username=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			if(rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}

}
