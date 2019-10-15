<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.munggu.org.MemberDBmanager"%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	String checkValue = request.getParameter("idsave");
	out.println("checkValue = "+ checkValue);
	
	if( checkValue != null){
		// 저장
		Cookie cookie = new Cookie("idsave",id);
		cookie.setMaxAge(1*60*60*24);
		response.addCookie(cookie);
	}else{
		// 삭제
		Cookie cookie = new Cookie("idsave","");
		cookie.setMaxAge(1*60*60*24);
		response.addCookie(cookie);
	}

	MemberDBmanager mdm1 = MemberDBmanager.getInstance();
	boolean result = mdm1.checkLogin(id, pw);
	
	if(id ==null )
		out.println("아이디를 입력하세요.");
	else if(pw == null)
		out.println("비밀번호를 입력하세요.");
	
	if(result == true){
		out.println("로그인에 성공하였습니다. 확인 버튼 클릭시 메인페이지로 이동합니다.");
		session.setAttribute("login", "suc");
		session.setAttribute("id", id);
%>
	<div>
		<button onclick="location.href='index.jsp';">확인</button>
	</div>
<%
	}else{
		out.println("아이디와 비밀번호를 확인하세요. 확인버튼 클릭시 로그인화면으로 이동합니다.");
%>
	<div>
		<button onclick="location.href='memberLoginForm.jsp';">확인</button>
	</div>
<%
	}
// 	out.println("result = "+ result);

	// 	mdm1.doA();
	// 	out.println("mdm = "+ mdm1+"<br/>");

	// 	MemberDBManager mdm2 = MemberDBManager.getInstance();
	// 	mdm2.doA();
	// 	out.println("mdm = "+ mdm2+"<br/>");

	// 	MemberDBManager mdm3 = MemberDBManager.getInstance();
	// 	mdm3.doA();
	// 	out.println("mdm = "+ mdm3+"<br/>");
%>

