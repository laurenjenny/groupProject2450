package groupProject;

import groupProject.Deck;

public class War {
	Deck startDeck;

	// discardDeck is used to temporarily store cards
	// at the end of each round the contents of discardDeck
	// are added to the deck of the round winner
	Hand discardDeck = new Hand();

	boolean playerWinRound = false;
	boolean playerWinGame = false;

	Hand playerDeck = new Hand();
	Hand aiDeck = new Hand();
	Card playerCard;
	Card aiCard;

	// method to play game
	public void playGame() {
		startDeck = new Deck();
		warDeal(startDeck);

		// play round until either deck runs out of cards
		/*do {
			playRound();
		} while ((playerDeck.deckList.size() != 0) || (aiDeck.deckList.size() != 0));

		determineWinner();
		*/
	}

	// method to play one round of war
	public boolean playRound() {

		// take first card in each deck then add to discard
		playerCard = playerDeck.remove(0);
		addToDiscard(playerDeck, 0);

		aiCard = aiDeck.remove(0);
		addToDiscard(aiDeck, 0);

		// compare cards
		Card roundWin = compareCards(playerCard, aiCard);

		// determine if player wins round
		if (roundWin == playerCard)
			playerWinRound = true;
		else if (roundWin == aiCard)
			playerWinRound = false;

		// adds the two cards to the winners deck
		if (playerWinRound)
			addToRoundWinner(playerDeck);
		else if (!playerWinRound)
			addToRoundWinner(aiDeck);

		return playerWinRound;
	}

	// method to distribute cards between the two players
	public void warDeal(Deck deck) {
		do{
			playerDeck.addCard(deck.draw(0));
			aiDeck.addCard(deck.draw(0));
		}while(deck.deckList.size() != 0);
	}

	// method to compare two cards
	// returns the winning card
	public Card compareCards(Card card1, Card card2) {
		if (card1.getFace().getValue() > card2.getFace().getValue())
			return card1;
		else if (card1.getFace().getValue() < card2.getFace().getValue())
			return card2;
		else
			return tieBreak(playerDeck, aiDeck, discardDeck);
	}

	// recursive method that is called
	// when compareCards results in a tie
	// returns the winning card
	public Card tieBreak(Hand deck1, Hand deck2, Hand discard) {
		// get the next three cards from game decks
		// store them in two temporary hands
		Hand playerTie = new Hand();
		playerTie.addCard(deck1.remove(0));
		playerTie.addCard(deck1.remove(0));
		playerTie.addCard(deck1.remove(0));

		// after adding cards to temporary hands
		// remove them from game decks
		// and add to discard deck
		do{
			addToDiscard(deck2, 0);
		}while (playerTie.hand.size() != 0);

		Hand aiTie = new Hand();
		aiTie.addCard(deck2.remove(0));
		aiTie.addCard(deck2.remove(0));
		aiTie.addCard(deck2.remove(0));
		do{
			addToDiscard(deck2, 0);
		}while (aiTie.hand.size() != 0);

		// compare the third card from each hand
		return compareCards(aiTie.hand.get(0), playerTie.hand.get(0));
	}

	// method to remove an element from one deck
	// and add it to the discard deck
	public void addToDiscard(Hand deck, int element) {		
		discardDeck.addCard(deck.remove(element));
	}

	public void addToRoundWinner(Hand winDeck) {
		do{
			winDeck.addCard(discardDeck.remove(0));
		}while (discardDeck.size() != 0);
	}

	// method to determine winner1
	public boolean determineWinner() {
		if (playerDeck.size() == 0)
			playerWinGame = false;
		else if (aiDeck.size() == 0)
			playerWinGame = true;
		return playerWinGame;
	}
}
