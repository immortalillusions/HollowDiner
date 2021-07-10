package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DinerPanel extends JPanel implements KeyListener, ActionListener{
	
	ArrayList <Table> tables = new ArrayList <Table> ();
	ArrayList <Customer> customers = new ArrayList <Customer> ();
	ArrayList <Customer> copycustomers;
	
	long timer;
	long timeLeft;
	long start = 0;
	
	int minutes = 1;
	
	boolean isOver = false;
	boolean isPaused = false;
	
	String c = "/resources/HollowKnight.png"; 
	String order = "/resources/order.png";
	String s; // to get the text of the tables
	
//	Customer test;
	
	//Food testfood;
	
	Line line = new Line (0, 0, 0, 0, "/resources/blank.png");
	
	Table t1;
	Table t2;
	Table t3;
	Table t4;
	
	AnimateDiner animate;
	timer TIMER;
	Thread timerthread;
	Thread thread;
	
	int size = 250;
	
	JLabel score;
	int points = 0;
	
	Color colour = new Color(156, 234, 239);
	
	boolean started = false;
	
	DinerPanel () {
		this.setLayout(null);
		this.setBackground(colour);
		score = new JLabel();
		score.setBounds(1700, 0, 200, 150);
		score.setOpaque(false);
		score.setText("<html>5 minutes<br/>Goal: 20<br/>" + 
				"Current Score: 0</html>");
		score.setFont(new Font("Verdana",Font.BOLD,20));
		score.setBackground(Color.white);
		score.setVisible(true);
		this.add(score);
	//	testfood = new Food(250,250,250,250);
	//	testfood.appear();
		
		t1 = new Table("Table 1");
		t2 = new Table("Table 2");
		t3 = new Table("Table 3");
		t4 = new Table("Table 4");
		tables.add(t1);
		tables.add(t2);
		tables.add(t3);
		tables.add(t4);
		
		for (Table t: tables) {
			t.addActionListener(this);
			s = t.getText();
			t.setActionCommand(s);
			try {
				t.tableimage = ImageIO.read(getClass().getResource("/resources/table2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.setIcon(new ImageIcon(t.tableimage));

		}
		
		t1.addTable(550, 100, size, size, this);
		t2.addTable(1250, 100, size, size, this);
		t3.addTable(550, 540, size, size, this);
		t4.addTable(1250, 540, size, size, this);
		
	//	test = new Customer(50, 300, 100, 200, c);
	//	customers.add(test);
		
		addKeyListener(this);
		setFocusable(true);
	}
	
	public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	    return outputImage;
	}
	
	public void paintComponent (Graphics g) { 
		super.paintComponent(g);
		synchronized (this) {
			copycustomers = new ArrayList <Customer> (customers);
		}
		
		for (Customer c : copycustomers) {
			c.draw(g, this);
		}
		line.draw(g, this);
		repaint();
	}
		
	public void startTimer() {
		if (timer - System.currentTimeMillis() >= 0) { 
			timeLeft =timer - System.currentTimeMillis();
		}
		else {
			isOver = true;
		}
	}
	
	public void update() {		
		score.setText("<html>"+ (int)(timeLeft/1000)+ " seconds<br/>Goal: 20<br/>" + 
				"Current Score: " + points + "</html>");
		line.updateLine();
		line.addCount();
				
		try {
			line.pic = ImageIO.read(getClass().getResource(line.linepic)); // so it updates image
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Customer c : customers) {
			if (c.order()) {
				c.setPic(order);
				c.width = 150;
			}
		}
		
		for(Table t : tables) {
			if (t.customer!=null && t.customer.eat()) {
				try {
					t.tableimage = ImageIO.read(getClass().getResource("/resources/garbage.png"));
					t.customer.picstring = "/resources/blank.png"; //but need to continuously update but not really needed??
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.setIcon(new ImageIcon(t.tableimage));
			}
			if (t.pressed ==true) {
						if (t.addNew&& line.count>0) {
							t.customer = new Customer(t.xvalue - 150, t.yvalue + size/4, 100, 200, c);
							customers.add(t.customer);
							line.subtractCount();
							t.addNew = false; // only one customer per table
						}
						
						if (t.addNew == false) {
							
							if (t.customer.picstring == "/resources/order.png" && t.clicked == false) {
								t.customer.addFood();
								t.customer.eatingTime = System.currentTimeMillis() + 5*1000;
								try {
									t.tableimage = ImageIO.read(getClass().getResource("/resources/tfood.png"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								t.setIcon(new ImageIcon(t.tableimage));
								t.clicked = true;
								
							} 
							
							if(t.customer.picstring == "/resources/blank.png") { 
								t.customer.set_to_destroyed();
								t.addNew = true;
								t.clicked = false;
								try {
									t.tableimage = ImageIO.read(getClass().getResource("/resources/table2.png"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								t.setIcon(new ImageIcon(t.tableimage));
								points++;
							}
							
						}
						t.pressed = false;
					}
		}
		

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!started) {
				animate = new AnimateDiner(this);
				thread = new Thread(animate);
				line = new Line(50, 300, 300, 200, "/resources/blank.png");
				for (int i = 0; i<4; i++) {
					line.subtractCount();
				}			
				line.when = 5*1000;
				thread.start(); //calls run()
				started = true;
				
				TIMER = new timer(this);
				timerthread = new Thread(TIMER);
				timer= System.currentTimeMillis() + minutes*60*1000;
				timerthread.start();	
				
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	/*	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			DinerPanel d = new DinerPanel();
			this.dispose();
		} */
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
        if (action.equals("Table 1")) {
            System.out.println("Button1 pressed!");
            t1.pressed = true;
        }
        if (action.equals("Table 2")) {
            System.out.println("Button2 pressed!");
            t2.pressed = true;
        }
        if (action.equals("Table 3")) {
            System.out.println("Button3 pressed!");
           t3.pressed = true;
        }
        if (action.equals("Table 4")) {
            System.out.println("Button4 pressed!");
            t4.pressed = true;
        }
	}

}
