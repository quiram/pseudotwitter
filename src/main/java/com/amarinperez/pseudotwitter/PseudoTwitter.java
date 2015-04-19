package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.Collection;

public class PseudoTwitter {

	private Collection<User> users = new ArrayList<User>();

	public void post(String username, String message) {
		User user = findUser(username);

		if (user == null) {
			user = new User(username);
			users.add(user);
		}

		user.post(message);
	}

	public String getTimeline(String username) {
		return findUser(username).toString();
	}

	protected User findUser(String username) {
		return users.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
	}

	public void follow(String follower, String followee) {
		findUser(follower).follows(findUser(followee));
	}

	public String wall(String username) {
		User user = findUser(username);
		Timeline wall = user.getTimeline();
		for (User followee : user.getFollowees()) {
			wall = wall.mergeWith(followee.getTimeline());
		}
		
		return wall.toString();
	}
}
