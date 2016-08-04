package com.frame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import com.assistclass.Point;
import com.constant.Constant;
import com.data.Reader;
import com.image.GainImage;
import com.sqlservice.DriveSQL;

public class MainFrame extends JFrame{	
	
	private Point point;
	private Reader user;
//	private MainMenu menu;
	
	private DriveSQL mySql = new DriveSQL();	//new Object
	private ReaderMenu readerMenu;				//Reader Message and operation
	private SettingMenu seting;
	private BorrowMenu borrow;
	private HelpMenu help;
	private ExitMenu exit;
	private SearchMenu search;
	
	public MainFrame(Reader user){		
		this.setTitle("Library System");
		this.user = user;
		this.setLayout(null);
		
		point = new Point(Constant.WINDOQ_WIDTH,Constant.WINDOQ_HEIGHT);
		GainImage.imageInitialize();
		this.initialize();		
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	this.setLocationRelativeTo(null);
		this.setResizable(false);		
		this.setLocation(520,130);
		this.setSize(Constant.WINDOQ_WIDTH, Constant.WINDOQ_HEIGHT);
		this.setVisible(true);
	}	

	public void initialize(){
		JLabel title = new JLabel(new ImageIcon("image\\title.png"));
		title.setBounds(0,0,800,100);
		JLabel toolbar = new JLabel(new ImageIcon("image\\toolbar.png"));
		toolbar.setBounds(0,100,800,70);
		this.add(title);
		this.add(toolbar);
		
		ToolBar tool = new ToolBar(this,point);
		tool.setBounds(0,100,Constant.WINDOQ_WIDTH,70);
		this.add(tool);				
		
	}	
	
	public void addReaderMenu(){
		
//		String user = "2013083225";	
//
//		String strSql = "select * from Reader where readerNumber='"+user+"';";
//		Reader reader = mySql.getReaderMsg(strSql);
		
		readerMenu = new ReaderMenu(mySql,user);		
		readerMenu.setBounds(8,180,778,433);
		
		Border border = BorderFactory.createRaisedBevelBorder();          //…Ë÷√±ﬂøÚ  
		readerMenu.setBackground(Color.green);
		readerMenu.setBorder(border);
		
		this.add(readerMenu);
		readerMenu.updateUI();
	}		
	public void removeReaderMenu(){
		this.remove(readerMenu);
	}
	
	public void addSetingMenu(){
		seting = new SettingMenu(mySql);		
		seting.setBounds(8,180,775,430);
		
		Border border = BorderFactory.createRaisedBevelBorder();          //…Ë÷√±ﬂøÚ  
		seting.setBackground(Color.lightGray);
		seting.setBorder(border);
		
		this.add(seting);
		seting.updateUI();		
	}	
	public void removeSetingMenu(){
		this.remove(seting);
	}
	
	public void addSearchMenu(){
		search = new SearchMenu(mySql);		
		search.setBounds(9,180,777,432);
		
		Border border = BorderFactory.createRaisedBevelBorder();          //…Ë÷√±ﬂøÚ  
		search.setBackground(Color.black);
		search.setBorder(border);
		
		this.add(search);
		search.updateUI();		
	}
	public void removeSearchMenu(){
		this.remove(search);
	}
	
	public void addBorrowMenu(){
		borrow = new BorrowMenu(mySql);		
		borrow.setBounds(8,180,775,430);
		
		Border border = BorderFactory.createRaisedBevelBorder();          //…Ë÷√±ﬂøÚ  
		borrow.setBackground(Color.green);
		borrow.setBorder(border);
		
		this.add(borrow);
		borrow.updateUI();	
	}
	public void removeBorrowMenu(){
		this.remove(borrow);
	}
	
	public void addHelpMenu(){
		help = new HelpMenu();		
		help.setBounds(9,180,777,432);
		help.setBackground(Color.black);
		
		this.add(help);
		help.updateUI();	
	}
	public void removeHelpMenu(){
		this.remove(help);
	}
	
	public void addExitMenu(){
		exit = new ExitMenu(this,mySql);		
		exit.setBounds(8,180,778,433);
		
		this.add(exit);
		exit.updateUI();	
	}
	public void removeExitMenu(){
		this.remove(exit);
	}
	
}
