package com.amarinperez.pseudotwitter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

public class CommandInterpreterTest {
	private PseudoTwitter twitter;
	private CommandInterpreter interpreter;

	@Before
	public void setup()
	{
		twitter = mock(PseudoTwitter.class);
		interpreter = new CommandInterpreter(twitter);
	}
	
	@Test
	public void produceReadCommand() {
		String line = "John";
		String expectedTimeline = "timeline";
		
		when(twitter.getTimeline(line)).thenReturn(expectedTimeline);
		
		Command command = interpreter.interpret(line);
		assertThat(command, instanceOf(ReadCommand.class));
		assertEquals(expectedTimeline, command.execute());
	}
	
	@Test
	public void producePostCommand()
	{
		final String username = "Bob";
		final String message = "A new message from Bob.";
		String line = username + " -> " + message;
		
		Command command = interpreter.interpret(line);
		assertThat(command, instanceOf(PostCommand.class));

		command.execute();
		verify(twitter).post(username, message);
	}
	
	@Test
	public void produceFollowCommand()
	{
		String follower = "Bob";
		String followee = "Mike";
		String line = follower + " follows " + followee;
		Command command = interpreter.interpret(line);
		assertThat(command, instanceOf(FollowComand.class));
		command.execute();
		verify(twitter).follow(follower, followee);
	}
	
	@Test
	public void produceWallCommand()
	{
		String username = "Carl";
		String line = username + " wall";
		Command command = interpreter.interpret(line);
		assertThat(command, instanceOf(WallComand.class));
		command.execute();
		verify(twitter).wall(username);
	}
}
