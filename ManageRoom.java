package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import net.proteanit.sql.DbUtils;

public class ManageRoom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane sp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRoom frame = new ManageRoom();
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
	public ManageRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 418);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD NEW ROOM");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 158, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home hp = new Home();
				hp.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(585, 12, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Room Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(20, 47, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(150, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Activate or Deactivate");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(277, 47, 167, 14);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox yes = new JCheckBox("Yes");
		yes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		yes.setBounds(450, 45, 80, 23);
		contentPane.add(yes);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
					String room_no=textField.getText();
					String room_status=textField_1.getText();
					String st=String.valueOf(yes.isSelected());
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root","qwerty");
		            Statement s=con.createStatement();
		            String query="insert into manage_room values('"+room_no+"','"+room_status+"','"+st+"')";
		            int x=s.executeUpdate(query);
		            if(x==0) {
		            	JOptionPane.showMessageDialog(btnNewButton, "Already Exist");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(btnNewButton, "You have successfully inserted");
		            }
		            
		        }
		        
		            catch(Exception ea)
		            {
		            	System.out.println(ea);
		            }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(536, 45, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 77, 684, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("UPDATE & DELETE ROOM");
		lblNewLabel_3.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 89, 218, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Room Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(20, 123, 120, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 122, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
				
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JScrollPane sp=new JScrollPane();
				sp.setBounds(92, 227, 484, 141);
				contentPane.add(sp);
				
				table = new JTable();
				table.setBounds(92, 227, 484, 141);
				contentPane.add(table);
				sp.setViewportView(table);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root","qwerty");
		           Statement s=con.createStatement();
		           String q="select * from manage_room where room_no='"+textField_1.getText()+"';";
		           ResultSet rs=s.executeQuery(q);
		           
		           table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception es) {
					System.out.print(es);
				}

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setBounds(297, 119, 89, 23);
		contentPane.add(btnNewButton_4);

		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 196, 684, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("ALL ROOM");
		lblNewLabel_6.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel_6.setBounds(277, 203, 120, 24);
		contentPane.add(lblNewLabel_6);
		
	}
}
