package com.amarinperez.pseudotwitter;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	@Test
	public void getUsername() {
		final String username = "username";
		User user = new User(username);
		assertEquals(username, user.getUsername());
	}
}
