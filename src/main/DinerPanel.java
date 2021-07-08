package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
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
	
	String c = "/resources/HollowKnight.png"; 
	String order = "/resources/order.png";
	String s; // to get the text of the tables
	
//	Customer test;
	Customer customer1;
	Customer customer2;
	Customer customer3;
	Customer customer4;
	
	//Food testfood;
	
	Line line = new Line(50, 300, 300, 200, "/resources/blank.png");
	
	Table t1;
	Table t2;
	Table t3;
	Table t4;
	
	BufferedImage tableimage1;
	BufferedImage tableimage2;
	BufferedImage tableimage3;
	BufferedImage tableimage4;
	
	AnimateDiner animate;
	Thread thread;
	
	int size = 250;
	
	boolean started = false;
	boolean pressed1 = false;
	boolean pressed2 = false;
	boolean pressed3 = false;
	boolean pressed4 = false;
	boolean addNew1 = true;
	boolean addNew2 = true;
	boolean addNew3 = true;
	boolean addNew4 = true;
	boolean clicked1 = false;
	boolean clicked2 = false;
	boolean clicked3 = false;
	boolean clicked4 = false;
	
	
	DinerPanel () {
		this.setLayout(null);
		
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
		
		try {
			tableimage1 = ImageIO.read(getClass().getResource("/resources/table2.png"));
			tableimage2 = ImageIO.read(getClass().getResource("/resources/table2.png"));
			tableimage3 = ImageIO.read(getClass().getResource("/resources/table2.png"));
			tableimage4 = ImageIO.read(getClass().getResource("/resources/table2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Table t: tables) {
			t.addActionListener(this);
			s = t.getText();
			t.setActionCommand(s);
			t.setIcon(new ImageIcon(tableimage1));

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
		
	
	
	public void update() {		
		
		line.updateLine();
		line.addCount();
		if (customer1!=null && customer1.eat()) {
			try {
				tableimage1 = ImageIO.read(getClass().getResource("/resources/garbage.png"));
				customer1.picstring = "/resources/blank.png"; //but need to continuously update but not really needed??
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t1.setIcon(new ImageIcon(tableimage1));
		}
		if (customer2!=null &&customer2.eat()) {
			try {
				tableimage2 = ImageIO.read(getClass().getResource("/resources/garbage.png"));
				customer2.picstring = "/resources/blank.png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t2.setIcon(new ImageIcon(tableimage2));
		}
		if (customer3!=null &&customer3.eat()) {
			try {
				tableimage3 = ImageIO.read(getClass().getResource("/resources/garbage.png"));
				customer3.picstring = "/resources/blank.png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t3.setIcon(new ImageIcon(tableimage3));
		}
		if (customer4!=null &&customer4.eat()) {
			try {
				tableimage4 = ImageIO.read(getClass().getResource("/resources/garbage.png"));
				customer4.picstring = "/resources/blank.png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t4.setIcon(new ImageIcon(tableimage4));
		}
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
		if (pressed1 ==true) {
			//		test.x = t1.xvalue - 150;
			//		test.y = t1.yvalue + size/4;
			//		System.out.println(test.x);
			//		System.out.println(test.y);
					
					if (addNew1&& line.count>0) {
						customer1 = new Customer(t1.xvalue - 150, t1.yvalue + size/4, 100, 200, c);
						customers.add(customer1);
						line.subtractCount();
						addNew1 = false; // only one customer per table
					}
					
					if (addNew1 == false) {
						
						if (customer1.picstring == "/resources/order.png" && clicked1 == false) {
							customer1.addFood();
							customer1.eatingTime = System.currentTimeMillis() + 5*1000;
							try {
								tableimage1 = ImageIO.read(getClass().getResource("/resources/tfood.png"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							t1.setIcon(new ImageIcon(tableimage1));
							clicked1 = true;
							
						} 
						
						if(customer1.picstring == "/resources/blank.png") { 
							customer1.set_to_destroyed();
							addNew1 = true;
							clicked1 = false;
							try {
								tableimage1 = ImageIO.read(getClass().getResource("/resources/table2.png"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							t1.setIcon(new ImageIcon(tableimage1));
						}
						
					}
					pressed1 = false;
				}

		if (pressed2 ==true) {
	//		test.x = t2.xvalue - 150;
	//		test.y = t2.yvalue + size/4;
	//		System.out.println(test.x);
	//		System.out.println(test.y);
			
			if (addNew2&& line.count>0) {
				customer2 = new Customer(t2.xvalue - 150, t2.yvalue + size/4, 100, 200, c);
				customers.add(customer2);
				line.subtractCount();
				addNew2 = false; // only one customer per table
			}
			
			if (addNew2 == false) {
				
				if (customer2.picstring == "/resources/order.png" && clicked2 == false) {
					customer2.addFood();
					customer2.eatingTime = System.currentTimeMillis() + 5*1000;
					try {
						tableimage2 = ImageIO.read(getClass().getResource("/resources/tfood.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t2.setIcon(new ImageIcon(tableimage2));
					clicked2 = true;
				} 
				if(customer2.picstring == "/resources/blank.png") { 
					customer2.set_to_destroyed();
					addNew2 = true;
					clicked2 = false;
					try {
						tableimage2 = ImageIO.read(getClass().getResource("/resources/table2.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t2.setIcon(new ImageIcon(tableimage2));
				}
			}
			
			pressed2 = false;
		}
		if (pressed3 ==true) {
	//		test.x = t3.xvalue - 150;
	//		test.y = t3.yvalue + size/4;
	//		System.out.println(test.x);
	//		System.out.println(test.y);
			
			if (addNew3&& line.count>0) {
				customer3 = new Customer(t3.xvalue - 150, t3.yvalue + size/4, 100, 200, c);
				customers.add(customer3);
				line.subtractCount();
				addNew3 = false; // only one customer per table
			}
			if (addNew3 == false) {
				
				if (customer3.picstring == "/resources/order.png"&& clicked3 == false) {
					customer3.addFood(); 
					customer3.eatingTime = System.currentTimeMillis() + 5*1000;
					customer3.eatingTime = System.currentTimeMillis() + 5*1000;
					try {
						tableimage3 = ImageIO.read(getClass().getResource("/resources/tfood.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t3.setIcon(new ImageIcon(tableimage3));
					clicked3 = true;
				} 
				if(customer3.picstring == "/resources/blank.png") { 
					customer3.set_to_destroyed();
					addNew3 = true;
					clicked3 = false;
					try {
						tableimage3 = ImageIO.read(getClass().getResource("/resources/table2.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t3.setIcon(new ImageIcon(tableimage3));
				}
			}
			pressed3 = false;
		}
		if (pressed4 ==true) {
	//		test.x = t4.xvalue - 150;
	//		test.y = t4.yvalue + size/4;
	//		System.out.println(test.x);
	//		System.out.println(test.y);
			
			if (addNew4&& line.count>0) {
				customer4 = new Customer(t4.xvalue - 150, t4.yvalue + size/4, 100, 200, c);
				customers.add(customer4);
				line.subtractCount();
				addNew4 = false; // only one customer per table
			}
			if (addNew4 == false) {
				
				if (customer4.picstring == "/resources/order.png"&& clicked4 == false) {
					customer4.addFood(); 
					customer4.eatingTime = System.currentTimeMillis() + 5*1000;
					try {
						tableimage4 = ImageIO.read(getClass().getResource("/resources/tfood.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t4.setIcon(new ImageIcon(tableimage4));
					clicked4 = true;
				} 
				if(customer4.picstring == "/resources/blank.png") { 
					customer4.set_to_destroyed();
					addNew4 = true;
					clicked4 = false;
					try {
						tableimage4 = ImageIO.read(getClass().getResource("/resources/table2.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					t4.setIcon(new ImageIcon(tableimage4));
				}
			}
			pressed4 = false;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!started) {
				animate = new AnimateDiner(this);
				thread = new Thread(animate);
				
				for (int i = 0; i<4; i++) {
					line.subtractCount();
				}				
				thread.start(); //calls run()
				started = true;
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
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
            pressed1 = true;
        }
        if (action.equals("Table 2")) {
            System.out.println("Button2 pressed!");
            pressed2 = true;
        }
        if (action.equals("Table 3")) {
            System.out.println("Button3 pressed!");
            pressed3 = true;
        }
        if (action.equals("Table 4")) {
            System.out.println("Button4 pressed!");
            pressed4 = true;
        }
	}

}
