package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;


public class BowlingMatchIT {

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private BowlingMatch match;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@Before
    public void initMatch()
    {
        match = new BowlingMatch();
    }
	
	@Test
	public void play2Player() throws NumberFormatException, NotAllowedRoll {
		String gameInput = "src/main/resources/game2PlayerSample.txt";
		match.play(gameInput);
		match.printScores();
		String expectedResult="Frame		1		2		3		4		5		6		7		8		9		10\n" + 
				"Jeff\n" + 
				"Pinfalls		X	7	/	9	0		X	0	8	8	/	F	6		X		X	X	8	1	\n" + 
				"Score		20		39		48		66		74		84		90		120		148		167		\n" + 
				"John\n" + 
				"Pinfalls	3	/	6	3		X	8	1		X		X	9	0	7	/	4	4	X	9	0	\n" + 
				"Score		16		25		44		53		82		101		110		124		132		151		";
		assertEquals(expectedResult, outContent.toString());
		
		
	}
	
	@Test
	public void playPerfectScore() throws NumberFormatException, NotAllowedRoll {
		String gameInput = "src/main/resources/gamePerfectScore.txt";
		match.play(gameInput);
		match.printScores();
		String expectedResult="Frame		1		2		3		4		5		6		7		8		9		10\n" + 
				"Carl\n" + 
				"Pinfalls		X		X		X		X		X		X		X		X		X	X	X	X	\n" + 
				"Score		30		60		90		120		150		180		210		240		270		300		";
		assertEquals(expectedResult, outContent.toString());
		
		
	}
	
	@Test
	public void playZeroScore() throws NumberFormatException, NotAllowedRoll {
		String gameInput = "src/main/resources/gameZeroScore.txt";
		match.play(gameInput);
		match.printScores();
		String expectedResult="Frame		1		2		3		4		5		6		7		8		9		10\n" + 
				"Carl\n" + 
				"Pinfalls	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	\n" + 
				"Score		0		0		0		0		0		0		0		0		0		0		";
		assertEquals(expectedResult, outContent.toString());
		
		
	}
	
	@Test
	public void playFoulsScore() throws NumberFormatException, NotAllowedRoll {
		String gameInput = "src/main/resources/gameFouls.txt";
		match.play(gameInput);
		match.printScores();
		String expectedResult="Frame		1		2		3		4		5		6		7		8		9		10\n" + 
				"Carl\n" + 
				"Pinfalls	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	\n" + 
				"Score		0		0		0		0		0		0		0		0		0		0		";
		assertEquals(expectedResult, outContent.toString());
		
		
	}
	
	@Test(expected = NotAllowedRoll.class)
	public void playBadInput() throws NumberFormatException, NotAllowedRoll {
		String gameInput = "src/main/resources/gameBadInput.txt";
		match.play(gameInput);
		match.printScores();
		
	}
	
	
	
}
