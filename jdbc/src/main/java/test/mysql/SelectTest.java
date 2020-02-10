package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			// 1. JDBC Driver(MySQL)로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select no,name from dept";
			rset = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rset.next()) {
				Long no = rset.getLong(1);
				String name = rset.getString(2);
				System.out.println("no-" + no + " / name-" + name);
			}

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.err.println("에러 발생 : " + e);
		} finally {
			try {
				// 6. 자원 정리
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
