/**
 * Program: Hand
 * Authors: Daniel Lee (dle69@ucsc.edu)  Driving 360 minutes. Navigating 360 minutes.
 *
 * CMP 12A/L, Fall 2013
 * Programming Assignment #5
 * November 24, 2013
 *
 * This code is utilized by BlackJack.java
 *
 * Input:
 * no input
 *
 * Output:
 * no ouputs
 *
 * Bugs and limitations:
 * Success rate is 99.99% unless someone really blew it.
 */

import java.util.ArrayList;

public class Hand
{
	public int deckIndex = 0; // current index of deck
	public int cardSum = 0; // sum of cards in hand
	public ArrayList<Integer> cards;
	public int aceCount = 0;
	
	public Hand() // default constructor
	{
		cards = new ArrayList<Integer>();
	}
	
	/**
	 * dealNewCard( Deck aDeck )
	 *
	 * Method gets first two cards from a deck and adds it to
	 * arrayList cards. Adds the value of each card to cardSum
	 * Since new hand is drawn resets cardSum, aceCount, and 
	 * clears arrayList cards.
	 *
	 * Input:  a card deck
	 * Output: no output
	 */
	public void dealNewCard(Deck aDeck)
	{
		cardSum = 0;
		aceCount = 0;
		cards.clear(); // removes old cards
		cards.add(aDeck.deck[deckIndex]);
		int value = aDeck.deck[deckIndex];
		addVal(value);
		deckIndex++;
		cards.add(aDeck.deck[deckIndex]);
		value = aDeck.deck[deckIndex];
		addVal(value);
		deckIndex++;
	}
	
	/**
	 * getRemainingCardCount()
	 *
	 * Returns the number of cards left in deck.
	 *
	 * Input: no input
	 * Output: number of cards left in deck
	 */
	public int getRemainingCardCount()
	{
		return  (52 - cards.size());
	}
	
	/**
	 * hit( Deck aDeck )
	 *
	 * Draws a rectangle in the current color using the 2 points as
	 * diagonally opposite points.
	 *
	 * Input:  card deck
	 * Output: 
	 */
	public void hit(Deck aDeck)
	{
		cards.add(aDeck.deck[deckIndex]);
		int value = aDeck.deck[deckIndex];
		addVal(value);
		deckIndex++;
	}
	
	/**
	 * addVal( int num )
	 *
	 * It adds the card number value of the int num
	 * to the sum value of cards in player's hand.
	 *
	 * Input:  an int num
	 * Output: no output
	 */
	public void addVal(int num)
	{
		int value = num % 13;
		if (value == 0) // ace case
		{
			if ( aceCount == 0) // first ace in hand
			{
				value = 11;
				aceCount++;
			}
			else // more than one ace in hand
			{
				value = 1;
				aceCount++;
			}
			cardSum += value;
		}
		else if (0 < value && value < 10) // number card case
		{
			value = value + 1;
			cardSum += value;
		}
		else  // face card case (jack, queen, king)
		{
			value = 10;
			cardSum += value;
		}
		
	}
	
	/**
	 * convertIntToSuitValue
	 *
	 * Prints out the corresponding suit and card
	 * of the array position in deck
	 *
	 * Input:  an int num
	 * Output: the suit and card value corresponding to the number
	 */
	public static void convertIntToSuitValue(int num)
	{
		if (num < 13)
		{
			if ( num == 0)
			{
				System.out.println("Club Ace");
			}
			else if (num == 10)
			{
				System.out.println("Club Jack");
			}
			else if (num == 11)
			{
				System.out.println("Club Queen");
			}
			else if (num == 12)
			{
				System.out.println("Club King");
			}
			else
			{
				System.out.println("Club " + (num + 1));
			}
		}
		else if (num > 12 && num < 26)
		{
			if ( num == 13)
			{
				System.out.println("Diamond Ace");
			}
			else if (num == 23)
			{
				System.out.println("Diamond Jack");
			}
			else if (num == 24)
			{
				System.out.println("Diamond Queen");
			}
			else if (num == 25)
			{
				System.out.println("Diamond King");
			}
			else
			{
				System.out.println("Diamond " + (num - 12));
			}
		}
		else if (num > 25 && num < 39)
		{
			if ( num == 26)
			{
				System.out.println("Heart Ace");
			}
			else if (num == 36)
			{
				System.out.println("Heart Jack");
			}
			else if (num == 37)
			{
				System.out.println("Heart Queen");
			}
			else if (num == 38)
			{
				System.out.println("Heart King");
			}
			else
			{
				System.out.println("Heart " + (num - 25));
			}
		}
		else 
		{
			if ( num == 39)
			{
				System.out.println("Spade Ace");
			}
			else if (num == 49)
			{
				System.out.println("Spade Jack");
			}
			else if (num == 50)
			{
				System.out.println("Spade Queen");
			}
			else if (num == 51)
			{
				System.out.println("Spade King");
			}
			else
			{
				System.out.println("Spade " + (num - 38));
			}
		}
	}
	
	/**
	 * getCardCount()
	 *
	 * Returns the number of cards in player's hand.
	 *
	 * Input:  no input
	 * Output: the number of cards in player's hand
	 */
	public int getCardCount()
	{
		return cards.size();
	}
	
	/**
	 * showCards()
	 *
	 * Prints out the cards in player's hand
	 * and the sum of the cards in player's hand.
	 *
	 * Input:  no input
	 * Output: Prints the cards in the player's hand
	 * 		   and the sum of the cards in player's hand.
	 */
	public void showCards()
	{
		System.out.println("You have the following cards: ");
		for(int count = 0; count < cards.size(); count++)
		{
			convertIntToSuitValue(cards.get(count));
		}
		System.out.println("Value of your hand is: " + cardSum);
	}
}
