package com.douzone.bookshop.vo;

public class CartVo {
	private long bno;
	private long mno;
	private long cartQuantity;
	private long totalPrice;
	private String bookTitle;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public long getMno() {
		return mno;
	}

	public void setMno(long mno) {
		this.mno = mno;
	}

	public long getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(long cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartVo [bno=" + bno + ", mno=" + mno + ", cartQuantity=" + cartQuantity + ", totalPrice=" + totalPrice
				+ ", bookTitle=" + bookTitle + "]";
	}

}
