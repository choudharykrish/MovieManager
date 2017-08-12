package all;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class C_Movie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String Movie_Name;
	int tickets;
	JLabel lblMovieName;
	JLabel lblNum;
	int tobook;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					C_Movie frame = new C_Movie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void init(String name, int num)
	{
		Movie_Name = name;
		tickets = num;
		lblMovieName.setText(name);
		lblNum.setText(String.valueOf(num));
	}

	/**
	 * Create the frame.
	 */
	public C_Movie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMovieName = new JLabel(Movie_Name);
		lblMovieName.setFont(new Font("Charlemagne Std", Font.PLAIN, 17));
		lblMovieName.setBounds(267, 48, 249, 62);
		contentPane.add(lblMovieName);
		
		JLabel lblAvailableTickets = new JLabel("Available Tickets: ");
		lblAvailableTickets.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblAvailableTickets.setBounds(47, 143, 156, 35);
		contentPane.add(lblAvailableTickets);
		
		lblNum = new JLabel(String.valueOf(tickets));
		lblNum.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblNum.setBounds(197, 143, 66, 35);
		contentPane.add(lblNum);
		
		JLabel lblTicketsToBook = new JLabel("Tickets to book: ");
		lblTicketsToBook.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		lblTicketsToBook.setBounds(47, 201, 143, 35);
		contentPane.add(lblTicketsToBook);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(196, 201, 67, 35);
		contentPane.add(textField);
		
		//Book button
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tobook = Integer.parseInt(textField.getText());
				if(tobook>tickets||tobook<0)
				{
					JOptionPane.showMessageDialog(null, tobook + " tickets not available.");
					textField.setText("");
				}
				else
				{
					//Update table movies
					try {
						PreparedStatement pt = Conn.con.prepareStatement("Update movies set tickets = ? where name = ?");
						pt.setInt(1, tickets-tobook);
						pt.setString(2, Movie_Name);
						int count = pt.executeUpdate();
						tickets = tickets-tobook;
						lblNum.setText(String.valueOf(tickets));
						textField.setText("");
						JOptionPane.showMessageDialog(null, tobook+" tickets booked!");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnBook.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBook.setBounds(202, 289, 139, 55);
		contentPane.add(btnBook);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new Cashier_home().show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBack.setBounds(411, 289, 139, 55);
		contentPane.add(btnBack);
	}
}
