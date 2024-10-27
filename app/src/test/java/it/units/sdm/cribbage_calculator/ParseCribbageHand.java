package it.units.sdm.cribbage_calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParseCribbageHand {

	@Test
	void faceCardWithSuitDiamonds() {
		CribbageHandParser cribbageHandParser = new CribbageHandParser();
		Hand cribbageHand = cribbageHandParser.parse("5♥5♦5♠J♣5♦");
		assertAll(() -> assertEquals('♦', cribbageHand.faceCard().suite()),
				() -> assertEquals('5', cribbageHand.faceCard().rank()));
	}

}
