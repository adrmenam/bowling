package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public class BallTest {

	private Ball ball;
	
	@Test
	public void throwBall() throws NotAllowedRoll {
		ball = new Ball("1");
	}
	
	@Test(expected = NotAllowedRoll.class)
	public void throwBallNegative() throws NotAllowedRoll {
		ball = new Ball("-8");
	}
	
	@Test(expected = NotAllowedRoll.class)
	public void throwBallMoreThanTen() throws NotAllowedRoll {
		ball = new Ball("18");
	}
	
	@Test(expected = NumberFormatException.class)
	public void throwBallInvalidInput() throws NotAllowedRoll {
		ball = new Ball("A");
	}
	
	@Test
	public void throwBallFoul() throws NotAllowedRoll {
		ball = new Ball("F");
		assertEquals(0,ball.getPins());
		assertEquals("F",ball.getRollResult());
	}
}
