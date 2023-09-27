<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="dao" class="mybean.BoardDao"/>
<jsp:useBean id="dto" class="mybean.Board"/>



<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:setProperty property="*" name="dto" /> <!-- java 코드 대신에 action 태그로 일일이/ *쓸 경우 넘어오는 모든 데이터 한번에 넣어줄 수 있다 -->



<%/*
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String home = request.getParameter("homepage");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String pass = request.getParameter("pass");
		
	dto.setB_name(name);
	dto.setB_email(email);
	dto.setB_homepage(home);
	dto.setB_subject(subject);
	dto.setB_content(content);
	dto.setB_pass(pass);
	dto.setB_ip(request.getRemoteAddr());
	*/

	dao.setBoard(dto);
	
	response.sendRedirect("List.jsp");
%>
<!--<%= dto.getB_name()%><br>
<%= dto.getB_email()%><br>
<%= dto.getB_homepage()%><br>
<%= dto.getB_subject()%><br>
<%= dto.getB_content()%><br>
<%= dto.getB_pass()%><br>
<%= dto.getB_ip()%><br>

<jsp:getProperty property="b_name" name="dto"/><br>
<jsp:getProperty property="b_email" name="dto"/><br>
<jsp:getProperty property="b_homepage" name="dto"/><br>
<jsp:getProperty property="b_subject" name="dto"/><br>
<jsp:getProperty property="b_content" name="dto"/><br>
-->

