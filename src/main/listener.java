package main;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class listener extends JPanel {

	JPanel panel;
	Framethread Framethread;
	Thread thread;
	
	listener(JPanel p) {
		panel = p;
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		System.out.println("listener out of while");
//		while (DinerPanel.frame == true) {
	//		this.remove(panel);
	//		System.out.println("listener");
	//	}
		Framethread = new Framethread(this);
		thread = new Thread(Framethread);
		thread.start(); //calls run()
	}

	public void addPanel(JPanel dinerPanel) {
		// TODO Auto-generated method stub
		panel = dinerPanel;
		this.add(panel);
		
	}

	
	
}
