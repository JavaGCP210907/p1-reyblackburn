package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.ConnectionUtil;

public class ReimbursementStatusDao implements ReimbursementStatusDaoInterface {

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement_statuses where status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				ReimbursementStatus resultStatus = new ReimbursementStatus(
						rs.getInt("status_id"),
						rs.getString("status")
						);
				
				return resultStatus;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
