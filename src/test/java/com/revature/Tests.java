package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;
import com.revature.models.Reimbursement;
import com.revature.services.LoginServices;
import com.revature.services.ReimbursementService;
import com.revature.utils.ConnectionUtil;

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
	
	
	
	

}
