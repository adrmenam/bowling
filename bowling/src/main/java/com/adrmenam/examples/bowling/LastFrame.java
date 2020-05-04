package com.adrmenam.examples.bowling;

public class LastFrame extends GenericFrame {
	
	public LastFrame() {
		super();
	}
	
	@Override
	public boolean addBall(Ball ball) {
		// TODO Auto-generated method stub
		if(this.getAllowMoreBalls()&&ball.getPins()<=10) {
			this.getBalls().add(ball);
			if(this.getBalls().size()==1&&ball.getPins()==10) {
				this.setAllowedBalls(3);
			}
			if(this.getBalls().size()>=this.getAllowedBalls()) {
				this.setAllowMoreBalls(false);
			}
			return true;
		}
		return false;
	}

}
