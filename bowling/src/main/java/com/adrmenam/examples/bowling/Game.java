package com.adrmenam.examples.bowling;

import com.adrmenam.examples.sharedMethods.NotAllowedRoll;

public interface Game {
	

	public void play(String gameFilePath) throws NotAllowedRoll,NumberFormatException;
	
	public void printScores();
}
