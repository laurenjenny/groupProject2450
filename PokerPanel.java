package groupProject;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PokerPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1315651565131L;
	final JPanel menu = new JPanel();
	
    //Card labels
    final JLabel playerCard1 = new JLabel();
    final JLabel playerCard2 = new JLabel();

    final JLabel dealerCard1 = new JLabel();
    final JLabel dealerCard2 = new JLabel();
    final JLabel dealerCard3 = new JLabel();
    final JLabel dealerCard4 = new JLabel();
    final JLabel dealerCard5 = new JLabel();

    final JLabel ai1Card1 = new JLabel();
    final JLabel ai1Card2 = new JLabel();

    final JLabel ai2Card1 = new JLabel();
    final JLabel ai2Card2 = new JLabel();

    final ImageIcon backOfCard = new ImageIcon(getClass().getResource("Images/Back.png"));
    //Buttons
    JButton btnDraw = new JButton("Draw Turn");
    JLabel message = new JLabel();
    JLabel messageAI1 = new JLabel();
    JLabel messageAI2 = new JLabel();
    final JButton dealNewCards = new JButton("New Game");
    final JButton quit = new JButton("Quit");
    Poker game = new Poker();
    int drawCount = 0;
    
	/**
	 * Create the panel.
	 */
	public PokerPanel()
	{	
		setBackground(Color.LIGHT_GRAY);
		setBounds(15, 16, 1120, 796);
		setLayout(null);
        
        menu.setForeground(Color.WHITE);
        menu.setBounds(863, 11, 332, 368);
        menu.setLayout(null);
        menu.setVisible(true);
        add(menu);
        
        dealNewCards.setFont(new Font("Tahoma", Font.PLAIN, 13));
        dealNewCards.setBounds(107, 153, 150, 50);
        dealNewCards.setFocusable(false);
        dealNewCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dealNewCards.setBackground(Color.LIGHT_GRAY);
        dealNewCards.setVisible(true);
        dealNewCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.newGame();
                resetCards();
            }
        });
        menu.add(dealNewCards);
        
        quit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        quit.setBounds(107, 241, 150, 50);
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

        //Win/Lose Message
        message.setFont(new Font("Sitka Text", Font.BOLD, 30));
        message.setForeground(Color.BLACK);
        message.setBounds(73, 39, 200, 60);
        message.setHorizontalAlignment(SwingConstants.CENTER);
       
        menu.add(message);
        
        messageAI1.setFont(new Font("Sitka Text", Font.BOLD, 30));
        messageAI1.setForeground(Color.BLACK);
        messageAI1.setBackground(Color.LIGHT_GRAY);
        messageAI1.setBounds(935, 524, 200, 60);
        messageAI1.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageAI1);
        
        
        messageAI2.setFont(new Font("Sitka Text", Font.BOLD, 30));
        messageAI2.setForeground(Color.BLACK);
        messageAI2.setBackground(Color.LIGHT_GRAY);
        messageAI2.setBounds(107, 524, 200, 60);
        messageAI2.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageAI2);
        
      //**CARDS**
        //Player Card 1
		playerCard1.setBounds(507, 455, 151, 217);
        //Card 2  
        playerCard2.setBounds(535, 455, 151, 217);

        //Dealer Card 1       
        dealerCard1.setBounds(507, 11, 151, 217);
        //Card 2
        dealerCard2.setBounds(535, 11, 151, 217);
        //Card 3
        dealerCard3.setBounds(560, 11, 151, 217);
        //Card 4
        dealerCard4.setVisible(false);
        dealerCard4.setBounds(588, 11, 151, 217);
        //Card 5
        dealerCard5.setVisible(false);
        dealerCard5.setBounds(616, 11, 151, 217);
        
        //AI cards
        ai2Card1.setBounds(107, 455, 151, 217);              
        ai2Card2.setBounds(135, 455, 151, 217);
    
        ai1Card1.setBounds(907, 455, 151, 217);       
        ai1Card2.setBounds(935, 455, 151, 217);
    
        
      //Adding the Cards to the Panel. This order will determine which cards on are top/bottom
        add(playerCard2);
        add(playerCard1);

        add(dealerCard5);
        add(dealerCard4);
        add(dealerCard3);
        add(dealerCard2);
        add(dealerCard1);
        
        add(ai1Card1);
        add(ai1Card2);
        
        add(ai2Card1);
        add(ai2Card2);


        //Hit Button
		btnDraw.setToolTipText("Deal Next Card");
		btnDraw.setBackground(Color.BLACK);
		btnDraw.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnDraw.setForeground(Color.WHITE);
		btnDraw.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnDraw.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDraw.setBounds(478, 699, 115, 29);
        btnDraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Hit button Action
        btnDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	switch(drawCount) {
            		case 0:
            			turn();
            			break;
            		case 1:
            			river();
            			break;
            	}
            	drawCount++;
            }
        });
        
		add(btnDraw);
		
		JLabel panel_1 = new JLabel();
		panel_1.setIcon(new ImageIcon(PokerPanel.class.getResource("/groupProject/Images/poker_table.png")));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 51, 0));
		panel_1.setBounds(0, 0, 1249, 799);
		add(panel_1);
	}

	private void river() {
		game.theRiver();
		dealerCard5.setIcon(game.table.hand.get(4).getIcon());
		dealerCard5.setVisible(true);
		endGame();
	}

	private void turn() {
		game.theTurn();
		dealerCard4.setIcon(game.table.hand.get(3).getIcon());
		dealerCard4.setVisible(true);
		btnDraw.setText("Draw River");
	}
	
    //Resetting the cards for a new deal
    public void resetCards(){
    	
    	//Buttons
        btnDraw.setEnabled(true);
        message.setVisible(false);
        messageAI1.setVisible(false);
        messageAI1.setOpaque(false);
        messageAI2.setVisible(false);
        messageAI2.setOpaque(false);
        menu.setVisible(false);
        game.theFlop();
        //Cards
        ai1Card1.setIcon(game.ai1.hand.get(0).getIcon());
        ai1Card2.setIcon(game.ai1.hand.get(1).getIcon());
        
    	playerCard1.setIcon(game.playerHand.hand.get(0).getIcon());
        playerCard2.setIcon(game.playerHand.hand.get(1).getIcon());     
        
        ai2Card1.setIcon(game.ai2.hand.get(0).getIcon());
        ai2Card2.setIcon(game.ai2.hand.get(1).getIcon());
        
        dealerCard1.setIcon(game.table.hand.get(0).getIcon());
        dealerCard2.setIcon(game.table.hand.get(1).getIcon());
        dealerCard3.setIcon(game.table.hand.get(2).getIcon());
        dealerCard4.setVisible(false);
        dealerCard5.setVisible(false);
        
        drawCount = 0;
    }
    

    //Ending the game
    public void endGame(){
        disableButtons();
    }

    //Disabling the buttons
    public void disableButtons(){
        btnDraw.setEnabled(false);
        menu.setVisible(true);
    }
}
