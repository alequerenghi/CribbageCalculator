package it.units.sdm.cribbage_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParseCard {
	private final CardParser cardParser = new CardParser();

	@Test
	void withSuitSpades() {
		Card card = cardParser.parse("5♠");
		assertEquals('♠', card.suite());

	}

	@Test
	void withSuitHearts() {
		Card card = cardParser.parse("5♥");
		assertEquals('♥', card.suite());

	}

	@Test
	void withSuitClubs() {
		Card card = cardParser.parse("5♣︎︎");
		assertEquals('♣', card.suite());

	}

	@Test
	void withSuitDiamonds() {
		Card card = cardParser.parse("5♦");
		assertEquals('♦', card.suite());

	}
}
