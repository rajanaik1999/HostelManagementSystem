package Hostel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManageRoom mr = new ManageRoom();
				mr.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(10, 11, 260, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				NewStudent ns = new NewStudent();
				ns.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(10, 61, 260, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update&Delete Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateDeleteStudent udp =new UpdateDeleteStudent();
				udp.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setBounds(10, 110, 260, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Student Fees");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentFees sf =new StudentFees();
				sf.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_3.setBounds(10, 163, 260, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New Employee");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewEmployee ne =new NewEmployee();
				ne.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_4.setBounds(297, 11, 260, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update&Delete Employee");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_5.setBounds(297, 61, 260, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Employee Payment");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_6.setBounds(297, 110, 260, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("All Employee Working");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_7.setBounds(297, 163, 260, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("All Student Living");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_8.setBounds(10, 218, 260, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Leaved Employee");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_9.setBounds(297, 218, 260, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Leaved Students");
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_10.setBounds(10, 272, 260, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Logout");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_11.setBounds(316, 274, 89, 23);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Exit");
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_12.setBounds(450, 274, 89, 23);
		contentPane.add(btnNewButton_12);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 684, 361);
		contentPane.add(panel);
	}
}
