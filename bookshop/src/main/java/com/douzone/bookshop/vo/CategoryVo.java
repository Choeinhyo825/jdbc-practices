package com.douzone.bookshop.vo;

public class CategoryVo {
	private long cno;
	private String category;

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryVo [cno=" + cno + ", categoryName=" + category + "]";
	}

}
