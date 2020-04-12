package com.skilldistillery.blackjack;

public class Dealer {

	private Deck deck = new Deck();
	private Hand dealerHand = new BlackjackHand();

	public Dealer() {

	} 

	public void dealerShuffleDeck() {
		deck.shuffle();

	} 

	public Card dealCards() {
		Card cardy = deck.dealCard();
		return cardy;

	}

	public void addCardToHand(Card cardy) {
		dealerHand.addCard(cardy);
	}
	
	public boolean blackjackMet(Card card1, Card card2) {
		int handValue = getDealerHandValue();
		return ((BlackjackHand) dealerHand).isBlackJack(handValue);
	}
	public boolean bustOccurred() {
		int handValue = getDealerHandValue();
		return ((BlackjackHand) dealerHand).isBust(handValue);
	}

	public int getDealerHandValue() {
		return dealerHand.getHandValue();
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
