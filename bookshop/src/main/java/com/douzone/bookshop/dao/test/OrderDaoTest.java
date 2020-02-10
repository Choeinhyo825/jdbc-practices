package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		// (고객번호, 주문번호(비즈니스), 결제금액, 배송지) : 주문 테이블
		insertTest(1, "20200129-0001", 82000, "강원도 춘천시 후석로 326");
		// (서적번호, 주문고유번호, 수량) : 주문도서 테이블
		insertOrderBook(1, 1, 1);
		insertOrderBook(3, 1, 1);
		selectTest();
	}

	public static void insertTest(long mno, String orderCode, long orderPrice, String orderAddress) {
		OrderVo vo = new OrderVo();

		vo.setMno(mno);
		vo.setOrderCode(orderCode);
		vo.setOrderPrice(orderPrice);
		vo.setOrderAddress(orderAddress);

		new OrderDao().insert(vo);

	}

	public static void insertOrderBook(long bno, long ono, long orderQuantity) {

		OrderVo vo = new OrderVo();

		vo.setBno(bno);
		vo.setOno(ono);
		vo.setOrderQuantity(orderQuantity);

		new OrderDao().insertOrderBook(vo);

	}

	public static void selectTest() {
		List<OrderVo> list = new OrderDao().findOrder();
		System.out.println("<<<주문 리스트>>>");
		for (OrderVo vo : list) {
			System.out.println(vo.getOrderCode() + " / " + vo.getOrderMemberName() + " / " + vo.getOrderMemberEmail()
					+ " / " + vo.getOrderPrice() + " / " + vo.getOrderAddress());
		}

		List<OrderVo> OBlist = new OrderDao().findOrderBook();
		for (OrderVo vo : OBlist) {
			System.out.println("도서번호:"+vo.getBno() + " / 도서제목:" + vo.getOrderBookTitle() + " / 수량:" + vo.getOrderQuantity());
		}
	}
}
