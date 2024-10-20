package it.units.sdm.cribbage_calculator;

public class Hand {

	private Deck deck;
	private char[] cards;

	public Hand() {
		String hand = "";
		deck = new Deck();
		for (int i = 0; i < 5; i++) {
			hand.concat(deck.deal().toString());
		}
		this.cards = hand.toCharArray();
	}

	public int calculatePoints() {
		int total = 0;

		total = twoFifteens(0, 0, 0);

		total += runs();

		total += pairs();

		return total + flush();
	}

	public int twoFifteens(int index, int currentSum, int totalPoints) {
		int[] faceVals = new int[5];
		for (int i = 0; i < 5; i++) {
			if (cards[i * 2] == 'J' || cards[i * 2] == 'Q' || cards[i * 2] == 'K')
				faceVals[i] = 10;
			else
				faceVals[i] = Character.getNumericValue(cards[i * 2]);
		}
		for (int i = index; i < 5; i++) {
			if (currentSum + faceVals[i] < 15)
				return twoFifteens(index + 1, faceVals[i] + currentSum, totalPoints);
			else if (currentSum + faceVals[i] == 15)
				totalPoints += 2;
		}
		return totalPoints;
	}

	public int runs() {
		int streak = 1;
		int[] faceVals = new int[5];
		for (int i = 0; i < 5; i++) {
			faceVals[i] = switch (cards[i * 2]) {
			case 'J' -> 11;
			case 'Q' -> 12;
			case 'K' -> 13;
			default -> Character.getNumericValue(cards[i * 2]);
			};
		}
		for (int i = 1; i < 5; i++) {
			if (faceVals[i] == faceVals[i - 1] + 1) {
				streak++;
			} else if (streak < 3)
				streak = 1;
		}
		return streak < 3 ? 0 : streak;
	}

	public int pairs() {
		int streak = 1;
		int total = 0;
		int[] faceVals = new int[5];
		for (int i = 0; i < 5; i++) {
			faceVals[i] = switch (cards[i * 2]) {
			case 'J' -> 11;
			case 'Q' -> 12;
			case 'K' -> 13;
			default -> Character.getNumericValue(cards[i * 2]);
			};
		}
		for (int i = 1; i < 5; i++) {
			if (faceVals[i] == faceVals[i - 1])
				streak++;
			else {
				total += switch (streak) {
				case 2 -> 2;
				case 3 -> 6;
				case 4 -> 12;
				default -> 0;
				};
				streak = 1;
			}
		}
		return total;
	}

	public int flush() {
		for (int i = 1; i < 5; i++) {
			if (cards[i * 2 + 1] != cards[i * 2 - 1])
				return 0;
		}
		if (cards[9] == cards[7])
			return cards[8] == 'J' ? 6 : 5;
		return 4;
	}

	public static void main(String[] args) {

		System.out.print("ciao".substring(1, 2));
	}
}
