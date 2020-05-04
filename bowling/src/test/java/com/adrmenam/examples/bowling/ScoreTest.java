package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public class ScoreTest {
	private Score score;
	
	@Before
	public void initScore() {
		score = new Score();
	}
	
	@Test
    public void rollBallCorrectPinNumber() throws NotAllowedRoll
    {
        assertTrue( score.addBall(new Ball("5")) );
    }
	
	@Test(expected = NotAllowedRoll.class)
    public void rollBallIncorrectPinNumber() throws NotAllowedRoll
    {
        score.addBall(new Ball("12"));
    }
	
	@Test(expected = NotAllowedRoll.class)
    public void rollBallNegativePinNumber() throws NotAllowedRoll
    {
        score.addBall(new Ball("-2"));
    }
	
	@Test
    public void roll20BallsCorrect() throws NotAllowedRoll
    {
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );

    }
	
	@Test
    public void roll17BallsIncorrect() throws NotAllowedRoll
    {
        assertTrue( score.addBall(new Ball("10")) );
        assertTrue( score.addBall(new Ball("7")) );
        assertTrue( score.addBall(new Ball("3")) );
        assertTrue( score.addBall(new Ball("9")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("10")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("6")) );
        assertTrue( score.addBall(new Ball("10")) );
        assertTrue( score.addBall(new Ball("10")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertFalse( score.addBall(new Ball("1")) );

    }
	
	@Test
    public void roll21BallsStrikeInLastFrame() throws NotAllowedRoll
    {
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("7")) );
        assertTrue( score.addBall(new Ball("3")) );
        assertTrue( score.addBall(new Ball("9")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("6")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("2")) );
        assertTrue( score.addBall(new Ball("3")) );
        assertTrue( score.addBall(new Ball("10")) );
        assertTrue( score.addBall(new Ball("8")) );
        assertTrue( score.addBall(new Ball("1")) );
        

    }
	
	@Test
    public void roll12Strikes() throws NotAllowedRoll
    {
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
        
    }
	
	@Test
    public void roll13StrikesFail() throws NotAllowedRoll
    {
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertFalse( score.addBall(new Ball("10")) );
        
    }
	
	@Test
    public void calculateScorePerfect() throws NotAllowedRoll
    {
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		assertTrue( score.addBall(new Ball("10")) );
		score.calculateScore();
		assertEquals(300,score.getGlobalScore());
        
    }
	
	@Test
    public void calculateScoreZero() throws NotAllowedRoll
    {
		assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
        assertTrue( score.addBall(new Ball("0")) );
		score.calculateScore();
		assertEquals(0,score.getGlobalScore());
        
    }
	
}
