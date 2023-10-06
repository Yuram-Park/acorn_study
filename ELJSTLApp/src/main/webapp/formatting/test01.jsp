<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="10000000"/><br>
	<fmt:formatNumber value="10000000" groupingUsed="false"/><br>
	<fmt:formatNumber value="3.141598" pattern="#.###"/><br>
	<fmt:formatNumber value="0.5" type="percent"/><br>
	<fmt:formatNumber value="250000000000" type="currency"/><br> <!-- 현재 나라의 통화기호 -->
	<fmt:formatNumber value="250000000000" type="currency" currencySymbol="$"/><br> 
	
	<hr>
	
	<%
		Date date = new Date();
	%>
	
	<c:set var="today" value="<%=new Date() %>"/>
	
	<fmt:formatDate value="${today}" type="date"/><br> 
	<fmt:formatDate value="${today}" type="time"/><br>
	<fmt:formatDate value="${today}" type="both"/><br>
	<br>
	<fmt:formatDate value="${today}" dateStyle="short"/> <br> <!-- type 기본값은 date -->
	<fmt:formatDate value="${today}" dateStyle="medium"/> <br>
	<fmt:formatDate value="${today}" dateStyle="long"/> <br>
	<fmt:formatDate value="${today}" dateStyle="full"/> <br>
	<br>
	<fmt:formatDate value="${today}" type="time" timeStyle="short"/> <br> 
	<fmt:formatDate value="${today}" type="time" timeStyle="medium"/> <br>
	<fmt:formatDate value="${today}" type="time" timeStyle="long"/> <br>
	<fmt:formatDate value="${today}" type="time" timeStyle="full"/> <br>
	<br>
	<fmt:formatDate value="${today}" pattern="yyyy/MM/dd(E)"/> <br>
	
	<hr>
	
	<!-- 원하는 국가 형태 -->
	<fmt:setLocale value="en_us"/> <!-- 현재 위치 지정하기 -->
	<fmt:formatNumber value="250000000000" type="currency"/><br>
	<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full"/><br>
	
	<hr>
	
	<!-- 해당 국가 표준시간 -->
	<fmt:setLocale value="ko_kr"/>
	서울: <fmt:formatDate value="${today}" type="both"/><br>
	<br>
	<fmt:timeZone value="Asia/Hong_Kong">
	홍콩: <fmt:formatDate value="${today}" type="both"/><br>
	</fmt:timeZone>
	<br>
	<fmt:timeZone value="Europ/London">
	런던: <fmt:formatDate value="${today}" type="both"/><br>
	</fmt:timeZone>
	<br>
	<fmt:timeZone value="America/New_York">
	뉴욕: <fmt:formatDate value="${today}" type="both"/><br>
	</fmt:timeZone>
	
</body>
</html>


