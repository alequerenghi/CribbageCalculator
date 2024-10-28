package it.units.sdm.cribbage_calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

	private final List<Card> handCards;
	private final Card faceCard;

	public Hand(List<Card> handCards, Card faceCard) {
		this.handCards = handCards;
		this.faceCard = faceCard;
	}

	public String score() {

		// total = fifteenTwos(0, 0, 0);

		// total += runs();

		// total += pairs();

		// total += flush();
		return String.valueOf("");
	}

	public int fifteenTwos() {
		return fifteenTwosRec(0, 0);
	}

	private int fifteenTwosRec(int beginIndex, int currentSum) {
		int score = 0;
		for (int current = beginIndex; current < handCards.size() + 1; current++) {
			int valueToAdd = current < handCards.size() ? handCards.get(current).rank() : faceCard.rank();
			if (valueToAdd > 10) {
				valueToAdd = 10;
			}
			if (currentSum + valueToAdd < 15) {
				score += fifteenTwosRec(current + 1, currentSum + valueToAdd);
			} else if (currentSum + valueToAdd == 15) {
				score += 2;
			}
		}
		return score;
	}

	public int runs() {
		List<Integer> ranks = handCards.stream().map(i -> i.rank()).collect(Collectors.toList());
		ranks.add(faceCard.rank());
		Collections.sort(ranks);

		int streak = 1;
		int previous = ranks.get(0);

		for (int current : ranks) {
			if (current == previous + 1) {
				streak++;
			} else if (current == previous) {
				continue;
			} else if (streak < 3) {
				streak = 1;

			}
			previous = current;
		}
		return streak < 3 ? 0 : streak;
	}

	public int pairs() {
		int streak = 0;
		int total = 0;
		List<Integer> ranks = handCards.stream().map(i -> i.rank()).collect(Collectors.toList());
		ranks.add(faceCard.rank());
		Collections.sort(ranks);
		int previous = ranks.get(0);
		for (int current : ranks) {
			if (current == previous)
				streak++;
			else {
				previous = current;
				total += streak > 1 ? Hand.factorial(streak) : 0;
				streak = 1;
			}
		}
		return total + (streak > 1 ? Hand.factorial(streak) : 0);
	}

	public int flush() {
		char previous = handCards.get(0).suite();
		for (Card current : handCards) {
			if (previous != current.suite()) {
				return 0;
			} else {
				previous = current.suite();
			}
		}
		return previous == faceCard.suite() ? (faceCard.rank() == 11 ? 6 : 5) : 4;
	}

	private static int factorial(int value) {
		int out = 1;
		for (int i = value; i > 0; i--) {
			out *= i;
		}
		return out;
	}

	public Card faceCard() {
		return faceCard;
	}

	public List<Card> handCards() {
		return new ArrayList<Card>(handCards);
	}

}
