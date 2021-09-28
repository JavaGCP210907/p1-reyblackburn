package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

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

	}

}
