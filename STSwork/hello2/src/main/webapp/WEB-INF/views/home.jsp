<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="home.css" rel="stylesheet">
</head>
<body>
    <h1>Welcome to my home~~</h1>
    ${message}
    <br><br>
    <c:out value="jstl 테스트 입니다.">이것은 대체문자입니다.</c:out>
</body>
</html>