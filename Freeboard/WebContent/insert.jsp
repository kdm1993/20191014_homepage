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
		제목 <input type="text" name="title" placeholder="제목을 입력하세요"><br><br>
		<textarea name="content" cols="50" rows="10" placeholder="내용을 입력하세요"></textarea>
		<br>
		<input type="submit" value="확인" onclick="application.href='/select.jsp'">
	</form>
</body>
</html>