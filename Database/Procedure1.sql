CREATE OR REPLACE VIEW vw_emp1
AS
SELECT empno, ename, deptno FROM emp WHERE deptno=30;

SELECT * FROM vw_emp1;

DESC user_views;
SELECT view_name, text_length, text FROM user_views;


CREATE OR REPLACE VIEW vw_emp2
AS
SELECT empno, ename, sal, dept.deptno, dname, loc
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
ORDER BY empno DESC;

SELECT * FROM vw_emp2;

-- WITH CHECK OPTION--
CREATE OR REPLACE VIEW vw_emp3
AS
SELECT empno, ename, job, sal FROM emp
WHERE sal BETWEEN 1500 and 3000 WITH CHECK OPTION;

UPDATE vw_emp3 SET sal=1000 WHERE empno=7499; -- 오류발생

-- WITH READ ONLY --
CREATE OR REPLACE VIEW vw_emp3
AS
SELECT empno, ename, job, sal FROM emp WHERE sal BETWEEN 1500 AND 3000 WITH READ ONLY;

UPDATE vw_emp3 SET sal=2000 WHERE empno=7499; -- 오류 발생

-- 입사일이 빠른 5명 조회
CREATE OR REPLACE VIEW vw_emp4
AS
SELECT empno, ename, hiredate FROM emp ORDER BY hiredate ASC;

SELECT empno, ename, hiredate FROM vw_emp4 WHERE rownum <=5;

-- 인라인 뷰 적용
SELECT empno, ename, hiredate 
FROM (SELECT empno, ename, hiredate FROM emp ORDER BY hiredate)
WHERE rownum <= 5;


-- PROCEDURE
-- 사번이 7902인 사원의 급여를 3500으로 수정하는 프로시저
CREATE OR REPLACE PROCEDURE usp_sal1
IS
BEGIN
    UPDATE emp SET sal=3500 WHERE empno=7902;
END;
/
EXEC usp_sal1;
select * from emp;

-- 매개변수 사용하기
CREATE OR REPLACE PROCEDURE usp_sal1(
    p_sal IN number, p_empno IN number)
IS
BEGIN
    UPDATE emp SET sal=p_sal WHERE empno=p_empno;
END;
/
exec usp_sal1(3000, 7902);
select * from emp;

-- 메시지 출력 프로시저
CREATE OR REPLACE PROCEDURE usp_sal1(
    p_sal IN number, p_empno IN number)
IS
BEGIN
    UPDATE emp SET sal=p_sal WHERE empno=p_empno;
    
    IF SQL%NOTFOUND THEN
        dbms_output.put_line('변경내역이 없습니다.');
    ELSE
        dbms_output.put_line(to_char(SQL%ROWCOUNT) || '명의 자료가 수정되었습니다.');
    END IF;
END;
/
SET SERVEROUTPUT ON;
EXEC usp_sal1(3000, 999);
SELECT * from emp;

-- 특정한 수에 7%의 세금을 계산하여 그 결과를 돌려받을 수 있는 프로시저 작성
CREATE OR REPLACE PROCEDURE usp_tax(
    p_num IN number, p_result OUT number)
IS
BEGIN
    p_result := p_num * 0.07;
END;
/
DECLARE
    v_result number;
BEGIN
    usp_tax(10000, v_result);
    dbms_output.put_line('결과:' || v_result);
END;
/