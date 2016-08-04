package com.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GainImage {
	
	public static BufferedImage toolbarBack;
	public static BufferedImage reader1;
	public static BufferedImage help1;
	public static BufferedImage search1;
	public static BufferedImage borrow1;
	public static BufferedImage seting1;
	public static BufferedImage exit1;
	
	public static BufferedImage borrow2;
	public static BufferedImage help2;
	public static BufferedImage search2;
	public static BufferedImage reader2;
	public static BufferedImage seting2;
	public static BufferedImage exit2;
	
	public static void imageInitialize(){
		try {
			toolbarBack = ImageIO.read(new File("image\\toolbar.png"));
			reader1 = ImageIO.read(new File("image\\reader1.png"));			
			help1 = ImageIO.read(new File("image\\help1.png"));
			search1 = ImageIO.read(new File("image\\search1.png"));
			borrow1 = ImageIO.read(new File("image\\borrow1.png"));	
			seting1 = ImageIO.read(new File("image\\backstage1.png"));	
			exit1 = ImageIO.read(new File("image\\exit1.png"));	
			
			borrow2 = ImageIO.read(new File("image\\borrow2.png"));			
			reader2 = ImageIO.read(new File("image\\reader2.png"));			
			help2 = ImageIO.read(new File("image\\help2.png"));
			search2 = ImageIO.read(new File("image\\search2.png"));
			seting2 = ImageIO.read(new File("image\\backstage2.png"));
			exit2 = ImageIO.read(new File("image\\exit2.png"));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
