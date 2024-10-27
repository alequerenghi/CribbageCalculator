package it.units.sdm.cribbage_calculator;

public class Hand {

	private final Card[] handCards = null;
	private final Card faceCard = null;

	public Hand(String hand) {
		// this.cards = parse(hand);
		// this.faceCard = new Card((int) Integer.valueOf(hand.charAt(hand.length() -
		// 2)), '0');
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
	/*
	 * public int runs() { int streak = 1; int[] faceVals = ranks();
	 * Arrays.sort(faceVals); for (int i = 1; i < 5; i++) { if (faceVals[i] ==
	 * faceVals[i - 1] + 1) { streak++; } else if (streak < 3) streak = 1; } return
	 * streak < 3 ? 0 : streak; }
	 * 
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
	public static void main(String[] args) {

		System.out.print("ciao".substring(1, 2));
	}

	public Card faceCard() {
		// TODO Auto-generated method stub
		return null;
	}
}
