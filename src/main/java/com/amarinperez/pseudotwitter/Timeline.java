package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Timeline {

	ArrayList<Post> messages = new ArrayList<Post>();

	public void add(String message) {
		messages.add(new Post(message));
	}

	public String toString() {
		@SuppressWarnings("unchecked")
		List<Post> messagesInReverse = (List<Post>) messages.clone();
		Collections.reverse(messagesInReverse);
		String timeline = messagesInReverse.stream().map(Post::toString)
				.reduce((a, b) -> a + System.lineSeparator() + b).get();

		return timeline;
	}

	@SuppressWarnings("unchecked")
	public Timeline mergeWith(Timeline timeline2) {
		Timeline result = new Timeline();
		result.messages = (ArrayList<Post>) this.messages.clone();
		result.messages.addAll(timeline2.messages);
		return result;
	}
}
