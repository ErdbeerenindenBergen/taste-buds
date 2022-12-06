BEGIN TRANSACTION;

DROP TABLE IF EXISTS tb_user,tb_event,event_invitation,event_restaurant;
DROP SEQUENCE IF EXISTS seq_user_id,seq_event_id,seq_invitation_id;

CREATE SEQUENCE seq_user_id
INCREMENT BY 1
START WITH 3001
NO MAXVALUE;

CREATE TABLE tb_user(
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username VARCHAR(50) NOT NULL,
	email_address VARCHAR(50) NOT NULL,
	password_hash VARCHAR(200) NOT NULL,
	user_role VARCHAR(20) NOT NULL,
	CONSTRAINT PK_tb_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username),
	CONSTRAINT UQ_email_address UNIQUE (email_Address)
);

CREATE SEQUENCE seq_event_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE tb_event(
	event_id INT NOT NULL Default nextval('seq_event_id'),
	event_name VARCHAR(200) NOT NULL,
	event_city VARCHAR(50),
	event_zipcode INT CHECK(event_zipcode BETWEEN 0 AND 99999),
	event_state VARCHAR(2),
	event_user_latitude VARCHAR(30),
	event_user_longitude VARCHAR(30),
	event_date DATE NOT NULL,
	event_time TIME NOT NULL,
	event_organizer_id INT NOT NULL,
	response_deadline_date DATE NOT NULL,
	response_deadline_time TIME NOT NULL,
	CONSTRAINT PK_tb_event PRIMARY KEY (event_id),
	CONSTRAINT FK_tb_event_tb_user FOREIGN KEY (event_organizer_id) REFERENCES tb_user (user_id)
);

CREATE SEQUENCE seq_invitation_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE event_invitation(
	invitation_id INT NOT NULL DEFAULT nextval('seq_invitation_id'),
	event_id INT NOT NULL,
	has_voted BOOLEAN NOT NULL DEFAULT false,
	CONSTRAINT PK_event_invitation PRIMARY KEY (invitation_id),
	CONSTRAINT FK_event_invitation_tb_event FOREIGN KEY (event_id) REFERENCES tb_event (event_id)
);

CREATE TABLE event_restaurant(
	yelp_restaurant_id VARCHAR(100) NOT NULL,
	event_id INT NOT NULL,
	vote_count INT NOT NULL,
	CONSTRAINT PK_event_restaurant PRIMARY KEY (yelp_restaurant_id,event_id)	
);

COMMIT;