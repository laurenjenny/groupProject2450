package groupProject;

public class Blackjack {
	Deck deck = new Deck();
	Hand dealerHand = new Hand();
	Hand playerHand = new Hand();
	Hand ai1 = new Hand();
	Hand ai2 = new Hand();
	
	
	public void newGame(){
		deck.shuffle();
		
		dealerHand.addCard(deck.draw(1));
		ai1.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));
		
		dealerHand.addCard(deck.draw(1));
		ai1.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));
	}
	
	public void compPlay(){
		dealerPlay();
		ai1Play();
		ai2Play();
	}
	
	public void dealerPlay(){
		if(playerHand.value() < 17 && playerHand.value() > 21){
			playerHand.addCard(hit());
		}
		else stay();
	}
	
	public void ai1Play(){
		if(ai1.value() < 17 && ai1.value() > 21){
			ai1.addCard(hit());
		}
		else stay();
	}
	
	
	public void ai2Play(){
		if(ai2.value() < 17 && ai2.value() > 21){
			ai2.addCard(hit());
		}
		else stay();
	}
	
	public Card hit(){
		return deck.draw(1);
	}
	
	public void stay(){
		
	}
	
	public void bust(){
		
	}
}
