package com.data;

import java.util.Date;

public class Book {
	private String bookNumber;
	private String bookName;
	private String bookType;
	private String bookAuthor;
	private float bookPrice;
	private int bookCount;
	private String bookState;
	private String bookPress;
	private String bookDate;
	private String bookDiscuss;
	
	public Book(String number,String name,String type,
			String author,float price,int count,String state,String press,String date,String discuss){
		this.bookNumber = number;
		this.bookName = name;
		this.bookType = type;
		this.bookAuthor = author;
		this.bookPrice = price;
		this.bookCount = count;
		this.bookState = state;
		this.bookPress = press;
		this.bookDate = date;
		this.bookDiscuss = discuss;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPress() {
		return bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookDiscuss() {
		return bookDiscuss;
	}

	public void setBookDiscuss(String bookDiscuss) {
		this.bookDiscuss = bookDiscuss;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getBookState() {
		return bookState;
	}

	public void setBookState(String bookState) {
		this.bookState = bookState;
	}	
}
