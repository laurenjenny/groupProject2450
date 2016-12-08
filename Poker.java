package groupProject2450;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import groupProject2450.Card.Face;
import groupProject2450.Card.Suit;

public class Poker {
	Deck deck = new Deck();
	Hand playerHand = new Hand();
	Hand ai1 = new Hand();
	Hand ai2 = new Hand();
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
	
	Suit clubs = Suit.CLUBS;
	Suit spades = Suit.SPADES;
	Suit diamonds = Suit.DIAMONDS;
	Suit hearts = Suit.HEARTS;
	
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
	
	public int checkHandValues(Hand checkHand){
		if(isRoyalFlush(checkHand) == true){
			return 10;
		}
		else if(isStraightFlush(checkHand) == true){
			return 9;
		}
		else if(isFourOfAKind(checkHand) == true){
			return 8;
		}
		else if(isFullHouse(checkHand) == true){
			return 7;
		}
		else if(isFlush(checkHand) == true){
			return 6;
		}
		else if(isStraight(checkHand) == true){
			return 5;
		}
		else if(isThreeOfAKind(checkHand) == true){
			return 4;
		}
		else if(isTwoPair(checkHand) == true){
			return 3;
		}
		else if(isPair(checkHand) == true){
			return 2;
		}
		else return 1;
		
	}
	
	public void determineWinner(){
		Collections.max(Arrays.asList( suitCheck( playerHand ), suitCheck( ai1 ) , suitCheck( ai2 ) ) );	
		
		if(Arrays.asList(0)!= Arrays.asList(1)){
			System.out.println(Arrays.asList(0).toString());
		}
		
	}
	
