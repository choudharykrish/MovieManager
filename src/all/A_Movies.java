package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

public class A_Movies extends JFrame {
	class dynamicList
	{
		public ArrayList<JLabel> l;
		public ArrayList<JButton> b;
		public ArrayList<Integer> index;
		
		public dynamicList()
		{
			l = new ArrayList<>();
			b = new ArrayList<JButton>();
			index = new ArrayList<>();
			
		}
		
	}
	int j;
	dynamicList dl;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Movies frame = new A_Movies();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public A_Movies() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoviesNowShowing = new JLabel("Movies Now Showing");
		lblMoviesNowShowing.setFont(new Font("Charlemagne Std", Font.PLAIN, 17));
		lblMoviesNowShowing.setBounds(232, 32, 245, 62);
		contentPane.add(lblMoviesNowShowing);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Home().show();
			}
		});
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		button.setBounds(523, 42, 139, 55);
		contentPane.add(button);
		
		
		
		//ArrayList<JLabel> l = new ArrayList<>();
		//ArrayList<JButton> b = new ArrayList<>();
		dl = new dynamicList();
		int i = Cashier_home.count_Movies();
		ResultSet rs = Conn.st.executeQuery("Select * from movies");
		rs.next();	
		
		int y;
		thehandler handler = new thehandler();
		//Creating Dynamic list
		for(j=0, y=0; j<i;j++)
		{
			JLabel temp = new JLabel(rs.getString(1));
			temp.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
			temp.setBounds(42, 139+y, 123, 35);
			dl.l.add(temp);
			contentPane.add(dl.l.get(j));
			dl.index.add(j);
			JButton btnRemove = new JButton("remove");
			btnRemove.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
			btnRemove.setBounds(175, 139+y, 90, 35);
			dl.b.add(btnRemove);
			dl.b.get(j).addActionListener(handler);
			contentPane.add(dl.b.get(dl.index.get(j)));
			y+=100; 
			rs.next();
		}
		/*
		//Adding Listener Events to Dynamically Created Remove Buttons
		rs.beforeFirst();
		rs.next();
		for(j=0;j<i;j++)
		{
			String name = rs.getString(1);
			System.out.println(j);
			b.get(j).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("inner j : "+j);
						//int x = Conn.st.executeUpdate("Delete from movies where name = '"+ l.get(j).getText() + "'");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			rs.next();
			
		}
		*/
		
	}
	private class thehandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				//System.out.println("inner j : "+j);
				for(int i=0;i<dl.b.size();i++)
				{
					if(e.getSource()==dl.b.get(i))
					{
						int x = Conn.st.executeUpdate("Delete from movies where name = '"+ dl.l.get(dl.index.get(i)).getText() + "'");
						if(x==1)
						{
							JOptionPane.showMessageDialog(null,dl.l.get(dl.index.get(i)).getText()+ " removed successfully!");
							dispose();
							new A_Movies().show();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Unexpected error occured while removing!");
						}
					}
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
		

