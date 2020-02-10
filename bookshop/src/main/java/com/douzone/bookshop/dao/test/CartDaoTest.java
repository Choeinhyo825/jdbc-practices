package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		// (서적번호, 회원번호, 수량, 금액);
		insertTest(1L, 1L, 1L);
		insertTest(3L, 1L, 1L);
		selectTest(1L);
	}

	public static void insertTest(long bno, long mno, long cartQuantity) {
		CartVo vo = new CartVo();

		vo.setBno(bno);
		vo.setMno(mno);
		vo.setCartQuantity(cartQuantity);

		new CartDao().insert(vo);
	}

	public static void selectTest(long mno) {
		List<CartVo> list = new CartDao().findAll(mno);
		System.out.println("<<<카트 리스트>>>");
		for (CartVo vo : list) {
			System.out.println(
					"도서제목:" + vo.getBookTitle() + "\t수량:" + vo.getCartQuantity() + "\t가격:" + vo.getTotalPrice());
		}
	}
}
