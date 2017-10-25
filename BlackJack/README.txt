This program allows the user to play a game of solitaire black jack from one deck of cards. My program manages a deck of cards, shuffles it (code provided), and deals cards to the user. It also checks the dealt cards to see if the player got (a) black jack, or (b) busted.
 
This is a single player game. The user is not playing against the computer. The computer does not play the game, it just arbitrates the game.

 Input: A lucky number and chars n, h, q to play the game.
 
 Output: Prints out the prompts and the cards in your hand. Prints out bust if your
         hand sum is greater than 21 and black jack if your hand sum is equal to 21. 
         Prints out bye when you quit program.

Rules of Blackjack:
- An Ace counts as 11. If there is more than 1 Ace in the hand, then additional Ace cards count as 1.
- Face cards e.g. Jack, Queen, and King count as 10.
- A player is dealt 2 cards each time they request a new hand.
- A player is dealt 1 card each time they request a hit.
- A hand can have a maximum of 5 cards. It is complete and the user cannot add another card to the hand. A new hand is required if the player wants to continue playing.
- There must be at least two cards left on the stack to be dealt a new hand (if not, the program should terminate).
- There must be at least one card left on the stack to be dealt a new card (if not, the program should terminate).
- If the hand adds up to more than 21, then the hand is BUSTED.
- If the hand adds up to 21, it is complete. A new hand is required if the player wants to continue playing.
- If the new hand contains an Ace and a 10 (ten, Jack, Queen, or King), then it's a BLACK JACK.

Example Run of Program:
 
 Enter (n)ew hand, (h)it, or (q)uit: h
-- GET A NEW HAND FIRST --

Enter (n)ew hand, (h)it, or (q)uit: n
You have the following cards:
Club 6
Club 10
Value of your hand is: 16
==========================================================================
Enter (n)ew hand, (h)it, or (q)uit: n
You have the following cards:
Diamond Ace
Club 3
Value of your hand is: 14

Enter (n)ew hand, (h)it, or (q)uit: h
You have the following cards:
Diamond Ace
Club 3
Diamond 10
Value of your hand is: 24
-- BUSTED! --
                                               
Enter (n)ew hand, (h)it, or (q)uit: n
You have the following cards:
Club 6
Club Ace
Value of your hand is: 17

Enter (n)ew hand, (h)it, or (q)uit: h
You have the following cards:
Club 6
Club Ace
Heart 5
Value of your hand is: 22
-- BUSTED! -- 
