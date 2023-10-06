<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL -->

<%
	request.setAttribute("cnt1", 100);
	int cnt2 = (Integer)request.getAttribute("cnt1");
%>

<%= cnt2 %><br>
<% out.println(cnt2); %><br>

${cnt1}<br>
${requestScope.cnt1 }<br> <!-- request 안에서 꺼내서 저장하겠다 --> 
${sessionScope.cnt1 }<br> <!-- 이미 request안에서 찾아서 안찾음 / null 값조차 안나옴-->


<%= session.getAttribute("cnt1") %><br> <!-- null 값 나옴 -->

${requestScope["cnt1"] }<br>
${cnt2 } <!-- 지역변수는 안됨 -->
</body>
</html>