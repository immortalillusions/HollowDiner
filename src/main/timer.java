package main;

public class timer implements Runnable{
	DinerPanel dp;
	boolean isOver = false;
	boolean isPaused = false;
	
	timer (DinerPanel b) { //constructor
		dp = b;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!isOver) { //change true to when lost = false bp.lost=false
			if (!isPaused) {
				dp.startTimer();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
