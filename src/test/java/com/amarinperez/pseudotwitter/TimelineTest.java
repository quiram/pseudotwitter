package com.amarinperez.pseudotwitter;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
	
	@Test
	public void mergeTimeline()
	{
		Timeline timeline1 = new Timeline();
		Timeline timeline2 = new Timeline();
		
		String message1 = "ABC";
		timeline1.add(message1);
		String message2 = "123";
		timeline2.add(message2);
		Timeline timeline3 = timeline1.mergeWith(timeline2);
		assertThat(timeline3.toString(), containsString(message1));
		assertThat(timeline3.toString(), containsString(message2));
	}
}
