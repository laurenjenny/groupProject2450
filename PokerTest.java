package groupProject;

public class PokerTest {

	public static void main(String[] args){
		Poker game = new Poker();
		boolean value;
		
		game.newGame();
		
		game.theFlop();
		
		game.theTurn();
		
		game.theRiver();
		
		game.playerHand.hand.addAll(game.table.hand);
		
		game.ai1.hand.addAll(game.table.hand);
		
		game.ai2.hand.addAll(game.table.hand);
		
		game.ai3.hand.addAll(game.table.hand);
		
		System.out.println(game.playerHand.hand);
		
		System.out.println(game.checkHandValues(game.playerHand));
		
		System.out.println(game.ai1.hand);
		
		System.out.println(game.checkHandValues(game.ai1));
		
		System.out.println(game.ai2.hand);
		
		System.out.println(game.checkHandValues(game.ai2));
		
		System.out.println(game.ai3.hand);
		
		System.out.println(game.checkHandValues(game.ai3));
	}
}
