package groupProject;


import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7243492624009395201L;
	JButton btnExit;
	JButton btnBlackjack;
	JButton btnPoker;
	JButton btnWar;
	
	public MenuPanel()
	{
		setBackground(Color.WHITE);
		setLayout(null);
		
		btnBlackjack = new JButton("Blackjack");
		btnBlackjack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(Main.frame.getContentPane().getLayout());
				cl.show(Main.frame.getContentPane(), "BlackJack");
			}
		});
		btnBlackjack.setBackground(Color.LIGHT_GRAY);
		btnBlackjack.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnBlackjack.setBounds(542, 245, 150, 50);
		add(btnBlackjack);
		
		btnPoker = new JButton("Poker");
		btnPoker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(Main.frame.getContentPane().getLayout());
				cl.show(Main.frame.getContentPane(), "Poker");
			}
		});
		btnPoker.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnPoker.setBackground(Color.LIGHT_GRAY);
		btnPoker.setBounds(542, 317, 150, 50);
		add(btnPoker);
		
		btnWar = new JButton("War");
		btnWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(Main.frame.getContentPane().getLayout());
				cl.show(Main.frame.getContentPane(), "War");
			}
		});
		btnWar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnWar.setBackground(Color.LIGHT_GRAY);
		btnWar.setBounds(542, 387, 150, 50);
		add(btnWar);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(542, 459, 150, 50);
		add(btnExit);
	}
}
