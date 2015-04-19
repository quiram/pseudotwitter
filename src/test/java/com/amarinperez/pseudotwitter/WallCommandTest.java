package com.amarinperez.pseudotwitter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class WallCommandTest {
	@Test
	public void wallIsInvoked() {
		String username = "paco";
		PseudoTwitter twitter = mock(PseudoTwitter.class);
		String wall = "Paco's wall";
		when(twitter.wall(username)).thenReturn(wall);
		Command command = new WallComand(twitter, username);
		String output = command.execute();
		assertEquals(wall, output);
	}
}
