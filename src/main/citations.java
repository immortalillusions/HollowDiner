package main;

public class citations {

	// pictures of Hollow knight are from the game
	// picture of the cereal is from @pockles4nockles on Twitter
	
/*	try {
		tableimage1 = ImageIO.read(getClass().getResource("/resources/table2.png"));
		tableimage2 = ImageIO.read(getClass().getResource("/resources/table2.png"));
		tableimage3 = ImageIO.read(getClass().getResource("/resources/table2.png"));
		tableimage4 = ImageIO.read(getClass().getResource("/resources/table2.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*	if (customer1!=null && customer1.eat()) {
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
} */
	
	
	
	
	
	/*		if (pressed1 ==true) {
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
					points++;
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
			points++;
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
			points++;
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
			points++;
		}
	}
	pressed4 = false;
} */
}
