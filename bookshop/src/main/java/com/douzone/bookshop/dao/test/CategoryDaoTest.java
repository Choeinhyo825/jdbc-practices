package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		insertTest("IT");
		insertTest("에세이");
		insertTest("소설");
		selectTest();
	}

	public static void insertTest(String category) {
		CategoryVo vo = new CategoryVo();
		vo.setCategory(category);;
		new CategoryDao().insert(vo);
		
	}

	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		System.out.println("<<<카테고리 리스트>>>");
		for (CategoryVo vo : list) {
			System.out.println(vo.getCno() + ") " +vo.getCategory());
		}
	}
}
