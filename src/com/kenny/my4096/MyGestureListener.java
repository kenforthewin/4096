package com.kenny.my4096;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class MyGestureListener extends SimpleOnGestureListener{

	private static final int SWIPE_MIN_DISTANCE = 75;

	private static final int SWIPE_MAX_OFF_PATH = 150;

	private static final int SWIPE_THRESHOLD_VELOCITY = 75;

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

		float dX = e2.getX()-e1.getX();
	
		float dY = e1.getY()-e2.getY();
	
		if (Math.abs(dY)<SWIPE_MAX_OFF_PATH && Math.abs(velocityX)>=SWIPE_THRESHOLD_VELOCITY && Math.abs(dX)>=SWIPE_MIN_DISTANCE ) {	
			if (dX>0) {
				MainActivity.gameBoard.RightMove();
			} 
			else {
	
				MainActivity.gameBoard.LeftMove();
			}
	
			return true;
	
		} else if (Math.abs(dX)<SWIPE_MAX_OFF_PATH && Math.abs(velocityY)>=SWIPE_THRESHOLD_VELOCITY && Math.abs(dY)>=SWIPE_MIN_DISTANCE ) {
	
			if (dY>0) {
				MainActivity.gameBoard.UpMove();

			} else {		
				MainActivity.gameBoard.DownMove();

			}

			return true;

		}
	
		return false;

	}
}
