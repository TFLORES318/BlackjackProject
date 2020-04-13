package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackDealingApp {
	private Dealer d = new Dealer();
	private Player p = new Player();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackDealingApp blackjackApp = new BlackjackDealingApp();
		blackjackApp.runIntro();
		blackjackApp.playerMenu();
		blackjackApp.dealerMenu();
	}

	public void runIntro() {
		System.out.println("Welcome to Black Jack!\n");
		System.out.println("The dealer will now shuffle the cards...\n");
		d.dealerShuffleDeck();

		System.out.println("Your cards:");
		Card playerCard1 = d.dealCards();
		p.addCardToHand(playerCard1);
		Card playerCard2 = d.dealCards();
		p.addCardToHand(playerCard2);
		System.out.println(playerCard1 + " and " + playerCard2 + ".\n");

		System.out.println("Dealers cards:");
		Card dealerCard1 = d.dealCards();
		d.addCardToHand(dealerCard1);
		Card dealerCard2 = d.dealCards();
		d.addCardToHand(dealerCard2);
		System.out.println(dealerCard1 + " and FACE DOWN CARD.\n");

		checkBlackjackBeforeStarting(playerCard1, playerCard2);
		checkBlackjackBeforeStarting(dealerCard1, dealerCard2);
	}

	public void playerMenu() {
		System.out.println("Would you like to stay or hit?\n1.Stay \n2.Hit");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			System.out.println("This is your hand:\n" + p.getPlayerHand() + ". It is worth " + p.getPlayerHandValue()
					+ " points.");
			break;
		case 2:
			Card additionalPlayerCards = d.dealCards();
			p.addCardToHand(additionalPlayerCards);
			System.out.println("Your new card is " + additionalPlayerCards);
			if (p.getPlayerHandValue() > 21) {
				boolean playerBust = p.bustOccurred();
				if (playerBust == true) {
					System.out.println("Your hand is at " + p.getPlayerHandValue() + " points. You lose!");
					System.exit(0);
				}
			} else if (p.getPlayerHandValue() < 21) {
				System.out.println("Your hand is now worth " + p.getPlayerHandValue() + " points.");
				playerMenu();

			} else if (p.getPlayerHandValue() == 21) {
				System.out.println("Your hand is now worth 21 points! Perfect.");
			}

		}
	}

	public void dealerMenu() {
		System.out.println("It's the dealer's turn now. Their current hand is " + d.getDealerHand() + ".");

		while (d.getDealerHandValue() < 17) {
			Card additionalDealerCards = d.dealCards();
			d.addCardToHand(additionalDealerCards);
			System.out.println("The dealer deals " + additionalDealerCards + " and their hand is worth "
					+ d.getDealerHandValue() + " points.");
		}
		if (d.getDealerHandValue() > 21) {
			boolean dealerBust = d.bustOccurred();
			if (dealerBust == true) {
				System.out.println("Dealer loses! You win!");
			}
		} else if (d.getDealerHandValue() > p.getPlayerHandValue()) {
			System.out.println("Dealer wins!");
		} else if (d.getDealerHandValue() < p.getPlayerHandValue()) {
			System.out.println("You win!");
		} else if (d.getDealerHandValue() == p.getPlayerHandValue()) {
			System.out.println("It's a tie! No one wins.");
		}
	}

	public void checkBlackjackBeforeStarting(Card card1, Card card2) {
		boolean blackjackPlayer = p.blackjackMet(card1, card2);
		if (blackjackPlayer == true) {
			System.out.println("You have Blackjack! You automatically win.");
			System.exit(0);
		}
		boolean blackjackDealer = d.blackjackMet(card1, card2);
		if (blackjackDealer == true) {
			System.out.println("The dealer's hand is " +d.getDealerHand() + ". Dealer has met " + d.getDealerHandValue() + " points and has Blackjack. You lose!");
			System.exit(0);
		}
	}
}
