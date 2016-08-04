package com.frame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.assistclass.Circle;
import com.assistclass.Point;
import com.assistclass.Rectangle;
import com.constant.Constant;
import com.image.GainImage;

public class ToolBar extends JPanel implements Runnable {

	private boolean isStart = true;				//控制刷新图标按钮
	private int onClickNum;							//记录单击的是哪个按钮
	
	private boolean areaIn = false;				//用于改变光标样式
	
	private int Queen[] = new int[3];  ///用于保存上次值的栈
	private int top;					//栈指针
	
	private BufferedImage back;			//工具栏背景图片
	private BufferedImage reader;		//读者信息按钮图片
	private BufferedImage help;         //系统帮助按钮图片
	private BufferedImage search;		//图书搜索按钮图片
	private BufferedImage borrow;		//图书借阅按钮图片
	private BufferedImage seting;		//系统设置按钮图片
	private BufferedImage exit;			//退出系统按钮图片
	
	private MainFrame frame;
	private Point point;				//记录鼠标点击位置

	public ToolBar(MainFrame frame,Point p) {
		this.frame = frame;
		this.point = p;
		initialize();
		
		top = -1;	//Initialize Queen
		onClickNum = Constant.TOOLBAR_MENU_SEARCH;
		Queen[++top] =  Constant.TOOLBAR_MENU_SEARCH;
		
		frame.addSearchMenu();
		new Thread(this).start();

		this.addMouseListener(new Listener());
		this.addMouseMotionListener(new ListenerMove());

	}

	public void initialize() {						//Initialize default button image
		back = GainImage.toolbarBack;
		reader = GainImage.reader1;		
		help = GainImage.help2;
		search = GainImage.search2;
		borrow = GainImage.borrow1;
		seting = GainImage.seting1;
		exit = GainImage.exit1;
	}

	private class ListenerMove extends MouseMotionAdapter {					//refresh toolbar icon
		public void mouseMoved(MouseEvent e) {
			Point p = new Point(e.getX(),e.getY());		
			if(new Rectangle(17,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){	
				areaIn = true;
				seting = GainImage.seting2;				
			}else{				
				seting = GainImage.seting1;	
			}
			if(new Rectangle(147,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				areaIn = true;
				reader = GainImage.reader2;				
			}else{
				reader = GainImage.reader1;
			}
			if(new Rectangle(278,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				areaIn = true;
				search = GainImage.search2;
			}else{
				search = GainImage.search1;
			}
			if(new Rectangle(408,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				areaIn = true;
				borrow = GainImage.borrow2;			
			}else{
				borrow = GainImage.borrow1;
			}
			if(new Rectangle(538,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				areaIn = true;
				help = GainImage.help1;
			}else{
				help = GainImage.help2;
			}		
			if(new Rectangle(668,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				areaIn = true;
				exit = GainImage.exit2;
			}else{
				exit = GainImage.exit1;
			}	
			drawCurrentMenu(onClickNum);
			if(areaIn){							//Seting mouse style
				frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}else{
				frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}	
			areaIn = false;		
		}
	}

	private class Listener extends MouseAdapter {				//judge onClick button
		public void mouseClicked(MouseEvent e) {
			int temp = Queen[top--];
			judgeRemoveMenu(temp);
			Point p = new Point(e.getX(),e.getY());				
			if(new Rectangle(17,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				onClickNum = Constant.TOOLBAR_MENU_SETING;	
				frame.addSetingMenu();
			}else if(new Rectangle(147,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				onClickNum = Constant.TOOLBAR_MENU_READER;
				frame.addReaderMenu();	
			}else if(new Rectangle(278,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				onClickNum = Constant.TOOLBAR_MENU_SEARCH;
				frame.addSearchMenu();
			}else if(new Rectangle(408,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				onClickNum = Constant.TOOLBAR_MENU_BORROW;
				frame.addBorrowMenu();
			}else if(new Rectangle(538,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){
				onClickNum = Constant.TOOLBAR_MENU_HELP;
				frame.addHelpMenu();
			}else if(new Rectangle(668,15,Constant.TOOLBAR_MENU_WIDTH,Constant.TOOLBAR_MENU_HEIGHT).contants(p)){			
				onClickNum = Constant.TOOLBAR_MENU_EXIT;
				frame.addExitMenu();
			}	
			Queen[++top] = onClickNum;
		}
	}
	
	public void judgeRemoveMenu(int index){						//dynatic remove frame's module
		if(index == Constant.TOOLBAR_MENU_SETING){
			frame.removeSetingMenu();
		}else if(index == Constant.TOOLBAR_MENU_READER){
			frame.removeReaderMenu();
		}else if(index == Constant.TOOLBAR_MENU_SEARCH){
			frame.removeSearchMenu();
		}else if(index == Constant.TOOLBAR_MENU_BORROW){
			frame.removeBorrowMenu();
		}else if(index == Constant.TOOLBAR_MENU_HELP){
			frame.removeHelpMenu();
		}else if(index == Constant.TOOLBAR_MENU_EXIT){
			frame.removeExitMenu();
		}
		frame.repaint();
	}
	
	public void drawCurrentMenu(int index){						
		if(index == Constant.TOOLBAR_MENU_SETING){
			seting = GainImage.seting2;	
		}else if(index == Constant.TOOLBAR_MENU_READER){
			reader = GainImage.reader2;	
		}else if(index == Constant.TOOLBAR_MENU_SEARCH){
			search = GainImage.search2;
		}else if(index == Constant.TOOLBAR_MENU_BORROW){
			borrow = GainImage.borrow2;	
		}else if(index == Constant.TOOLBAR_MENU_HELP){
			help = GainImage.help1;
		}else if(index == Constant.TOOLBAR_MENU_EXIT){
			exit = GainImage.exit2;
		}
	}


	public void paint(Graphics g) {							//draw all button
		BufferedImage image = new BufferedImage(point.getInt_x(), 70,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		
		g2.drawImage(back, 0, 0, this);
		g2.drawImage(seting, 17, 15, this);
		g2.drawImage(reader, 147, 15, this);
		g2.drawImage(search, 278, 15, this);
		g2.drawImage(borrow, 408, 15,  this);
		g2.drawImage(help, 538, 15, this);		
		g2.drawImage(exit, 668, 15, this);	
		
		g.drawImage(image, 0, 0, this);
	}

	public void run() {							//refresh button icon
		while(isStart) {			
			this.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
