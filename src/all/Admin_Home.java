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
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin_Home extends JFrame {

	private JPanel contentPane;
	static Admin_Home frame;
	
	/*static
	{
		frame = new Admin_Home();
		
	}
*/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Admin_Home();
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
	public Admin_Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome  Admin");
		lblWelcomeAdmin.setFont(new Font("Charlemagne Std", Font.PLAIN, 17));
		lblWelcomeAdmin.setBounds(238, 66, 184, 62);
		contentPane.add(lblWelcomeAdmin);
		
		JButton btnNowShowing = new JButton("Now Showing");
		btnNowShowing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new A_Movies().show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNowShowing.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNowShowing.setBounds(73, 154, 139, 55);
		contentPane.add(btnNowShowing);
		
		JButton btnAddmovie = new JButton("Add movie");
		btnAddmovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new A_add().show();
			}
		});
		btnAddmovie.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnAddmovie.setBounds(73, 237, 139, 55);
		contentPane.add(btnAddmovie);
		
		JButton btnRemoveMovie = new JButton("Remove Movie");
		btnRemoveMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new A_Movies().show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemoveMovie.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnRemoveMovie.setBounds(73, 322, 139, 55);
		contentPane.add(btnRemoveMovie);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logged out successfully!");
				dispose();
				new Home().show();
			}
		});
		btnLogOut.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnLogOut.setBounds(433, 187, 139, 55);
		contentPane.add(btnLogOut);
	}
}
