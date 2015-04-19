package com.amarinperez.pseudotwitter;

import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ReadCommandTest {
	@Test
	public void getsTheTimeline() {
		String username = "john";
		PseudoTwitter twitter = mock(PseudoTwitter.class);
		String expectedTimeline = "this is John's timeline";
		when(twitter.getTimeline(username)).thenReturn(expectedTimeline);
		ReadCommand command = new ReadCommand(twitter, username);

		String timeline = command.execute();
		assertEquals(expectedTimeline, timeline);
	}
}
