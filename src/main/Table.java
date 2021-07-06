package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Table extends JButton {
	String text;
	int xvalue;
	int yvalue;
	
	public Table(String string) {
		// TODO Auto-generated constructor stub
		this.setText(string);
		text = string;
		setFocusable(false); // this way when i first click the button, it will focus on panel instead
	}
	
	public String getText() {
		return text;
	}
	
	public void addTable(int x, int y, int width, int height, JPanel p) {
		p.add(this);
		this.setBounds(x, y, width, height);
		xvalue = x;
		yvalue = y;
	}
	
}
