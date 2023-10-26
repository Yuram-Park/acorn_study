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