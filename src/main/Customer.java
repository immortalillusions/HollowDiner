package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Customer extends Rectangle {
	BufferedImage pic;
	boolean destroyed = false;
	int time = 5;
	long timeChange = System.currentTimeMillis() + time*1000;
	
	Customer (int a, int b, int w, int h, String s) {
		x = a;
		y = b;
		width = w;
		height = h;
		try {
			pic = ImageIO.read(getClass().getResource(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPic(String s) {
		try {
			pic = ImageIO.read(getClass().getResource(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean order() {

		if (System.currentTimeMillis() < timeChange ) {
			return false; //break = loop, return = function/method exit
		}
		timeChange += time*1000;
		return true;
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
