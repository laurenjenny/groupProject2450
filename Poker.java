package groupProject;

public class Poker {
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
}
