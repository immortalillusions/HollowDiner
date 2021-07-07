package main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Food extends Rectangle {
	BufferedImage foodimage;
	
	Food (int a, int b, int w, int h) {
		x = a;
		y = b;
		width = w;
		height = h;
		try {
			foodimage = ImageIO.read(getClass().getResource("/resources/food.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
