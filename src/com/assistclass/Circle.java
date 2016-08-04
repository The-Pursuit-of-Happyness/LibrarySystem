package com.assistclass;

public class Circle {
	private int radius;			//°ë¾¶
	private int pos_x;          //×óÉÏ½Çx×ø±ê
	private int pos_y;			//×óÉÏ½Çy×ø±ê
	
	public Circle(int pos_x,int pos_y,int radius){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.radius = radius;
	}
	
	public boolean contants(int pos_x,int pos_y){
		int draw_x = this.pos_x + this.radius;
		int draw_y = this.pos_y + this.radius;
		int distance = (int)Math.sqrt((draw_x-pos_x)*(draw_x-pos_x)+(draw_y-pos_y)*(draw_y-pos_y));
		if(distance <= this.radius){
			return true;
		}
		return false;		
	}
}
