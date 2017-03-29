import java.util.*;

public class Blackjack {
  public static void main(String [] args) {
    // outputs number of rounds and decks being used
    System.out.println("Starting Blackjack with " + args[0] + " rounds and " +
                        args[1] + " decks in the shoe.\n");
    // grabs the int value of String
    int numRounds = Integer.parseInt(args[0]);
    int numDecks = Integer.parseInt(args[1]);

    // number sizes shoe appropriately
    int numOverall = 52 * numDecks;
    // Instance Objects
    RandIndexQueue<Card> shoe = new RandIndexQueue<Card>(numOverall);
    RandIndexQueue<Card> discard = new RandIndexQueue<Card>(numOverall);
    RandIndexQueue<Card> playerHand = new RandIndexQueue<Card>(10);
    RandIndexQueue<Card> dealerHand = new RandIndexQueue<Card>(10);
    // Instance Variables
    int MAX_POINTS_BEFORE_STAY = 17;
    int BLACK_JACK = 21;
    int playerSum = 0;
    int dealerSum = 0;
    int playerWins = 0;
    int dealerWins = 0;
    int pushCount = 0;
    int noWinCount = 0;
    int quartShoeVal = numOverall/4;

    // populates the shoe
    for (int i = 0; i < numDecks; i++) {
      Card c1 = new Card(Card.Suits.Diamonds, Card.Ranks.Ace);
      Card c2 = new Card(Card.Suits.Diamonds, Card.Ranks.Two);
      Card c3 = new Card(Card.Suits.Diamonds, Card.Ranks.Three);
      Card c4 = new Card(Card.Suits.Diamonds, Card.Ranks.Four);
      Card c5 = new Card(Card.Suits.Diamonds, Card.Ranks.Five);
      Card c6 = new Card(Card.Suits.Diamonds, Card.Ranks.Six);
      Card c7 = new Card(Card.Suits.Diamonds, Card.Ranks.Seven);
      Card c8 = new Card(Card.Suits.Diamonds, Card.Ranks.Eight);
      Card c9 = new Card(Card.Suits.Diamonds, Card.Ranks.Nine);
      Card c10 = new Card(Card.Suits.Diamonds, Card.Ranks.Ten);
      Card c11 = new Card(Card.Suits.Diamonds, Card.Ranks.Jack);
      Card c12 = new Card(Card.Suits.Diamonds, Card.Ranks.Queen);
      Card c13 = new Card(Card.Suits.Diamonds, Card.Ranks.King);
      Card c14 = new Card(Card.Suits.Hearts, Card.Ranks.Ace);
      Card c15 = new Card(Card.Suits.Hearts, Card.Ranks.Two);
      Card c16 = new Card(Card.Suits.Hearts, Card.Ranks.Three);
      Card c17 = new Card(Card.Suits.Hearts, Card.Ranks.Four);
      Card c18 = new Card(Card.Suits.Hearts, Card.Ranks.Five);
      Card c19 = new Card(Card.Suits.Hearts, Card.Ranks.Six);
      Card c20 = new Card(Card.Suits.Hearts, Card.Ranks.Seven);
      Card c21 = new Card(Card.Suits.Hearts, Card.Ranks.Eight);
      Card c22 = new Card(Card.Suits.Hearts, Card.Ranks.Nine);
      Card c23 = new Card(Card.Suits.Hearts, Card.Ranks.Ten);
      Card c24 = new Card(Card.Suits.Hearts, Card.Ranks.Jack);
      Card c25 = new Card(Card.Suits.Hearts, Card.Ranks.Queen);
      Card c26 = new Card(Card.Suits.Hearts, Card.Ranks.King);
      Card c27 = new Card(Card.Suits.Clubs, Card.Ranks.Ace);
      Card c28 = new Card(Card.Suits.Clubs, Card.Ranks.Two);
      Card c29 = new Card(Card.Suits.Clubs, Card.Ranks.Three);
      Card c30 = new Card(Card.Suits.Clubs, Card.Ranks.Four);
      Card c31 = new Card(Card.Suits.Clubs, Card.Ranks.Five);
      Card c32 = new Card(Card.Suits.Clubs, Card.Ranks.Six);
      Card c33 = new Card(Card.Suits.Clubs, Card.Ranks.Seven);
      Card c34 = new Card(Card.Suits.Clubs, Card.Ranks.Eight);
      Card c35 = new Card(Card.Suits.Clubs, Card.Ranks.Nine);
      Card c36 = new Card(Card.Suits.Clubs, Card.Ranks.Ten);
      Card c37 = new Card(Card.Suits.Clubs, Card.Ranks.Jack);
      Card c38 = new Card(Card.Suits.Clubs, Card.Ranks.Queen);
      Card c39 = new Card(Card.Suits.Clubs, Card.Ranks.King);
      Card c40 = new Card(Card.Suits.Spades, Card.Ranks.Ace);
      Card c41 = new Card(Card.Suits.Spades, Card.Ranks.Two);
      Card c42 = new Card(Card.Suits.Spades, Card.Ranks.Three);
      Card c43 = new Card(Card.Suits.Spades, Card.Ranks.Four);
      Card c44 = new Card(Card.Suits.Spades, Card.Ranks.Five);
      Card c45 = new Card(Card.Suits.Spades, Card.Ranks.Six);
      Card c46 = new Card(Card.Suits.Spades, Card.Ranks.Seven);
      Card c47 = new Card(Card.Suits.Spades, Card.Ranks.Eight);
      Card c48 = new Card(Card.Suits.Spades, Card.Ranks.Nine);
      Card c49 = new Card(Card.Suits.Spades, Card.Ranks.Ten);
      Card c50 = new Card(Card.Suits.Spades, Card.Ranks.Jack);
      Card c51 = new Card(Card.Suits.Spades, Card.Ranks.Queen);
      Card c52 = new Card(Card.Suits.Spades, Card.Ranks.King);
      // populates the deck
      shoe.addItem(c1);
      shoe.addItem(c2);
      shoe.addItem(c3);
      shoe.addItem(c4);
      shoe.addItem(c5);
      shoe.addItem(c6);
      shoe.addItem(c7);
      shoe.addItem(c8);
      shoe.addItem(c9);
      shoe.addItem(c10);
      shoe.addItem(c11);
      shoe.addItem(c12);
      shoe.addItem(c13);
      shoe.addItem(c14);
      shoe.addItem(c15);
      shoe.addItem(c16);
      shoe.addItem(c17);
      shoe.addItem(c18);
      shoe.addItem(c19);
      shoe.addItem(c20);
      shoe.addItem(c21);
      shoe.addItem(c22);
      shoe.addItem(c23);
      shoe.addItem(c24);
      shoe.addItem(c25);
      shoe.addItem(c26);
      shoe.addItem(c27);
      shoe.addItem(c28);
      shoe.addItem(c29);
      shoe.addItem(c30);
      shoe.addItem(c31);
      shoe.addItem(c32);
      shoe.addItem(c33);
      shoe.addItem(c34);
      shoe.addItem(c35);
      shoe.addItem(c36);
      shoe.addItem(c37);
      shoe.addItem(c38);
      shoe.addItem(c39);
      shoe.addItem(c40);
      shoe.addItem(c41);
      shoe.addItem(c42);
      shoe.addItem(c43);
      shoe.addItem(c44);
      shoe.addItem(c45);
      shoe.addItem(c46);
      shoe.addItem(c47);
      shoe.addItem(c48);
      shoe.addItem(c49);
      shoe.addItem(c50);
      shoe.addItem(c51);
      shoe.addItem(c52);
    } // end for

    // shuffles all the decks
    shoe.shuffle();

    if (numRounds <= 10) {
      for (int i = 0; i < numRounds; i++) {
        // moves cards back in shoe if its 1/4 empty and reshuffles
        if (shoe.size() < quartShoeVal) {
          while (discard.size() > 0) {
            shoe.addItem(discard.removeItem());
          } // end while
          shoe.shuffle();
          System.out.println("Reshuffling the shoe before round " + i + " begins...\n");
        }

        System.out.println("Round " + i + " beginning...");
        // Initial card deal. Each player gets two cards.
        for (int m = 0; m < 2; m++) {
          playerHand.addItem(shoe.removeItem());
          dealerHand.addItem(shoe.removeItem());
        } // end for
        printCardHand(playerHand, "Player");
        printCardHand(dealerHand, "Dealer");
        playerSum = calculateCardHandSum(playerHand);
        dealerSum = calculateCardHandSum(dealerHand);

        // hits if sum is less than 17 and determines if players bust or stand
        while (playerSum < MAX_POINTS_BEFORE_STAY) {
          Card temp = (Card)shoe.removeItem();
          playerHand.addItem(temp);
          System.out.println("Player hits: " + temp.toString());
          playerSum = calculateCardHandSum(playerHand);
        } // end while
        if (playerSum <= BLACK_JACK) {
          printCardHand(playerHand, "Player STANDS");
        } else {
          printCardHand(playerHand, "Player BUSTS");
        }
        while (dealerSum < MAX_POINTS_BEFORE_STAY) {
          Card temp = (Card)shoe.removeItem();
          dealerHand.addItem(shoe.removeItem());
          System.out.println("Dealer hits: " + temp.toString());
          dealerSum = calculateCardHandSum(dealerHand);
        } // end while
        if(dealerSum <= BLACK_JACK) {
          printCardHand(dealerHand, "Dealer STANDS");
        } else {
          printCardHand(dealerHand, "Dealer BUSTS");
        }

        // Displays result of the round
        if (dealerSum == playerSum) {
          System.out.println("Result: Push!");
          pushCount++;
        } else if (playerSum < BLACK_JACK && dealerSum < BLACK_JACK && dealerSum > playerSum) {
          System.out.println("Result: Dealer Wins!");
          dealerWins++;
        } else if (playerSum > BLACK_JACK && dealerSum < BLACK_JACK) {
          System.out.println("Result: Dealer Wins!");
          dealerWins++;
        } else if (dealerSum == BLACK_JACK && dealerSum != playerSum) {
          System.out.println("Result: Dealer Blackjack wins!");
          dealerWins++;
        } else if (dealerSum < BLACK_JACK && playerSum < BLACK_JACK && playerSum > dealerSum) {
          System.out.println("Result: Player Wins!");
          playerWins++;
        } else if (dealerSum > BLACK_JACK && playerSum < BLACK_JACK){
          System.out.println("Result: Player Wins!");
          playerWins++;
        } else if (playerSum == BLACK_JACK && playerSum != dealerSum) {
          System.out.println("Result: Player Blackjack wins!");
          playerWins++;
        } else {
          System.out.println("Result: NO WINNER.");
          noWinCount++;
        }

        // adds cards played this round to discard pile
        while (playerHand.size() > 0) {
            discard.addItem(playerHand.removeItem());
        } // end while
        while(dealerHand.size() > 0) {
            discard.addItem(dealerHand.removeItem());
        } // end while
        System.out.println();
      } // end for

      // Displays result of the game
      System.out.println("After " + numRounds + " rounds, here are the results:");
      System.out.println("\tDealer Wins: " + dealerWins);
      System.out.println("\tPlayer Wins: " + playerWins);
      System.out.println("\tPushes: " + pushCount);
      System.out.println("\tRounds with NO WINNER: " + noWinCount);

    } else {
      for (int i = 0; i < numRounds; i++) {
        // moves cards back in shoe if its 1/4 empty and reshuffles
        if (shoe.size() < quartShoeVal) {
          while (discard.size() > 0) {
            shoe.addItem(discard.removeItem());
          } // end while
          shoe.shuffle();
          System.out.println("Reshuffling the shoe in round " + i);
        }

        // Initial card deal. Each player gets two cards.
        for (int m = 0; m < 2; m++) {
          playerHand.addItem(shoe.removeItem());
          dealerHand.addItem(shoe.removeItem());
        } // end for
        playerSum = calculateCardHandSum(playerHand);
        dealerSum = calculateCardHandSum(dealerHand);

        // hits if sum is less than 17 and determines if players bust or stand
        while (playerSum < MAX_POINTS_BEFORE_STAY) {
          Card temp = (Card)shoe.removeItem();
          playerHand.addItem(temp);
          playerSum = calculateCardHandSum(playerHand);
        } // end while
        while (dealerSum < MAX_POINTS_BEFORE_STAY) {
          Card temp = (Card)shoe.removeItem();
          dealerHand.addItem(shoe.removeItem());
          dealerSum = calculateCardHandSum(dealerHand);
        } // end while

        // Counts wins for each player
        if (dealerSum == playerSum) {
          pushCount++;
        } else if (playerSum < BLACK_JACK && dealerSum < BLACK_JACK && dealerSum > playerSum) {
          dealerWins++;
        } else if (playerSum > BLACK_JACK && dealerSum < BLACK_JACK) {
          dealerWins++;
        } else if (dealerSum == BLACK_JACK && dealerSum != playerSum) {
          dealerWins++;
        } else if (dealerSum < BLACK_JACK && playerSum < BLACK_JACK && playerSum > dealerSum) {
          playerWins++;
        } else if (dealerSum > BLACK_JACK && playerSum < BLACK_JACK){
          playerWins++;
        } else if (playerSum == BLACK_JACK && playerSum != dealerSum) {
          playerWins++;
        } else {
          noWinCount++;
        }

        // adds cards played this round to discard pile
        while (playerHand.size() > 0) {
          discard.addItem(playerHand.removeItem());
        } // end while
        while(dealerHand.size() > 0) {
          discard.addItem(dealerHand.removeItem());
        } // end while
          System.out.println();
      } // end for
      // Displays result of the game
      System.out.println("After " + numRounds + " rounds, here are the results:");
      System.out.println("\tDealer Wins: " + dealerWins);
      System.out.println("\tPlayer Wins: " + playerWins);
      System.out.println("\tPushes: " + pushCount);
      System.out.println("\tRounds with NO WINNER: " + noWinCount);
    }
  } // end main

  // prints the players cards
  public static void printCardHand(RandIndexQueue<Card> listOfCards, String playerName) {
    String printToBuffer = playerName + ": ";
    for(int i = 0; i < listOfCards.size(); i++) {
      printToBuffer += listOfCards.get(i).toString();
      if(i != listOfCards.size() -1) {
        printToBuffer += ", ";
      } else {
        printToBuffer += ": ";
      }
    } // end for
    printToBuffer += calculateCardHandSum(listOfCards);
    System.out.println(printToBuffer);
  } // end printCardHand()

  // calculates and returns the players hand
  public static int calculateCardHandSum(RandIndexQueue<Card> listOfCards) {
    int cardHandSum = 0;
    for(int i = 0; i < listOfCards.size(); i++) {
      if(cardHandSum < 17) {
        cardHandSum += listOfCards.get(i).value();
      } else {
        cardHandSum += listOfCards.get(i).value2();
      }
    } // end for
    return cardHandSum;
  } // end calculateCardHandSum

} // end class Blackjack
