package it.units.sdm.cribbage_calculator;

public class Card {

	private final Character suit;
	private final int rank;

	public Card(Character rank, Character suit) {
		this.rank = switch (rank) {
		case 'A' -> 1;
		case '0' -> 10;
		case 'J' -> 11;
		case 'Q' -> 12;
		case 'K' -> 13;
		default -> Character.getNumericValue(rank);
		};
		this.suit = suit;
	}

	public int rank() {
		return rank;
	}

	public Character suite() {
		return suit;
	}

}