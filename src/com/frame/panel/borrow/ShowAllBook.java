package com.frame.panel.borrow;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.constant.Constant;
import com.data.BookTableModel;
import com.sqlservice.DriveSQL;

public class ShowAllBook extends JPanel{

	private JTable bookTable;	
	private BookTableModel bookModel;
	private DriveSQL sql;
	
	public ShowAllBook(DriveSQL sql){
		this.sql = sql;
				
		bookModel = new BookTableModel(sql);
		bookTable = new JTable(bookModel);
		
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(bookTable),BorderLayout.CENTER);
		bookModel.showAllBook();	
		
		bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bookTable.setRowHeight(30);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		bookTable.setDefaultRenderer(Object.class, tcr);		
		
		TableColumnModel tcm =  bookTable.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			TableColumn tc = tcm.getColumn(i);	
			tc.setMinWidth(Constant.TABLE_COLUM_WIDTH[i]);
			tc.setPreferredWidth(Constant.TABLE_COLUM_WIDTH[i]);			
		}			
	}	
}
