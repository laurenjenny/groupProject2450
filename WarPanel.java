package groupProject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class WarPanel extends JPanel
{
	final JPanel menu = new JPanel();
	final List<JLabel> playerCards = new ArrayList<JLabel>();
	final List<JLabel> AICards = new ArrayList<JLabel>();
	final ImageIcon backOfCard = new ImageIcon(getClass().getResource("Images/Back.png"));
	JButton playBtn = new JButton("Draw Card");
	JLabel message = new JLabel("WAR");
	JLabel gameMessage = new JLabel();
	JLabel playerTitle = new JLabel("Player");
	JLabel AITitle = new JLabel("AI");
	final JLabel playerTotal = new JLabel();
    final JLabel ai1Total = new JLabel();
	final JButton newGame = new JButton("New Game");
    final JButton quit = new JButton("Quit");
    JButton draw = new JButton("Draw");
    War game = new War();
    boolean win = false;
    
    final JLabel ai1Card1 = new JLabel();
    final JLabel playerCard1 = new JLabel();
    
	private static final long serialVersionUID = 1L;

	public WarPanel()
	{
		setBackground(new Color(0, 128, 0));
		setBounds(15, 16, 1120, 796);
		setLayout(null);
        
        menu.setForeground(Color.WHITE);
        menu.setBounds(349, 174, 564, 368);
        menu.setLayout(null);
        add(menu);
        
        newGame.setFont(new Font("Tahoma", Font.PLAIN, 13));
        newGame.setBounds(217, 152, 150, 50);
        newGame.setFocusable(false);
        newGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newGame.setBackground(Color.LIGHT_GRAY);
        newGame.setVisible(true);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.playGame();
                resetCards();
            }
        });
        menu.add(newGame);
        
        quit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        quit.setBounds(217, 240, 150, 50);
        quit.setFocusable(false);
        quit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quit.setBackground(Color.LIGHT_GRAY);
        quit.setVisible(true);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CardLayout cl = (CardLayout)(Main.frame.getContentPane().getLayout());
				cl.show(Main.frame.getContentPane(), "Menu");
            }
        });
        menu.add(quit);
        
        message.setFont(new Font("Sitka Text", Font.BOLD, 30));
        message.setForeground(Color.BLACK);
        message.setBounds(183, 38, 200, 60);
        message.setHorizontalAlignment(SwingConstants.CENTER);
       
        menu.add(message);
        
        gameMessage.setBounds(380, 250, 500, 60);
        gameMessage.setFont(new Font("Sitka Text", Font.BOLD, 30));
        gameMessage.setForeground(Color.BLACK);
        gameMessage.setHorizontalAlignment(SwingConstants.CENTER);
        add(gameMessage);
        
        playerTitle.setBounds(894, 185, 200, 60);
        playerTitle.setFont(new Font("Sitka Text", Font.BOLD, 50));
        playerTitle.setForeground(Color.BLACK);
        playerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerTitle);
        
        AITitle.setBounds(165, 185, 200, 60);
        AITitle.setFont(new Font("Sitka Text", Font.BOLD, 50));
        AITitle.setForeground(Color.BLACK);
        AITitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(AITitle);
        
        playerTotal.setBackground(Color.BLACK);
        playerTotal.setForeground(Color.WHITE);
        playerTotal.setOpaque(true);
        playerTotal.setBounds(899, 566, 130, 33);
        playerTotal.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerTotal);
        //AI 1
        ai1Total.setBackground(Color.BLACK);
        ai1Total.setForeground(Color.WHITE);
        ai1Total.setOpaque(true);
        ai1Total.setBounds(209, 566, 130, 33);
        ai1Total.setHorizontalAlignment(SwingConstants.CENTER);
        add(ai1Total);
        
        playBtn.setVisible(false);
        playBtn.setToolTipText("Draw");
        playBtn.setBackground(Color.BLACK);
        playBtn.setForeground(Color.WHITE);
        playBtn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        playBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        playBtn.setBounds(584, 568, 115, 29);
        playBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Hit button Action
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	
                win = game.playRound();
                draw();
            }
        });
        
		add(playBtn);
		playerCard1.setBounds(923, 263, 151, 217);
		playerCard1.setVisible(false);
		add(playerCard1);
		ai1Card1.setBounds(188, 250, 151, 217);
		add(ai1Card1);
		
		JLabel lblCardsLeft = new JLabel("Cards left");
		lblCardsLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardsLeft.setBounds(241, 610, 61, 14);
		add(lblCardsLeft);
		
		JLabel label = new JLabel("Cards left");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(933, 610, 61, 14);
		add(label);
		ai1Card1.setVisible(false);
		
	}
	
public void resetCards(){
    	
    	//Buttons
        draw.setEnabled(true);
        playBtn.setVisible(true);
        message.setVisible(false);
        gameMessage.setVisible(false);
        menu.setVisible(false);
        ai1Total.setText(String.valueOf(game.aiDeck.deckList.size()));
        playerTotal.setText(String.valueOf(game.playerDeck.deckList.size()));
        
        //Cards
        ai1Card1.setVisible(false);
        playerCard1.setVisible(false);
    }

public void draw(){
	ai1Card1.setIcon(game.aiDeck.deckList.get(0).getIcon());
    playerCard1.setIcon(game.playerDeck.deckList.get(0).getIcon());
    ai1Card1.setVisible(true);
    playerCard1.setVisible(true);
    gameMessage.setVisible(true);
    ai1Total.setText(String.valueOf(game.aiDeck.deckList.size()));
    playerTotal.setText(String.valueOf(game.playerDeck.deckList.size()));
    
    if(win)
    	gameMessage.setText("Player Wins Round");
    else
    	gameMessage.setText("AI Wins Round");
    
    if((game.playerDeck.deckList.size() == 0) || (game.aiDeck.deckList.size() == 0)){
    	win = game.determineWinner();
    	end();
    }
}

public void end(){
	draw.setEnabled(false);
	message.setVisible(true);
	gameMessage.setVisible(false);
	menu.setVisible(true);
	playBtn.setVisible(false);
	
	if(win)
    	message.setText("Player Wins");
    else
    	message.setText("AI Wins");
}
}
