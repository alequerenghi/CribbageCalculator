package it.units.sdm.cribbage_calculator;

import java.util.Random;

import it.units.sdm.cribbage_calculator.Card.*;

public class Deck {

	private Card[] deck = new Card[52];
	private int currentCard = 0;

	public Deck() {

		Rank[] ranks = { Rank.ACE, Rank.DEUCE, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT,
				Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING };
		Suit[] suits = { Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES };
		for (int i = 0; i < 52; i++)
			deck[i] = new Card(suits[i % suits.length], ranks[i / suits.length]);
		shuffle();
	}
	
	

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < 52; i++) {
			int rand = random.nextInt();
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
	}

	public Card deal() {
		if (currentCard < 52)
			return deck[currentCard++];
		else {
			System.out.println("No more cards to deal");
			return null;
		}
	}
}
