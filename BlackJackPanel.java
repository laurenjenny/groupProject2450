package groupProject;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class BlackJackPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPanel menu = new JPanel();
	//Totals
    final JLabel playerTotal = new JLabel();
    final JLabel dealerTotal = new JLabel();
    final JLabel ai1Total = new JLabel();
    final JLabel ai2Total = new JLabel();
    //Card labels
    final JLabel playerCard1 = new JLabel();
    final JLabel playerCard2 = new JLabel();
    final JLabel playerCard3 = new JLabel();
    final JLabel playerCard4 = new JLabel();
    final JLabel playerCard5 = new JLabel();
    final JLabel playerCard6 = new JLabel();
    final JLabel dealerCard1 = new JLabel();
    final JLabel dealerCard2 = new JLabel();
    final JLabel dealerCard3 = new JLabel();
    final JLabel dealerCard4 = new JLabel();
    final JLabel dealerCard5 = new JLabel();
    final JLabel dealerCard6 = new JLabel();
    final JLabel ai1Card1 = new JLabel();
    final JLabel ai1Card2 = new JLabel();
    final JLabel ai1Card3 = new JLabel();
    final JLabel ai1Card4 = new JLabel();
    final JLabel ai1Card5 = new JLabel();
    final JLabel ai1Card6 = new JLabel();
    final JLabel ai2Card1 = new JLabel();
    final JLabel ai2Card2 = new JLabel();
    final JLabel ai2Card3 = new JLabel();
    final JLabel ai2Card4 = new JLabel();
    final JLabel ai2Card5 = new JLabel();
    final JLabel ai2Card6 = new JLabel();
    final ImageIcon backOfCard = new ImageIcon(getClass().getResource("Images/Back.png"));
    //Buttons
    JButton btnStay = new JButton("STAY");
    JButton btnHit = new JButton("HIT");
    JLabel message = new JLabel();
    final JButton dealNewCards = new JButton("New Deal");
    final JButton quit = new JButton("Quit");
    Blackjack game = new Blackjack();
    int hitCount = 0;
    
	/**
	 * Create the panel.
	 */
	public BlackJackPanel()
	{	
		setBackground(Color.LIGHT_GRAY);
		setBounds(15, 16, 1120, 796);
		setLayout(null);
        
        menu.setForeground(Color.WHITE);
        menu.setBounds(349, 174, 564, 368);
        menu.setLayout(null);
        add(menu);
        
        dealNewCards.setFont(new Font("Tahoma", Font.PLAIN, 13));
        dealNewCards.setBounds(217, 152, 150, 50);
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

        //Win/Lose Message
        message.setFont(new Font("Sitka Text", Font.BOLD, 30));
        message.setForeground(Color.BLACK);
        message.setBounds(183, 38, 200, 60);
        message.setHorizontalAlignment(SwingConstants.RIGHT);
       
        menu.add(message);

        //Totals
        //Dealer
        dealerTotal.setOpaque(true);
        dealerTotal.setBackground(Color.BLACK);
        dealerTotal.setForeground(Color.WHITE);
        dealerTotal.setBorder(UIManager.getBorder("DesktopIcon.border"));
        dealerTotal.setBounds(570, 244, 130, 33);
        dealerTotal.setText("");
        dealerTotal.setHorizontalAlignment(SwingConstants.CENTER);
        add(dealerTotal);
        //Player
        playerTotal.setBorder(UIManager.getBorder("DesktopIcon.border"));
        playerTotal.setBackground(Color.BLACK);
        playerTotal.setForeground(Color.WHITE);
        playerTotal.setOpaque(true);
        playerTotal.setBounds(570, 413, 130, 33);
        playerTotal.setText(String.valueOf(game.playerHand.value()));
        playerTotal.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerTotal);
        //AI 1
        ai1Total.setBorder(UIManager.getBorder("DesktopIcon.border"));
        ai1Total.setBackground(Color.BLACK);
        ai1Total.setForeground(Color.WHITE);
        ai1Total.setOpaque(true);
        ai1Total.setBounds(170, 400, 130, 33);
        ai1Total.setText(String.valueOf(game.playerHand.value()));
        ai1Total.setHorizontalAlignment(SwingConstants.CENTER);
        add(ai1Total);
        //AI 2
        ai2Total.setBorder(UIManager.getBorder("DesktopIcon.border"));
        ai2Total.setBackground(Color.BLACK);
        ai2Total.setForeground(Color.WHITE);
        ai2Total.setOpaque(true);
        ai2Total.setBounds(980, 400, 130, 33);
        ai2Total.setText(String.valueOf(game.playerHand.value()));
        ai2Total.setHorizontalAlignment(SwingConstants.CENTER);
        add(ai2Total);
        
      //**CARDS**
        //Player Card 1

		playerCard1.setBounds(507, 455, 151, 217);
        //Card 2
        
        playerCard2.setBounds(535, 455, 151, 217);
        //Card 3
        playerCard3.setBounds(560, 455, 151, 217);
        playerCard3.setVisible(false);
        //Card 4
        playerCard4.setBounds(588, 455, 151, 217);
        playerCard4.setVisible(false);
        //Card 5
        playerCard5.setBounds(616, 455, 151, 217);
        playerCard5.setVisible(false);
        //Card 6
        playerCard6.setBounds(644, 455, 151, 217);
        playerCard6.setVisible(false);

        //Dealer Card 1
        
        dealerCard1.setBounds(507, 11, 151, 217);
        //Card 2
        dealerCard2.setBounds(535, 11, 151, 217);
        
        //Card 3
        dealerCard3.setVisible(false);
        dealerCard3.setBounds(560, 11, 151, 217);
        //Card 4
        dealerCard4.setVisible(false);
        dealerCard4.setBounds(588, 11, 151, 217);
        dealerCard4.setIcon(backOfCard);
        //Card 5
        dealerCard5.setVisible(false);
        dealerCard5.setBounds(616, 11, 151, 217);
        //Card 6
        dealerCard6.setVisible(false);
        dealerCard6.setBounds(644, 11, 151, 217);
        
        //AI cards

        ai1Card1.setBounds(107, 455, 151, 217);
              
        ai1Card2.setBounds(135, 455, 151, 217);
    
        ai1Card3.setBounds(160, 455, 151, 217);
        ai1Card3.setVisible(false);
    
        ai1Card4.setBounds(188, 455, 151, 217);
        ai1Card4.setVisible(false);
          
        ai1Card5.setBounds(216, 455, 151, 217);
        ai1Card5.setVisible(false);
             
        ai1Card6.setBounds(244, 455, 151, 217);
        ai1Card6.setVisible(false);
        
        ai2Card1.setBounds(907, 455, 151, 217);
        
        ai2Card2.setBounds(935, 455, 151, 217);
    
        ai2Card3.setBounds(960, 455, 151, 217);
        ai2Card3.setVisible(false);
    
        ai2Card4.setBounds(988, 455, 151, 217);
        ai2Card4.setVisible(false);
          
        ai2Card5.setBounds(1016, 455, 151, 217);
        ai2Card5.setVisible(false);
             
        ai2Card6.setBounds(1044, 455, 151, 217);
        ai2Card6.setVisible(false);
        
      //Adding the Cards to the Panel. This order will determine which cards on are top/bottom
        add(playerCard6);
        add(playerCard5);
        add(playerCard4);
        add(playerCard3);
        add(playerCard2);
        add(playerCard1);

        add(dealerCard6);
        add(dealerCard5);
        add(dealerCard4);
        add(dealerCard3);
        add(dealerCard2);
        add(dealerCard1);
        
        add(ai1Card1);
        add(ai1Card2);
        add(ai1Card3);
        add(ai1Card4);
        add(ai1Card5);
        add(ai1Card6);
        
        add(ai2Card1);
        add(ai2Card2);
        add(ai2Card3);
        add(ai2Card4);
        add(ai2Card5);
        add(ai2Card6);


        //Hit Button
		btnHit.setToolTipText("Draw another card");
		btnHit.setBackground(Color.BLACK);
		btnHit.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnHit.setForeground(Color.WHITE);
		btnHit.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnHit.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnHit.setBounds(478, 699, 115, 29);
        btnHit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Hit button Action
        btnHit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.hit();
                switch (hitCount){
                    case 0: playerCard3.setIcon(game.playerHand.hand.get(2).getIcon());
                        playerCard3.setVisible(true);
                        break;
                    case 1: playerCard4.setIcon(game.playerHand.hand.get(3).getIcon());
                        playerCard4.setVisible(true);
                        break;
                    case 2: playerCard5.setIcon(game.playerHand.hand.get(4).getIcon());
                        playerCard5.setVisible(true);
                        break;
                    case 3: playerCard6.setIcon(game.playerHand.hand.get(5).getIcon());
                        playerCard6.setVisible(true);
                        break;
                }
                playerTotal.setText(String.valueOf(game.playerHand.value()));
                ++hitCount;
                if(game.endGame){
                    endGame();
                }
            }
        });
        
		add(btnHit);

        //Stay button
		btnStay.setToolTipText("Don't draw another card");
		btnStay.setForeground(Color.WHITE);
		btnStay.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnStay.setBackground(Color.BLACK);
		btnStay.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStay.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnStay.setBounds(679, 699, 115, 29);
        btnStay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Stay button action
        btnStay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealerCard2.setIcon(game.dealerHand.hand.get(1).getIcon());
                game.stay();
                switch (game.ai1.hand.size()){
                    case 3: dealerCard3.setIcon(game.ai1.hand.get(2).getIcon());
                        ai1Card3.setVisible(true);
                        break;
                    case 4:
                    	ai1Card3.setIcon(game.ai1.hand.get(2).getIcon());
                    	ai1Card3.setVisible(true);
                    	ai1Card4.setIcon(game.ai1.hand.get(3).getIcon());
                    	ai1Card4.setVisible(true);
                        break;
                    case 5:
                    	ai1Card3.setIcon(game.ai1.hand.get(2).getIcon());
                    	ai1Card3.setVisible(true);
                    	ai1Card4.setIcon(game.ai1.hand.get(3).getIcon());
                    	ai1Card4.setVisible(true);
                    	ai1Card5.setIcon(game.ai1.hand.get(4).getIcon());
                    	ai1Card5.setVisible(true);
                        break;
                    case 6:
                    	ai1Card3.setIcon(game.ai1.hand.get(2).getIcon());
                    	ai1Card3.setVisible(true);
                    	ai1Card4.setIcon(game.ai1.hand.get(3).getIcon());
                    	ai1Card4.setVisible(true);
                    	ai1Card5.setIcon(game.ai1.hand.get(4).getIcon());
                    	ai1Card5.setVisible(true);
                    	ai1Card6.setIcon(game.ai1.hand.get(5).getIcon());
                    	ai1Card6.setVisible(true);
                        break;
                }
                switch (game.ai2.hand.size()){
                    case 3: dealerCard3.setIcon(game.ai2.hand.get(2).getIcon());
                        ai2Card3.setVisible(true);
                        break;
                    case 4:
                    	ai2Card3.setIcon(game.ai2.hand.get(2).getIcon());
                    	ai2Card3.setVisible(true);
                    	ai2Card4.setIcon(game.ai2.hand.get(3).getIcon());
                    	ai2Card4.setVisible(true);
                        break;
                    case 5:
                    	ai2Card3.setIcon(game.ai2.hand.get(2).getIcon());
                    	ai2Card3.setVisible(true);
                    	ai2Card4.setIcon(game.ai2.hand.get(3).getIcon());
                    	ai2Card4.setVisible(true);
                    	ai2Card5.setIcon(game.ai2.hand.get(4).getIcon());
                    	ai2Card5.setVisible(true);
                        break;
                    case 6:
                    	ai2Card3.setIcon(game.ai2.hand.get(2).getIcon());
                    	ai2Card3.setVisible(true);
                    	ai2Card4.setIcon(game.ai2.hand.get(3).getIcon());
                    	ai2Card4.setVisible(true);
                    	ai2Card5.setIcon(game.ai2.hand.get(4).getIcon());
                    	ai2Card5.setVisible(true);
                    	ai2Card6.setIcon(game.ai2.hand.get(5).getIcon());
                    	ai2Card6.setVisible(true);
                        break;
                }
                switch (game.dealerHand.hand.size()){
                    case 3: dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
                        dealerCard3.setVisible(true);
                        break;
                    case 4:
                        dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
                        dealerCard3.setVisible(true);
                        dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
                        dealerCard4.setVisible(true);
                        break;
                    case 5:
                        dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
                        dealerCard3.setVisible(true);
                        dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
                        dealerCard4.setVisible(true);
                        dealerCard5.setIcon(game.dealerHand.hand.get(4).getIcon());
                        dealerCard5.setVisible(true);
                        break;
                    case 6:
                        dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
                        dealerCard3.setVisible(true);
                        dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
                        dealerCard4.setVisible(true);
                        dealerCard5.setIcon(game.dealerHand.hand.get(4).getIcon());
                        dealerCard5.setVisible(true);
                        dealerCard6.setIcon(game.dealerHand.hand.get(5).getIcon());
                        dealerCard6.setVisible(true);
                        break;
                }
                ai1Total.setText(String.valueOf(game.ai1.value()));
                ai2Total.setText(String.valueOf(game.ai2.value()));
                dealerTotal.setText(String.valueOf(game.dealerHand.value()));
                endGame();
            }
        });
		add(btnStay);
		
		JLabel panel_1 = new JLabel();
		panel_1.setIcon(new ImageIcon(BlackJackPanel.class.getResource("/groupProject/Images/table_trans.png")));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 51, 0));
		panel_1.setBounds(0, 0, 1249, 799);
		add(panel_1);
	}

    //Resetting the cards for a new deal
    public void resetCards(){
  
        //Cards
    	playerCard1.setIcon(game.playerHand.hand.get(0).getIcon());
        playerCard2.setIcon(game.playerHand.hand.get(1).getIcon());
        playerCard3.setVisible(false);
        playerCard4.setVisible(false);
        playerCard5.setVisible(false);
        playerCard6.setVisible(false);
        dealerCard1.setIcon(game.dealerHand.hand.get(0).getIcon());
        dealerCard2.setIcon(backOfCard);
        dealerCard3.setVisible(false);
        dealerCard4.setVisible(false);
        dealerCard5.setVisible(false);
        dealerCard6.setVisible(false);
        ai1Card1.setIcon(game.ai1.hand.get(0).getIcon());
        ai1Card2.setIcon(game.ai1.hand.get(1).getIcon());
        ai1Card3.setVisible(false);
        ai1Card4.setVisible(false);
        ai1Card5.setVisible(false);
        ai1Card6.setVisible(false);
        ai2Card1.setIcon(game.ai2.hand.get(0).getIcon());
        ai2Card2.setIcon(game.ai2.hand.get(1).getIcon());
        ai2Card3.setVisible(false);
        ai2Card4.setVisible(false);
        ai2Card5.setVisible(false);
        ai2Card6.setVisible(false);
        

        //Totals
        playerTotal.setText(String.valueOf(game.playerHand.value()));
        dealerTotal.setText(String.valueOf(game.dealerHand.value()));
        ai1Total.setText(String.valueOf(game.ai1.value()));
        ai2Total.setText(String.valueOf(game.ai2.value()));

        //Hit count
        hitCount = 0;

        //Buttons
        btnHit.setEnabled(true);
        btnStay.setEnabled(true);
        message.setVisible(false);
        menu.setVisible(false);
        
        //end game immediately if blackjack
        if(game.endGame == true)
        {
        	dealerCard2.setIcon(game.dealerHand.hand.get(1).getIcon());
        	endGame();
        }
    }

    //Ending the game
    public void endGame(){
        if(game.playerBusts) {
            message.setText("You Bust!");
            message.setVisible(true);
            disableButtons();
        }
        if(game.playerWins && !game.playerBusts){
            message.setText("You Win!");
            message.setVisible(true);
            dealerTotal.setText(String.valueOf(game.dealerHand.value()));
            disableButtons();
        }
        if(game.dealerBusts){
            message.setText("Dealer Busts!");
            message.setVisible(true);
            dealerTotal.setText(String.valueOf(game.dealerHand.value()));
            disableButtons();
        }
        if(game.playerPush){
        	message.setText("Push!");
        	message.setVisible(true);
        	dealerTotal.setText(String.valueOf(game.dealerHand.value()));
            disableButtons();
        }
    }

    //Disabling the buttons
    public void disableButtons(){
        btnHit.setEnabled(false);
        btnStay.setEnabled(false);
        menu.setVisible(true);
    }
}
