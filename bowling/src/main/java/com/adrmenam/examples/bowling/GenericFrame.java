package com.adrmenam.examples.bowling;

import java.util.ArrayList;

public class GenericFrame implements BowlingFrame {

	private ArrayList<Ball> balls;
	private int score;
	private boolean allowMoreBalls;
	private int allowedBalls;
	
	public GenericFrame() {
		this.balls = new ArrayList<Ball>();
		this.score = 0;
		this.allowMoreBalls=true;
		this.allowedBalls=2;
	}
	
	public GenericFrame(int allowedBalls) {
		this.balls = new ArrayList<Ball>();
		this.score = 0;
		this.allowMoreBalls=true;
		this.allowedBalls=allowedBalls;
	}
	
	public ArrayList<Ball> getBalls() {
		return balls;
	}
	public void setBalls(ArrayList<Ball> balls) {
		this.balls = balls;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 
	
	
	public boolean getAllowMoreBalls() {
		return allowMoreBalls;
	}

	public void setAllowMoreBalls(boolean allowMoreBalls) {
		this.allowMoreBalls = allowMoreBalls;
	}
	
	

	public int getAllowedBalls() {
		return allowedBalls;
	}

	public void setAllowedBalls(int allowedBalls) {
		this.allowedBalls = allowedBalls;
	}

	@Override
	public boolean addBall(Ball ball) {
		// TODO Auto-generated method stub
		if(this.getAllowMoreBalls()&&((this.sumBalls()+ball.getPins())<=10)&&ball.getPins()<=10) {
			this.getBalls().add(ball);
			if(ball.getPins()==10||this.getBalls().size()>=2) {
				this.setAllowMoreBalls(false);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int sumBalls() {
		// TODO Auto-generated method stub
		return this.balls.stream().mapToInt(ball -> ball.getPins()).sum();
	}

}
