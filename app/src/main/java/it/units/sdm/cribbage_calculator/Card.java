package it.units.sdm.cribbage_calculator;

public class Card {

	private final Character suit;
	private final Character rank;

	public Card(Character rank, Character suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Character rank() {
		return rank;
	}

	public Character suite() {
		return suit;
	}

	@Override
	public String toString() {
		return String.valueOf(rank()) + " " + String.valueOf(suite());
	}
}