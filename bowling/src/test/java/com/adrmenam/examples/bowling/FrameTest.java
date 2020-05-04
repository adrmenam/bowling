package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public class FrameTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private BowlingFrame frame;
	
	@Before
	public void initFrame() {
		frame = new GenericFrame();
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
    public void roll2BallsCorrectPinNumber() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("5")) );
        assertTrue( frame.addBall(new Ball("4")) );
    }
	
	@Test
    public void roll2BallsIncorrectPinNumber() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("5")) );
        assertFalse( frame.addBall(new Ball("6")) );
    }
	
	@Test
    public void roll3BallsFrame() throws NotAllowedRoll
    {
        assertTrue( frame.addBall(new Ball("5")) );
        assertTrue( frame.addBall(new Ball("2")) );
        assertFalse( frame.addBall(new Ball("2")) );
    }
	
	
}
