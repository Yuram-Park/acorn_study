<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="mybean.*" %>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
		if (document.form.pass.value == "") {
		alert("패스워드를 입력하세요.");
		form.pass.focus();
		return false;
		}
		document.form.submit();
	}
</script>
</head>
<body>

<jsp:useBean id="dao" class="mybean.BoardDao"/>
<%
	Vector vec = (Vector)dao.getBoardList();
	


try{
	
	if(pass.equals(rs.getString("b_pass"))){
		sql = "delete from tblboard where b_num=?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, b_num);
		stmt.executeUpdate();

		response.sendRedirect("List.jsp");
	} else{
%>
		<script>
			alert("비밀번호가 틀렸습니다.");
			history.back();
		</script>
<%
	}
}
catch(Exception e){
	System.out.println("Delete.jsp: " + e);
}
finally{
	if(stmt != null) stmt.close();
	if(con != null)	con.close();
	if(rs != null) rs.close();
}
%>
<center>
<br><br>
<table width=50% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=#dddddd height=21 align=center>
      사용자의 비밀번호를 입력해 주세요.</td>
 </tr>
</table>
<table width=70% cellspacing=0 cellpadding=2>
<form name=form method=post action="Delete.jsp" >
 <input type="hidden" name="b_num" value="<%=b_num%>"/>
 <input type="hidden" name="b_pass" value="<%=pass %>"/>
 <tr>
  <td align=center>
   <table align=center border=0 width=91%>
    <tr> 
     <td align=center>  
	  <input type=password name="pass" size=17 maxlength=15>
	 </td> 
    </tr>
    <tr>
     <td><hr size=1 color=#eeeeee></td>
    </tr>
    <tr>
     <td align=center>
	  <input type=button value="삭제완료" onClick="check()"> 
      <input type=reset value="다시쓰기"> 
      <input type=button value="뒤로" onClick="history.back()">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</form> 
</table>
</center>
</body>
</html>
