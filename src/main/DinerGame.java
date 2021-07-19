package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DinerGame {
	public static void main (String[] args) {
		JFrame frame = new JFrame("Hollow Diner");
		DinerPanel panel = new DinerPanel();
	//	mediaPlayer player = new mediaPlayer("file:///C:/Users/youth/eclipse-workspace/Diner/src/resources/Tutorial2.mpeg");

		panel.setLayout(new BorderLayout());

		frame.getContentPane().add(panel);
	//	frame.getContentPane().add(player);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1920,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}
