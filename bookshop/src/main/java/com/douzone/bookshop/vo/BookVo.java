package com.douzone.bookshop.vo;

public class BookVo {

	private long bno;
	private long cno;
	private String title;
	private long price;
	private String category;

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BookVo [bno=" + bno + ", cno=" + cno + ", title=" + title + ", price=" + price + ", category="
				+ category + "]";
	}

}
