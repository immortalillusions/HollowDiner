package main;

public class AnimateDiner implements Runnable{
	
	DinerPanel dp;
	boolean isOver = false;
	boolean isPaused = false;
	
	AnimateDiner (DinerPanel b) { //constructor
		dp = b;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!isOver) { //change true to when lost = false bp.lost=false
			if (!isPaused) {
				dp.update();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
