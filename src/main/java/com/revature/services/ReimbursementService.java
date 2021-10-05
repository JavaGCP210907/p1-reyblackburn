package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
//import com.revature.controllers.Reimbursement;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	ReimbursementDao rDao = new ReimbursementDao();

	public List<Reimbursement> getAllReimbursements() {
		return rDao.getAllReimbursement();
	}

	public List<Reimbursement> getReimbursementByStatus(int status) {
		return rDao.getReimbursementByStatusId(status);
	}
	
	public void addReimbursement(Reimbursement reimbursement) {
		rDao.addReimbursement(reimbursement);
	}
	
	public void updateReimbursementStatus(int id, int status, int user_id) {
		rDao.updateReimbursementStatus(id, status, user_id);
	}

	public List<Reimbursement> getReimbursementsByUserId(int user_id) {
		return rDao.getReimbursementByUserId(user_id);
	}

}
