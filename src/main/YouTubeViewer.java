package main;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer; //imported wrong one!! not util but swing!!

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class YouTubeViewer{
	static JPanel webBrowserPanel;
	static DinerGame frame;
	static JWebBrowser webBrowser;
	
public static void main(String[] args) {
    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	frame = new DinerGame();
        	DinerPanel panel = new DinerPanel();

    		panel.setLayout(new BorderLayout());

    		webBrowserPanel = new JPanel(new BorderLayout());
    	    webBrowser = new JWebBrowser(JWebBrowser.destroyOnFinalization());
    	    frame.setJPanel(webBrowserPanel);
        	frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		frame.setSize(1920,1080);
    		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    		frame.setUndecorated(true);
    		
    		frame.setResizable(false);
    		frame.setVisible(true);
    		frame.setFocusable(true);
    		Timer timer = new Timer(53000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("made it into timer after 50 sec");
					frame.getContentPane().add(panel); //panel doesn't appear for some reason
					webBrowserPanel.setFocusable(false);
					frame.remove(webBrowserPanel);
					panel.requestFocusInWindow(); //THIS MADE IT WORK
					panel.setFocusable(true); //maybe request focus too
					frame.repaint(); 
					frame.revalidate();
				//	frame.pack(); //AHA, this breaks the jframe and makes it disappear
				}
    			});
    			timer.setRepeats(false); // Only execute once
    			timer.start(); // Go go go!
    		Timer timer1 = new Timer(3000, new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				try {
   						click(500,500);
    				} catch (AWTException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    			}
        		});
        		timer1.setRepeats(false); // Only execute once
        		timer1.start();  		
        	
        }
    });
    
    NativeInterface.runEventPump();
    // don't forget to properly close native components
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            NativeInterface.close();
        }
    }));
}

public static JPanel getBrowserPanel() {
    
    webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
    webBrowser.setBarsVisible(false);
    webBrowser.navigate("https://www.youtube.com/embed/XH9n7Bg73Ak"); //embed makes it fullscreen
    //https://youtu.be/XH9n7Bg73Ak
    //https://www.youtube.com/embed/XH9n7Bg73Ak

    return webBrowserPanel;
}

public static JPanel returnThis() {
	return webBrowserPanel;
}

public static void click(int x, int y) throws AWTException{
    Robot bot = new Robot();
    bot.mouseMove(x, y);    
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
}
}