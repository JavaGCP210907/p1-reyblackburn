package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoInterface {
	
	//Add reimbursement
	public void addReimbursement(Reimbursement reimburse);
	
	//view pending requests
	public List<Reimbursement> reimbursementByStatusId(int status_id);
	
	//update request
	public void updateReimbursementStatus(int reimb_id, int reimb_status);
	
	//View updated status
	public List<Reimbursement> viewReimbursement();
	
	//Get New Reimbursement for finance manager
	public Reimbursement newReimbursementTask();

}
