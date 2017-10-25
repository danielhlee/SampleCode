import java.util.*;

/**
 *  The Deck class is a new type that represents a deck
 *  of cards.  It should have methods that have anything
 *  to do with a deck of cards.  A constructor and a
 *  shuffle method are provided to get you started.
 *  Written by:  Alex Pang
 *  Edited by:   Tom Austin
 *       (replacing tio package with java.util.Scanner
 *        and some updates to formatting.)
 *  Date: Feb 21, 2011
 */


class Deck
{
    public int[] deck;

    // -------------------
    // constructor
    // -------------------
    public Deck()
    {
      deck = new int[52];
      for(int i=0; i<52; i++) deck[i] = i;
    }

    // -------------------
    // instance method
    // -------------------
    public void print()
    {
      for(int i=0; i<52; i++) System.out.printf( "%3d", deck[i] );
      System.out.println();
    }

    // -------------------
    // instance method
    // -------------------
    public void shuffle()
    {
      int i, j, tmp;
      int seed;
      Random r;
      Scanner scan = new Scanner(System.in);
      System.out.print( "Enter your lucky number: " );
      seed = scan.nextInt();
      r = new Random(seed); // initialize random # generator
      for(i=0; i<52; i++ )  // shuffle deck of cards
      {
        j = r.nextInt(52);  // randomly pick a card
        tmp = deck[j];      // swap with i-th card
        deck[j] = deck[i];
        deck[i] = tmp;
      }
    }
}