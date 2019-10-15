package com.munggu.org;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn != null) {
			return conn;
		}
		else {
			try {
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kdm1993");
				Connection conn = ds.getConnection();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
	
}
