package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class A_add extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField ticketsText;
	String name;
	int tickets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_add frame = new A_add();
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
	public A_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add a new Movie");
		lblAddANew.setFont(new Font("Charlemagne Std", Font.PLAIN, 24));
		lblAddANew.setBounds(221, 37, 283, 81);
		contentPane.add(lblAddANew);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Home().show();
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBack.setBounds(574, 43, 139, 55);
		contentPane.add(btnBack);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the following credentials:");
		lblPleaseEnterThe.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblPleaseEnterThe.setBounds(55, 129, 402, 35);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblMovieName = new JLabel("Movie Name: ");
		lblMovieName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMovieName.setBounds(74, 194, 111, 35);
		contentPane.add(lblMovieName);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(214, 194, 111, 28);
		contentPane.add(nameText);
		
		JLabel lblAvailableTickets = new JLabel("Available Tickets: ");
		lblAvailableTickets.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblAvailableTickets.setBounds(74, 240, 130, 35);
		contentPane.add(lblAvailableTickets);
		
		ticketsText = new JTextField();
		ticketsText.setBounds(214, 240, 111, 28);
		contentPane.add(ticketsText);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nameText.getText();
				tickets = Integer.parseInt(ticketsText.getText());
				try {
					int x = Conn.st.executeUpdate("Insert into movies values ('" + name + "' , "+String.valueOf(tickets)+")");
					if(x==1)
					{
						JOptionPane.showMessageDialog(null, "Added Successfully!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Failed!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nameText.setText("");
				ticketsText.setText("");
			}
		});
		btnAdd.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		btnAdd.setBounds(128, 305, 82, 28);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameText.setText("");
				ticketsText.setText("");
			}
		});
		btnClear.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		btnClear.setBounds(231, 305, 82, 28);
		contentPane.add(btnClear);
	}
}
