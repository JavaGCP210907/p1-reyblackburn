package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

public class ReimbursementTypeDao implements ReimbursementTypeDaoInterface {

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement_types where type_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				ReimbursementType typeStatus = new ReimbursementType(
						rs.getInt("type_id"),
						rs.getString("type")
						);
				
				return typeStatus;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
