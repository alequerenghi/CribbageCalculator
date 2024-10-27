package it.units.sdm.cribbage_calculator;

import java.util.ArrayList;
import java.util.List;

public class CribbageHandParser {

	public CribbageHandParser() {

	}

	public Hand parse(String string) {
		CardParser cardParser = new CardParser();
		List<Card> handCards = new ArrayList<Card>(4);
		for (int card = 0; card < 8; card += 2) {
			handCards.add(cardParser.parse(string.substring(card, card + 2)));
		}
		return new Hand(handCards, cardParser.parse(string.substring(8, 10)));
	}

}
