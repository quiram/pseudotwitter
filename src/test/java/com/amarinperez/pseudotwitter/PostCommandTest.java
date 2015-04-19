package com.amarinperez.pseudotwitter;

import static org.mockito.Mockito.*;

import org.junit.Test;

import static org.junit.Assert.*;

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
