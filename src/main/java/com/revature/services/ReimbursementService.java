package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
//import com.revature.controllers.Reimbursement;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	ReimbursementDao rDao = new ReimbursementDao();

	public List<Reimbursement> getAllReimbursements() {
		return rDao.viewAllReimbursement();
	}

//	public List<Reimbursement> getReimbursementByStatus(int status) {
//		return rDao.reimbursementByStatusId(status);
//	}
	
	public void addReimbursement(Reimbursement reimbursement) {
		rDao.addReimbursement(reimbursement);
	}
	
	public void updateReimbursementStatus(int id, int status) {
		rDao.updateReimbursementStatus(id, status);
	}

}
