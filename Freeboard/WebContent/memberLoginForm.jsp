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
					<td>���̵�</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="password"></td>
				</tr>				
			</table>
		</div>
		<input type="submit" value="�α���">
		<input type="button" onclick="doBack();" value="�ڷΰ���">
	</form>
</body>
</html>