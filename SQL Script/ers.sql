CREATE TABLE user_roles (
	user_role_id serial PRIMARY KEY,
	user_role VARCHAR(10)
);

CREATE TABLE users (
	users_id serial PRIMARY KEY,
	username varchar(50) UNIQUE NOT NULL,
	PASSWORD varchar(50) NOT NULL,
	first_name varchar(100),
	last_name varchar(100),
	user_email varchar(150) UNIQUE NOT NULL,
	user_role_id_fk int REFERENCES user_roles(user_role_id)
);

CREATE TABLE reimbursement_statuses (
	status_id serial PRIMARY KEY,
	status varchar(10)
);

CREATE TABLE reimbursement_types (
	type_id serial PRIMARY KEY,
	TYPE varchar(10)
);

CREATE TABLE reimbursements (
	reimb_id serial PRIMARY KEY,
	reimb_amount int,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author int REFERENCES users(users_id),
	reimb_resolver int REFERENCES users(users_id) DEFAULT NULL,
	reimb_status_id int REFERENCES reimbursement_statuses(status_id),
	reimb_type_id int REFERENCES reimbursement_types(type_id)
);

INSERT INTO reimbursement_types (type)
VALUES ('LODGING'),
	   ('TRAVEL'),
	   ('FOOD'),
	   ('OTHER');
	  
INSERT INTO reimbursement_statuses (status)
VALUES ('NEW'),
	   ('PENDING'),
	   ('COMPLETED'),
	   ('AUDIT');
	  
INSERT INTO user_roles (user_role)
VALUES ('Employee'),
	   ('Manager');
	  
INSERT INTO users (username, PASSWORD, first_name, last_name, user_email, user_role_if_fk)
VALUES ()

DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS reimbursement_statuses;
DROP TABLE IF EXISTS reimbursement_types;


