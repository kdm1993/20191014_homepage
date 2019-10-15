<%@page import="com.munggu.org.FreeBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		FreeBoardDTO fbdto = (FreeBoardDTO) request.getAttribute("fbd");
	%>
	<b><%=fbdto.getTitle()%></b>&nbsp;｜&nbsp;<%=fbdto.getWriter()%><br><hr>
	<%=fbdto.getContent()%>
</body>
</html>