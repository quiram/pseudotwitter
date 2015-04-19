package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Timeline {

	ArrayList<String> messages = new ArrayList<String>();
	
	public void add(String message) {
		messages.add(message);
	}
	
	public String toString()
	{
		@SuppressWarnings("unchecked")
		List<String> messagesInReverse = (List<String>) messages.clone();
		Collections.reverse(messagesInReverse);
		return String.join(System.lineSeparator(), messagesInReverse.toArray(new String[0]));
	}
}
