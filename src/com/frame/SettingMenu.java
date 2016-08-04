package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import com.frame.panel.seting.AddBook;
import com.frame.panel.seting.BackStageManager;
import com.frame.panel.seting.UpdateBook;
import com.sqlservice.DriveSQL;

public class SettingMenu  extends JTabbedPane{
	
	private DriveSQL sql;
	
	public SettingMenu(DriveSQL sql){
		
		this.sql = sql;
		
		initialize();
		
		this.setTabPlacement(JTabbedPane.LEFT);
	}
	
	public void initialize(){
		
		this.addTab(null,new ImageIcon("tipImage\\addBook.png"),new AddBook(sql),"添加图书");
		this.addTab(null,new ImageIcon("tipImage\\fixBook.png"),new UpdateBook(sql),"修改图书信息");
		this.addTab(null,new ImageIcon("tipImage\\deleteBook.png"),new UpdateBook(sql),"删除图书");
		this.addTab(null,new ImageIcon("tipImage\\logout.png"),new UpdateBook(sql),"注销用户");		
		this.addTab(null,new ImageIcon("tipImage\\sql.png"),new BackStageManager(this.sql),"数据库后台管理");	
		
	}
}
