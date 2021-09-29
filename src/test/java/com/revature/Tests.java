package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;
import com.revature.utils.ConnectionUtil;

public class Tests {
	
	public static UsersDao uDao;
	public static ReimbursementDao rDao;
	
	String usern = "rey.blackburn";
	String userp = "Password12";
	String usernFake = " ";
	String userpFake = " ";
	
	@BeforeAll
	public static void createUDao() {
		
		uDao = new UsersDao();
		rDao = new ReimbursementDao();
	}
	
	@Test
	public void testConnection() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Welcome back buddy");
		} catch(SQLException e) {
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVerifyUsernamePassword() {
		boolean b = uDao.verifyUsernamePassword(usern, userp);
		System.out.println(b);
		assertTrue(b == true);
	}
	
	@Test
	public void testVerifyUsernamePasswordFalse() {
		boolean b = uDao.verifyUsernamePassword(usernFake, userpFake);
		System.out.println(b);
		assertFalse(b == true);
	}
	
	@Test
	public void testGetRoleId() {
		int i = uDao.getRoleId(usern, userp);
		assertEquals(i, 1);
	}
	

}
