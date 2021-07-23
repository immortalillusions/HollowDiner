package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DinerGame extends JFrame{
	JPanel p;
	boolean youtube = false;
	public void setJPanel(JPanel jp) {
		p = jp;
	}
	public void setTrue () {
		youtube = true;
	}
/*	public static void main (String[] args) {
		JFrame frame = new JFrame("Hollow Diner");
		DinerPanel panel = new DinerPanel();

		panel.setLayout(new BorderLayout());

		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
	} */
}
