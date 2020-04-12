package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackDealingApp {
	private Dealer d = new Dealer();
	private Player p = new Player();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackDealingApp blackjackApp = new BlackjackDealingApp();
		blackjackApp.run();
	}

	public void run() {
		System.out.println("----------------------");
		System.out.println("Welcome to Black Jack!");
		System.out.println("----------------------");
		System.out.println();
		System.out.println("The cards will now be shuffled");
		d.dealerShuffleDeck();
		System.out.println();
		System.out.println("Dealers cards:");
		Card dealerCard1 = d.dealCards();
		d.addCardToHand(dealerCard1);
		System.out.println("HIDDEN CARD");
		Card dealerCard2 = d.dealCards();
		d.addCardToHand(dealerCard2);
		System.out.println(dealerCard2);
		System.out.println();
		System.out.println("Your cards:");
		Card playerCard1 = d.dealCards();
		p.addCardToHand(playerCard1);
		System.out.println(playerCard1);
		Card playerCard2 = d.dealCards();
		p.addCardToHand(playerCard2);
		System.out.println(playerCard2);
		checkPlayerBlackjackBeforeStarting(playerCard1, playerCard2);
		checkDealerBlackjackBeforeStarting(dealerCard1, dealerCard2);
	// check for black jack before game starts from either player or dealer :o
	// blackjack be gettin detected weird - review
		
		System.out.println("-------------------------------------------------------");
		// if no black jack occurred.....
		playerMenu();
		dealerMenu(); 
	}

	public void checkPlayerBlackjackBeforeStarting(Card pCard1, Card pCard2) {
		boolean blackjackPlayer = p.blackjackMet(pCard1, pCard2);
		if (blackjackPlayer == true) {
			System.out.println("You have Blackjack! You win.");
			System.exit(0);
		}
		
	}

	public void checkDealerBlackjackBeforeStarting(Card dCard1, Card dCard2) {
		boolean blackjackDealer = d.blackjackMet(dCard1, dCard2);
		if (blackjackDealer == true) {
			System.out.println("Dealer's hand with the hidden card is " +d.getDealerHand());
			System.out.println("Dealer has Blackjack! You lose.");
			System.exit(0);
		}
		
	}
	
	public void playerMenu() {
		System.out.println("Would you like to stay or hit?");
		System.out.println("1. Stay");
		System.out.println("2. Hit");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			System.out.println("This is your hand:\n" + p.getPlayerHand());
			System.out.println("Your total value is\n" + p.getPlayerHandValue());
			break;
		case 2:
			Card additionalPlayerCards = d.dealCards();
			p.addCardToHand(additionalPlayerCards);
			System.out.println("Your new card is " + additionalPlayerCards);
			if (p.getPlayerHandValue() > 21) {
				boolean playerBust = p.bustOccurred();
				if (playerBust == true) {
					System.out.println("You lose!");
					System.exit(0);
				}
			} else if (p.getPlayerHandValue() < 21) {
				System.out.println("Your new hand value is "+p.getPlayerHandValue());
				playerMenu();

			}

		}
	}

	public void dealerMenu() {
		System.out.println("It's the dealer's turn now..");
		System.out.println(d.getDealerHand()); 

		while (d.getDealerHandValue() < 17) {
			Card additionalDealerCards = d.dealCards();
			d.addCardToHand(additionalDealerCards);
			System.out.println("The dealer deals " + additionalDealerCards);
			System.out.println("Dealer's hand is at " + d.getDealerHandValue());
		}
			if (d.getDealerHandValue() > 21) {
				boolean dealerBust = d.bustOccurred();
				if (dealerBust == true) {
					System.out.println("Dealer loses! You win!");
				}
			}

			else if (d.getDealerHandValue() > p.getPlayerHandValue()) {
					System.out.println("Dealer wins!");
				}
			else if (d.getDealerHandValue() < p.getPlayerHandValue()) {
					System.out.println("You win!");
				}
			else if (d.getDealerHandValue() == p.getPlayerHandValue()) {
					System.out.println("Push - no one wins.");
				}
			}
		}

