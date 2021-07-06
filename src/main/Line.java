package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Line extends Rectangle{
	int count = 0;
	BufferedImage pic;
	String linepic;
	Random random = new Random();
	int when;
	long change = System.currentTimeMillis() + when*1000;
	
	Line (int a, int b, int w, int h, String s) {
		x = a;
		y = b;
		width = w;
		height = h;
		linepic = s;
		try {
			pic = ImageIO.read(getClass().getResource(linepic));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addCount () {
		when = random.nextInt(5);
		if (System.currentTimeMillis() < change ) {
			return; //break = loop, return = function/method exit
		}
		change += when*1000;
		if (count<4) {
			count++;
		}
	}
	
	public void subtractCount () {
		if (count>0) {
			count--;
		}
	}
	
	public void draw(Graphics g, Component c) {
		g.drawImage(pic, x, y, width, height, c);
	}
	
	public void updateLine() {
		if (count == 0) {
			linepic = "/resources/blank.png"; 
		}
		if (count == 1) {
			linepic = "/resources/HollowKnight.png"; 
		}
		if (count == 2) {
			linepic = "/resources/twoline.png"; 
		}
		if (count == 3) {
			linepic = "/resources/threeline.png"; 
		}
		if (count == 4) {
			linepic = "/resources/fourline.png"; 
		}
	}
	
}
