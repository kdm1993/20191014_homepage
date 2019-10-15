<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>
<style type="text/css">
	a{
		text-decoration: none;
		border: 1px solid black;
		padding: 20px;
		margin: 10px;
		background-color: lime;
	}
	a:hover {
		background-color: yellow;
	}
	#main_banner {
		background-color: black;
		width : 100%;
		height : 100px;
		z-index : 0;
	}
	#main_banner_sub {
		background-color: black;
		width : 90%;
		text-align : center;
		border : 1px solid white;
		color : white;
		margin-left : 5%;
		margin-right : 5%;
		height : 100px;
	}
	#main_banner_1 {
		width : 30%;
		height : 100px;
		border : 1px solid white;
	}
	#main_banner_2 {
		width : 60%;
		height : 100px;
		border : 1px solid white;
	}
	div.inner {
		float : left;
		text-align : center;
		border : 1px solid white;
		color : white;
	}
</style>

</head>
<body>
	<%
		String id = "";
		String pw = "";
		String idsave_check = "";
		
		Cookie[] cks = request.getCookies();
		
		if(cks != null) {
			for(int x=0; x<cks.length; x++) {
				if(cks[x].getName().equals("idsave")) {
					idsave_check = cks[x].getValue().equals("true") ? "checked" : "";
				}
			}
			if(idsave_check.equals("checked")) {
				for(int x=0; x<cks.length; x++) {
					if(cks[x].getName().equals("id")) {
						id = cks[x].getValue();
					}
				}
			}
		}
	%>
	<div id="main_banner">
		<div id="main_banner_sub">
			<div id = "main_banner_1">
				<h1>KDM Free Board</h1>		
			</div>
			<div id = "main_banner_2">
				<form action="Logined.jsp" method="POST">
					<table>
						<tr>
							<td>아이디 <input type="text" name="id" value=<%= id %>></td>
							<td>비밀번호 <input type="password" name="password" value=<%= pw %>></td>
							<td class="align_right" colspan="2"><input type="checkbox" name="idsave" <%= idsave_check %>>아이디/비밀번호 저장</td>
							<td class="align_right" colspan="2"><input type="submit" value="로그인">
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div>
		<div>
			<h2>회원관리프로그램</h2>
		</div>
		<div>
			<a href="memberlist.jsp">회원목록</a>
			<a href="Join.jsp">회원가입</a>
			<a href="memberLogOut.jsp">회원로그아웃</a>
			<a href="memberLoginForm.jsp">회원로그인</a>
			<a href="selectFreeboard">글목록</a>
		</div>
	</div>
</body>
</html>




