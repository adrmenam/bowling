package com.adrmenam.examples.bowling;

import java.util.ArrayList;

public class Score implements BowlingScoreBoard{

	private Player player;
	private ArrayList<GenericFrame> frames;
	private int globalScore;
	
	public Score() {
		this.frames = new ArrayList<GenericFrame>();
		this.player = new Player();
		this.globalScore=0;
	}
	
	public Score(Player player) {
		this.player=player;
		this.frames = new ArrayList<GenericFrame>();
		this.globalScore=0;
	}
	
	@Override
	public boolean addBall(Ball ball) {
		// TODO Auto-generated method stub
		if(this.frames.isEmpty()) {
			this.addFrame();
		}

		Boolean ballAdded = this.frames.get(this.frames.size()-1).addBall(ball);
		
		if(ballAdded) {
			return true;
		}else {
			if(this.addFrame()) {
				return this.addBall(ball);
			}
			else {
				return false;
			}
		}	
	}

	@Override
	public boolean addFrame() {
		// TODO Auto-generated method stub
		GenericFrame frame;
		if(frames.size()<FRAME_NUMBER-1) {
			frame = new GenericFrame();
			this.frames.add(frame);
			return true;
		}else if(frames.size()==FRAME_NUMBER-1) {
			frame = new LastFrame();
			this.frames.add(frame);
			return true;
		}
		return false;
	}
	
	@Override
	public void calculateScore() {
		for(int i=0;i<this.frames.size();i++) {
			
			if(this.frames.get(i).sumBalls()==10) {
				
				if(this.frames.get(i).getBalls().size()==1) {
					if(this.frames.get(i+1) instanceof LastFrame) {
						this.globalScore+=this.frames.get(i).sumBalls()+this.frames.get(i+1).getBalls().get(0).getPins()+this.frames.get(i+1).getBalls().get(1).getPins();
					}else {
						this.globalScore+=this.frames.get(i).sumBalls()+this.frames.get(i+1).sumBalls();
					}
					
					
					if(this.frames.get(i+1).getBalls().size()==1&&this.frames.get(i+1).sumBalls()==10) {
						this.globalScore+=this.frames.get(i+2).getBalls().get(0).getPins();
					}
					
				}else {
					this.globalScore+=this.frames.get(i).sumBalls()+this.frames.get(i+1).getBalls().get(0).getPins();
				}
				
			}else {
				this.globalScore+=this.frames.get(i).sumBalls();
				
			}
			this.frames.get(i).setScore(this.globalScore);
		}
	}
	
	

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<GenericFrame> getFrames() {
		return frames;
	}

	public void setFrames(ArrayList<GenericFrame> frames) {
		this.frames = frames;
	}

	public int getGlobalScore() {
		return globalScore;
	}

	public void setGlobalScore(int globalScore) {
		this.globalScore = globalScore;
	}

	
	
	
	
	
}
