package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection conn = null;

		try {
			// JDBC Driver(MySQL)로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결 성공!");

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.err.println("에러 발생 : " + e);
		} finally {
			try {
				// 3. 자원정리
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
