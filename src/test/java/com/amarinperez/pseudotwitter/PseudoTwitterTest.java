package com.amarinperez.pseudotwitter;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		assertThat(timeline, containsString("ago"));
	}

	@Test
	public void usersAreNotCaseSensitive() {
		String message = "A message";
		twitter.post("Bob", message);
		String timeline = twitter.getTimeline("bob");
		assertThat(timeline, containsString(message));
	}

	@Test
	public void wallIncludesActivityFromFollowees() throws InterruptedException {
		String john = "John";
		String johnMessage = "I am a guy";
		String charlie = "Charlie";
		String charlieMessage = "Charlie reporting for duty.";
		twitter.post(charlie, charlieMessage);
		TimeUnit.MILLISECONDS.sleep(1); // Need to add a slight delay between posts to allow ordering
		twitter.post(john, johnMessage);
		twitter.follow(john, charlie);
		String wall = twitter.wall(john);
		List<String> expectedMessages = Arrays.asList(new String[] {johnMessage, charlieMessage} );
		assertThat(wall, stringContainsInOrder(expectedMessages));
		assertThat(wall, containsString(john));
		assertThat(wall, containsString(charlieMessage));
		assertThat(wall, containsString("ago"));
	}
	
	@Test
	public void wallWithoutFollowees()
	{
		String john = "John";
		String johnMessage = "I am a guy";
		twitter.post(john, johnMessage);
		String wall = twitter.wall(john);
		assertThat(wall, containsString(johnMessage));
	}
}
