package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDao implements ReimbursementDaoInterface {
	
	UsersDao uDao = new UsersDao();
	ReimbursementStatusDao rsDao = new ReimbursementStatusDao();
	ReimbursementTypeDao rtDao = new ReimbursementTypeDao();

	@Override
	public void addReimbursement(Reimbursement reimburse) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into reimbursements (reimb_amount, reimb_description, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id)" +
			"values (?, ?, ?, ?, 1, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimburse.getReimb_amount());
			ps.setString(2, reimburse.getReimb_description());
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setInt(4, reimburse.getReimb_author().getUsers_id());
			ps.setInt(5, reimburse.getReimb_status_id().getStatus_id());
			ps.setInt(5, reimburse.getReimb_type_id().getType_id());
			
			ps.executeUpdate();					
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> getReimbursementByStatusId(int status_id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements where reimb_status_id = ? order by reimb_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, status_id);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getInt("reimb_amount"));
				r.setReimb_submitted(rs.getString("reimb_submitted"));
				r.setReimb_resolved(rs.getString("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				
				if(rs.getInt("reimb_author") != 0) {
					r.setReimb_author(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {
					r.setReimb_resolver(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				
				if(rs.getInt("reimb_status_id") != 0) {
					r.setReimb_status_id(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {
					r.setReimb_type_id(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(r);
			}
			
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateReimbursementStatus(int reimb_id, int reimb_status, int user_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update reimbursements set reimb_status_id = ?, reimb_resolved = ?, reimb_resolver = ? where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_status);
			ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			ps.setInt(3, user_id);
			ps.setInt(4, reimb_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> getAllReimbursement() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements order by reimb_id";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getInt("reimb_amount"));
				r.setReimb_submitted(rs.getString("reimb_submitted"));
				r.setReimb_resolved(rs.getString("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				
				if(rs.getInt("reimb_author") != 0) {
					r.setReimb_author(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {
					r.setReimb_resolver(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				
				if(rs.getInt("reimb_status_id") != 0) {
					r.setReimb_status_id(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {
					r.setReimb_type_id(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(r);
			}
			
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}



	@Override
	public List<Reimbursement> getReimbursementByUserId(int user_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements where reimb_author = ? order by reimb_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement();
				
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getInt("reimb_amount"));
				r.setReimb_submitted(rs.getString("reimb_submitted"));
				r.setReimb_resolved(rs.getString("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				
				if(rs.getInt("reimb_author") != 0) {
					r.setReimb_author(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {
					r.setReimb_resolver(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				
				if(rs.getInt("reimb_status_id") != 0) {
					r.setReimb_status_id(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {
					r.setReimb_type_id(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(r);
			}
			
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
