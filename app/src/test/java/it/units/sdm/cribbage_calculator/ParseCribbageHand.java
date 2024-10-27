package it.units.sdm.cribbage_calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParseCribbageHand {
	CribbageHandParser cribbageHandParser = new CribbageHandParser();

	@Test
	void faceCardWithSuitDiamonds() {
		Hand cribbageHand = cribbageHandParser.parse("5♥5♦5♠J♣5♦");
		assertAll(() -> assertEquals('♦', cribbageHand.faceCard().suite()),
				() -> assertEquals(5, cribbageHand.faceCard().rank()));
	}

	@Test
	void thirdHandCard() {
		Hand cribbageHand = cribbageHandParser.parse("5♥5♦5♠J♣5♦");
		assertAll(() -> assertEquals(5, cribbageHand.handCards().get(2).rank()),
				() -> assertEquals('♠', cribbageHand.handCards().get(2).suite()));
	}

}
