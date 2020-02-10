package com.douzone.bookshop.vo;

public class OrderVo {

	// 주문
	private long ono;
	private long mno;
	private String orderCode;
	private long orderPrice;
	private String orderAddress;

	private String orderMemberName;
	private String orderMemberEmail;

	// 주문도서
	private long bno;
	private long orderQuantity;
	private String orderBookTitle;

	public String getOrderBookTitle() {
		return orderBookTitle;
	}

	public void setOrderBookTitle(String orderBookTitle) {
		this.orderBookTitle = orderBookTitle;
	}

	public String getOrderMemberName() {
		return orderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}

	public String getOrderMemberEmail() {
		return orderMemberEmail;
	}

	public void setOrderMemberEmail(String orderMemberEmail) {
		this.orderMemberEmail = orderMemberEmail;
	}

	public long getOno() {
		return ono;
	}

	public void setOno(long ono) {
		this.ono = ono;
	}

	public long getMno() {
		return mno;
	}

	public void setMno(long mno) {
		this.mno = mno;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public long getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "OrderVo [ono=" + ono + ", mno=" + mno + ", orderCode=" + orderCode + ", orderPrice=" + orderPrice
				+ ", orderAddress=" + orderAddress + ", orderMemberName=" + orderMemberName + ", orderMemberEmail="
				+ orderMemberEmail + ", bno=" + bno + ", orderQuantity=" + orderQuantity + ", orderBookTitle="
				+ orderBookTitle + "]";
	}

}
