package main;

import javax.swing.JFrame;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class AnimateDiner implements Runnable{
	
	DinerPanel dp;
	DinerGame f;
	
	AnimateDiner (DinerPanel b, DinerGame f) { //constructor
		dp = b;
		this.f = f;
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while (!dp.isOver) { //change true to when lost = false bp.lost=false
				if (!dp.isPaused) {
					dp.update();
					//THREAD.SLEEP SOMETIMES PREVENTS END MESSAGE FROM APPEARING
				/*	try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} */
				}
				
			}
			dp.end();
			if (dp.isOver) {
			//	f.add(f.p); has to occur in main thread
				f.setTrue();
			}
		
		
		
	}
	
}
