package com.amarinperez.pseudotwitter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PostTest {
	private String username;
	private String message;
	private Post post;

	@Before
	public void setup()
	{
		username = "John";
		message = "message";
		post = new Post(username, message);
	}
	
	@Test
	public void getUsername() {
		assertEquals(username, post.getUsername());
	}
	
	@Test
	public void getMessage()
	{
		assertEquals(message, post.getMessage());
	}
	
	@Test
	public void getTimestamp()
	{
		Post post2 = new Post(username, message);
		assertThat(post.getTimestamp(), lessThan(post2.getTimestamp()));
	}
}
