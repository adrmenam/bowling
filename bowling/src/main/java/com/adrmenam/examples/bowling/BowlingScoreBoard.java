package com.adrmenam.examples.bowling;

public interface BowlingScoreBoard {
	
	static final int FRAME_NUMBER = 10;
	
	boolean addBall(Ball ball);
	
	boolean addFrame();
	
	void calculateScore();
}
