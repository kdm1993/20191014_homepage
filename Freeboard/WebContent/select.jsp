<%@page import="com.munggu.org.FreeBoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 목록</h2>
<% 
	
	List<FreeBoardDTO> list = (ArrayList) request.getAttribute("list");
%>
	<table border="1">
	<tr>
		<th>게시물번호</th>
		<th>제목</th>
		<th>작성자</th>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>	
			<td>${dto.idx}</td>
			<td><a href="Content?page=${dto.idx}">${dto.title}</a></td>
			<td>${dto.writer}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="button" onclick="location.href='insert.jsp'" value="글쓰기">
</body>
</html>



