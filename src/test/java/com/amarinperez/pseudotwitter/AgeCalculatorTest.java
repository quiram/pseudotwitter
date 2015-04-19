package com.amarinperez.pseudotwitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class AgeCalculatorTest {
	private AgeCalculator calc;
	private LocalDateTime timestamp1;

	@Before
	public void setup() {
		calc = new AgeCalculator();
		timestamp1 = LocalDateTime.of(2015, 10, 10, 10, 5, 10);
	}

	@Test
	public void secondsOld() {
		LocalDateTime timestamp2 = LocalDateTime.of(2015, 10, 10, 10, 5, 15);
		String age = calc.getAge(timestamp1, timestamp2);
		assertEquals("5 second(s) ago", age);
	}

	@Test
	public void minutesOld() {
		LocalDateTime timestamp2 = LocalDateTime.of(2015, 10, 10, 10, 7, 15);
		String age = calc.getAge(timestamp1, timestamp2);
		assertEquals("2 minute(s) ago", age);
	}

	@Test
	public void hoursOld() {
		LocalDateTime timestamp2 = LocalDateTime.of(2015, 10, 10, 12, 7, 15);
		String age = calc.getAge(timestamp1, timestamp2);
		assertEquals("2 hour(s) ago", age);
	}

	@Test
	public void daysOld() {
		LocalDateTime timestamp2 = LocalDateTime.of(2015, 10, 20, 12, 7, 15);
		String age = calc.getAge(timestamp1, timestamp2);
		assertEquals("on 2015-10-10", age);
	}
}
