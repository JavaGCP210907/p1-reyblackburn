package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
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
			
			if(rs.next()){
			
				if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public int getRoleId(String username, String password) {
			
		try(Connection conn = ConnectionUtil.getConnection()){
				
			String sql = "select user_role_id_fk from users where username=? and password=?";
				
			PreparedStatement ps = conn.prepareStatement(sql);
				
			ps.setString(1, username);
			ps.setString(2, password);
				
			ResultSet rs = ps.executeQuery();
				
			rs.next();
				
			return rs.getInt("user_role_id_fk");
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getUserId(String username, String password) {
			
		try(Connection conn = ConnectionUtil.getConnection()){
				
			String sql = "select users_id from users where username=? and password=?";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
				
			ResultSet rs = ps.executeQuery();
				
			rs.next();
				
			return rs.getInt("users_id");
				
		}catch (SQLException e) {
			e.printStackTrace();
		}

		
	return 0;
		
	}

	@Override
	public Users getUserById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users where users_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Users u = new Users(
						rs.getInt("users_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						null
						);
				
				return u;
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
