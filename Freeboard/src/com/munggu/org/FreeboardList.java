package com.munggu.org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

public class FreeboardList {
	
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
	
	public ArrayList<FreeBoardDTO> FreeboardList_return() {
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from freeboard");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FreeBoardDTO freeboarddto = new FreeBoardDTO();
				freeboarddto.setIdx(rs.getInt("idx"));
				freeboarddto.setTitle(rs.getString("title"));
				freeboarddto.setRedate(rs.getString("regdate"));
				freeboarddto.setModdate(rs.getString("moddate"));
				freeboarddto.setWriter(rs.getString("writer"));
				freeboarddto.setContent(rs.getString("content"));
				list.add(freeboarddto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
