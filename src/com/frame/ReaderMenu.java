package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import com.data.Reader;
import com.frame.panel.readerMsg.FixReaderMsg;
import com.frame.panel.readerMsg.ShowReaderMsg;
import com.sqlservice.DriveSQL;

public class ReaderMenu extends JTabbedPane{
	
	private DriveSQL sql;
	private Reader user;
	
	public ReaderMenu(DriveSQL sql,Reader user){
		this.sql = sql;
		this.user = user;		
		
		initialize();
		
		
		this.setTabPlacement(JTabbedPane.LEFT);
	}
	
	public void initialize(){
		
		this.addTab(null,new ImageIcon("tipImage\\userMsg.png"),new ShowReaderMsg(sql,user),"读者详细信息");
		this.addTab(null,new ImageIcon("tipImage\\fixMsg.png"),new FixReaderMsg(sql,user),"读者信息修改");
		
	}
}
