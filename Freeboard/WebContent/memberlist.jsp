<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.munggu.org.MemberDBmanager" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
	<%
		MemberDBmanager dba = MemberDBmanager.getInstance();	
		
		for(int x=0; x<dba.join("id").size(); x++) {
	%>
		<table border="1">
			<tr>
				<td>
					아이디
				</td>
				<td>
					<%= dba.join("id").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					비밀번호
				</td>
				<td>
					<%= dba.join("pw").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					성별
				</td>
				<td>
					<%= dba.join("gender").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					자기소개
				</td>
				<td>
					<%= dba.join("commenta").get(x) %>
				</td>
			</tr>
			<hr/>
		</table>
	<%
		}
	%>	
</body>
</html>