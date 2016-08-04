package com.frame.panel.readerMsg;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.assistclass.FixAssistData;
import com.constant.Constant;
import com.data.Reader;
import com.sqlservice.DriveSQL;


public class ShowReaderMsg extends JPanel{
	
	private Reader reader;
	private ImageIcon backIcon;	
	private JLabel[] label;
	
	public ShowReaderMsg(DriveSQL sql,Reader reader){
		
		this.reader = reader;
		this.setLayout(null);
		
	//	initialize();
		FixAssistData showMsg = new FixAssistData(sql,reader,Constant.SHOW_TYPE_READER);
		showMsg.setBounds(0, 0, 750, 430);
		this.add(showMsg);
		
		backIcon = new ImageIcon("image1\\background.png");
		JLabel back = new JLabel(backIcon);
		back.setBounds(0, 0, backIcon.getIconWidth(), backIcon.getIconHeight());
		this.add(back);		
	}
	
	/*public void initialize(){
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(3,2,10,10));		
		p2.setLayout(new GridLayout(2,2,30,0));
		
		p1.setOpaque(false);
		p2.setOpaque(false);
		
		label = new JLabel[Constant.SHOW_STRING.length];
		String obj;
		for(int i=0;i<6;i++){
			obj = null;
			switch(i){
			case 0:
				obj = " "+reader.getReaderNumber();
				break;
			case 1:
				obj = " "+reader.getReaderName();
				break;
			case 2:
				obj = " "+reader.getReaderSex();
				break;
			case 3:
				obj = " "+reader.getReaderAge();
				break;
			case 4:
				obj = "  "+reader.getReaderPhone();
				break;
			case 5:
				obj = " "+reader.getReaderEmail();
				break;
			}
			label[i] = new JLabel(Constant.SHOW_STRING[i]+obj);
			label[i].setFont(new Font("华文楷体",Font.BOLD,20));	
			label[i].setForeground(Color.red);        
			p1.add(label[i]);
		}
		
		for(int i=6;i<Constant.SHOW_STRING.length;i++){
			obj = null;
			switch (i) {
			case 6:
				obj = " " + reader.getReaderTie();
				break;
			case 7:
				obj = " " + reader.getReaderType();
				break;
			case 8:
				obj = " " + reader.getReaderGrade();
				break;
			case 9:
				obj = " " + reader.getReaderLimits();
				break;
			}
			label[i] = new JLabel(Constant.SHOW_STRING[i] + obj);
		    label[i].setFont(new Font("华文楷体",Font.BOLD,20));
			p2.add(label[i]);
		}
		
		p1.setBorder(new TitledBorder("基础信息"));
		p2.setBorder(new TitledBorder("附加信息"));
		
		this.setLayout(null);
		p1.setBounds(30, 30, 635, 150);
		p2.setBounds(30, 230, 635, 150);
		this.add(p1);
		this.add(p2);
	}
	*/
}
