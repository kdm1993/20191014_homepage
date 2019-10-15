package com.munggu.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Content")
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/ex01") javax.sql.DataSource ds;
	private Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public FreeBoardDTO Content_return(String idx) {
		FreeBoardDTO freeboarddto = new FreeBoardDTO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from freeboard " + " where idx = ?");
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				freeboarddto.setIdx(rs.getInt("idx"));
				freeboarddto.setTitle(rs.getString("title"));
				freeboarddto.setRedate(rs.getString("regdate"));
				freeboarddto.setModdate(rs.getString("moddate"));
				freeboarddto.setWriter(rs.getString("writer"));
				freeboarddto.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return freeboarddto;
	}

	public ContentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Content.jsp");
		request.setAttribute("fbd", Content_return(request.getParameter("page")));
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
