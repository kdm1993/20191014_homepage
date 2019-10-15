package com.munggu.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class FreeboardDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	
    public FreeboardDAO() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		RequestDispatcher rd = request.getRequestDispatcher("select.jsp");
		
		List<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
	
		try {
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kdm1993");
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from freeboard");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeBoardDTO freeboarddto = new FreeBoardDTO();
				freeboarddto.setIdx(rs.getInt("idx"));
				freeboarddto.setTitle(rs.getString("title"));
				freeboarddto.setWriter(rs.getString("writer"));
				freeboarddto.setContent(rs.getString("content"));
				freeboarddto.setView(rs.getInt("view"));
				list.add(freeboarddto);
			}
			request.setAttribute("list", list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			}catch (Exception e) { }
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}









