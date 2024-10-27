package it.units.sdm.cribbage_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParseCard {

	@Test
	void withSuitSpades() {
		CardParser cardParser = new CardParser();
		Card card = cardParser.parse("5♠︎");
		assertEquals("♠", card.getSuit());

	}

}
