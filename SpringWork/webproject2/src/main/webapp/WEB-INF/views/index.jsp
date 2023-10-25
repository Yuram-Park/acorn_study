<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
	<h2>Hello World!</h2>
	
	<ul>
		<li><a href="/first">first.jsp</a></li>
		<li><a href="/second?p1=apple&p2=grape">second.jsp</a></li>
	</ul>
	<br><br>
	<form method="post" action="/third">
		이름: <input type="text" name="name"/><br>
		나이: <input type="text" name="age"/><br>
		점수: <input type="text" name="point"/><br>
		<input type="submit" value="전송"/><br>
	</form>
	
	<br><br>
	<form method="get" action="/fourth">
		이름: <input type="text" name="name"/><br>
		나이: <input type="text" name="age"/><br>
		점수: <input type="text" name="point"/><br>
		<input type="checkbox" name="chk"/>동의 여부<br>
		<input type="submit" value="전송"/><br>
	</form>
	
	<br><br>
	<a href="/fifth">다섯번째 요청</a>
	
</body>
</html>
