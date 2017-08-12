package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	static Home frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Charlemagne Std", Font.PLAIN, 17));
		lblNewLabel.setBounds(245, 43, 150, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseSelectYour = new JLabel("Please select your designation");
		lblPleaseSelectYour.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPleaseSelectYour.setBounds(204, 101, 279, 38);
		contentPane.add(lblPleaseSelectYour);
		
		JButton AdminButton = new JButton("Admin");
		AdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				try {
					//new Admin_Login().setVisible(true);
					Admin_Login al = new Admin_Login();
					al.show();
					//Admin_Login.frame.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		AdminButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		AdminButton.setBounds(244, 178, 139, 55);
		contentPane.add(AdminButton);
		
		//Cashier Button
		JButton btnCashier = new JButton("Cashier");
		btnCashier.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				try {
					//new Cashier_Login().setVisible(true);
					dispose();
					new Cashier_Login().show();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCashier.setBounds(245, 279, 139, 55);
		contentPane.add(btnCashier);
	}
}
