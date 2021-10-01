package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.LoginServices;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginServices ls = new LoginServices();
	

	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) {
			
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			ctx.req.getSession();
			
			ctx.status(200);
			
			ctx.result("Congrats you made it! JWT is: " + jwt);
			
		} else {
			
			ctx.status(401);
			ctx.result("Login Failed");
		}
		
	};

	public Handler getRoleIdHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		int role_id = ls.getRoleId(LDTO.getUsername(), LDTO.getPassword());
		
		String JSONRole_Id = gson.toJson(role_id);
		
		ctx.status(200);
		
		ctx.result(JSONRole_Id);
		
		} else {
			ctx.status(403);
		}
		
	};

}
