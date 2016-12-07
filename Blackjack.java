package groupProject;

import groupProject.Deck;

public class Blackjack {
	Deck deck = new Deck();
	BlackjackHand dealerHand = new BlackjackHand();
	BlackjackHand playerHand = new BlackjackHand();
	BlackjackHand ai1 = new BlackjackHand();
	BlackjackHand ai2 = new BlackjackHand();
	boolean playerBusts = false;
    boolean playerWins = false;
    boolean playerLose = false;
    boolean playerPush = false;
    boolean playerBlackJack = false;
    boolean dealerBusts = false;
    boolean dealerBlackJack = false;
    boolean ai1Busts = false;
    boolean ai1Wins = false;
    boolean ai1Lose = false;
    boolean ai1Push = false;
    boolean ai1BlackJack = false;
    boolean ai2Busts = false;
    boolean ai2Wins = false;
    boolean ai2Lose = false;
    boolean ai2Push = false;
    boolean ai2BlackJack = false;
    boolean endGame = false;
    
	
	public void newGame(){
		playerBusts = false;
	    playerWins = false;
	    playerLose = false;
	    playerPush = false;
	    playerBlackJack = false;
	    dealerBusts = false;
	    dealerBlackJack = false;
	    ai1Busts = false;
	    ai1Wins = false;
	    ai1Lose = false;
	    ai1Push = false;
	    ai1BlackJack = false;
	    ai2Busts = false;
	    ai2Wins = false;
	    ai2Lose = false;
	    ai2Push = false;
	    ai2BlackJack = false;
	    endGame = false;
        dealerHand.hand.clear();
        playerHand.hand.clear();
        ai1.hand.clear();
        ai2.hand.clear();
        
        if(deck.deckList.size() < 20){
            deck = new Deck();
        }
		deck.shuffle();
		
		dealerHand.addCard(deck.draw(1));
		ai1.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		
		dealerHand.addCard(deck.draw(1));
		ai1.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		
		if (dealerHand.value() == 21)
        {
        	if (playerHand.value() == 21)
        		playerPush = true;
        	if (ai1.value() == 21)
        		ai1Push = true;
        	if (ai2.value() == 21)
        		ai2Push = true;
        	dealerBlackJack = true;
        	endGame();
        }
		if (playerHand.value() == 21 && dealerHand.value() != 21){
        	playerBlackJack = true;
        	compPlay();
		}
        if (ai1.value() == 21 && dealerHand.value() != 21)
        	ai1BlackJack = true;
        if (ai2.value() == 21 && dealerHand.value() != 21)
        	ai2BlackJack = true;
		
		if (ai1BlackJack == false)
			ai1Play();	
	}
	
	public void compPlay(){
		if (ai2BlackJack == false)
			ai2Play();
		dealerPlay();
		endGame();
	}
	
	public void dealerPlay(){
		while(dealerHand.value() < 17){
			dealerHand.addCard(deck.draw(1));
		}
		if(dealerHand.value() > 21){
			dealerBusts = true;
		}
	}
	
	public void ai1Play(){
		while(ai1.value() < 17){
			ai1.addCard(deck.draw(1));
		}
		if(ai1.value() > 21){
			ai1Busts = true;
		}
	}
	
	
	public void ai2Play(){
		while(ai2.value() < 17){
			ai2.addCard(deck.draw(1));
		}
		if(ai2.value() > 21){
			ai2Busts = true;
		}
	}
	
	public void hit(){
		playerHand.addCard(deck.draw(1));
		if(playerHand.value() > 21){
            playerBusts = true;
            compPlay();
		}
	}
	
	public void stay(){
		compPlay();
	}
	
	public void endGame(){
		if(!playerBusts && !playerBlackJack){
			if(playerHand.value() > dealerHand.value())
				playerWins = true;
			if(playerHand.value() == dealerHand.value())
				playerPush = true;
			if(playerHand.value() < dealerHand.value())
				playerLose = true;
		}
		if(!ai1Busts && !ai1BlackJack){
			if(ai1.value() > dealerHand.value())
				ai1Wins = true;
			if(ai1.value() == dealerHand.value())
				ai1Push = true;
			if(ai1.value() < dealerHand.value())
				ai1Lose = true;
		}
		if(!ai1Busts && !ai1BlackJack){
			if(ai2.value() > dealerHand.value())
				ai2Wins = true;
			if(ai2.value() == dealerHand.value())
				ai2Push = true;
			if(ai2.value() < dealerHand.value())
				ai2Lose = true;
		}
		endGame = true;
	}
}
