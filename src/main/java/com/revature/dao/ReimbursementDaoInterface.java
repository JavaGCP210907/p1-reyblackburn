package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoInterface {
	
	//Add reimbursement
	public void addReimbursement(Reimbursement reimburse);
	
	//view pending requests
	public List<Reimbursement> getReimbursementByStatusId(int status_id);
	
	//update request
	public void updateReimbursementStatus(int reimb_id, int reimb_status, int user_id);
	
	//View updated status
	public List<Reimbursement> getAllReimbursement();
	
	//Get Reimbursement by User Id
	public List<Reimbursement> getReimbursementByUserId(int user_id);

}
