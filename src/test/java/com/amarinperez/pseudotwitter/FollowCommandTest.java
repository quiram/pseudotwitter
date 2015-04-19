package com.amarinperez.pseudotwitter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class FollowCommandTest {
	@Test
	public void userFollowsAnotherUser() {
		PseudoTwitter twitter = mock(PseudoTwitter.class);
		String username1 = "paco";
		String username2 = "john";
		Command command = new FollowComand(twitter, username1, username2);
		String output = command.execute();
		assertEquals("following!", output);
		verify(twitter).follow(username1, username2);
	}
}
