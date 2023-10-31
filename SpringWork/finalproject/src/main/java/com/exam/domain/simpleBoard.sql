CREATE TABLE simpleBoard(
	bNo number primary key,
	bTitle varchar2(200) not null,
	bContent varchar2(4000) null,
	bWriter varchar2(50) not null,
	bRegdate date default sysdate not null,
	bViewcnt number default 0
);

drop table simpleBoard;

CREATE SEQUENCE seq_bNo increment by 1 start with 1;
DROP SEQUENCE seq_id;
CREATE SEQUENCE seq_id;
CREATE TABLE simpleMember(
	id number not null,
	email varchar2(50),
	password varchar(50),
	name varchar2(50),
	regdate date,
	CONSTRAINT pk_email PRIMARY KEY(email)
);

CREATE TABLE simpleFile(
	fileNo number primary key,
	bNo number not null,
	oFileName varchar2(500) not null,
	cFileName varchar2(500) not null,
	fileSize number
);

CREATE SEQUENCE seq_fileNo;