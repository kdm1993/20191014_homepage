package com.munggu.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insert() {
        super();
    }
    @Resource(name="jdbc/ex01") javax.sql.DataSource ds;
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
			System.out.println("conn = "+ conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("insert into freeboard"
					+ "(title, content, writer)"
					+ "values(?,?,?)");
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, "ÀÛ¼ºÀÚ");
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) { }
		}
		
	}

}
