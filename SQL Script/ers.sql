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
	reimb_resolved timestamp DEFAULT NULL,
	reimb_description varchar(250),
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
VALUES ('PENDING'),
	   ('GRANTED'),
	   ('DENIED');
	  
INSERT INTO user_roles (user_role)
VALUES ('Employee'),
	   ('Manager');
	  
INSERT INTO users (username, PASSWORD, first_name, last_name, user_email, user_role_id_fk)
VALUES ('rey.blackburn', 'Password12', 'Rey', 'Blackburn', 'rey.blackburn@revature.net', 1),
	   ('john.doe', 'Passphrase21', 'John', 'Doe', 'johnydoe@revature.net', 2);
	  
INSERT INTO reimbursements (reimb_amount, reimb_description, reimb_submitted, reimb_resolved, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
values (250, 'Had a food','2021-09-21', NULL, 1, NULL, 1, 3),
	   (100, 'Place to sleep', '2021-09-24', NULL, 1, NULL, 1, 1),
	   (25, 'Flight to Las Vegas', '2021-09-25', '2021-09-26', 1, 2, 2, 3);

DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS reimbursement_statuses;
DROP TABLE IF EXISTS reimbursement_types;


