package com.amarinperez.pseudotwitter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PseudoTwitterTest {
	private PseudoTwitter twitter;

	@Before
	public void setup()
	{
		twitter = new PseudoTwitter();
	}
	
	@Test
	public void postFromAlice() {
		String message = "Hello World!";
		String username = "Alice";
		twitter.post(username, message);
		String timeline = twitter.getTimeline(username);
		assertThat(timeline, containsString(message));
	}
	
	@Test
	public void postFromBob()
	{
		String username = "Bob";
		String message = "Here I am too :-)";
		twitter.post(username, message);
		String timeline = twitter.getTimeline(username);
		assertThat(timeline, containsString(message));
	}

	@Test
	public void multiplePostsFromSameUser()
	{
		String username = "Charlie";
		String message1 = "My message";
		String message2 = "My other message";
		twitter.post(username, message1);
		twitter.post(username, message2);
		String timeline = twitter.getTimeline(username);
		assertThat(timeline, containsString(message1));
		assertThat(timeline, containsString(message2));
	}
}
