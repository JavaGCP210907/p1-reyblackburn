package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.models.Reimbursement;
import com.revature.services.LoginServices;
import com.revature.services.ReimbursementService;

public class Tests {
	
	public static LoginServices ls;
	public static ReimbursementService rs;
	
	String usern = "rey.blackburn";
	String userp = "Password12";
	String usernFake = " ";
	String userpFake = " ";
	
	@BeforeAll
	public static void createServices() {
		
		ls = new LoginServices();
		rs = new ReimbursementService();
	}
	
	@Test
	public void CheckPasswordValidUserAndPasswordReturnTrue() {
		boolean result = ls.login(usern, userp);
		assertTrue(result);
	}
	
	@Test
	public void CheckPasswordInvalidUserAndPasswordReturnFalse() {
		boolean result = ls.login(usernFake, userpFake);
		assertFalse(result);
	}
	
	@Test
	public void CheckRoleIdValue1() {
		int result = ls.getRoleId(usern, userp);
		assertEquals(1, result);
	}
	
	@Test
	public void CheckUserIdValue1() {
		int result = ls.getUserId(usern, userp);
		assertEquals(1,result);
	}
	
	@Test
	public void CheckUpdateReimbursementThrowsSQLException() {
		assertThrows(SQLException.class, () -> rs.updateReimbursementStatus(80, 'd', 'v'));
	}

}
