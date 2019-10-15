package com.munggu.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MysqlTestConnection")
public class MysqlTestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MysqlTestConnection() {
        super();
    }

    /*
     * tomcat 실행
     * 
     * server.xml
     * context.xml
     * web.xml
     * 
     * *.java 자바 파일 안에 어노테이션
     * 
     * 
     */
    @Resource(name="jdbc/mysql") javax.sql.DataSource ds;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
			System.out.println("conn = "+ conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
