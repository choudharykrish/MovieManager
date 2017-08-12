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

public class Cashier_Login extends JFrame {

	private JPanel contentPane;
	private JTextField uname_TF;
	private JPasswordField password_TF;
	static Cashier_Login frame;

	/*static
	{
		try {
			frame = new Cashier_Login();
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
					frame = new Cashier_Login();
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
	public Cashier_Login() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCashierLogin = new JLabel("Cashier Login");
		lblCashierLogin.setFont(new Font("Charlemagne Std", Font.PLAIN, 24));
		lblCashierLogin.setBounds(158, 72, 283, 81);
		contentPane.add(lblCashierLogin);
		
		JLabel label_1 = new JLabel("Please login to continue...");
		label_1.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		label_1.setBounds(143, 164, 262, 35);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		label_2.setBounds(144, 224, 82, 35);
		contentPane.add(label_2);
		
		uname_TF = new JTextField();
		uname_TF.setColumns(10);
		uname_TF.setBounds(236, 232, 111, 20);
		contentPane.add(uname_TF);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		label_3.setBounds(144, 270, 82, 35);
		contentPane.add(label_3);
		
		password_TF = new JPasswordField();
		password_TF.setBounds(236, 278, 111, 20);
		contentPane.add(password_TF);
		
		JButton button = new JButton("Login");
		
		ResultSet rs = Conn.st.executeQuery("Select * from Cashier");
		
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
						dispose();
						new Cashier_home().show();
						
						
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
		button.setBounds(169, 335, 82, 28);
		contentPane.add(button);
		
		//Back Button
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new Home().show();
			}
		});
		
		button_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		button_1.setBounds(272, 335, 82, 28);
		contentPane.add(button_1);
	}

}
