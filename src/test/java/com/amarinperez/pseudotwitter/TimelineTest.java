package com.amarinperez.pseudotwitter;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TimelineTest {
	@Test
	public void timelinePrintsNewestMessageFirst() {
		Timeline timeline = new Timeline();
		String message1 = "ABC";
		String message2 = "123";

		timeline.add(message1);
		timeline.add(message2);

		List<String> expectedListOfMessages = Arrays.asList(new String[] { message2, message1 });

		assertThat(timeline.toString(), stringContainsInOrder(expectedListOfMessages));
	}
}
