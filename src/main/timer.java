package main;

public class timer implements Runnable{
	DinerPanel dp;
	
	timer (DinerPanel b) { //constructor
		dp = b;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!dp.isOver) { //change true to when lost = false bp.lost=false
			if (!dp.isPaused) {
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
