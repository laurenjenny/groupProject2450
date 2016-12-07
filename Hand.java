package groupProject;

import java.util.*;

public class Hand {
	public List<Card> hand = new ArrayList<Card>();

    public void addCard(Card c){
        hand.add(c);
    }
    
    public int value()
	{
		int value = 0;
				
		for (Card card : hand){
			value += card.getFace().getValue();								
		}
		return value;
	}
    
    public int size(){
    	return hand.size();
    }

}
