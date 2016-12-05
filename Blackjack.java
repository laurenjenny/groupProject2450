package groupProject;

public class Blackjack {
	Deck deck = new Deck();
	Hand dealerHand = new Hand();
	Hand playerHand = new Hand();
	Hand ai1 = new Hand();
	Hand ai2 = new Hand();
	
	int[] stayOrBust = new int[4];
	int size = 0;
	
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
		if(stayOrBust[0] == 0){
			dealerPlay();
		}
		
		if(stayOrBust[1] == 0){
			ai1Play();
		}
		
		if(stayOrBust[1] == 0){
			ai2Play();
		}
	}
	
	public void dealerPlay(){
		if(dealerHand.value() < 17 && dealerHand.value() > 21){
			playerHand.addCard(hit());
			stayOrBust[0] = 0;
		}
		else{
			size++;
			stayOrBust[0] = stay();
		}
	}
	
	public void ai1Play(){
		if(ai1.value() < 17 && ai1.value() > 21){
			ai1.addCard(hit());
			stayOrBust[1] = 0;
		}
		else{
			size++;
			stayOrBust[1] = stay();
		}
	}
	
	public void ai2Play(){
		if(ai2.value() < 17 && ai2.value() > 21){
			ai2.addCard(hit());
			stayOrBust[2] = 0;
		}
		else{
			size++;
			stayOrBust[2] = stay();
		}
	}
	
	public Card hit(){
		return deck.draw(1);
	}
	
	public int stay(){
		return 1;
	}
	
	public String checkWinner(){
		int value1 = dealerHand.value();
		int value2 = ai1.value();
		int value3 = ai2.value();
		int value4 = playerHand.value();
		int i = 0;
		String player;
		
		while(i == 0){
			if(value2 > value1){
				i = 1;
			}
			if(value3 > value1){
				i = 1;
			}
			if(value4 > value1){
				i = 1;
			}
			
			player = "dealer";
			i = 10;
		}
		
		while(i == 1){
			if(value2 > value3){
				i = 2;
			}
			if(value3 > value4){
				i = 2;
			}
			player = "computer 1";
			i = 10;
		}
		
		while(i == 2){
			if(value3 > value4);
			{
				player = "computer 2";
			}
			else player = "player";
		}
		
		
		return player;
	}
}
