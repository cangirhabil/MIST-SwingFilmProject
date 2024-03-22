package swingPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class NavigationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	//static User name;
	
	public static void main(String[] args) {
		
		ArrayList<Film> allFilms = new ArrayList<Film>();
		
		try {
			File filmFile = new File("IMDB top 1000.csv");
			Scanner sc = new Scanner(filmFile);  
			//sc.useDelimiter(",");	//delimiter
			while (sc.hasNext()) {
				String line = sc.nextLine();
				
			}
		}
		catch(Exception e) {
			
		}
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavigationPage frame = new NavigationPage(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param enteredName 
	 */
	public NavigationPage(String enteredName ,UserList userlist) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(122, 0, 621, 494);
		contentPane.add(tabbedPane);
		
		JPanel taskPanel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(taskPanel);
		JPanel panelProfile = new JPanel();
		tabbedPane.addTab("Profile", null, panelProfile, null);
		panelProfile.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(enteredName);
		lblNewLabel_2.setBounds(246, 0, 102, 66);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelProfile.add(lblNewLabel_2);
		
		JPanel panelFilms = new JPanel();
		tabbedPane.addTab("SavedFilms", null, panelFilms, null);
		panelFilms.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Panel 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(259, 178, 140, 65);
		panelFilms.add(lblNewLabel_1);
		
		JPanel panelExplore = new JPanel();
		tabbedPane.addTab("Explore", null, panelExplore, null);
		panelExplore.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("panel 3");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(243, 148, 158, 89);
		panelExplore.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBounds(10, 65, 101, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Saved Films");
		btnNewButton_1.setBounds(10, 186, 101, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Explore");
		btnNewButton_2.setBounds(10, 312, 101, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Go back");
		btnNewButton_3.setBounds(10, 440, 89, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoFrame df = new DemoFrame(userlist);			
				df.show();
				dispose();
			}
		});
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(10, 346, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
