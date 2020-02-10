package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest("풀하우스", 4L);
		selectTest();
	}

	public static void insertTest(String title, long no) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(no);
		new BookDao().insert(vo);
	}

	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println("책 제목:" + vo.getTitle() + ", \t작가:" + vo.getAuthorName() + ", \t대여 유무:" + vo.getState());
		}
	}

}
