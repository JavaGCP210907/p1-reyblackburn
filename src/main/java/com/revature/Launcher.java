package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		ReimbursementController rc = new ReimbursementController();
		LoginController lc = new LoginController();

		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Welcome back buddy");
		} catch(SQLException e) {
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8090);
		
		app.post("/login", lc.loginHandler);
		
		app.get("/login/roleId", lc.getRoleIdHandler);
		
		app.get("/reimbursements", rc.getAllReimbursementsHandler);
		
		app.get("/reimbursements/userId", rc.getReimbursementByUserIdHandler);
		
		app.post("/reimbursements/add", rc.addNewReimbursementHandler);
		
		app.put("/reimbursements/update", rc.updateReimbursementStatusHandler);
		
		app.get("reimbursements/status", rc.getReimbursementByStatusHandler);

	}

}
