package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Customer extends Rectangle {
	BufferedImage pic;
	String picstring;
	boolean destroyed = false;
	boolean alreadyOrdered = false;
	Food food;
	int time = 5;
	long timeChange = System.currentTimeMillis() + time*1000;
	
	Customer (int a, int b, int w, int h, String s) {
		x = a;
		y = b;
		width = w;
		height = h;
		picstring = s;
		try {
			pic = ImageIO.read(getClass().getResource(s));
			food = new Food(x + 150, y - 250/4, 1000,500); //250 = size of table
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPic(String s) {
		try {
			pic = ImageIO.read(getClass().getResource(s));
			picstring = s;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean order() {
		
		if (alreadyOrdered == false) {
		
			if (System.currentTimeMillis() < timeChange ) {
				return false; //break = loop, return = function/method exit
			}
			timeChange += time*1000;
			picstring = "/resources/order.png";
			return true;
		} else return false;
	}
	
	public void addFood() {
		try {
	//		if (this.picstring == "/resources/order.png") {
				pic = ImageIO.read(getClass().getResource("/resources/HollowKnight.png"));
				this.width = 100;
		//		this.food.appear();
				this.alreadyOrdered = true;
				System.out.println("if statement worked");
	//		} else System.out.println("if statement did not work");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	public void set_to_destroyed() {
		destroyed = true;
	}
	
	public void draw(Graphics g, Component c) {
		if (!destroyed){
			g.drawImage(pic, x, y, width, height, c);

		}
	}
}
