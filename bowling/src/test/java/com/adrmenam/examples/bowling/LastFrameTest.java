package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public class LastFrameTest {
	
	private BowlingFrame frame;
	
	@Before
	public void initFrame() {
		frame = new LastFrame();
	}
	
	
	@Test
    public void rollBallCorrectPinNumber() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("5")) );
    }
	
	@Test(expected = NotAllowedRoll.class)
    public void rollBallIncorrectPinNumber() throws NotAllowedRoll
    {
        frame.addBall(new Ball("12"));
    }
	
	@Test(expected = NotAllowedRoll.class)
    public void rollBallNegativePinNumber() throws NotAllowedRoll
    {
        frame.addBall(new Ball("-2"));
    }
	
	@Test
    public void roll3BallsLastFrame() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("5")) );
        assertTrue( frame.addBall(new Ball("2")) );
        assertFalse( frame.addBall(new Ball("2")) );
    }
	
	@Test
    public void roll3BallsLastFrameFirstStrike() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("10")) );
        assertTrue( frame.addBall(new Ball("2")) );
        assertTrue( frame.addBall(new Ball("2")) );
    }
	
	@Test
    public void roll3BallsLastFrameThreeStrikes() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("10")) );
        assertTrue( frame.addBall(new Ball("10")) );
        assertTrue( frame.addBall(new Ball("10")) );
    }
	
	@Test
    public void roll3BallsLastFrameThreeFouls() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("F")) );
        assertTrue( frame.addBall(new Ball("F")) );
        assertFalse( frame.addBall(new Ball("F")) );
    }
	
	@Test
    public void roll2BallsLastFrameTwoFouls() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("F")) );
        assertTrue( frame.addBall(new Ball("F")) );
    }
}
