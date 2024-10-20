package it.units.sdm.cribbage_calculator;

public class Card {

	private final Rank rank;
	private final Suit suit;

	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public String getRank() {
		return rank.getRank();
	}

	public String getSuit() {
		return suit.getSuit();
	}

	@Override
	public String toString() {
		return getRank() + getSuit();
	}

	public enum Rank {

		ACE("1"), DEUCE("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
		JACK("J"), QUEEN("Q"), KING("K");

		private final String rank;

		Rank(String rank) {
			this.rank = rank;
		}

		public String getRank() {
			return rank;
		}
	}

	public enum Suit {
		CLUBS("♣︎"), SPADES("♠︎"), HEARTS("♥︎"), DIAMONDS("♦︎");

		Suit(final String suit) {
			this.suit = suit;
		}

		private String suit;

		public String getSuit() {
			return suit;
		}
	}
}
