package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Person;
import Model.User;
import Model.Users;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtOtherPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage(null);
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
	public SignUpPage(Users userlist) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(47, 32, 140, 23);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(46, 66, 326, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(46, 131, 326, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtOtherPassword = new JTextField();
		txtOtherPassword.setBounds(46, 196, 326, 20);
		contentPane.add(txtOtherPassword);
		txtOtherPassword.setColumns(10);		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(47, 97, 140, 23);
		contentPane.add(lblPassword);
		
		JLabel lblOtherPassword = new JLabel("Password again");
		lblOtherPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOtherPassword.setBounds(47, 164, 140, 21);
		contentPane.add(lblOtherPassword);
		
		JButton btnBack = new JButton("Go back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoFrame df = new DemoFrame(userlist);			
				df.show();
				dispose();
			}
		});
		btnBack.setBounds(78, 227, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblError = new JLabel("");
		
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setForeground(new Color(255, 69, 0));
		lblError.setBounds(152, 164, 274, 23);
		contentPane.add(lblError);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String enteredPassword = txtPassword.getText();
				String reEnteredPassword = txtOtherPassword.getText();
				
				if(enteredPassword.equals(reEnteredPassword)) {
					lblError.setText("");
					
					Person user = new User(username);
					User newUser = (User) user;
					newUser.setPassword(enteredPassword);
					user = (Person) newUser;
					
					userlist.addUser(user);
					
					DemoFrame df = new DemoFrame(userlist);			
					df.show();
					dispose();
				}
				else {
					lblError.setText("Re-entered password must be the same");
				}
			}
		});
		
		btnConfirm.setBounds(247, 227, 89, 23);
		contentPane.add(btnConfirm);
	}
}
