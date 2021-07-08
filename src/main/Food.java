package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Food extends Rectangle {
	BufferedImage foodimage;
	boolean destroyed = false;
	
	Food (int a, int b, int w, int h) {
		x = a;
		y = b;
		width = w;
		height = h;
		try {
			foodimage = ImageIO.read(getClass().getResource("/resources/blank.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void appear() {
		try {
			foodimage = ImageIO.read(getClass().getResource("/resources/food.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void set_to_destroyed() {
		destroyed = true;
	}
	
	public void draw(Graphics g, Component c) {
		if (!destroyed){
			g.drawImage(foodimage, x, y, width, height, c);

		}
	}
}
