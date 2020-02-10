package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	public boolean insert(OrderVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getMno());
			pstmt.setString(2, vo.getOrderCode());
			pstmt.setLong(3, vo.getOrderPrice());
			pstmt.setString(4, vo.getOrderAddress());

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

	public boolean insertOrderBook(OrderVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getBno());
			pstmt.setLong(2, vo.getOno());
			pstmt.setLong(3, vo.getOrderQuantity());

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

	public List<OrderVo> findOrder() {
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select o.order_num, m.name, m.email, o.order_price, o.order_address from orders o join member m on(o.mno = m.mno)";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String orderCode = rs.getString(1);
				String orderMemberName = rs.getString(2);
				String orderMemberEmail = rs.getString(3);
				Long orderPrice = rs.getLong(4);
				String orderAddress = rs.getString(5);

				OrderVo vo = new OrderVo();
				vo.setOrderCode(orderCode);
				vo.setOrderMemberName(orderMemberName);
				vo.setOrderMemberEmail(orderMemberEmail);
				vo.setOrderPrice(orderPrice);
				vo.setOrderAddress(orderAddress);
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

	public List<OrderVo> findOrderBook() {
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select ob.bno , b.title, ob.order_quantity from order_book ob join orders o on(ob.ono = o.ono) join book b on(ob.bno = b.bno)";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long bno = rs.getLong(1);
				String orderBookTitle = rs.getString(2);
				Long orderQuantity = rs.getLong(3);

				OrderVo vo = new OrderVo();
				vo.setBno(bno);
				vo.setOrderQuantity(orderQuantity);
				vo.setOrderBookTitle(orderBookTitle);
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
