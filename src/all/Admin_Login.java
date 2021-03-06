package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JTextField uname_TF;
	private JPasswordField password_TF;
	static Admin_Login frame;
	
	/*static
	{
		try {
			frame = new Admin_Login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Admin_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Admin_Login() throws Exception {

		ResultSet rs = Conn.st.executeQuery("Select * from Admin");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Admin Login");
		lblLogin.setFont(new Font("Charlemagne Std", Font.PLAIN, 24));
		lblLogin.setBounds(182, 36, 283, 81);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("Please login to continue...");
		label.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		label.setBounds(167, 128, 262, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		label_1.setBounds(168, 188, 82, 35);
		contentPane.add(label_1);
		
		uname_TF = new JTextField();
		uname_TF.setColumns(10);
		uname_TF.setBounds(260, 196, 111, 20);
		contentPane.add(uname_TF);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		label_2.setBounds(168, 234, 82, 35);
		contentPane.add(label_2);
		
		password_TF = new JPasswordField();
		password_TF.setBounds(260, 242, 111, 20);
		contentPane.add(password_TF);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.beforeFirst();
					int flag = 0;
					String pwd = password_TF.getText();
					String user = uname_TF.getText();
					while(rs.next())
					{
						if((user.equals(rs.getString(1)))&&(pwd.equals(rs.getString(2))))
						{
							flag = 1;
							break;
							
						}
					}
					
					//valid user
					if(flag==1)
					{
						JOptionPane.showMessageDialog(null, "Success!\n Welcome " + user);
						uname_TF.setText("");
						password_TF.setText("");
						//new Test().setVisible(true);
						dispose();
						new Admin_Home().show();
						
						
					}
					//Invalid User
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or password!");
						uname_TF.setText("");
						password_TF.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		button.setBounds(193, 299, 82, 28);
		contentPane.add(button);
		
		
		//Back Button
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new Home().show();
			}
		});
		btnBack.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		btnBack.setBounds(296, 299, 82, 28);
		contentPane.add(btnBack);
		
		
		
		
		
	}

}
