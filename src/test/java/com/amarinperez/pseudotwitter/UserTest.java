package com.amarinperez.pseudotwitter;

import static org.junit.Assert.*;
import java.util.Collection;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class UserTest {
	@Test
	public void getUsername() {
		final String username = "username";
		User user = new User(username);
		assertEquals(username, user.getUsername());
	}

	@Test
	public void newUserFollowsNobody() {
		User user = new User("Bob");
		Collection<User> followees = user.getFollowees();
		assertThat(followees, is(empty()));
	}
	
	@Test
	public void followUsers()
	{
		User bob = new User("Bob");
		User carmen = new User("Carmen");
		bob.follows(carmen);
		assertThat(bob.getFollowees(), contains(carmen));
	}
}
