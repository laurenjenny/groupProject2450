package groupProject;

public class PokerTest {

	public static void main(String[] args){
		Poker game = new Poker();
		int value;
		
		game.newGame();
		
		game.theFlop();
		
		game.theTurn();
		
		game.theRiver();
		
		game.playerHand.hand.addAll(game.table.hand);
		
		System.out.println(game.playerHand.hand);
		
		game.isRoyalFlush(game.playerHand);
		
		value = game.isRoyalFlush(game.playerHand);
		
		System.out.println("isRoyalFlush " + value);
		
		value = game.isStraightFlush(game.playerHand);
		
		System.out.println("isStraightFlush " + value);
		
		value = game.isFourOfAKind(game.playerHand);
		
		System.out.println("isFourOfAKind " + value);
		
		value = game.isFullHouse(game.playerHand);
		
		System.out.println("isFullHouse " + value);
		
		value = game.isFlush(game.playerHand);
		
		System.out.println("isFlush " + value);
		
		value = game.isStraight(game.playerHand);
		
		System.out.println("isStraight " + value);
		
		value = game.isThreeOfAKind(game.playerHand);
		
		System.out.println("isThreeOfAKind " + value);
		
		value = game.isTwoPair(game.playerHand);
		
		System.out.println("isTwoPair " + value);
		
		value = game.isPair(game.playerHand);
		
		System.out.println("isPair " + value);
		
		value = game.isHighCard(game.playerHand);
		
		System.out.println("isHighCard " + value);
		
	}
}
