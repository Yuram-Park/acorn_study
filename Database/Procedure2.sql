CREATE OR REPLACE PROCEDURE usp_tel(p_tel IN OUT varchar2)
IS
BEGIN
p_tel:= substr(p_tel, 1, 3) || '-' || substr(p_tel, 4);
END;

var v_tel varchar2(10);
BEGIN
    :v_tel := '1234567';
END;

exec usp_tel(:v_tel);
print v_tel;

--사원등록--

CREATE SEQUENCE seq_empno START WITH 8000;

CREATE OR REPLACE PROCEDURE usp_register(
    p_name IN emp.ename%type,
    p_job IN emp.job%type,
    p_mgr IN emp.mgr%type,
    p_sal IN emp.sal%type
)
IS
    v_deptno emp.deptno%type;
    v_comm emp.comm%type;
BEGIN
	SELECT deptno INTO v_deptno FROM emp WHERE empno=p_mgr;

	IF p_job = 'SALESMAN' THEN
		v_comm := 0;
	ELSE
		v_comm := null;
	END IF;

	INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)

	VALUES(seq_empno.nextVal, p_name, p_job, p_mgr, sysdate, p_sal, v_comm, v_deptno);
END;

exec usp_register('Tom', 'CLERK', 7902, 1500);

select * from emp;
DELETE FROM emp WHERE ename='Tom';

--트리거 예시--
CREATE OR REPLACE TRIGGER tri_emp_update 
BEFORE UPDATE ON emp 
FOR EACH ROW WHEN(NEW.sal < OLD.sal OR NEW.sal >= OLD.sal*1.1) 
BEGIN
raise_application_error(-20506,'수정된 값이 잘못되었다.');
END;

UPDATE emp
SET sal=1500
WHERE ename='FORD';

DESC user_triggers;
SELECT trigger_name, table_name FROM user_triggers;

DROP TRIGGER tri_emp_update;
DROP PROCEDURE usp_register;
DROP PROCEDURE usp_tel;


SELECT to_char(sysdate,'HH24') FROM dual;

CREATE OR REPLACE TRIGGER tri_resource
BEFORE UPDATE OR INSERT OR DELETE ON emp
BEGIN
    IF to_char(sysdate, 'dy') IN('토', '일', '수') OR  to_number(to_char(sysdate, 'HH24')) NOT BETWEEN 9 AND 18
    THEN
        raise_application_error(-20506, '작업시간이 아닙니다.');
    END IF;
END;
DELETE FROM emp WHERE empno=8001;
DROP TRIGGER tri_resource;
