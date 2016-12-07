package groupProject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel{

	private ImageIcon icon;
	
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS}

	public enum Face{
		Ace(14), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7),
		Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);

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
		this.icon = new ImageIcon(getClass().getResource("Images/" + this.toString() + ".png"));
	}

	public Face getFace(){
		return face;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public ImageIcon getIcon()
	{
		return icon;
	}

	@Override
	public String toString(){
		return "" + suit + face;
	}
}
