package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest("최인효", "010-5154-0825", "inhyo825@gmail.com", "1q2w3e4r");
		insertTest("홍길동", "010-1234-5678", "hong123@gmail.com", "rlfehd123");
		selectTest();
	}

	public static void insertTest(String name, String phone, String email, String pass) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPass(pass);
		new MemberDao().insert(vo);
	}

	public static void selectTest() {
		List<MemberVo> list = new MemberDao().findAll();
		System.out.println("<<<회원 리스트>>>");
		for (MemberVo vo : list) {
			System.out.println("이름:" + vo.getName() + " / 전화번호:" + vo.getPhone() + " / 이메일:" + vo.getEmail()
					+ " / 비밀번호:" + vo.getPass());
		}
	}

}
