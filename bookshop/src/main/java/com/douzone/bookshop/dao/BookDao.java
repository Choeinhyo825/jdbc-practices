package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVo;

public class BookDao {
	public boolean insert(BookVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into Book values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getCno());
			pstmt.setString(2, vo.getTitle());
			pstmt.setLong(3, vo.getPrice());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<BookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select b.bno, c.cno, b.title, b.price, c.category from Book b join category c on(b.cno = c.cno)";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long bno = rs.getLong(1);
				Long cno = rs.getLong(2);
				String title = rs.getString(3);
				Long price = rs.getLong(4);
				String category = rs.getString(5);

				BookVo vo = new BookVo();
				vo.setBno(bno);
				vo.setCno(cno);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategory(category);
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}

}
