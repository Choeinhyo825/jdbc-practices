package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	public boolean insert(CartVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getBno());
			pstmt.setLong(2, vo.getMno());
			pstmt.setLong(3, vo.getCartQuantity());

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

	public List<CartVo> findAll(long memberNo) {
		List<CartVo> result = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select c.bno, c.mno, c.cart_quantity, b.price*c.cart_quantity, b.title from cart c join Book b on(c.bno = b.bno) where c.mno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long bno = rs.getLong(1);
				Long mno = rs.getLong(2);
				Long cartQuantity = rs.getLong(3);
				Long totalPrice = rs.getLong(4);
				String bookTitle = rs.getString(5);

				CartVo vo = new CartVo();
				vo.setBno(bno);
				vo.setMno(mno);
				vo.setCartQuantity(cartQuantity);
				vo.setTotalPrice(totalPrice);
				vo.setBookTitle(bookTitle);
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
