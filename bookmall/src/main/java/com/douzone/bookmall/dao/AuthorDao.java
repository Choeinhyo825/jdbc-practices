package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDao {

	public Boolean insert(AuthorVo vo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into author values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.err.println("에러 발생 : " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<AuthorVo> findAll() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = getConnection();
			String sql = "select * from author";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				long no = rset.getLong(1);
				String name = rset.getString(2);

				AuthorVo vo = new AuthorVo();
				vo.setNo(no);
				vo.setName(name);
				list.add(vo);
			}

		} catch (SQLException e) {
			System.err.println("에러 발생 : " + e);
		} finally {
			try {
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
		return list;
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패 : " + e);
		}

		return conn;

	}

}
