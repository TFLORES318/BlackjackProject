package com.skilldistillery.blackjack;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int currentCard = 0;
		int handValue = 0;
		for (int i = 0; i < cards.size(); i++) {
			currentCard = ((Card) cards.get(i)).getValue();
			handValue += currentCard;
		}
		return handValue;
	}

	public boolean isBlackJack(int handValue) {
		boolean blackJackMet = true;
		boolean blackJackNotMet = false;
		if (getHandValue() == 21) {
			return blackJackMet;
		}
	 else {
		return blackJackNotMet;
	}
}


	public boolean isBust(int handValue) {
		boolean bustGame = true;
		if (getHandValue() > 21) {
			System.out.println("BUST!");
		}
		return bustGame;
	}

}
