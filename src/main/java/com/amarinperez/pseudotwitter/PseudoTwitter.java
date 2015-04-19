package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PseudoTwitter {
	private Collection<Post> posts = new ArrayList<Post>();
	private Map<String, Collection<String>> followees = new HashMap<String, Collection<String>>();

	public void post(String username, String message) {
		posts.add(new Post(username, message));
	}

	public String getTimeline(String username) {
		Predicate<Post> filterCriteria = p -> p.getUsername().equalsIgnoreCase(username);
		Function<Post, String> mapper = p -> p.getMessage() + " (" + p.getAge() + ")";
		String timeline = getTimelineForPostsMatching(filterCriteria, mapper);
		return timeline;
	}

	public void follow(String follower, String followee) {
		follower = follower.toLowerCase();
		followee = followee.toLowerCase();
		Collection<String> followeesByUser = followees.get(follower);
		if (followeesByUser == null) {
			followeesByUser = new ArrayList<String>();
			followees.put(follower, followeesByUser);
		}

		followeesByUser.add(followee);
	}

	public String wall(String username) {
		username = username.toLowerCase();
		Collection<String> usersToConsider = new ArrayList<String>();
		usersToConsider.add(username);
		Collection<String> followeesOfThisUser = followees.get(username);

		if (followeesOfThisUser != null) {
			usersToConsider.addAll(followeesOfThisUser);
		}

		Predicate<Post> filterCriteria = p -> usersToConsider.contains(p.getUsername().toLowerCase());
		Function<Post, String> mapper = p -> p.getUsername() + " - " + p.getMessage() + " (" + p.getAge() + ")";
		String wall = getTimelineForPostsMatching(filterCriteria, mapper);

		return wall;
	}

	private String getTimelineForPostsMatching(Predicate<Post> filterCriteria, Function<Post, String> mapper) {
		return posts.stream().filter(filterCriteria).map(mapper).reduce((a, b) -> a + System.lineSeparator() + b).get();
	}
}
