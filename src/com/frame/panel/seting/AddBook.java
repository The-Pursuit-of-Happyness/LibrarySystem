package com.frame.panel.seting;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class AddBook extends JPanel{
	
	private JComboBox comboBoxYear;
	private JComboBox comboBoxMouth;
	private JLabel[] label;
	private JLabel jlabel;
	private JLabel back;
	
	private JTextField[] textfield;
	private JButton okButton;
	private JButton cancleButton;
	private String[] stringMassage= {
			"图书编号:  ", "图书名称:  ", "图书类型:  ", "图书作者:  ", "图书价格:  ",
			"图书数量:  ", "借阅状态:  ", "出版商   :  ", "出版日期:  "
			};
	private String[] selectYear;
	private String[] selectMonth;
	private DriveSQL sql;
	
	private int selectYearId =0;
	private int selectMonthId=0;
	private String selectYearItem="请选择年";
	private String selectMonthItem="请选择月份";
	
	public AddBook(DriveSQL sql){
		this.sql = sql;
		
		this.setLayout(null);
		ImageIcon icon = new ImageIcon("image1\\background.png");
		back = new JLabel(icon);
		back.setBounds(0, 0, icon.getIconWidth()+5,icon.getIconHeight());
	
		initialized();
		this.add(back);	
	}
	
	public void initialized(){
		selectYear = new String[67];
		selectYear[0] = "请选择年";
		for(int i=66,count=1;i>0;i--,count++){
			selectYear[count]= ""+(i+1949);
		}
		selectMonth = new String[13];
		selectMonth[0] = "请选择月";
		for(int i=1;i<13;i++){
			selectMonth[i]=""+(i);
		}
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridBagLayout());
		p1.setOpaque(false);
		
		okButton = new JButton("确定");
		okButton.addMouseListener(new mouseAction());
		cancleButton = new JButton("取消");
		cancleButton.addMouseListener(new mouseAction());
		label = new JLabel[stringMassage.length];
		jlabel = new JLabel("添加书籍信息");
		jlabel.setFont(new Font("华文楷体",0,35));
		textfield = new JTextField[stringMassage.length];
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridheight = 2;//占据格子的宽度和高度
		c.gridwidth = 4;
		c.gridx =0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;		
		p1.add(jlabel,c);
		
		int countrlX =0;
		int countrlY =0;
		for(int i=0;i<Constant.TABLE_HEAD.length-1;i++){			
			label[i] = new JLabel(stringMassage[i]);			
			textfield[i] = new JTextField(18);
			c.gridheight = 1;//占据格子的宽度和高度
			c.gridwidth = 1;
			c.weightx = 0;
			c.weighty = 1;
			if(i%2==0){countrlX++;}//添加标签
			c.gridx = countrlY;
			c.gridy = countrlX+1;
			//c.anchor = GridBagConstraints.CENTER;
			label[i].setFont(new Font("华文楷体",0,20));
			p1.add(label[i],c);
			if(i<stringMassage.length-1){//添加单行文本框
			c.gridwidth = 1;
			c.gridx = countrlY+1;
			c.gridy = countrlX+1;
			c.ipady = 15;
			c.anchor = GridBagConstraints.EAST;
			p1.add(textfield[i],c);
			}
			countrlY+=2;
			if(countrlY%4==0)countrlY=0;
			if(i==stringMassage.length-1){
				c.gridx = 2;
				c.ipadx = 80;
				c.gridy = countrlX+2;
				p1.add(okButton,c);
				c.gridx = 3;
				c.gridy = countrlX+2;
				p1.add(cancleButton,c);
			}
		}
		c.gridx =1;
		c.gridy =6;	
		c.anchor = GridBagConstraints.CENTER;
		comboBoxYear = new JComboBox(selectYear);		
		//添加月选项监听事件
		comboBoxYear.addItemListener(new ItemListener() {
			 public void itemStateChanged(final ItemEvent e) {
				  int index = comboBoxYear.getSelectedIndex();
				  if (index != 0) { // ==0表示选中的事第一个					  
					  selectYearId =index;
					  selectYearItem =comboBoxYear.getSelectedItem().toString();
				     }
				  }
			});		
		p1.add(comboBoxYear,c);		
		
		c.gridx =2;			
		comboBoxMouth = new JComboBox(selectMonth);				
				//添加月选项监听事件
				comboBoxMouth.addItemListener(new ItemListener() {
					public void itemStateChanged(final ItemEvent e) {
						  int index = comboBoxMouth.getSelectedIndex();						  
						  if (index != 0) { // ==0表示选中的事第一个
							  selectMonthId =index;
							  selectMonthItem =comboBoxMouth.getSelectedItem().toString();
						     }
						  }
					});				
		p1.add(comboBoxMouth,c);	
		p1.setBounds(0, 0, 700, 400);
		this.add(p1);
		
	}
	//獲取選擇的信息
	public void getMassage(){
		boolean isSure = true;
//		for(int i=0;i<stringMassage.length-1;i++){
//			System.out.println(textfield[i].getText());
//			
//		}
		//图书编号
		if(textfield[0].getText().isEmpty()){
			isSure = false;
		}
		//图书名称
		if(textfield[1].getText().isEmpty()){
			isSure = false;
		}
		//图书类型
		if(textfield[2].getText().isEmpty()&&textfield[2].getText().length()>10){
			isSure = false;
		}
		//图书作者
		if(textfield[3].getText().isEmpty()&&textfield[3].getText().length()>20){
			isSure = false;
		}
		//图书价格
		if(textfield[4].getText().isEmpty()){
			isSure = false;
		}
		//图书数量
		if(textfield[5].getText().isEmpty()){
			isSure = false;
		}
		//图书状态
		if(textfield[6].getText().isEmpty()){
			isSure = false;
		}
		//出版商
		if(textfield[7].getText().isEmpty()){
			isSure = false;
		}
		//出版日期
		if(isSure){
		//向数据库中添加数据
		String data = selectYearItem+"+"+selectMonthItem;
		String strSql = "insert into book values('"+textfield[0].getText()+"',"
				+ "'"+textfield[1].getText()+"','"+textfield[2].getText()+"',"
						+ "'"+textfield[3].getText()+"','"+textfield[4].getText()+"',"
								+ "'"+textfield[5].getText()+"','"+textfield[6].getText()+"',"
										+ "'"+textfield[7].getText()+"',"
												+ "'"+data+"','');";
		System.out.println(strSql);
		if(sql.insertMessage(strSql)){
			JOptionPane.showMessageDialog(null, "添加成功!", "成功......", JOptionPane.ERROR_MESSAGE);
			setMassage();
			//System.out.println("插入成功");			
		}
		else{
			JOptionPane.showMessageDialog(null, "添加失败!", "错误......", JOptionPane.ERROR_MESSAGE);
			System.out.println("插入失败");
		}		
		}
		else{
			JOptionPane.showMessageDialog(null, "数据有误!", "错误......", JOptionPane.ERROR_MESSAGE);
		}
		//System.out.println(strSql);
	}
	//從新初始化選項信息
	public void setMassage(){
		for(int i=0;i<stringMassage.length-1;i++){
			textfield[i].setText("");
		}	
		comboBoxYear.setSelectedIndex(0);
		comboBoxMouth.setSelectedIndex(0);
		selectYearId = 0;
		selectYearItem = "请选择年";
		selectMonthId = 0;
		selectMonthItem = "请选择月份";
	}
	//取消選項的鼠標事件
	class mouseAction extends MouseAdapter{
		public void mouseClicked(MouseEvent m){
			if(m.getSource() == okButton){
				getMassage();
			}else if(m.getSource() == cancleButton){
				setMassage();
			}
		}
	}	
}

