package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {

		Boolean result = delete(1);
		if (result) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public static boolean delete(int no) {
		Boolean result = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			// 1. JDBC Driver(MySQL)로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "delete from dept where no = " + no;
			int count = stmt.executeUpdate(sql);

			// 5. 성공여부
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.err.println("에러 발생 : " + e);
		} finally {
			try {
				// 6. 자원 정리
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
