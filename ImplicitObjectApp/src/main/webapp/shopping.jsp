<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Object id = session.getAttribute("id");
	Object pw = session.getAttribute("pw");
	if(id == null || pw == null){
%>
	<script>alert("로그인 후 쇼핑몰을 이용하세요.")</script>
<%
	response.sendRedirect("index.html");
	} else {
%>
	<h3><%= id %>님 우리 쇼핑몰에 오신 것을 환영합니다~</h3>
	<h3>Enjoy your shopping~!!</h3>
<%
	}
%>
</body>
</html>