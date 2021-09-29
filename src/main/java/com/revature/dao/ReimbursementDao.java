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

	@Override
	public void addReimbursement(Reimbursement reimburse) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into reimbursements (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id)" +
			"values (?, ?, ?, null, ?, 1, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimburse.getReimb_amount());
			ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			ps.setString(3, reimburse.getReimb_description());
			
			ps.setInt(4, reimburse.getReimb_author());
			ps.setInt(5, reimburse.getReimb_type_id());
			
			ps.executeUpdate();					
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> reimbursementByStatusId(int status_id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements where reimb_status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, status_id);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getString("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				reimbursementList.add(r);
			}
			
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateReimbursementStatus(int reimb_id, int reimb_status) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update reimbursements set reimb_status_id = ? where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_status);
			ps.setInt(2, reimb_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> viewAllReimbursement() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements order by reimb_id";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getString("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				reimbursementList.add(r);
			}
			
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Reimbursement newReimbursementTask() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements where reimb_status_id = 1 limit 1";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			if(!rs.next()) {
				
				return null;
				
			} else {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getString("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
						
				return r;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
