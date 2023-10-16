<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="model.BookDto"></jsp:useBean> 

	<b>현재 주문한 도서</b>
	<table border="1">
	
		<tr>
			<th>도서 제목</th><th>작가</th><th>가격</th><th>수량</th>
		</tr>
<%
	ArrayList bookList = (ArrayList) session.getAttribute("bookList");
%>
		<!-- 주문한 도서들 출력 -->
	<c:forEach var="dto" items="${bookList}">
		<tr>
			<td><%=dto.getTitle()%></td>
			<td><%=dto.getAuthor()%></td>
			<td><%=dto.getPrice()%></td>
			<td><%=dto.getQuantity()%></td>
		</tr>
	</c:forEach>
	</table>
	<br>
		<b>전체 구입 액수 : </b>
	<br>
	<form method="post" action="/MVCApp/bookshop">
		<input type="submit" value="결제"/>
	</form>
</body>
</html>