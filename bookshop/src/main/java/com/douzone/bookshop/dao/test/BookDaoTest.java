package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest(1L, "자바의 정석", 50000L);
		insertTest(2L, "에세이의 정석", 35000L);
		insertTest(3L, "소설의 정석", 32000L);
		selectTest();
	}

	public static void insertTest(long categoryNum, String title, long price) {
		BookVo vo = new BookVo();
		vo.setCno(categoryNum);
		vo.setTitle(title);
		vo.setPrice(price);
		
		new BookDao().insert(vo);
		

	}

	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		System.out.println("<<<서적 리스트>>>");
		for (BookVo vo : list) {
			System.out.println("카테고리:"+vo.getCategory() + "\t제목:" + vo.getTitle()+"\t가격:"+vo.getPrice());
		}
	}
}
