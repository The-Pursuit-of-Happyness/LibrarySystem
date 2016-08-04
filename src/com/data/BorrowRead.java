package com.data;

public class BorrowRead {
	private int authorNum;
	private String bookNum;
	private String borrowTime;
	private int borrowCount;
	
	public BorrowRead(int author,String book,String borrowTime,int count){
		this.authorNum = author;
		this.bookNum = book;
		this.borrowTime = borrowTime;
		this.borrowCount = count;
	}

	public int getAuthorNum() {
		return authorNum;
	}

	public String getBookNum() {
		return bookNum;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public int getBorrowCount() {
		return borrowCount;
	}	
	
}
