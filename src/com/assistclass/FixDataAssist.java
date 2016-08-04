package com.assistclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class FixDataAssist extends JPanel{
	private ImageIcon background;
	
	private JLabel[] label;
	private JTextField[] textField;
	private JPanel[] panel;
	
	private JButton okBtn;
	private JButton cancleBtn;
	
	private String[] showLabel;
	private int type;
	private int length;
	
	public FixDataAssist(int type){	
		this.type = type;
		
		this.setLayout(null);
		initialize();
		
		okBtn = new JButton("确认修改");
		cancleBtn = new JButton("取消修改");
		
		JPanel p3 = new JPanel();
		p3.setOpaque(false);
		p3.setLayout(new GridLayout(1,2,30,0));
		
		p3.add(okBtn);
		p3.add(cancleBtn);
		
		p3.setBounds(190, 343, 300, 45);
		this.add(p3);
		
		this.background = new ImageIcon("image1\\background.png");
		JLabel back = new JLabel(background);
		back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		this.add(back);
		
		okBtn.addMouseListener(new OwnListener());
		cancleBtn.addMouseListener(new OwnListener());
	}
	
	public void initialize(){
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		String tipStr;
		
		if(type == Constant.FIX_TYPE_READER){
			showLabel = Constant.SHOW_STRING;
			length = Constant.SHOW_STRING.length - 4;
			tipStr = "基础信息请慎重修改";
			p1.setLayout(new GridLayout(3,2,10,10));	
			System.out.println("FIX_TYPE_READER");
		}else{
			showLabel = Constant.TABLE_HEAD;
			length = Constant.TABLE_HEAD.length - 1;  
			tipStr = "图书信息修改";
			p1.setLayout(new GridLayout(5,2,10,10));
			System.out.println("FIX_TYPE_BOOK");
		}		
			
		p2.setLayout(new GridLayout(2,2,30,10));
		
		p1.setOpaque(false);
		p2.setOpaque(false);
		
		label = new JLabel[showLabel.length - 1];
		textField = new JTextField[showLabel.length - 1];
		panel = new JPanel[showLabel.length - 1];
		
		
		for(int i=0;i<length;i++){
			
			label[i] = new JLabel(showLabel[i]+"  ");
			label[i].setFont(new Font("华文楷体",Font.BOLD,16));	
			label[i].setForeground(Color.red);   
			
			textField[i] = new JTextField();
			
			panel[i] = new JPanel();
			panel[i].setLayout(new BorderLayout());
			panel[i].setOpaque(false);
			
			panel[i].add(label[i],BorderLayout.WEST);
			panel[i].add(textField[i],BorderLayout.CENTER);
			
			p1.add(panel[i]);
		}
		
		if (type == Constant.FIX_TYPE_READER) {
			for (int i = length; i < showLabel.length - 1; i++) {

				if (8 == i)
					label[i] = new JLabel("   " + showLabel[i] + "  ");
				else
					label[i] = new JLabel(showLabel[i] + "  ");
				label[i].setFont(new Font("华文楷体", Font.BOLD, 16));

				textField[i] = new JTextField();

				panel[i] = new JPanel();
				panel[i].setLayout(new BorderLayout());
				panel[i].setOpaque(false);

				panel[i].add(label[i], BorderLayout.WEST);
				panel[i].add(textField[i], BorderLayout.CENTER);

				p2.add(panel[i]);
			}
			
			p1.setBounds(30, 30, 635, 150);
			p2.setBorder(new TitledBorder("附加信息修改"));
			p2.setBounds(30, 210, 635, 105);
			this.add(p2);
		}else{			
			p1.setBounds(30, 25, 635, 270);
		}
		
		p1.setBorder(new TitledBorder(tipStr));		

		this.setLayout(null);
		
		this.add(p1);		
	}
	
	private class OwnListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getSource() == okBtn){
				System.out.println("OK BTN");
			}else{
				System.out.println("CANCLE BTN");
			}
		}
	}
}
