package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cashier_home extends JFrame {

	private JPanel contentPane;
	int j;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashier_home frame = new Cashier_home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static int count_Movies() throws SQLException
	{
		ResultSet rs = Conn.st.executeQuery("Select count(*) from movies");
		rs.next();
		return rs.getInt(1);
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Cashier_home() throws SQLException {
		int i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeCashier = new JLabel("Welcome Cashier");
		lblWelcomeCashier.setFont(new Font("Charlemagne Std", Font.PLAIN, 17));
		lblWelcomeCashier.setBounds(276, 49, 199, 62);
		contentPane.add(lblWelcomeCashier);
		
		
		
		JButton button_3 = new JButton("Log Out");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logged out successfully!");
				dispose();
				new Home().show();
			}
		});
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		button_3.setBounds(556, 35, 139, 55);
		contentPane.add(button_3);
		
		ArrayList<JButton> b = new ArrayList<>();
		i = Cashier_home.count_Movies();
		
		ResultSet rs = Conn.st.executeQuery("Select * from movies");
		rs.next();	
		
		//Creating Dynamic Buttons
		for(int j=0, y=0; j<i;j++)
		{
			JButton temp = new JButton(rs.getString(1));
			temp.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			temp.setBounds(83, 132+y, 139, 55);
			temp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String Bname = temp.getText();
					System.out.println(Bname);
					try {
						Statement s = Conn.con.createStatement();
						ResultSet rstemp = s.executeQuery("Select * from movies");
						while(rstemp.next())
						{
							
							System.out.println("rstemp.getString(1) : "+rstemp.getString(1));
							System.out.println("Bname : "+ Bname);
							if(Bname.equals(rstemp.getString(1)))
							{
								System.out.println("rstemp.getString(1) : "+rstemp.getString(1));
								C_Movie c = new C_Movie();
								c.init(rstemp.getString(1), rstemp.getInt(2));
								dispose();
								c.show();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			b.add(temp);
			contentPane.add(b.get(j));
			y+=100;
			rs.next();
		}
		/*
		//Adding Listener Events to Dynamically Created Buttons
		rs.beforeFirst();
		rs.next();
		for(j=0;j<i;j++)
		{
			String name = rs.getString(1);
			int tickets = rs.getInt(2);
			System.out.println(j);
			b.get(j).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("inner j : "+j);
					C_Movie c = new C_Movie();
					c.init(name, tickets);
					dispose();
					c.show();
				}
			});
			rs.next();
			
		}*/
		
	}
}
