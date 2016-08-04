package com.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class ExitMenu extends JPanel implements Runnable {

	private DriveSQL sql;
	private JFrame frame;

	private JButton btn;
	private ImageIcon back1;
	private ImageIcon back2;
	private boolean isStart = false;
	private boolean isStop = false;
	private int index = 2;
	private int i = 1;
	private String strTip;
	private Font font;

	public ExitMenu(JFrame frame, DriveSQL sql) {
		this.sql = sql;
		this.frame = frame;

		back1 = new ImageIcon("image1\\exitBack.gif");
		back2 = new ImageIcon("image1\\exitBack3.gif");
		
		font = new Font("»ªÎÄ¿¬Ìå", 0, 30);

		strTip = Constant.EXIT_TIP[0];

		this.addMouseListener(new OwnListener());
	}

	public void paint(Graphics g) {
		BufferedImage image = new BufferedImage(778, 433,
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();

		if (!isStart) {
			g2.drawImage(back1.getImage(), 1, 1, this);
		}
		g2.setFont(font);
		g2.setColor(Color.lightGray);
		if (isStart) {
			g2.drawImage(back2.getImage(), 1, 1, this);

			g2.drawString(strTip, 200, 400);

		}

		g.drawImage(image, 1, 1, this);
	}

	private class OwnListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			isStart = true;
			start();
		}
	}

	public void start() {
		new Thread(ExitMenu.this).start();
		isStop = true;
	}

	public void run() {
		while (isStop) {
			index++;
			if (index >= 20) {
				sql.closeSQL();
				frame.dispose();
				isStop = false;
				System.exit(0);
			}
			i++;
			strTip = Constant.EXIT_TIP[i];
			if (i % 6 == 0) {
				i = 0;
			}

			try {
				Thread.sleep(130);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
