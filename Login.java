package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(21, 32, 110, 23);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(182, 33, 115, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 71, 110, 23);
		contentPane.add(lblNewLabel_1);
		
		pwd = new JPasswordField();
		pwd.setBounds(182, 72, 115, 20);
		contentPane.add(pwd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uName=name.getText();
					String pass=String.valueOf(pwd.getPassword());
					String password="";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","qwerty");
					System.out.print("con done");
					Statement s= con.createStatement();
					String q="select * from login_info where u_name='"+uName+"'";
					ResultSet rs=s.executeQuery(q);
					while(rs.next()) {
						password=rs.getString("pass");
					}
					if(password.equals(pass)) {
						JOptionPane.showMessageDialog(btnNewButton, "Sucess");
						dispose();
						Home ob=new Home();
						ob.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Mismatch");
					}
					
				}catch(Exception w) {
					System.out.print(w);
				}
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.BOLD, 18));
		btnNewButton.setBounds(42, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		JCheckBox chk = new JCheckBox("Show Me");
		chk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chk.isSelected()) {
					pwd.setEchoChar((char)0);
				}
				else {
					pwd.setEchoChar('*');
				}
			}
		});
		chk.setFont(new Font("Algerian", Font.BOLD, 14));
		chk.setBounds(188, 110, 97, 23);
		contentPane.add(chk);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					name.setText("");
					pwd.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Algerian", Font.BOLD, 18));
		btnNewButton_1.setBounds(182, 160, 103, 23);
		contentPane.add(btnNewButton_1);
	}
}
