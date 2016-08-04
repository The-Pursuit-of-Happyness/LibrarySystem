package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.assistclass.SearchAssist;
import com.assistclass.ShowSearchResult;
import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class SearchMenu extends JPanel{
	
	private DriveSQL sql;
	private SearchAssist searchmenu;
	private ShowSearchResult result;
	
	private ImageIcon background;
	
	public SearchMenu(DriveSQL sql){
		this.sql = sql;
		this.setLayout(null);

		background = new ImageIcon("image1\\background.png");
		JLabel back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(), background.getIconHeight());

		searchmenu = new SearchAssist(sql);
		searchmenu.setBounds(180, 40, Constant.SEARCH_WIDTH,
				Constant.SEARCH_HEIGHT);

		this.add(searchmenu);
		
		result = new ShowSearchResult(sql,Constant.BOOK_SEARCH);
		result.setBounds(20, 100, Constant.SEARCH_RESULT_WIDTH,
				Constant.SEARCH_RESULT_HEIGHT);
		this.add(result);
		this.add(back);
	}
}
