package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.frame.panel.borrow.BorrowBook;
import com.sqlservice.DriveSQL;

public class BorrowBookTableModel extends AbstractTableModel {
	
	private DriveSQL sql;
	private String[] head = {"∂¡’ﬂ±‡∫≈","Õº È±‡∫≈","ΩË‘ƒ ±º‰","ΩË‘ƒ¥Œ ˝"};
	private List<BorrowRead> borrowBook = new ArrayList<BorrowRead>();
	
	public BorrowBookTableModel(DriveSQL sql) {
		this.sql = sql;
		
		BorrowRead book1 = new BorrowRead(2013083222,"0001","2015-4",2);
		BorrowRead book2 = new BorrowRead(2013083223,"0002","2015-3",2);
		BorrowRead book3 = new BorrowRead(2013083224,"0003","2015-5",2);
		BorrowRead book4 = new BorrowRead(2013083225,"0004","2015-6",2);
		BorrowRead book5 = new BorrowRead(2013083226,"0005","2015-7",2);
		
		borrowBook.add(book1);
		borrowBook.add(book2);
		borrowBook.add(book3);
		borrowBook.add(book4);
		borrowBook.add(book5);
	}

	public void showAllBook() {
//		String opSql = "select * from Book;";
//		sql.showBook(opSql);
		this.fireTableStructureChanged();
	}

	public int getRowCount() {
		return borrowBook.size();
	}

	public String getColumnName(int column) {
		return head[column];
	}

	public int getColumnCount() {
		return head.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		BorrowRead obj = borrowBook.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getAuthorNum();
		case 1:
			return obj.getBookNum();
		case 2:
			return obj.getBorrowTime();
		case 3:
			return obj.getBorrowCount();
		}
		return null;
	}

}
