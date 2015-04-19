package com.amarinperez.pseudotwitter;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PseudoTwitterTest {
	private PseudoTwitter twitter;

	@Before
	public void setup() {
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
	public void postFromBob() {
		String username = "Bob";
		String message = "Here I am too :-)";
		twitter.post(username, message);
		String timeline = twitter.getTimeline(username);
		assertThat(timeline, containsString(message));
	}

	@Test
	public void multiplePostsFromSameUser() {
		String username = "Charlie";
		String message1 = "My message";
		String message2 = "My other message";
		twitter.post(username, message1);
		twitter.post(username, message2);
		String timeline = twitter.getTimeline(username);
		assertThat(timeline, containsString(message1));
		assertThat(timeline, containsString(message2));
	}

	@Test
	public void usersAreNotCaseSensitive() {
		String expectedTimeline = "A message";
		twitter.post("Bob", expectedTimeline);
		String timeline = twitter.getTimeline("bob");
		assertEquals(expectedTimeline, timeline);
	}

	@Test
	public void wallIncludesActivityFromFollowees() {
		String john = "John";
		String johnMessage = "I am John";
		String charlie = "Charlie";
		String charlieMessage = "Charlie reporting for duty.";
		twitter.post(john, johnMessage);
		twitter.post(charlie, charlieMessage);
		twitter.follow(john, charlie);
		String wall = twitter.wall(john);
		assertThat(wall, containsString(johnMessage));
		assertThat(wall, containsString(charlieMessage));
	}
}
