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
	<h1>ȸ�����</h1>
	<%
		MemberDBmanager dba = MemberDBmanager.getInstance();	
		
		for(int x=0; x<dba.join("id").size(); x++) {
	%>
		<table border="1">
			<tr>
				<td>
					���̵�
				</td>
				<td>
					<%= dba.join("id").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					��й�ȣ
				</td>
				<td>
					<%= dba.join("pw").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					����
				</td>
				<td>
					<%= dba.join("gender").get(x) %>
				</td>
			</tr>
			<tr>
				<td>
					�ڱ�Ұ�
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