package groupProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import groupProject.Card.Face;

public class Poker {
	Deck deck = new Deck();
	Hand playerHand = new Hand();
	Hand ai1 = new Hand();
	Hand ai2 = new Hand();
	Hand ai3 = new Hand();
	Hand table = new Hand();
	
	Face ace = Face.Ace;
	Face king = Face.King;
	Face queen = Face.Queen;
	Face jack = Face.Jack;
	Face ten = Face.Ten;
	Face nine = Face.Nine;
	Face eight = Face.Eight;
	Face seven = Face.Seven;
	Face six = Face.Six;
	Face five = Face.Five;
	Face four = Face.Four;
	Face three = Face.Three;
	Face two = Face.Two;
	
	public void newGame(){
		deck.shuffle();
		
		ai1.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		ai3.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));

		ai1.addCard(deck.draw(1));
		ai2.addCard(deck.draw(1));
		ai3.addCard(deck.draw(1));
		playerHand.addCard(deck.draw(1));
	}
	
	public void theFlop(){
		table.addCard(deck.draw(1));
		table.addCard(deck.draw(1));
		table.addCard(deck.draw(1));
	}
	
	public void theTurn(){
		table.addCard(deck.draw(1));
	}
	
	public void theRiver(){
		table.addCard(deck.draw(1));
	}
	
	public void determineWinner(){
		
	}
	
	public int isRoyalFlush(Hand checkHand){
		ArrayList<Face> face = new ArrayList<Face>();
		
		face.add(ace);
		face.add(king);
		face.add(queen);
		face.add(jack);
		face.add(ten);
		
		int value = 0;
		
		ArrayList<Face> compareFace = new ArrayList<Face>();
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			compareFace.add(checkHand.hand.get(i).getFace());
		}
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getSuit().equals(checkHand.hand.get(0).getSuit()) == true);
			value++;
		}
		
		if(value > 4){
			if(compareFace.containsAll(face)){
				return 10;
			}
		}
		
		return 0;
	}
	
	public int isStraightFlush(Hand checkHand){
		int yes = isFlush(checkHand);
		int yes2 = isStraight(checkHand);
		
		if(yes == 7){
			if(yes2 == 6){
				return 9;
			}
		}
		
		return 0;
	}
	
	public int isFourOfAKind(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(checkHand.hand.get(0).getFace()) == true);
			value++;
		}
		
		if(value == 4){
			return 8;
		}
		
		return 0;
	}
	
	public int isFullHouse(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(checkHand.hand.get(0).getFace()) == true){
				checkHand.hand.remove(i);
				value++;
			}
		}
		
		if(value == 3){
			if(isPair(checkHand) == 2){
				return 7;
			}
		}
		
		return 0;
	}

	public int isFlush(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getSuit().equals(checkHand.hand.get(0).getSuit()) == true){
				value++;
			}
		}
		
		if(value > 4){
			return 6;
		}
		
		return 0;
	}
	
	public int isStraight(Hand checkHand){
		ArrayList<Face> face = new ArrayList<Face>();
		ArrayList<Face> face2 = new ArrayList<Face>();
		ArrayList<Face> face3 = new ArrayList<Face>();
		ArrayList<Face> face4 = new ArrayList<Face>();
		ArrayList<Face> face5 = new ArrayList<Face>();
		ArrayList<Face> face6 = new ArrayList<Face>();
		ArrayList<Face> face7 = new ArrayList<Face>();
		ArrayList<Face> face8 = new ArrayList<Face>();
		ArrayList<Face> face9 = new ArrayList<Face>();
		ArrayList<Face> compareFace = new ArrayList<Face>();
		
		face.add(two);
		face.add(three);
		face.add(four);
		face.add(five);
		face.add(six);
		
		face2.add(three);
		face2.add(four);
		face2.add(five);
		face2.add(six);
		face2.add(seven);
		
		face3.add(four);
		face3.add(five);
		face3.add(six);
		face3.add(seven);
		face3.add(eight);
		
		face4.add(five);
		face4.add(six);
		face4.add(seven);
		face4.add(eight);
		face4.add(nine);
		
		face5.add(six);
		face5.add(seven);
		face5.add(eight);
		face5.add(nine);
		face5.add(ten);
		
		face6.add(seven);
		face6.add(eight);
		face6.add(nine);
		face6.add(ten);
		face6.add(jack);
		
		face7.add(eight);
		face7.add(nine);
		face7.add(ten);
		face7.add(jack);
		face7.add(queen);
		
		face8.add(nine);
		face8.add(ten);
		face8.add(jack);
		face8.add(queen);
		face8.add(king);
		
		face9.add(ace);
		face9.add(two);
		face9.add(three);
		face9.add(four);
		face9.add(five);
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			compareFace.add(checkHand.hand.get(i).getFace());
		}
		
		if(compareFace.containsAll(face)){
			return 5;
		}
		
		if(compareFace.containsAll(face2)){
			return 5;
		}
		
		if(compareFace.containsAll(face3)){
			return 5;
		}
		
		if(compareFace.containsAll(face4)){
			return 5;
		}
		
		if(compareFace.containsAll(face5)){
			return 5;
		}
		
		if(compareFace.containsAll(face6)){
			return 5;
		}
		
		if(compareFace.containsAll(face7)){
			return 5;
		}
		
		if(compareFace.containsAll(face8)){
			return 5;
		}
		
		if(compareFace.containsAll(face9)){
			return 5;
		}
		
		return 0;
	}
	
	public int isThreeOfAKind(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(checkHand.hand.get(0).getFace()) == true){
				value++;
			}
		}
		
		if(value == 3){
			return 4;
		}
		
		return 0;
	}
	
	public int isTwoPair(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(checkHand.hand.get(0).getFace()) == true);
			checkHand.hand.remove(i);
			value++;
		}
		
		for(int j = 0; j < checkHand.hand.size(); j++){
			if(checkHand.hand.get(j).getFace().equals(checkHand.hand.get(0).getFace()) == true);
			value++;
		}
		
		if(value == 4){
			return 3;
		}
		
		return 0;
	}
	
	public int isPair(Hand checkHand){
		int value = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(checkHand.hand.get(0).getFace()) == true);
			value++;
		}
		
		if(value == 2){
			return 2;
		}
		
		return 0;
	}
	
	public int isHighCard(Hand checkHand){
		return 1;
	}
	
}
