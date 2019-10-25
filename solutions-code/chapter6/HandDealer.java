package chapter6;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HandDealer extends JFrame
{
	public HandDealer()
	{
		super("Hand Dealer");
		
		final HandPanel aNorth = new HandPanel();
		
		setLayout(new BorderLayout());
		add(aNorth, BorderLayout.CENTER);
		
		final JButton deal = new JButton("Deal");
		add(deal, BorderLayout.SOUTH);
		deal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				aNorth.showHand(dealHand());
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new HandDealer();
	}
	
	private static Card[] dealHand()
	{
		Card[] lReturn = new Card[13];
		Deck deck = new Deck();
		for( int i = 0; i < 13; i++)
		{
			lReturn[i] = deck.draw();
		}
		return lReturn;
	}
}

@SuppressWarnings("serial")
class HandPanel extends JPanel
{
	private static final Color CASINO_GREEN = new Color(0,102,0);

	private JLabel aLabel = new JLabel();
	
	public HandPanel()
	{
		setBackground(CASINO_GREEN);
		add(aLabel);
		aLabel.setIcon(CardImages.getBack());
	}
	
	public void showHand(Card[] pHand)
	{
		aLabel.setIcon(CardImages.getJoker());
	}
}