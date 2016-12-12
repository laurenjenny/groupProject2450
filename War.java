package groupProject;

import groupProject.Deck;

public class War {
	Deck startDeck;

	boolean playerWinRound = false;
	boolean playerWinGame = false;
	boolean tie = true;
	boolean tieOOB = false;

	Hand playerDeck = new Hand();
	Hand aiDeck = new Hand();
	Card playerCard;
	Card aiCard;

	// method to play game
	public void playGame() {
		startDeck = new Deck();
		warDeal(startDeck);
	}

	// method to play one round of war
	public boolean playRound() {
		// at the beginning of each round, set tie to true
		tie = true;

		// do the following while tie is true
		while (tie) {
			// take first card out of each deck
			playerCard = playerDeck.remove(0);
			aiCard = aiDeck.remove(0);

			// compare cards
			int compare = compareCards(playerCard, aiCard);

			// determine
			if (compare == 1) {
				// players wins
				playerWinRound = true;
				tie = false;
			} else if (compare == -1) {
				// ai wins
				playerWinRound = true;
				tie = false;
			} else if (compare == 0) {
				// if there is a tie, call tieEvent and re loop
				tieEvent(playerCard, aiCard, playerDeck, aiDeck);
				tie = true;
			}
		}
		;

		// once roundWinnder has been determined
		// and tie loop has ended (meaning the round did not end in a tie)
		// add cards to the end of winner deck
		if (playerWinRound) {
			playerDeck.addCard(playerCard);
			playerDeck.addCard(aiCard);
		} else if (!playerWinRound) {
			aiDeck.addCard(playerCard);
			aiDeck.addCard(aiCard);
		}

		return playerWinRound;
	}

	// method to distribute cards between the two players
	public void warDeal(Deck deck) {
		do {
			playerDeck.addCard(deck.draw(0));
			aiDeck.addCard(deck.draw(0));
		} while (deck.deckList.size() != 0);
	}

	// method to compare two cards
	public int compareCards(Card pCard, Card aCard) {
		// playerCard wins
		if (pCard.getFace().getValue() > aCard.getFace().getValue())
			return 1;
		// playerCard loses
		else if (pCard.getFace().getValue() < aCard.getFace().getValue())
			return -1;
		// there is a tie
		else
			return 0;
	}

	// in the event of a tie, the cards will be returned to respective decks
	public void tieEvent(Card pCard, Card aCard, Hand pDeck, Hand aDeck) {
		pDeck.addCard(pCard);
		aDeck.addCard(aCard);
	}

	// method to determine game winner
	public boolean determineGameWinner() {
		if (playerDeck.size() == 0)
			playerWinGame = false;
		else if (aiDeck.size() == 0)
			playerWinGame = true;
		return playerWinGame;
	}
}
