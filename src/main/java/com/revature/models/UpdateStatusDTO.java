package com.revature.models;

public class UpdateStatusDTO {
	
	private int reimb_id;
	private int status_id;
	private int user_id;
	
	public UpdateStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateStatusDTO(int reimb_id, int status_id, int user_id) {
		super();
		this.reimb_id = reimb_id;
		this.status_id = status_id;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "UpdateStatusDTO [reimb_id=" + reimb_id + ", status_id=" + status_id + ", user_id=" + user_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimb_id;
		result = prime * result + status_id;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateStatusDTO other = (UpdateStatusDTO) obj;
		if (reimb_id != other.reimb_id)
			return false;
		if (status_id != other.status_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
