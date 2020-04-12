package com.skilldistillery.blackjack;

public class Player {

	private Hand playerHand = new BlackjackHand();

	public Player() {
	}

	public void addCardToHand(Card cardy) {
		playerHand.addCard(cardy);
	}

	public int getPlayerHandValue() {
		return playerHand.getHandValue();
	}

	public boolean blackjackMet(Card card1, Card card2) {
		int handValue = getPlayerHandValue();
		return ((BlackjackHand) playerHand).isBlackJack(handValue);
	}

	public boolean bustOccurred() {
		int handValue = getPlayerHandValue();
		return ((BlackjackHand) playerHand).isBust(handValue);
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

}
