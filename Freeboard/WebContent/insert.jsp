<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		���� <input type="text" name="title" placeholder="������ �Է��ϼ���"><br><br>
		<textarea name="content" cols="50" rows="10" placeholder="������ �Է��ϼ���"></textarea>
		<br>
		<input type="submit" value="Ȯ��" onclick="application.href='/select.jsp'">
	</form>
</body>
</html>