<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오라클 DB 연결 테스트</h1>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 드라이버주소~@이후 oracle DB주소=> @localhost=DB서버의 ip주소, 1521=포트주소, orcl=db이름주소
		Connection conn = DriverManager.getConnection(url, "scott", "1111");
	%>
	
	DB 연결 주소: <%=conn %>
	
	<%
		conn.close();
	%>
	
	
</body>
</html>