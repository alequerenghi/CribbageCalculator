package it.units.sdm.cribbage_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HandScore {

	CribbageHandParser parser = new CribbageHandParser();

	@Test

	void runsScoreIsFour() {
		Hand hand = parser.parse("0♦J♥Q♣A♣9♦");
		assertEquals(4, hand.runs());
	}

	@Test
	void runsScoreIsZero() {
		Hand hand = parser.parse("5♥5♦5♠J♣5♣");
		assertEquals(0, hand.runs());
	}

	@Test
	void flushScoreIsZero() {
		Hand hand = parser.parse("5♥5♦5♠J♣5♣");
		assertEquals(0, hand.flush());
	}

	@Test
	void flushScoreIsFour() {
		Hand hand = parser.parse("5♥5♥5♥J♥J♣");
		assertEquals(4, hand.flush());
	}

	@Test
	void flushScoreIsSix() {
		Hand hand = parser.parse("5♥5♥5♥J♥J♥");
		assertEquals(6, hand.flush());
	}

	@Test
	void fifteenTwosScoreIsZero() {
		Hand hand = parser.parse("0♦J♥Q♣A♣9♦");
		assertEquals(0, hand.fifteenTwos());
	}

	@Test
	void fifteenTwoScoreIsFourteen() {
		Hand hand = parser.parse("5♥5♥5♥J♥J♣");
		assertEquals(14, hand.fifteenTwos());
	}

}
