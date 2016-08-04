package com.sqlservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.assistclass.MyFunction;
import com.data.Book;
import com.data.Reader;

public class DriveSQL {
	private int isSuccess;
	private Connection conn = null;
	private String sql;
	private String url = "jdbc:mysql://127.0.0.1:3306/mysql?"
			+ "user=root&password=123456&useUnicode=true&characterEncoding=UTF8"; // Create
																					// URL
	private Statement stmt;
	private List<Book> book = new ArrayList<Book>();

	public DriveSQL() {
		
		createSQL();
		
	}

	public boolean createSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 动态加载mysql驱动
			// System.out.println("成功加载MySQL驱动程序"); // 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url); // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			stmt = conn.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "加载数据库失败!", "错误......", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean creatTable(String sql) { // executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean insertMessage(String stuMsg) { // Insert student message
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(stuMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean deleteMessage(String delMsg) {
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(delMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean updateMessage(String fixMsg) {
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(fixMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public void showBook(String showMsg) {
		ResultSet rs;
		removeShowBook();
		try {
			rs = stmt.executeQuery(showMsg);
			while (rs.next()) {
				Book obj = new Book(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),Float.parseFloat(rs.getString(5)),Integer.parseInt(rs.getString(6)),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				book.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery会返回结果的集合，否则返回空值
	}

	public void removeShowBook() {
		for (int i = 0; i < book.size();) {
			book.remove(0);
		}
	}

	public Reader getReaderMsg(String sql) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return new Reader(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),Integer.parseInt(rs.getString(5)),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery会返回结果的集合，否则返回空值
		return null;
	}
	
	public Book getBook(String sql) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						Float.parseFloat(rs.getString(5)),Integer.parseInt(rs.getString(6)),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery会返回结果的集合，否则返回空值
		return null;
	}


	public void closeSQL() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public List<Book> getBook() {
		return book;
	}
	
	
}
