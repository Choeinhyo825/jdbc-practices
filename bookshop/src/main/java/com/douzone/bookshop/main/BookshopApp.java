package com.douzone.bookshop.main;

import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.MemberDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;

public class BookshopApp {
	public static void main(String[] args) {
		System.out.println("==========================회원==============================");
		new MemberDaoTest().main(args); 
		System.out.println("\n=======================카테고리============================");
		new CategoryDaoTest().main(args);
		System.out.println("\n========================서적=============================");
		new BookDaoTest().main(args);
		System.out.println("\n========================카트=============================");
		new CartDaoTest().main(args);
		System.out.println("\n========================주문=============================");
		new OrderDaoTest().main(args);
		
	}
}
