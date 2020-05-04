package com.adrmenam.examples.bowling;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

	private Player player;
	
	@Test
	public void createAnonymousPlayer() {
		player = new Player();
		assertTrue(player.getName().equals(""));
	}
	
	@Test
	public void createNamedPlayer() {
		player = new Player("Carl");
		assertTrue(player.getName().equals("Carl"));
	}
}
