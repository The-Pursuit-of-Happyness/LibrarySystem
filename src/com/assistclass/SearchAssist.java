package com.assistclass;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.data.Book;
import com.sqlservice.DriveSQL;

public class SearchAssist extends JPanel {

	public String bookmsg;
	private JTextField text;
	private JButton btn;
	private DriveSQL sql;
	private int type;
	private String strSql;

	public SearchAssist(DriveSQL sql) {
		this.sql = sql;

		text = new JTextField();
		btn = new JButton("ËÑË÷");
		this.setLayout(new BorderLayout());
		add(text, BorderLayout.CENTER);
		add(btn, BorderLayout.EAST);
		btn.addActionListener(new ActionListenerImp());

	}

	public String getsearch() {
		if (!text.getText().isEmpty()) {
			return text.getText();
		}
		return null;
	}

	private class ActionListenerImp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			strSql = "select * from book where bookName=" + getsearch() + ";";
			Book book = sql.getBook(strSql);
		}
	}
}
