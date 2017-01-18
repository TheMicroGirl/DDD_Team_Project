/** UserClass defines a player object, which is either a computer player
*   or a human player. They share common attributes and conceptual methods,
*   however they differ in how they execute certain methods.
*/
import java.util.*;

public class UserClass {

	/** Class Constants */

	/** Instance Variables */
	private CardClass [] hand;
	private int count;

	/** Default Constructor */
	public UserClass() {

		count = 0;

	}

	/** Non-Default Constructor */

	/** Accessor for hand */


	public void getHand() {  // not void

		for (int i =0; i < hand.length; i++){

			System.out.println(" This si the hand" + hand[i].getIntelligence());
		}
		
	}

	/** Mutator for hand */
	public void setHand(CardClass [] hand) {
		this.hand = hand;
	} 

	/** Adds a Card to a users hand
	*
	*  IDEA : 		deck = Arrays.copyOf(deck,(deck.length+1));
	*	deck[deck.length-1] = crd; 
	*
	*	@param card to be added
	*/
	public void addCard(CardClass crd) {


		hand = new CardClass [40];
		hand[count] = crd;
		System.out.println(" The test:::"+ hand[count].getIntelligence());


		count++;

		



	}


	/** Deletes a Card from the users hand:
	*   It will always be the 0th index card of the hand array to be deleted
	*	
	*	hand = Arrays.copyOf(hand,(hand.length-1));
	*	hand[hand.length-1] = crd;
	*
	*/
	public void deleteCard() {
	
	}

	/** Counts the number of cards a user has in 
	*	their hand
	*	@return total number of cards in the hand
	*
	*/
	public int totalCards() {
		return 0;

	}

	/** Player selects the appropriate category 
	*   to play
	*/
	public String selectCategory() {
		return "";

	}
}