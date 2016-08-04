package com.frame.panel.seting;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.assistclass.SearchAssist;
import com.assistclass.ShowSearchResult;
import com.constant.Constant;
import com.data.Book;
import com.sqlservice.DriveSQL;

public class UpdateBook extends JPanel {

	private SearchAssist search;
	private ImageIcon back;
	private JLabel label[];
	private JPanel panel;
	private Book bookmsg;
	private String obj[];
	private ShowSearchResult result;
	private DriveSQL sql;

	public UpdateBook(DriveSQL sql) {
		this.setLayout(null);
		this.sql = sql;
		back = new ImageIcon("image1\\background.png");
		JLabel la = new JLabel(back);
		la.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());

		search = new SearchAssist(sql);
		search.setBounds(150, 40, Constant.SEARCH_WIDTH, Constant.SEARCH_HEIGHT);

		this.add(search);

		result = new ShowSearchResult(sql,Constant.BOOK_UPDATE);
		
		result.setBounds(20, 100, Constant.SEARCH_UPDATE_WIDTH,
				Constant.SEARCH_UPDATE_HEIGHT);
		this.add(result);
		
		this.add(la);

	}
	// public void initialize(){
	//
	// panel =new JPanel();
	// panel.setLayout(new GridLayout(4,2,5,5));
	// panel.setOpaque(false);
	//
	//
	// for(int i=0;i<Constant.TABLE_HEAD.length;i++){
	// label[i]=new JLabel(Constant.TABLE_HEAD[i]);
	// label[i].setFont(new Font("华文楷体",Font.BOLD,20));
	// panel.add(label[i]);
	// }
	// panel.setBorder(new TitledBorder("图书信息"));
	// panel.setBounds(30, 80, 635, 150);
	//
	// }

}
