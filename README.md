## Blackjack - Week 4 Skill Distillery


### Overview (what the project is, how to do it, how to run it)
- This project allows the user to make play a game of Blackjack. The user will be the only player and the dealer is the computer.

- Blackjack is a popular casino game in which the player will aim to get as close to 21 points as possible through the values of cards per blackjack rules. The dealer will aim to get as close to 21 points too, with the exceptions that they must begin their turn after the player has decided to stop and once the dealer hits 17 points, they cannot deal anymore cards to their hand.

- To begin, the user will receive his starting hand from the dealer - 2 cards - both revealed in the application. The dealer will also deal his hand - one card revealed, the other not.

- Before beginning, both hands will be checked by the application to see if blackjack has been met for either one. If blackjack has been met for player, they win without continuing the game. If blackjack has been met by the dealer, the player loses. If blackjack has been met by both, no one wins. 

- If blackjack was not met for either the player or the dealer, the game will begin. The player will decide whether they want to hit (get another card dealt to them) or stay (keep their hand the way it is). The player can hit until they want to stay. If the player ends up getting more than 21 points during hitting, the player loses. If the player gets 21 points while hitting, the dealer will begin their turn.

- The dealer's face down card will be revealed at this time and the dealer will need to hit if they are under 17 points. If they are over 17 points, the dealer's hand cannot be changed and will be compared to the player's to see who is closer to 21. If the dealer gets over 21 points while under 17 points after hitting, the player wins. If the dealer and the player tie in points, no one wins. 

This program contains nine classes - the enum classes of Suit and Rank which hold the card "make-up." 

The card class uses the enum classes to make card objects. 

The deck class creates the deck of 52 cards through an array list and also holds deck capabilities, like shuffling, removing a card from the deck, checking the deck size, etc. 

The abstract hand class has it's own array list which contains the hand that the player and dealer are dealt. Cards are added to the hand. 

In the blackjack hand subclass, a hand's value can be obtained by using a for loop to go through the array list and getting the card's value. This class also determines if a hand has met blackjack and if a hand is bust.

The dealer class has an instance of the deck as well as a blackjack hand. The dealer has the deck in their possession throughout the game. They have access to shuffle the deck, deal cards and add cards to their hand as well as get their hand value in points. 

The player class has an instance of their own blackjack hand. The player can have cards added to their hand as well as get their hand value in points.

In the blackjack application, the game is actually played. There is an instance of the dealer and the player in this class. There is a scanner as well as the player is actually the user running the game. Once the player and dealer receives their initial hand, blackjack is checked through methods living in both the dealer and player classes. If this is passed, the player menu opens up in which the card value is checked as the player "hits." Three conditions are checked through if and else if statements, if a player is at 21 points, over 21 or under 21 (in which they can still hit).
The dealer does not have a choice and must hit until they reach 17 points. This is done automatically through a while loop and conditions are checked as cards are added through if and else if statements. Conditions checked are if dealer's points are over 21 in which a bust occurs, if the dealer has more points than player, if the dealer has less points than player and if they have equal points to the player.


### Technologies Used
- Eclipse
- Java
- Terminal Commands
- GitHub/Git 
- Youtube (https://www.youtube.com/watch?v=gjjVmPwThCE)
- Washington Post (https://games.washingtonpost.com/games/blackjack/)


### Lessons Learned
- This project helped increase my understanding in object oriented programming. The beginning struggle for me was to connect how all of these classes will interact with each other and how to pass information between classes. 
- Using enum classes - it is still a new concept that I will need to practice on but I can tell how it increases efficiency in programs.
- Using UML diagrams to build a program - I was able to take time on Friday to analyze the UML diagram and write a relationship link chart between the classes. I didn't have it completely right when confirming on Saturday but it was close.
- Conditionals practice - there were many in this program and I got some more practice using booleans. 
- I got more practice using everything learned throughout my four weeks at Skill Distillery - this program applied many concepts. 
- I learned how to play blackjack. Before starting this program, I have never played or known the rules so I took a lot of time to made sure I understood the game before starting my program. 
