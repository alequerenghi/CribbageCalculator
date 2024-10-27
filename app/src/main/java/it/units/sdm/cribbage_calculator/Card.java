package it.units.sdm.cribbage_calculator;

public class Card {

	private final Character suit;
	private final int rank;

	public Card(int rank, Character suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public Character suite() {
		return suit;
	}

	@Override
	public String toString() {
		return String.valueOf(getRank()) + " " + String.valueOf(suite());
	}

	public enum Rank {

		ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
		KING(13);

		Rank(int rank) {
			this.rank = rank;
		}

		private final int rank;

		public int getRank() {
			return rank;
		}
	}

	public enum Suit {
		CLUBS('♣'), SPADES('♠'), HEARTS('♥'), DIAMONDS('♦');

		Suit(final char suit) {
			this.suit = suit;
		}

		private char suit;

		public char getSuit() {
			return suit;
		}
	}
}
