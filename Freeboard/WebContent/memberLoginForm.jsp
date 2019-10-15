<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function doBack() {
		location.href="index.jsp";
	}
</script>
</head>
	<body>
	<form action="memberLoginPage.jsp">
		<div>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>				
			</table>
		</div>
		<input type="submit" value="로그인">
		<input type="button" onclick="doBack();" value="뒤로가기">
	</form>
</body>
</html>