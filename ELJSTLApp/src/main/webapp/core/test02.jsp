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
		String str1 = "bbb";
	
		if(str1.equals("aaa"));{
	%>
			<b>aaa가 맞습니다.</b>
	<%	
		}
	%>
	<hr>
	<c:set var="str2" value="aaa"/>
	<c:if test="${str2 eq 'aaa'}">
		<b>aaa가 맞습니다.</b>
	</c:if>
	<hr>
	
	<form>
		숫자1 : <input type="text" name="num1"/><br><br>
		숫자2 : <input type="text" name="num2"/><br><br>
		<input type="submit" value="최대값 구하기"/>
	</form>
	<br><br>
	<%
		try {
				int num1 = Integer.parseInt(request.getParameter("num1"));
				int num2 = Integer.parseInt(request.getParameter("num2"));
		
				if(num1 > num2){
	%>
				<%=num1 %>이 크다.
	<%
				} else {
	%>
				}
				<%=num2 %>가 크다.
	<%
				}
		} catch(Exception err){}
	%>
	
	<hr>
	
	<c:if test="${param.num1 > param.num2}" > ${param.num1} 이 크다.</c:if> <!-- else문은 없다 -->
	<c:if test="${param.num1 < param.num2}" > ${param.num2} 이 크다.</c:if>
	
	<hr>
	
	<c:choose>
		<c:when test="${param.num1 > param.num2}">${param.num1} 이 크다.</c:when>
		<c:when test="${param.num1 < param.num2}">${param.num2} 이 크다.</c:when>
		<c:otherwise>
			<c:if test="${!empty param.num1}">
				똑같다.
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>



