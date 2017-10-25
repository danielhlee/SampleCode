import java.util.Scanner;

public class BlackJack
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    	// Create a deck
	Deck blackJack = new Deck();
	Scanner in = new Scanner(System.in);
	char choice;
	int deckCount = 52;
	// Randomize the deck
	blackJack.shuffle();
	Hand hand = new Hand();
		
	// start of while loop to make sure there are enough cards in deck
	while (deckCount >= 0)
	{
	    System.out.print("Enter a (n)ew hand, (h)it, or (q)uit: "); // prompt to play or quit
	    choice = in.next().charAt(0);
	    		
	    if (choice == 'n') // new deck option entered
	    {
	    	if (deckCount >= 2) // checks that there are enough cards for new hand
		{
		    hand.dealNewCard(blackJack); // call hand method to deal two cards
		    hand.showCards(); // display cards
		    if ( hand.cardSum == 21) // black jack case
		    {
		        System.out.println("=== BLACKJACK! ===");
			System.out.println();
		    }
		    	else // draw two cards and subtract two from deck count
			{
			    System.out.println();
			}
			deckCount = deckCount - 2;
		    }
		    else // less than 2 cards left on deck
		    {
		    	System.out.println("-- NOT ENOUGH CARDS LEFT ON DECK --");
			System.out.println();
			System.out.println("BYE");
			break;
		    }
		}
		else if (choice == 'h') // hit option entered
		{
		    if (hand.getCardCount() > 0) // checks if new hand is drawn
		    {
		    	if ( deckCount > 1) // checks if there is at least one card on deck
			{
			    if (hand.cardSum < 21 ) // checks if hand sum is less than 21
			    {
			        if(hand.getCardCount() < 5) // checks if there are less than 5 cards in hand
				{
			            hand.hit(blackJack); // call hit method
				    hand.showCards(); // print cards in hand 
				    if (hand.cardSum > 21) // bust case card sum > 21
				    {
				    	System.out.println("-- BUSTED! --");
					System.out.println();
				    }
				    else if ( hand.cardSum == 21) // black jack case card sum = 21
				    {
				    	System.out.println("-- BLACKJACK! --");
					System.out.println();
				    }
				    else // draw card and subtract from deck count
				    {
				    	System.out.println();
				    }
				    deckCount = deckCount - 1; 
				}
				else // 5 cards in hand already case
				{
				    System.out.println("-- ALREADY 5 CARDS IN HAND --");
				    hand.showCards();
				    System.out.println();
				}	
			    } 			   
			    else // get new hand case because of bust or black jack
			    {
			    	System.out.println("-- GET A NEW HAND FIRST --");
			        System.out.println();
			    }
			}
			else // no cards left on deck case 
			{
			    System.out.println("-- NO CARDS LEFT ON DECK --");
			    System.out.println();
			    System.out.println("BYE");
			    break;
			}
		    }
		    else // case where new hand has not been drawn
		    {
		    	System.out.println("-- GET A NEW HAND FIRST --");
			System.out.println();
		    }
		}
		else if (choice == 'q') // quit option entered exit program
		{
		    deckCount = -1;
		    System.out.println();
		    System.out.print("BYE");
	        }	
	} // end of while loop
	in.close();
    }
}
