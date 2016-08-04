package com.frame.panel.borrow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.assistclass.SearchAssist;
import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class BorrowBook extends JPanel{
	
	private DriveSQL sql;
	private SearchAssist search;
	
	private ImageIcon background;
	
	public BorrowBook(DriveSQL sql){
		this.sql = sql;
		
		this.setLayout(null);
  	  
		background = new ImageIcon("image1\\background.png");
  	  JLabel back = new JLabel(background);
  	  back.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
  	
  	  search = new SearchAssist(sql);
  	  search.setBounds(155, 40, Constant.SEARCH_WIDTH,Constant.SEARCH_HEIGHT);
   
  	  this.add(search);
  	  this.add(back); 
	}
}
