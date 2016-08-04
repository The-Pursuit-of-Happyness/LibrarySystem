package com.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.assistclass.Circle;
import com.data.Reader;
import com.frame.MainFrame;
import com.sqlservice.DriveSQL;
import com.sun.awt.AWTUtilities;

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Point origin; // 用于移动窗体
	private BufferedImage img; // 用来设定窗体不规则样式的图片

	private ImageIcon background;
	private JTextField userText = new JTextField(30);
	private JPasswordField passwordText = new JPasswordField(30);
	private JLabel userLabel = new JLabel("账 号:");
	private JLabel passwordLabel = new JLabel("密 码: ");
	private JButton okbtn = new JButton("确定");
	private JButton resert = new JButton("重置");
	private JButton register = new JButton("注册");

	private DriveSQL sql;

	public LoginWindow() {
		super();

		sql = new DriveSQL();

		background = new ImageIcon("image1\\login1.png");
		JLabel back = new JLabel(background);
		back.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		/*
		 * 首先初始化一张图片，我们可以选择一张有透明部分的不规则图片 (当然我们要选择支持Alpha(透明)层的图片格式，如PNG)，这张
		 * 图片将被用来生成与其形状相同的不规则窗体
		 */
		MediaTracker mt = new MediaTracker(this);

		try {
			img = ImageIO.read(new File("image1\\login1.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		mt.addImage(img, 0);

		try {
			mt.waitForAll(); // 开始加载由此媒体跟踪器跟踪的所有图像
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			initialize(); // 窗体初始化
		} catch (IOException e) {
			e.printStackTrace();
		}

		addMenu();
		this.add(back);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addMenu() {
		this.setLayout(null);
		Font font = new Font("", 0, 18);
		userLabel.setForeground(Color.white);
		passwordLabel.setForeground(Color.white);
		userLabel.setFont(font);
		passwordLabel.setFont(font);
		passwordText.setEchoChar('*');

		userLabel.setBounds(80, 120, 100, 50);
		passwordLabel.setBounds(80, 160, 100, 50);
		userText.setBounds(140, 130, 170, 30);
		passwordText.setBounds(140, 170, 170, 30);
		okbtn.setBounds(81, 210, 60, 25);
		resert.setBounds(166, 210, 60, 25);
		register.setBounds(251, 210, 60, 25);

		this.add(userLabel);
		this.add(userText);
		this.add(passwordLabel);
		this.add(passwordText);
		this.add(okbtn);
		this.add(resert);
		this.add(register);

		okbtn.addMouseListener(new OwnListener());
		resert.addMouseListener(new OwnListener());
		register.addMouseListener(new OwnListener());
		passwordText.addKeyListener(new KeyOwnListener());
	}

	private void initialize() throws IOException { // 窗体初始化
		// 设定窗体大小和图片一样大
		this.setSize(img.getWidth(null), img.getHeight(null));
		// 设定禁用窗体装饰，这样就取消了默认的窗体结构
		this.setUndecorated(true);
		// 初始化用于移动窗体的原点
		this.origin = new Point();

		// 调用AWTUtilities的setWindowShape方法设定本窗体为制定的Shape形状
		AWTUtilities.setWindowShape(this, getImageShape(img));
		// 设定窗体可见度
		AWTUtilities.setWindowOpacity(this, 0.8f);

		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		// 由于取消了默认的窗体结构，所以我们要手动设置一下移动窗体的方法
		this.addMouseListener(new OwnListener());

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
						- origin.y);
			}
		});
	}

	public Shape getImageShape(Image img) {// 将Image图像转换为Shape图形
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		int width = img.getWidth(null);// 图像宽度
		int height = img.getHeight(null);// 图像高度

		// 筛选像素
		// 首先获取图像所有的像素信息
		PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
		try {
			pgr.grabPixels();
		} catch (InterruptedException ex) {
			ex.getStackTrace();
		}
		int pixels[] = (int[]) pgr.getPixels();

		// 循环像素
		for (int i = 0; i < pixels.length; i++) {
			// 筛选，将不透明的像素的坐标加入到坐标ArrayList x和y中
			int alpha = getAlpha(pixels[i]);
			if (alpha == 0) {
				continue;
			} else {
				x.add(i % width > 0 ? i % width - 1 : 0);
				y.add(i % width == 0 ? (i == 0 ? 0 : i / width - 1) : i / width);
			}
		}

		// 建立图像矩阵并初始化(0为透明,1为不透明)
		int[][] matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}

		// 导入坐标ArrayList中的不透明坐标信息
		for (int c = 0; c < x.size(); c++) {
			matrix[y.get(c)][x.get(c)] = 1;
		}

		/*
		 * 由于Area类所表示区域可以进行合并，我们逐一水平"扫描"图像矩阵的每一行，
		 * 将不透明的像素生成为Rectangle，再将每一行的Rectangle通过Area类的rec
		 * 对象进行合并，最后形成一个完整的Shape图形
		 */
		Area rec = new Area();
		int temp = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 1) {
					if (temp == 0)
						temp = j;
					else if (j == width) {
						if (temp == 0) {
							Rectangle rectemp = new Rectangle(j, i, 1, 1);
							rec.add(new Area(rectemp));
						} else {
							Rectangle rectemp = new Rectangle(temp, i,
									j - temp, 1);
							rec.add(new Area(rectemp));
							temp = 0;
						}
					}
				} else {
					if (temp != 0) {
						Rectangle rectemp = new Rectangle(temp, i, j - temp, 1);
						rec.add(new Area(rectemp));
						temp = 0;
					}
				}
			}
			temp = 0;
		}
		return rec;
	}

	private int getAlpha(int pixel) {
		return (pixel >> 24) & 0xff;
	}

	/*
	 * 我们可以选择在窗体上绘制图片，是窗体完全呈现出图片的样式， 当然我们也可以根据需要不绘制它，而采取其他操作
	 */

	private class OwnListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			origin.x = e.getX();
			origin.y = e.getY();
		}

		// 窗体上单击鼠标右键关闭程序
		public void mouseClicked(MouseEvent e) {
			if (new Circle(350, 63, 11).contants(e.getX(), e.getY())) {
				System.exit(0);
			} else if (e.getSource() == okbtn) {
				isUserFail();
			} else if (e.getSource() == resert) {
				userText.setText("");
				passwordText.setText("");
			} else if (e.getSource() == register) {
				System.out.println("Register");
			}
		}

		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
		}
	}

	private class KeyOwnListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (10 == e.getKeyCode()) {
				isUserFail();
			}
		}
	}

	public void isUserFail() {
		String user = userText.getText();
		char[] pw = passwordText.getPassword();
		String password = new String(pw);
		if (!user.equals("") || !password.equals("")) {
			String strSql = "select * from reader where readerNumber='" + user
					+ "';";
			Reader userLogin = sql.getReaderMsg(strSql);
			if (userLogin != null) {
				String userPassword = userLogin.getReaderPassword();
				if (password.equals(userPassword)) {
					new MainFrame(userLogin);
					sql.closeSQL();
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "密码错误!", "错误......",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "账号不存在!", "错误......",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "账号或密码不能为空!", "错误......",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
