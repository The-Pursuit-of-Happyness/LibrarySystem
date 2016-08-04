package com.assistclass;

public class Point {
	
	private int int_x;
	private int int_y;
	
	private float float_x;
	private float float_y;
	
	private double dou_x;
	private double dou_y;
	
	public Point(int x,int y){
		this.int_x = x;
		this.int_y = y;
	}
	
	public Point(float x,float y){
		this.float_x = x;
		this.float_y = y;
	}
	
	public Point(double x,double y){
		this.dou_x = x;
		this.dou_y = y;
	}

	public int getInt_x() {
		return int_x;
	}

	public int getInt_y() {
		return int_y;
	}

	public float getFloat_x() {
		return float_x;
	}

	public float getFloat_y() {
		return float_y;
	}

	public double getDou_x() {
		return dou_x;
	}

	public double getDou_y() {
		return dou_y;
	}	
}
