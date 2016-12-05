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
			System.out.println("Your cards are: " + game.playerHand.hand);
		}
		else{
			game.size++;
			game.stayOrBust[3] = game.stay();
		}
		
		while(game.size < 4){
			game.compPlay();
			
			if(game.playerHand.value() > 21){
				game.size++;
				game.stayOrBust[3] = game.stay();
			}
			else{
				if(userChoice == 0){
					game.playerHand.addCard(game.deck.draw(1));
				}
				else{
					game.size++;
					game.stayOrBust[3] = game.stay();
				}
				
				System.out.println("Your cards are: " + game.playerHand.hand);
			}
		}
		
		//System.out.println("The winner is " + game.checkWinner());
	}
	
	

}
