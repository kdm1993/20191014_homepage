package com.munggu.org;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberDBmanager {
	
	private static MemberDBmanager dba = new MemberDBmanager();
	
	private MemberDBmanager() {};
	
	public static MemberDBmanager getInstance() {
		return dba;
	}
	private StaticValues sv = StaticValues.getInstance();
	
	public boolean checkLogin(String id, String pw) {
		boolean logincheck = true;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(sv.oracle);
			
			con = DriverManager.getConnection(sv.dburl, sv.dbuser, sv.dbpw);
			pstmt = con.prepareStatement("select * from member " +
										" where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				logincheck = true;
			} else {
				logincheck = false;
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
		return logincheck;
	}
	public ArrayList<String> join(String value2) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> value = new ArrayList<String>();
		
		try {
			Class.forName(StaticValues.getInstance().oracle);
			
			con = DriverManager.getConnection(StaticValues.getInstance().dburl, StaticValues.getInstance().dbuser, StaticValues.getInstance().dbpw);
			pstmt = con.prepareStatement("select * from member ");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				value.add(rs.getString(value2));
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
		return value;
	}
}