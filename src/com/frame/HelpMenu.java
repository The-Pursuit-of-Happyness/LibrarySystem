package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpMenu extends JPanel{
	
	private ImageIcon background;
	
	public HelpMenu(){
		
		this.setLayout(null);
		background = new ImageIcon("image1\\helpback.png");
		
		JLabel back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(),background.getIconHeight());
		
		this.add(back);
	}	
}
