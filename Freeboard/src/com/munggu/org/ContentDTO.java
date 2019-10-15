package com.munggu.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;

public class ContentDTO {
	
	@Resource(name="jdbc/ex01") javax.sql.DataSource ds;
	private Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
			System.out.println("conn = "+ conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public FreeBoardDTO Content_return(String idx) {
		
		FreeBoardDTO freeboarddto = new FreeBoardDTO();
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from freeboard " +
										" where idx = ?");
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				freeboarddto.setIdx(rs.getInt("idx"));
				freeboarddto.setTitle(rs.getString("title"));
				freeboarddto.setRedate(rs.getString("regdate"));
				freeboarddto.setModdate(rs.getString("moddate"));
				freeboarddto.setWriter(rs.getString("writer"));
				freeboarddto.setContent(rs.getString("content"));
			}
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
		return freeboarddto;
	}
}
