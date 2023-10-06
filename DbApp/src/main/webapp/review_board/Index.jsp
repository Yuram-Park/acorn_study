<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script type="text/javascript">
	// 로그아웃
	function logoutPro(){
		location.href="user/proc/LogoutProc.jsp";
	}
</script>
</head>
<body>
<h1>메인화면</h1>
<%
	if(session.getAttribute("sessionID") == null) { // 로그인이 안되었을 때
		//로그인 화면으로 이동
		response.sendRedirect("user/view/Login.jsp");
	}
	else { // 로그인 했을 경우
%>
	<h2>
		<%=session.getAttribute("sessionID") %>
		님 로그인되었습니다.
	</h2>
	<br><br>
	<input type="button" value="로그아웃" onclick="logoutPro()"/>
	<%} %>
</body>
</html>