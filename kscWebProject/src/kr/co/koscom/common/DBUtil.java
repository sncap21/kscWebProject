package kr.co.koscom.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnect(String DBTYPE) throws Exception{
		String url = null;
		String driver = null;
		Connection conn = null;
		String user = "koscom";
		String password = "koscom";
		// 드라이버로딩
		switch (DBTYPE.toUpperCase()) {
			case "ORACLE" : 
				url = "jdbc:oracle:thin:@localhost:1521:xe";
				driver = "oracle.jdbc.driver.OracleDriver";
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				break;
			case "MYSQL" :
				url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
				driver = "com.mysql.cj.jdbc.Driver";
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url, user, password);
				break;
			default : 
				System.out.println(DBTYPE);
				Exception e = new Exception("Unsupported DBTYPE ..");
				throw e;
		}
		return conn;		
	}

	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}
	
	public static void close (Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn,ps);
	}
	
}