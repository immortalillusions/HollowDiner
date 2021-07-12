package main;

public class AnimateDiner implements Runnable{
	
	DinerPanel dp;
	
	AnimateDiner (DinerPanel b) { //constructor
		dp = b;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			while (!dp.isOver) { //change true to when lost = false bp.lost=false
				if (!dp.isPaused) {
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
	
}
