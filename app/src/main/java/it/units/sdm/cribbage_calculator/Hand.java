package it.units.sdm.cribbage_calculator;

import java.util.Arrays;
import java.util.List;

public class Hand {

	private final List<Card> handCards;
	private final Card faceCard;

	public Hand(List<Card> handCards, Card faceCard) {
		this.handCards = handCards;
		this.faceCard = faceCard;
	}

	public String score() {
		int total = 0;

		// total = fifteenTwos(0, 0, 0);

		// total += runs();

		// total += pairs();

		// total += flush();
		return String.valueOf(total);
	}

	/*
	 * public int fifteenTwos(int index, int currentSum, int totalPoints) { int[]
	 * faceVals = new int[5]; for (int i = 0; i < 5; i++) { faceVals[i] = switch
	 * (hand.charAt(i * 2)) { case 'Q', 'J', 'K', '0' -> 10; case 'A' -> 1; default
	 * -> Integer.valueOf(hand.charAt(i)); }; } for (int i = index; i < 5; i++) { if
	 * (currentSum + faceVals[i] < 15) return fifteenTwos(index + 1, faceVals[i] +
	 * currentSum, totalPoints); else if (currentSum + faceVals[i] == 15)
	 * totalPoints += 2; } return totalPoints; }
	 */

	public int runs() {
		int streak = 1;
		int[] faceVals = new int[handCards.size() + 1];
		for (int i = 0; i < faceVals.length - 1; i++) {
			faceVals[i] = handCards.get(i).rank();
		}
		faceVals[handCards.size()] = faceCard.rank();
		Arrays.sort(faceVals);
		for (int i = 1; i < 5; i++) {
			if (faceVals[i] == faceVals[i - 1] + 1) {
				streak++;
			} else if (faceVals[i] == faceVals[i - 1]) {
				continue;
			} else if (streak < 3)
				streak = 1;
			else {
				break;
			}
		}
		return streak < 3 ? 0 : streak;
	}
	/*
	 * public int pairs() { int streak = 1; int total = 0; int[] faceVals = ranks();
	 * Arrays.sort(faceVals); for (int i = 1; i < 5; i++) { if (faceVals[i] ==
	 * faceVals[i - 1]) streak++; else { total += switch (streak) { case 2 -> 2;
	 * case 3 -> 6; case 4 -> 12; default -> 0; }; streak = 1; } } return total; }
	 */

	/*
	 * public int flush() { for (int i = 1; i < cards.length - 1; i++) { if
	 * (cards[i].suite() != cards[i - 1].suite()) return 0; } if (cards[cards.length
	 * - 1].suite() == cards[cards.length - 2].suite()) return
	 * cards[cards.length].suite() == 'J' ? 6 : 5; return 4; }
	 * 
	 * public int[] ranks() { int[] ranks = new int[cards.length]; for (int i = 0; i
	 * < ranks.length; i++) { ranks[i] = cards[i].getRank(); } return ranks; }
	 */

	public Card faceCard() {
		return faceCard;
	}

	public List<Card> handCards() {
		return List.copyOf(handCards);
	}
}
