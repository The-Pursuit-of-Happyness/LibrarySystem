package com.frame.panel.seting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sqlservice.DriveSQL;

public class BackStageManager extends JPanel {

	private DriveSQL sql;
	private JTextArea sqlText = null;
	private ImageIcon background = null;
	private JButton okBtn;
	private JButton cancle;

	public BackStageManager(DriveSQL sql) {
		this.sql = sql;
		this.setBackground(Color.blue);
		
		initialize();
		cancle.addMouseListener(new MouseOwnListener());
		okBtn.addMouseListener(new MouseOwnListener());
	}

	public void initialize() {
		background = new ImageIcon("image1\\back.png");

		this.setLayout(new BorderLayout());
		sqlText = new JTextArea();
		sqlText.setFont(sqlText.getFont().deriveFont((float) 20.0));
		this.add(new JScrollPane(sqlText), BorderLayout.CENTER);

		okBtn = new JButton("确定");
		cancle = new JButton("取消");

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 4, 30, 0));

		JLabel lab1 = new JLabel();
		JLabel lab2 = new JLabel();

		p.add(lab1);
		p.add(okBtn);
		p.add(cancle);
		p.add(lab2);

		this.add(p, BorderLayout.SOUTH);
	}
	
	private class MouseOwnListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getSource() == okBtn){
				int isOk = JOptionPane.showConfirmDialog(null, "你确定要进行操作吗!", "提示......", JOptionPane.CANCEL_OPTION);
				if(isOk == 0){
					System.out.println("OK");
					String sqlOperation = sqlText.getText();
					boolean result = sql.creatTable(sqlOperation);
					if(result){
						JOptionPane.showMessageDialog(null,"创建成功!", "成功......", JOptionPane.OK_CANCEL_OPTION);
					}else{
						JOptionPane.showMessageDialog(null, "创建失败!", "错误......", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}else if(e.getSource() == cancle){
				System.out.println("CAN CLick");
				sqlText.setText("");
			}
		}
	}
}
