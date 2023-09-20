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

UPDATE vw_emp3 SET sal=1000 WHERE empno=7499; -- �����߻�

-- WITH READ ONLY --
CREATE OR REPLACE VIEW vw_emp3
AS
SELECT empno, ename, job, sal FROM emp WHERE sal BETWEEN 1500 AND 3000 WITH READ ONLY;

UPDATE vw_emp3 SET sal=2000 WHERE empno=7499; -- ���� �߻�

-- �Ի����� ���� 5�� ��ȸ
CREATE OR REPLACE VIEW vw_emp4
AS
SELECT empno, ename, hiredate FROM emp ORDER BY hiredate ASC;

SELECT empno, ename, hiredate FROM vw_emp4 WHERE rownum <=5;

-- �ζ��� �� ����
SELECT empno, ename, hiredate 
FROM (SELECT empno, ename, hiredate FROM emp ORDER BY hiredate)
WHERE rownum <= 5;


-- PROCEDURE
-- ����� 7902�� ����� �޿��� 3500���� �����ϴ� ���ν���
CREATE OR REPLACE PROCEDURE usp_sal1
IS
BEGIN
    UPDATE emp SET sal=3500 WHERE empno=7902;
END;
/
EXEC usp_sal1;
select * from emp;

-- �Ű����� ����ϱ�
CREATE OR REPLACE PROCEDURE usp_sal1(
    p_sal IN number, p_empno IN number)
IS
BEGIN
    UPDATE emp SET sal=p_sal WHERE empno=p_empno;
END;
/
exec usp_sal1(3000, 7902);
select * from emp;

-- �޽��� ��� ���ν���
CREATE OR REPLACE PROCEDURE usp_sal1(
    p_sal IN number, p_empno IN number)
IS
BEGIN
    UPDATE emp SET sal=p_sal WHERE empno=p_empno;
    
    IF SQL%NOTFOUND THEN
        dbms_output.put_line('���泻���� �����ϴ�.');
    ELSE
        dbms_output.put_line(to_char(SQL%ROWCOUNT) || '���� �ڷᰡ �����Ǿ����ϴ�.');
    END IF;
END;
/
SET SERVEROUTPUT ON;
EXEC usp_sal1(3000, 999);
SELECT * from emp;

-- Ư���� ���� 7%�� ������ ����Ͽ� �� ����� �������� �� �ִ� ���ν��� �ۼ�
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
    dbms_output.put_line('���:' || v_result);
END;
/