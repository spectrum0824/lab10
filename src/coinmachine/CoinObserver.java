package coinmachine;
import java.awt.*;

import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.Observable;
import javax.swing.SwingConstants;

public class CoinObserver extends JFrame implements Observer{
	public CoinObserver(){
		super("asdsadsa");
		this.initComponent();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	private JLabel coinLb = new JLabel("#Coins: ",JLabel.LEFT);
	private JTextField coinTf = new JTextField("     0",JLabel.RIGHT);
	private JLabel lblNoCoins = new JLabel("No coins");
	private void initComponent(){
		coinLb.setBounds(6, 11, 119, 36);
		coinLb.setFont(new Font(coinLb.getFont().getName(), coinLb.getFont().getStyle(), 30));
		coinTf.setBounds(127, 5, 126, 48);
		coinTf.setFont(new Font(coinTf.getFont().getName(), coinTf.getFont().getStyle(), 30));
		getContentPane().setLayout(null);
		getContentPane().add(coinLb);
		getContentPane().add(coinTf);
		coinTf.setEditable(false);


		lblNoCoins.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoCoins.setForeground(Color.GRAY);
		lblNoCoins.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNoCoins.setBounds(16, 59, 237, 48);
		getContentPane().add(lblNoCoins);

	}
	public void run(){

		pack();
		setBounds(100, 100, 262, 132);
		setVisible(true);
		setResizable(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		coinTf.setText(((CoinMachine) arg).getCount()+"");
		lblNoCoins.setText("Accepting Coins");
		if(Integer.parseInt(coinTf.getText())==Demo.capacity){
			lblNoCoins.setText("Full");
		}
	}
}
