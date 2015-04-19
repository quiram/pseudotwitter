package com.amarinperez.pseudotwitter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class PostCommandTest {
	@Test
	public void postsTheExpectedMessage() {
		PseudoTwitter twitter = mock(PseudoTwitter.class);
		String username = "paco";
		String message = "this is the message";
		Command command = new PostCommand(twitter, username, message);
		String output = command.execute();
		assertEquals("", output);
		verify(twitter).post(username, message);
	}
}
