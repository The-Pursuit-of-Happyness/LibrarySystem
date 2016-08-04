package com.data;

import javax.swing.table.AbstractTableModel;

import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class BookTableModel extends AbstractTableModel {
	
	private DriveSQL sql;

	public BookTableModel(DriveSQL sql) {
		this.sql = sql;
	}

	public void showAllBook() {
		String opSql = "select * from Book;";
		sql.showBook(opSql);
		this.fireTableStructureChanged();
	}

	public int getRowCount() {
		return sql.getBook().size();
	}

	public String getColumnName(int column) {
		return Constant.TABLE_HEAD[column];
	}

	public int getColumnCount() {
		return Constant.TABLE_HEAD.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Book obj = sql.getBook().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getBookNumber();
		case 1:
			return obj.getBookName();
		case 2:
			return obj.getBookType();
		case 3:
			return obj.getBookAuthor();
		case 4:
			return obj.getBookPrice();
		case 5:
			return obj.getBookCount();
		case 6:
			return obj.getBookState();
		case 7:
			return obj.getBookPress();
		case 8:
			return obj.getBookDate();
		case 9:
			return obj.getBookDiscuss();
		}
		return null;
	}

}
