package com.munggu.org;

public class StaticValues {
	
	public String oracle;
	public String dburl, dbuser, dbpw;
	
	private static StaticValues sv = new StaticValues();
	private StaticValues() {
		oracle = "oracle.jdbc.driver.OracleDriver";
		dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		dbuser = "hr2";
		dbpw = "1234";
	}
	public static StaticValues getInstance() {
		return sv;
	}
}
