package com.revature.controllers;

import java.util.List;

import com.revature.services.ReimbursementService;
import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.models.UpdateStatusDTO;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();

	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			List<Reimbursement> allReimbursements = rs.getAllReimbursements();
			
			Gson gson = new Gson();
			
			String JSONReimbursements = gson.toJson(allReimbursements);
			
			ctx.result(JSONReimbursements);
			
			ctx.status(200);
			
		} else {
			ctx.status(403);
		}
		
	};
	
	public Handler addNewReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement newReimbursement = gson.fromJson(body, Reimbursement.class);
			
			rs.addReimbursement(newReimbursement);
			
			ctx.result("Added New Reimbursement");
			
			ctx.status(200);
			
		} else {
			ctx.status(403);
		}
	};

	public Handler updateReimbursementStatusHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			UpdateStatusDTO usDTO = gson.fromJson(body, UpdateStatusDTO.class);
			
			rs.updateReimbursementStatus(usDTO.getReimb_id(), usDTO.getStatus_id(), usDTO.getUser_id());
			
			ctx.result("Updated Reimbursement Status");
			
			ctx.status(200);
			
		} else {
			ctx.status(403);
		}
	};

	public Handler getReimbursementByStatusHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			UpdateStatusDTO usDTO = gson.fromJson(body, UpdateStatusDTO.class);
			
			List<Reimbursement> reimbursementStatus = rs.getReimbursementByStatus(usDTO.getStatus_id());
			
			String JSONReimbursement = gson.toJson(reimbursementStatus);
			
			ctx.result(JSONReimbursement);
			
			ctx.status(200);
			
		} else {
			ctx.status(403);
		}
	};

	public Handler getReimbursementByUserIdHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		UpdateStatusDTO usDTO = gson.fromJson(body, UpdateStatusDTO.class);
		
		List<Reimbursement> allReimbursements = rs.getReimbursementsByUserId(usDTO.getUser_id());
		
		String JSONReimbursements = gson.toJson(allReimbursements);
		
		ctx.result(JSONReimbursements);
		
		ctx.status(200);
		
	};

}
