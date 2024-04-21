package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;
import Model.Users;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.desktop.UserSessionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DemoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfldUsername;
	private JLabel lblPassword;
	private JTextField txtfldPassword;
	String userName;
	boolean isLogIn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		System.out.print("Started");
		
		Users userlist = new Users();
		User demo = new User("Demo User");
		demo.setPassword("password");
		
		

		userlist.addUser(demo);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame(userlist);
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
	public DemoFrame(Users userlist) {
		//String name = "Tunahan";
		//String password = "lmaoxd";
		
		setTitle("demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtfldUsername = new JTextField();
		txtfldUsername.setBounds(61, 36, 301, 20);
		txtfldUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtfldUsername);
		txtfldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(61, 11, 78, 14);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(61, 74, 78, 14);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPassword);
		
		txtfldPassword = new JTextField();
		txtfldPassword.setBounds(61, 99, 301, 20);
		txtfldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtfldPassword);
		txtfldPassword.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(104, 169, 223, 27);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(165, 130, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String enteredName = txtfldUsername.getText();
				
				String enteredPassword = txtfldPassword.getText();
				
				if(userlist.isEmpty()) {
					lblError.setText("User does not exist.");
				}
				else {
					boolean userExists = false;
					for(int i = 0; i < userlist.getSize(); i++) {
						if(userlist.getUsername(i).equals(enteredName)) {
							User user = (User) userlist.getUser(i);
							if(user.getPassword().equals(enteredPassword)) {
								lblError.setText("Login successful.");
								userExists = true;
								userName = enteredName;
								isLogIn = true;
								NavigationPage np = new NavigationPage(enteredName, userlist);
								np.show();
								dispose();
							}
							else {
								lblError.setText("Wrong password.");
								userExists = true;
								isLogIn = false;
								break;
							}
						}
						isLogIn = false;
					}
					
					if(!userExists) {
						lblError.setText("User does not exist.");
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage su = new SignUpPage(userlist);
				su.show();
				
				dispose();
			}
		});
		btnSignUp.setBounds(165, 229, 89, 23);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnSignUp);
		
		JLabel lblNoAcc = new JLabel("Don't have an account?");
		lblNoAcc.setBounds(153, 207, 183, 14);
		contentPane.add(lblNoAcc);
		contentPane.add(lblError);

	}
}
