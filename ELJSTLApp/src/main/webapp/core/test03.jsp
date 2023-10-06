<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] foods = {"불고기", "오므라이스", "짜장면"};
		request.setAttribute("foods", foods);
	%>
	
	<%
		String[] arrFoods = (String[])request.getAttribute("foods");
	
		for(int i=0; i<arrFoods.length; i++){
	%>
		${arrFoods[i]} <!-- 안나옴 -->
		<%=arrFoods[i] %>
	<%
		}
	%>
	<hr>
	
	<c:forEach begin="0" end="3" step="1" var="i"> <!-- step: 얼마씩 증가시킬 건지 -->
		${foods[i]}
	</c:forEach>
	
	<hr>
	
	<c:forEach var="food" items="${requestScope.foods}"> <!-- items: 배열이나 컬렉션-->
		${food}
	</c:forEach>
	
	<hr>
	
	<c:set var="guests" value="토끼/거북이*너구리-호랑이"/>
	<c:forTokens items="${guests }" delims="/*-," var="token">
		${token}
	</c:forTokens>
	
	<c:redirect url="test04.jsp">	<!-- response.sendRedirect 대신 -->
		<c:param name="irum" value="신돌석"></c:param>
		<c:param name="age" value="40세"></c:param>
	</c:redirect> 
	
	
	
</body>
</html>