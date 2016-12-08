package groupProject;

import groupProject.Deck;

public class War {
	Deck startDeck = new Deck();
	Deck discardDeck = new Deck();
	
	boolean playerWinRound = false;	
	boolean playerWinGame = false;
	
	Deck playerDeck;
	Deck aiDeck;

	
	// method to play game
	public void playGame() {
		startDeck.shuffle();
		warDeal(startDeck);

		//play round until either deck runs out of cards
		do {
			playRound();
		} while ((playerDeck.deckList.size() != 0) 
				|| (aiDeck.deckList.size() != 0));
		
		determineWinner();
	}

	// method to play one round of war
	public boolean playRound() {
		
		//take first card in each deck then add to discard
		Card playerCard = playerDeck.deckList.get(0);
		discardCard(playerDeck, 0);
		
		Card aiCard = aiDeck.deckList.get(0);
		discardCard(aiDeck, 0);

		//compare cards
		Card roundWin = compareCards(playerCard, aiCard);
		
		//determine if player wins round
		if(roundWin == playerCard)
			playerWinRound = true;
		else if (roundWin == aiCard)
			playerWinRound = false;
		
		return playerWinRound;
			
		
	}

	// method to distribute cards between the two players
	public void warDeal(Deck deck) {
		for (int i = 0; i < deck.deckList.size(); i++) {
			if (i % 2 == 0) {
				playerDeck.deckList.add((i / 2), 
						deck.deckList.get(i));
			} else {
				aiDeck.deckList.add((i / 2), 
						deck.deckList.get(i));
			}
		}
	}
	
	//method to compare two cards
	public Card compareCards(Card card1, Card card2) {
	            if (card1.getFace().getValue() 
	            		> card2.getFace().getValue())
	                return card1;
	            else if (card1.getFace().getValue() 
	            		< card2.getFace().getValue())
	                return card2;
	            else
	            	return tieBreak(playerDeck, aiDeck, discardDeck);       	
	}
	
	//recursive method that is called 
	//when compareCards results in a tie
	public Card tieBreak(Deck deck1, Deck deck2, Deck discard) {
		//get the next three cards from game decks
		//store them in two temporary hands
		Hand playerTie = new Hand();
		playerTie.addCard(deck1.deckList.get(0));
		playerTie.addCard(deck1.deckList.get(1));
		playerTie.addCard(deck1.deckList.get(2));
		
		//after adding cards temporary hands
		//remove them from game decks
		//and add to discard deck
		for(int i = 0; i < playerTie.hand.size(); i++) {
			discardCard(deck1, 0);
		}

		Hand aiTie = new Hand();
		aiTie.addCard(deck2.deckList.get(0));
		aiTie.addCard(deck2.deckList.get(1));
		aiTie.addCard(deck2.deckList.get(2));
		for(int i = 0; i < aiTie.hand.size(); i++) {
			discardCard(deck2, 0);
		}
		
		//compare the third card from each hand
		return compareCards(aiTie.hand.get(2), playerTie.hand.get(2));
	}
	
	//method to remove an element from one deck 
	//and add it to the discard deck
	public void discardCard(Deck deck, int element) {
		Card card = deck.deckList.get(element);
		deck.deckList.remove(element);
		discardDeck.deckList.add(card);
	}
	
	//method to determine winner1
	public boolean determineWinner() {
		if(playerDeck.deckList.size() == 0) 
			playerWinGame = false;
		else if (aiDeck.deckList.size() == 0)
			playerWinGame = true;
		return playerWinGame;
	}
}
