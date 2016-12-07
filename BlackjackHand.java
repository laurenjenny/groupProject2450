package groupProject;

import java.util.*;

public class BlackjackHand {
	public List<Card> hand = new ArrayList<Card>();

    public void addCard(Card c){
        hand.add(c);
    }
    
    public int value()
	{
		int value = 0;
		boolean hasAce = false;
		
		for (Card card : hand)
		{
			if(card.getFace().getValue() == 14)
				value += 11;
			else if(card.getFace().getValue() > 10)
				value += 10;
			else
				value += card.getFace().getValue();
			
			if(card.getFace().getValue() == 14)
				hasAce = true;			
		}
		
		if(value > 21 && hasAce == true)
			value -= 10;
		
		return value;
	}
    
    public int size(){
    	return hand.size();
    }

}
