package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import com.frame.panel.borrow.BorrowBook;
import com.frame.panel.borrow.PresentBorrow;
import com.frame.panel.borrow.ShowAllBook;
import com.sqlservice.DriveSQL;

public class BorrowMenu extends JTabbedPane{
	
	private DriveSQL sql;
	
	public BorrowMenu(DriveSQL sql){
		this.sql = sql;		
		this.setTabPlacement(JTabbedPane.LEFT);
		
		initialize();
	}	
	public void initialize(){
		
		this.addTab(null,new ImageIcon("tipImage\\borrowTip1.png"),new BorrowBook(sql),"图书借阅");
		this.addTab(null,new ImageIcon("tipImage\\borrowtip2.png"),new ShowAllBook(sql),"查看所有图书");
		this.addTab(null,new ImageIcon("tipImage\\borrowtip2.png"),new PresentBorrow(sql),"当前借阅");
		
	}
}
