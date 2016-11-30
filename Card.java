package groupProject;

public class Card{

	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS}

	public enum Face{
		Ace(11), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7),
		Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

		private int value;

		private Face(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}

	}
	
	private final Suit suit;
	private final Face face;
	
	Card(Suit suit, Face face){
		this.face = face;
		this.suit = suit;	
	}

	public Face getFace(){
		return face;
	}
	
	public Suit getSuit(){
		return suit;
	}

	@Override
	public String toString(){
		return "" + suit + face;
	}
}
