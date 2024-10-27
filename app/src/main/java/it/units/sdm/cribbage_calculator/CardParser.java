package it.units.sdm.cribbage_calculator;

public class CardParser {

	public Card parse(String card) {
		return new Card(card.charAt(0), card.charAt(1));
	}
}
