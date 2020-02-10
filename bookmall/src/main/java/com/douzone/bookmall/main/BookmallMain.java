package com.douzone.bookmall.main;

import java.util.List;
import java.util.Scanner;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookmallMain {
	public static void main(String[] args) {
		BookShop();
	}

	public static void BookShop() {
		Scanner sc = new Scanner(System.in);
		System.out.print("대여(1) / 반납(2) : ");
		int choose = sc.nextInt();
		selectAllBook();
		if (choose == 1) {
			System.out.print("\n대여 하고 싶은 책의 번호를 입력하세요 : ");
			long no = sc.nextLong();
			sc.close();
			rental(no, true);
		} else if (choose == 2) {
			System.out.print("\n반납 하고 싶은 책의 번호를 입력하세요 : ");
			long no = sc.nextLong();
			sc.close();
			rental(no, false);
		} else {
			System.out.println("잘못 선택하셨습니다.");
		}

	}

	public static void selectAllBook() {
		List<BookVo> list = new BookDao().findAll();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<책 내역>>>>>>>>>>>>>>>>>>>>>>>>");
		for (BookVo vo : list) {
			System.out.println("번호: " + vo.getNo() + "\t책 제목:" + vo.getTitle() + ", \t작가:" + vo.getAuthorName()
					+ ", \t대여 유무:" + vo.getState());
		}
	}

	public static void rental(long no, Boolean choose) {
		Boolean result = new BookDao().rental(no, choose);
		if (result) {
			if (choose) {
				System.out.println(findOneBookName(no) + "이(가) 대여 됐습니다.");
			} else {
				System.out.println(findOneBookName(no) + "이(가) 반납 됐습니다.");
			}
			selectAllBook();
		} else {
			System.out.println("실패");
		}
	}

	public static String findOneBookName(long no) {
		BookVo vo = new BookDao().findOne(no);
		return vo.getTitle();
	}
}
