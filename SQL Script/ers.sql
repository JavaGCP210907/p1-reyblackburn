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
	   ('GRANTED'),
	   ('DENIED'),
	   ('AUDIT');
	  
INSERT INTO user_roles (user_role)
VALUES ('Employee'),
	   ('Manager');
	  
INSERT INTO users (username, PASSWORD, first_name, last_name, user_email, user_role_id_fk)
VALUES ('rey.blackburn', 'Password12', 'Rey', 'Blackburn', 'rey.blackburn@revature.net', 1),
	   ('john.doe', 'Passphrase21', 'John', 'Doe', 'johnydoe@revature.net', 2);
	  
INSERT INTO reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
values (250, '2021-08-15 08:12:15', NULL, 'Had a food', NULL, 1, NULL, 1, 3),
	   (100, '2021-08-21 09:15:36', NULL, 'Place to sleep', NULL, 1, NULL, 1, 2),
	   (25, '2021-09-1 12:30:12', '2021-09-05 10:15:14', 'Flight to Las Vegas', NULL, 1, 2, 2, 4);

DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS reimbursement_statuses;
DROP TABLE IF EXISTS reimbursement_types;




