public class Round{


	private int index = 0;
	private int noPlayers;
	private DeckClass deck;
	private UserClass [] usersInGame = new UserClass [noPlayers];
	private int [] round ;
	private boolean winner;
	private int winningPlayerIndex;

	public Round(int index, int noPlayers, UserClass []  usersInGame, DeckClass communalDeck){


		this.index = index;
		this.noPlayers = noPlayers;
		this.usersInGame = usersInGame;
		this.deck = communalDeck;
		this.setUpRoundArray();
		this.findWinnerDraw();
		

	}

	/**
	 * [setUpRoundArray description]
	 */
	public void setUpRoundArray() {

		round = new int [noPlayers];

		//INDEX =0 IS NOT CONSIDERED, AS IT IS NEVER CHOOSEN AS A CATEGORY (DESCRIPTION)
		
		//Get the value of all players top card cat1 category	
		if (index==1) {
			for (int i=0; i<noPlayers; i++)
			{
				if( usersInGame[i].numberOfCards() !=0){

					round[i] = usersInGame[i].topCard().getCatOne();
				}
				else if (usersInGame[i].numberOfCards()  == 0){
					round[i] = -1; // set to kinus one if player eliminated
				}
			}
		
		}

		//Get the value of all players top card Weight category	
		if (index==2) {
			for (int i=0; i<noPlayers; i++)
			{
				if( usersInGame[i].numberOfCards() !=0){
					round[i] = usersInGame[i].topCard().getCatTwo();
				}

				else if (usersInGame[i].numberOfCards() == 0){
					round[i] = -1; // set to kinus one if player eliminated
				}
			}
		}	

		//Get the value of all players top card Length category
		if (index==3) {
			for (int i=0; i<noPlayers; i++)
			{
				if( usersInGame[i].numberOfCards() != 0){
					round[i] = usersInGame[i].topCard().getCatThree();
				}
				else if (usersInGame[i].numberOfCards() == 0){
					round[i] = -1; // set to kinus one if player eliminated
				}
			}

		}	

		//Get the value of all players top card ferocity category
		if (index==4) {
			for (int i=0; i<noPlayers; i++)
			{
				if( usersInGame[i].numberOfCards() !=0){
					round[i] = usersInGame[i].topCard().getCatFour();
				}
				else if (usersInGame[i].numberOfCards() == 0){
					round[i] = -1; // set to kinus one if player eliminated
				}

				}
		}


		//Get the value of all players top card intelligence category
		if (index==5) {
			for (int i=0; i<noPlayers; i++)
			{
				if( usersInGame[i].numberOfCards() != 0){
					round[i] = usersInGame[i].topCard().getCatFive();

				}
				else if (usersInGame[i].numberOfCards() == 0){
					round[i] = -1; // set to kinus one if player eliminated
				}
			}
		}	

		//JUST FOR TESTING
		for (int i=0; i<round.length; i++) {
			System.out.println("Value of category played by player " +i +" is " +round[i]);
		}

	}
	/**
	 * [findWinnerDraw description]
	 */
	public void findWinnerDraw() {
		winner= true;
		//Maxinum value in round array algorithm
		//COULD BE MOVED INTO ITS OWN METHOD
		int largestValue =round[0];
		int increment=1;
		int possibleWinner =0;
			 //index value for the round array
		while  (increment<round.length)	{
			if (round[increment]>largestValue) {
				largestValue = round[increment];
				possibleWinner= increment;
			}
			increment++;

		}

		System.out.println("WE FOUND OUR WINNING VALUE " +largestValue + " HELD BY PLAYER "+possibleWinner);
	
		boolean test = false;
		for (int i = 0; i < noPlayers; i++){


			if (largestValue==round[i]){
				test = false;



				if (possibleWinner == i){
					
					test = true;
				}
				if (!test){
					winner = false;
					System.out.println("We have a tie");
				}
			
			}

		
		}

		handOutCards(possibleWinner);
	}
		

		
		/*There is a winner:
		* 	add all cards for the other players deck to the winning players deck
		* 	remove cards from losing players deck
		*	add all communal cards to the winning players deck
		*	remove all cards from communal deck
		*	
		*/
	
	/**
	 * [handOutCards description]
	 * @param possibleWinner [description]
	 */
	public void handOutCards( int possibleWinner) {
		if (winner==true) {
			winningPlayerIndex = possibleWinner;
			

			for (int i=0; i<noPlayers; i++)
			{
				//Adding cards from the losing players hands to the winning players hands
				if (usersInGame[i].numberOfCards() != 0){
					usersInGame[winningPlayerIndex].addCard(usersInGame[i].topCard());
					usersInGame[i].deleteCard();
					

				}
					
				

			}
			int n = deck.getDeckCount();
			CardClass [] pile = deck.getPile(); 
			if ( n>0){
						for (int j =0; j <n; j++){

						usersInGame[winningPlayerIndex].addCard(pile[j]);
						}

					}

			int communalDeckTotal = deck.getDeckCount();
			deck.clear();


			
			System.out.println("Adding was successful" + usersInGame[winningPlayerIndex].numberOfCards());
			System.out.println("Deleting was successful" + usersInGame[1].numberOfCards());
			System.out.println("      INDEX of wining player: " +winningPlayerIndex);
			System.out.println("     Category in play: "+ index);

			
				
		}

		/** There is a draw:
		*	add all players cards to communal deck
		*   delete players cards
		*
		*/
		if (winner==false) {

			winningPlayerIndex = -1;
			for (int i=0; i<usersInGame.length; i++)
			{
				if (usersInGame[i].numberOfCards() != 0){

					deck.addCard(usersInGame[i].topCard());
					usersInGame[i].deleteCard();
				}
					
			}

			
		}

	}
	
	/**
	 * [getWinner description]
	 * @return [description]
	 */
 	public int getWinner() {

 		return winningPlayerIndex;
 }



}






