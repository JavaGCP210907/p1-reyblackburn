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
	   ('squidward.tentacles', 'ClarinetCool12', 'Squidward', 'Tentacles', 'squidward.tentacles@revature.net', 1),
	   ('dipper.pines', 'Notebook3', 'Dipper', 'Pines', 'dipper.pines@revature.net', 1),
	   ('john.doe', 'Passphrase21', 'John', 'Doe', 'john.doe@revature.net', 2);
	  
INSERT INTO reimbursements (reimb_amount, reimb_description, reimb_submitted, reimb_resolved, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
values (250, 'Had a food','2021-09-21', NULL, 1, NULL, 1, 3),
	   (100, 'Place to sleep', '2021-09-24', NULL, 1, NULL, 1, 1),
	   (25, 'Flight to Las Vegas', '2021-09-25', '2021-09-26', 1, 4, 2, 3),
	   (110, 'Vacation', '2021-09-28', NULL, 2, NULL, 1, 4),
	   (2000, 'Bought Company anti-weird trinkets', '2021-10-01', NULL, 3, NULL, 1, 4);

DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS reimbursement_statuses;
DROP TABLE IF EXISTS reimbursement_types;

SELECT * FROM reimbursements r LEFT JOIN users ua ON (ua.users_id = r.reimb_author)
							   LEFT JOIN users ub ON (ub.users_id = r.reimb_resolver)
							   JOIN reimbursement_statuses ON (reimb_status_id = status_id) 
							   JOIN reimbursement_types ON (reimb_type_id = type_id);
