package com.amarinperez.pseudotwitter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

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
