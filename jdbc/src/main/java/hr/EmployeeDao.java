package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

	public void findByName(EmployeeVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			// 1. JDBC Driver(MySQL)로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "employees", "employees");

			// 3. SQL문 준비(Prepare, 미완성된 쿼리)
			String sql = "select emp_no, first_name, last_name, hire_date from employees where first_name like ? order by 2";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, "%" + vo.getFirstName() + "%");

			// 5. SQL문 실행
			rset = pstmt.executeQuery();

			// 6. 결과 바인딩
			while (rset.next()) {
				Long no = rset.getLong(1);
				String firstName = rset.getString(2);
				String lastName = rset.getString(3);
				String hireDate = rset.getString(4);

				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setNo(no);
				employeeVo.setFirstName(firstName);
				employeeVo.setLastName(lastName);
				employeeVo.setHireDate(hireDate);

				System.out.println(employeeVo);
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
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Boolean insert(EmployeeVo vo) {
		return false;
	}

	public Boolean delete(Long no) {
		return false;
	}

	public Boolean insert(String name) {
		return false;
	}

	public Boolean update(EmployeeVo vo) {
		return false;
	}

}
