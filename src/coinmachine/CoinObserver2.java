package coinmachine;
import java.awt.*;

import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.Observable;
import javax.swing.JProgressBar;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoinObserver2 extends JFrame implements Observer{
	int currentBalance = 0;
	public CoinObserver2(){
		super("");
		this.initComponent();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	private JLabel coinLb = new JLabel("Balance: "+0+" ");
	private JLabel status = new JLabel("Status: ");
	private JProgressBar progressBar = new JProgressBar();
	private void initComponent(){
		getContentPane().setLayout(null);
		coinLb.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		coinLb.setBounds(38, 9, 121, 20);
		getContentPane().add(coinLb);
		status.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		status.setBounds(150, 9, 66, 20);
		getContentPane().add(status);
		progressBar.setStringPainted(true);
		
		
		progressBar.setToolTipText("");
		progressBar.setBounds(218, 11, 146, 20);
		progressBar.setMaximum(Demo.capacity);
		getContentPane().add(progressBar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Insert Money", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 43, 390, 115);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton oneBahtBt = new JButton("");
		oneBahtBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(1);
				Demo.machineMain.insert(coin);
			}
			
		});
		oneBahtBt.setIcon(new ImageIcon(CoinObserver2.class.getResource("/images/1baht.png")));
		oneBahtBt.setBounds(6, 16, 117, 93);
		panel.add(oneBahtBt);
		
		JButton fiveBahtBt = new JButton("");
		fiveBahtBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(5);
				Demo.machineMain.insert(coin);
			}
		});
		fiveBahtBt.setIcon(new ImageIcon(CoinObserver2.class.getResource("/images/5baht.png")));
		fiveBahtBt.setBounds(135, 16, 117, 93);
		panel.add(fiveBahtBt);
		
		JButton tenBahtBt = new JButton("");
		tenBahtBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin coin = new Coin(10);
				Demo.machineMain.insert(coin);
			}
		});
		tenBahtBt.setIcon(new ImageIcon(CoinObserver2.class.getResource("/images/10baht.png")));
		tenBahtBt.setBounds(264, 16, 117, 93);
		panel.add(tenBahtBt);

		
	}
	public void run(){

		pack();
		setBounds(100, 100, 400, 180);
		setVisible(true);
		setResizable(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		currentBalance = ((CoinMachine) arg).getBalance();
		coinLb.setText("Balance: "+ currentBalance);
		progressBar.setValue(((CoinMachine) arg).getCount());
	}
}