	public boolean suitCheck(Hand checkHand){
		int heartsCount = 0;
		int spadesCount = 0;
		int diamondsCount = 0;
		int clubsCount = 0;
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getSuit().equals(hearts) == true){
				heartsCount++;
			}
			else if(checkHand.hand.get(i).getSuit().equals(spades) == true){
				spadesCount++;
			}
			else if(checkHand.hand.get(i).getSuit().equals(diamonds) == true){
				diamondsCount++;
			}
			else{
				clubsCount++;
			}	
		}
		
		if(heartsCount > 4 || spadesCount > 4 || diamondsCount > 4 || clubsCount > 4){
			return true;
		}
		
		return false;
	}
	
	public boolean isRoyalFlush(Hand checkHand){
		ArrayList<Face> face = new ArrayList<Face>();
		
		face.add(ace);
		face.add(king);
		face.add(queen);
		face.add(jack);
		face.add(ten);
		
		ArrayList<Face> compareFace = new ArrayList<Face>();
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			compareFace.add(checkHand.hand.get(i).getFace());
		}
		
		if(suitCheck(checkHand) == true){
			if(compareFace.containsAll(face)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isStraightFlush(Hand checkHand){
				
		if(suitCheck(checkHand) == true){
			if(isStraight(checkHand) == true){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isFourOfAKind(Hand checkHand){
		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		int tenCount = 0;
		int nineCount = 0;
		int eightCount = 0;
		int sevenCount = 0;
		int sixCount = 0;
		int fiveCount = 0;
		int fourCount = 0;
		int threeCount = 0;
		int twoCount = 0;
		
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(ace) == true){
				aceCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(king) == true){
				kingCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(queen) == true){
				queenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(jack) == true){
				jackCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(ten) == true){
				tenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(nine) == true){
				nineCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(eight) == true){
				eightCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(seven) == true){
				sevenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(six) == true){
				sixCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(five) == true){
				fiveCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(four) == true){
				fourCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(three) == true){
				threeCount++;
			}
			else{
				twoCount++;
			}	
		}
		
		if(aceCount > 3 || kingCount > 3 || queenCount > 3 || jackCount > 3 || tenCount > 3 || nineCount > 3 ||
				eightCount > 3 || sevenCount > 3 || sixCount > 3 || fiveCount > 3 || fourCount > 3 || 
				threeCount > 3 || twoCount > 3){
			return true;
		}
		
		return false;
	}
	
	public boolean isFullHouse(Hand checkHand){
		ArrayList<Face> count = new ArrayList<Face>();

		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		int tenCount = 0;
		int nineCount = 0;
		int eightCount = 0;
		int sevenCount = 0;
		int sixCount = 0;
		int fiveCount = 0;
		int fourCount = 0;
		int threeCount = 0;
		int twoCount = 0;
		
		int aceCount2 = 0;
		int kingCount2 = 0;
		int queenCount2 = 0;
		int jackCount2 = 0;
		int tenCount2 = 0;
		int nineCount2 = 0;
		int eightCount2 = 0;
		int sevenCount2 = 0;
		int sixCount2 = 0;
		int fiveCount2 = 0;
		int fourCount2 = 0;
		int threeCount2 = 0;
		int twoCount2 = 0;
		
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(ace) == true){
				aceCount++;
				if(aceCount == 3){
					count.add(ace);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(king) == true){
				kingCount++;
				if(kingCount == 3){
					count.add(king);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(queen) == true){
				queenCount++;
				if(queenCount == 3){
					count.add(queen);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(jack) == true){
				jackCount++;
				if(jackCount == 3){
					count.add(jack);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(ten) == true){
				tenCount++;
				if(tenCount == 3){
					count.add(ten);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(nine) == true){
				nineCount++;
				if(nineCount == 3){
					count.add(nine);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(eight) == true){
				eightCount++;
				if(eightCount == 3){
					count.add(eight);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(seven) == true){
				sevenCount++;
				if(sevenCount == 3){
					count.add(seven);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(six) == true){
				sixCount++;
				if(sixCount == 3){
					count.add(six);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(five) == true){
				fiveCount++;
				if(fiveCount == 3){
					count.add(five);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(four) == true){
				fourCount++;
				if(fourCount == 3){
					count.add(four);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(three) == true){
				threeCount++;
				if(threeCount == 3){
					count.add(three);
				}
			}
			else{
				twoCount++;
				if(twoCount == 3){
					count.add(two);
				}
			}	
		}
		
		if(count.size() > 0){
			for(int j = 0; j < checkHand.hand.size(); j++){
				if(checkHand.hand.get(j).getFace().equals(ace) == true){
					aceCount2++;
					if(aceCount2 == 2  && aceCount != 3){
						count.add(ace);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(king) == true){
					kingCount2++;
					if(kingCount2 == 2  && kingCount != 3){
						count.add(king);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(queen) == true){
					queenCount2++;
					if(queenCount2 == 2 && queenCount != 3){
						count.add(queen);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(jack) == true){
					jackCount2++;
					if(jackCount2 == 2  && jackCount != 3){
						count.add(jack);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(ten) == true){
					tenCount2++;
					if(tenCount2 == 2  && tenCount != 3){
						count.add(ten);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(nine) == true){
					nineCount2++;
					if(nineCount2 == 2  && nineCount != 3){
						count.add(nine);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(eight) == true){
					eightCount2++;
					if(eightCount2 == 2  && eightCount != 3){
						count.add(eight);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(seven) == true){
					sevenCount2++;
					if(sevenCount2 == 2  && sevenCount != 3){
						count.add(seven);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(six) == true){
					sixCount2++;
					if(sixCount2 == 2  && sixCount != 3){
						count.add(six);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(five) == true){
					fiveCount2++;
					if(fiveCount2 == 2  && fiveCount != 3){
						count.add(five);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(four) == true){
					fourCount2++;
					if(fourCount2 == 2  && fourCount != 3){
						count.add(four);
					}
				}
				else if(checkHand.hand.get(j).getFace().equals(three) == true){
					threeCount2++;
					if(threeCount2 == 2  && threeCount != 3){
						count.add(three);
					}
				}
				else{
					twoCount2++;
					if(twoCount2 == 2  && twoCount != 3){
						count.add(two);
					}
				}	
			}
		}
		
		if(count.size() > 1){
			return true;
		}

		
		return false;
	}

	public boolean isFlush(Hand checkHand){
		if(suitCheck(checkHand) == true){
			return true;
		}
		
		return false;
	}
	
	public boolean isStraight(Hand checkHand){
		ArrayList<Face> face = new ArrayList<Face>();
		ArrayList<Face> face2 = new ArrayList<Face>();
		ArrayList<Face> face3 = new ArrayList<Face>();
		ArrayList<Face> face4 = new ArrayList<Face>();
		ArrayList<Face> face5 = new ArrayList<Face>();
		ArrayList<Face> face6 = new ArrayList<Face>();
		ArrayList<Face> face7 = new ArrayList<Face>();
		ArrayList<Face> face8 = new ArrayList<Face>();
		ArrayList<Face> face9 = new ArrayList<Face>();
		ArrayList<Face> face10 = new ArrayList<Face>();
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
		
		face9.add(ten);
		face9.add(jack);
		face9.add(queen);
		face9.add(king);
		face9.add(ace);
		
		face10.add(ace);
		face10.add(two);
		face10.add(three);
		face10.add(four);
		face10.add(five);
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			compareFace.add(checkHand.hand.get(i).getFace());
		}
		
		if(compareFace.containsAll(face)){
			return true;
		}
		
		if(compareFace.containsAll(face2)){
			return true;
		}
		
		if(compareFace.containsAll(face3)){
			return true;
		}
		
		if(compareFace.containsAll(face4)){
			return true;
		}
		
		if(compareFace.containsAll(face5)){
			return true;
		}
		
		if(compareFace.containsAll(face6)){
			return true;
		}
		
		if(compareFace.containsAll(face7)){
			return true;
		}
		
		if(compareFace.containsAll(face8)){
			return true;
		}
		
		if(compareFace.containsAll(face9)){
			return true;
		}
		
		if(compareFace.containsAll(face10)){
			return true;
		}
		
		return false;
	}
	
	public boolean isThreeOfAKind(Hand checkHand){
		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		int tenCount = 0;
		int nineCount = 0;
		int eightCount = 0;
		int sevenCount = 0;
		int sixCount = 0;
		int fiveCount = 0;
		int fourCount = 0;
		int threeCount = 0;
		int twoCount = 0;
		
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(ace) == true){
				aceCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(king) == true){
				kingCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(queen) == true){
				queenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(jack) == true){
				jackCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(ten) == true){
				tenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(nine) == true){
				nineCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(eight) == true){
				eightCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(seven) == true){
				sevenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(six) == true){
				sixCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(five) == true){
				fiveCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(four) == true){
				fourCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(three) == true){
				threeCount++;
			}
			else{
				twoCount++;
			}	
		}
		
		if(aceCount > 2 || kingCount > 2 || queenCount > 2 || jackCount > 2 || tenCount > 2 || nineCount > 2 ||
				eightCount > 2 || sevenCount > 2 || sixCount > 2 || fiveCount > 2 || fourCount > 2 || 
				threeCount > 2 || twoCount > 2){
			return true;
		}
		
		return false;
	}
	
	public boolean isTwoPair(Hand checkHand){
		ArrayList<Face> count = new ArrayList<Face>();

		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		int tenCount = 0;
		int nineCount = 0;
		int eightCount = 0;
		int sevenCount = 0;
		int sixCount = 0;
		int fiveCount = 0;
		int fourCount = 0;
		int threeCount = 0;
		int twoCount = 0;
		
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(ace) == true){
				aceCount++;
				if(aceCount == 2){
					count.add(ace);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(king) == true){
				kingCount++;
				if(kingCount == 2){
					count.add(king);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(queen) == true){
				queenCount++;
				if(queenCount == 2){
					count.add(queen);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(jack) == true){
				jackCount++;
				if(jackCount == 2){
					count.add(jack);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(ten) == true){
				tenCount++;
				if(tenCount == 2){
					count.add(ten);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(nine) == true){
				nineCount++;
				if(nineCount == 2){
					count.add(nine);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(eight) == true){
				eightCount++;
				if(eightCount == 2){
					count.add(eight);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(seven) == true){
				sevenCount++;
				if(sevenCount == 2){
					count.add(seven);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(six) == true){
				sixCount++;
				if(sixCount == 2){
					count.add(six);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(five) == true){
				fiveCount++;
				if(fiveCount == 2){
					count.add(five);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(four) == true){
				fourCount++;
				if(fourCount == 2){
					count.add(four);
				}
			}
			else if(checkHand.hand.get(i).getFace().equals(three) == true){
				threeCount++;
				if(threeCount == 2){
					count.add(three);
				}
			}
			else{
				twoCount++;
				if(twoCount == 2){
					count.add(two);
				}
			}	
		}
		
		if(count.size() > 1){
			return true;
		}

		
		return false;
	}
	
	public boolean isPair(Hand checkHand){
		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		int tenCount = 0;
		int nineCount = 0;
		int eightCount = 0;
		int sevenCount = 0;
		int sixCount = 0;
		int fiveCount = 0;
		int fourCount = 0;
		int threeCount = 0;
		int twoCount = 0;
		
		
		for(int i = 0; i < checkHand.hand.size(); i++){
			if(checkHand.hand.get(i).getFace().equals(ace) == true){
				aceCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(king) == true){
				kingCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(queen) == true){
				queenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(jack) == true){
				jackCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(ten) == true){
				tenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(nine) == true){
				nineCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(eight) == true){
				eightCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(seven) == true){
				sevenCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(six) == true){
				sixCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(five) == true){
				fiveCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(four) == true){
				fourCount++;
			}
			else if(checkHand.hand.get(i).getFace().equals(three) == true){
				threeCount++;
			}
			else{
				twoCount++;
			}	
		}
		
		if(aceCount > 1 || kingCount > 1 || queenCount > 1 || jackCount > 1 || tenCount > 1 || nineCount > 1 ||
				eightCount > 1 || sevenCount > 1 || sixCount > 1 || fiveCount > 1 || fourCount > 1 || 
				threeCount > 1 || twoCount > 1){
			return true;
		}
		
		return false;
	}
	
	public boolean isHighCard(Hand checkHand){
		return true;
	}
	
}
