package com.adrmenam.examples.sharedMethods;

import java.util.List;
import java.util.stream.IntStream;

import com.adrmenam.examples.bowling.Score;

public class sharedMethods {
	
	public static int getIndexByPlayerName(final List<Score> list, final String name) {
		
		return IntStream.range(0, list.size())
		     .filter(i -> list.get(i).getPlayer().getName().equals(name))
		     .findFirst()
		     .orElse(-1);
		     
	}
}
