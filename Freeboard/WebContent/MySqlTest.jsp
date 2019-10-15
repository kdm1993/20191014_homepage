<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// jar파일 확인
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/ex01?characterEncoding=UTF-8&serverTimezone=UTC";
         
         conn = DriverManager.getConnection(url,"root","1234");
         out.println("연결 성공<br/>");
         
		 String sql = "select * from freeboard";         
         
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()){
        	 out.println(rs.getInt("idx"));
        	 out.println(rs.getString(2));
        	 out.println(rs.getString(3));
        	 out.println(rs.getString(4));
        	 out.println(rs.getString(5));
        	 out.println(rs.getString(6));
        	 out.println("<br/>");
         }
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null)
			rs.close();
		if(pstmt != null)
			pstmt.close();
		if(conn != null)
			conn.close();
	}
%>
</body>
</html>






