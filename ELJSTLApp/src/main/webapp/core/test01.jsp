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
	int var1 = 100;
%>

<%= var1 %> <br>
<hr>
<c:set var="var2" value="200"/>
${var2}
<br>
<c:set var="var3" value="300"/>
<c:set var="result" value="${var2 + var3 }"/>
두 수의 합은 ${result} 입니다.

</body>
</html>