package com.amarinperez.pseudotwitter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalDateTime;

public class AgeCalculator {

	public String getAge(LocalDateTime timestamp1, LocalDateTime timestamp2) {
		long days = DAYS.between(timestamp1, timestamp2);
		if (days > 0)
			return "on " + ISO_LOCAL_DATE.format(timestamp1);

		long hours = HOURS.between(timestamp1, timestamp2);
		if (hours > 0)
			return hours + " hour(s) ago";

		long minutes = MINUTES.between(timestamp1, timestamp2);
		if (minutes > 0)
			return minutes + " minute(s) ago";

		long seconds = SECONDS.between(timestamp1, timestamp2);
		return seconds + " second(s) ago";
	}

}
