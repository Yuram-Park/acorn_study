CREATE TABLE member(
	id NUMBER not null,
	email VARCHAR2(50) not null PRIMARY KEY,
	name VARCHAR2(20) not null,
	password varchar2(10) not null,
	registerdate date not null
);

DROP TABLE member;

CREATE SEQUENCE seq_id;