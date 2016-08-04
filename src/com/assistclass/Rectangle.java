package com.assistclass;

public class Rectangle {
	private int pos_x;
	private int pos_y;
	private int width;
	private int height;
	
	public Rectangle(int pos_x,int pos_y,int width,int height){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.width = width;
		this.height = height;
	}
	
	public boolean contants(Point p){
		if((p.getInt_x() >= pos_x && p.getInt_x() <= (pos_x + this.width))
		    && (p.getInt_y() >= pos_y && p.getInt_y() <= (pos_y + this.height))){
			return true;
		}
		return false;
	}
}
