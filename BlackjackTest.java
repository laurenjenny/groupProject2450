package groupProject;

import java.util.Scanner;

public class BlackjackTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Blackjack game = new Blackjack();
		
		game.newGame();
		
		System.out.println("Your cards are: " + game.playerHand.hand);
		
		game.compPlay();
		
		System.out.println("Hit(0) or Stay(1)?");
		
		int userChoice = input.nextInt();
		
		if(userChoice == 0){
			game.playerHand.addCard(game.deck.draw(1));
		}
		else{
			game.stay();
		}
		
		System.out.println("Your cards are: " + game.playerHand.hand);
	}

}
