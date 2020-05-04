package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.adrmenam.examples.sharedMethods.sharedMethods;

public class sharedMethodsTest {

	
	
	@Test
    public void searchPlayer()
    {
		ArrayList<Score> scores = new ArrayList<Score>();
		scores.add(new Score(new Player("Carl")));
		
        assertEquals(0, sharedMethods.getIndexByPlayerName(scores, "Carl"));
    }
	
	@Test
    public void searchPlayerFalse()
    {
		ArrayList<Score> scores = new ArrayList<Score>();
		scores.add(new Score(new Player("Carl")));
		
        assertEquals(-1, sharedMethods.getIndexByPlayerName(scores, "Jeff"));
    }
}
