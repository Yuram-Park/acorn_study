<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="dao" class="mybean.BoardDao"/>
<jsp:useBean id="dto" class="mybean.Board"/>



<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>

<br><br>
<table align=center width=70% border=0 cellspacing=3 cellpadding=0>
<input type="hidden" name="b_num" value="b_num"/>
<input type="hidden" name="b_ip" value="<%=request.getRemoteAddr() %>"/>
<jsp:setProperty property="b_ip" name="dto"/>
<jsp:getProperty property="b_ip" name="dto"/>
 <tr>
  <td bgcolor=9CA2EE height=25 align=center class=m>���б�</td>
 </tr>
 <tr>
  <td colspan=2>
   <table border=0 cellpadding=3 cellspacing=0 width=100%> 
    <tr> 
	 <td align=center bgcolor=#dddddd width=10%> �� �� </td>
	 <td bgcolor=#ffffe8></td>
	 <td align=center bgcolor=#dddddd width=10%> ��ϳ�¥ </td>
	 <td bgcolor=#ffffe8></td>
	</tr>
    <tr>
	 <td align=center bgcolor=#dddddd width=10%> �� �� </td>
	 <td bgcolor=#ffffe8 ></td> 
	 <td align=center bgcolor=#dddddd width=10%> Ȩ������ </td>
	 <td bgcolor=#ffffe8 ><a href="http://" target="_new">http://</a></td> 
	</tr>
    <tr> 
     <td align=center bgcolor=#dddddd> �� ��</td>
     <td bgcolor=#ffffe8 colspan=3></td>
   </tr>
   <tr> 
    <td colspan=4></td>
   </tr>
   <tr>
    <td colspan=4 align=right>
     �� ���� ���� ����̽��ϴ�./  ��ȸ�� : 
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align=center colspan=2> 
	<hr size=1>
	[ <a href="javascript:list()">�� ��</a> | 
	<a href="Update.jsp?b_num=">�� ��</a> |
	<a href="Delete.jsp?b_num=">�� ��</a> ]<br>
  </td>
 </tr>
</table>
</body>
</html>
