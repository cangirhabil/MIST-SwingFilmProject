package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FilmListController;
import Controller.UserController;
import Model.Film;
import Model.FilmList;
import Model.Star;
import Model.User;
import Model.Users;
import Source.ReadCSV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class NavigationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ReadCSV csvFilms = new ReadCSV();
	
	double maxGross = 0;
	double averageGross;
	
	double maxPop = 0;
	double averagePop;
	
	private JPanel contentPanel;
	private JPanel myListsPanel;
	private JPanel watchedPanel;
	private JPanel moviePanel;
	private JPanel creditsPanel;
	private JPanel listPanel;
	private JTextField textField;
	
	Font font = new Font("Tahoma", Font.BOLD, 16);
	Font BTNFont = new Font("Tahoma", Font.BOLD, 16);
	Font textFont = new Font("Tahoma", Font.PLAIN, 16);
	Font TitleFont = new Font("Tahoma", Font.BOLD, 32);
	
	Color color1 = Color.decode("#222831");
	Color color2 = Color.decode("#393E46");
	Color color3 = Color.decode("#00ADB5");
	Color color4 = Color.decode("#EEEEEE");
	
	public static void main(String[] args) {
		
	}
	
	public NavigationPage(String enteredName ,Users userlist) {
		getAverageGross();
		System.out.println("  "+ String.format("%.0f",averageGross) + "  " + String.format("%.0f",maxGross));
		
		getAveragePop();
		System.out.println("  "+ String.format("%.0f",averagePop) + "  " + String.format("%.0f",maxPop));
		

		User user = (User)userlist.getUserByName(enteredName);
		System.out.println(user.getName());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 720, 720);
        setResizable(false);
        setLayout(null);
        contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        contentPanel.setBackground(color4);

        myListsPanel = new JPanel();
        watchedPanel = new JPanel();
        creditsPanel = new JPanel();
        moviePanel = new JPanel();
        listPanel = new JPanel();
        
        myListsPanel.setBackground(color3);
        watchedPanel.setBackground(color3);
        creditsPanel.setBackground(color3);
        moviePanel.setBackground(color3);
        listPanel.setBackground(color3);

        //contentPanel.add(moviePanel);
        
        listPanel.setBounds(200, 40, 480, 640);
        contentPanel.add(listPanel);
        listPanel.setVisible(false);
        listPanel.setLayout(null);
        
        myListsPanel.setBounds(200, 40, 480, 640);
        contentPanel.add(myListsPanel);
        myListsPanel.setVisible(false);
        myListsPanel.setLayout(null);
        
        watchedPanel.setBounds(200, 40, 480, 640);
        contentPanel.add(watchedPanel);
        watchedPanel.setVisible(false);
        watchedPanel.setLayout(null);
        
        creditsPanel.setBounds(200, 40, 480, 640);
        contentPanel.add(creditsPanel);
        creditsPanel.setVisible(false);
        creditsPanel.setLayout(null);
        
        moviePanel.setBounds(200, 40, 480, 640);
        contentPanel.add(moviePanel);
        moviePanel.setVisible(false);
        moviePanel.setLayout(null);
        
     // Name Label
        JLabel nameLabel = new JLabel(user.getName(), SwingConstants.CENTER);
        nameLabel.setBounds(40, 560, 120, 40);
        nameLabel.setFont(font);
        contentPanel.add(nameLabel);
        
        // My Lists
        JButton myListsBTN = new JButton("My Lists");
        myListsBTN.setBackground(color3);
        myListsBTN.setForeground(color2);
        myListsBTN.setFont(font);
        myListsBTN.setBounds(40, 360, 120, 40);
        myListsBTN.addActionListener(e -> {
        	myListsPanel.setVisible(false);
			myListsPanel.removeAll();
        	
            myListsPanel.setVisible(true);
            watchedPanel.setVisible(false);
            moviePanel.setVisible(false);
            creditsPanel.setVisible(false);
            listPanel.setVisible(false);
            
            
            displayMyLists(user);
        });
        contentPanel.add(myListsBTN);
        
        // Watched
        JButton watchedBTN = new JButton("Watched");
        watchedBTN.setBackground(color3);
        watchedBTN.setForeground(color2);
        watchedBTN.setFont(font);
        watchedBTN.setBounds(40, 440, 120, 40);
        watchedBTN.addActionListener(e -> {
            myListsPanel.setVisible(false);
            watchedPanel.setVisible(true);
            moviePanel.setVisible(false);
            creditsPanel.setVisible(false);
            listPanel.setVisible(false);
            
            displayWatchedList(user);
        });
        contentPanel.add(watchedBTN);
        
     // Go back
        JButton goBackBTN = new JButton("Go Back");
        goBackBTN.setBackground(color3);
        goBackBTN.setForeground(color2);
        goBackBTN.setFont(font);
        goBackBTN.setBounds(40, 520, 120, 40);
        goBackBTN.addActionListener(e -> {
        	DemoFrame df = new DemoFrame(userlist);
			df.show();
			dispose();
        });
        contentPanel.add(goBackBTN);
        
        /*JLabel watchedTitle = new JLabel("Watched");
        watchedTitle.setFont(font);
        watchedTitle.setBounds(360, 60, 120, 40);
        watchedPanel.add(watchedTitle);*/
        // Credits
        JButton creditsBTN = new JButton("Credits");
        creditsBTN.setBackground(color3);
        creditsBTN.setForeground(color2);
        creditsBTN.setFont(font);
        creditsBTN.setBounds(40, 640, 120, 40);
        creditsBTN.addActionListener(e -> {
            myListsPanel.setVisible(false);
            watchedPanel.setVisible(false);
            creditsPanel.setVisible(true);
            moviePanel.setVisible(false);
            listPanel.setVisible(false);
        });
        contentPanel.add(creditsBTN);
        
        JLabel creditsTitle = new JLabel("Credits",SwingConstants.CENTER);
        creditsTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
        creditsTitle.setBounds(120, 20, 240, 40);
        creditsPanel.add(creditsTitle);
        creditsTitle.setVerticalAlignment(SwingConstants.TOP);
        
        JLabel dev1Title = new JLabel("Semih Korkmaz",SwingConstants.CENTER);
        dev1Title.setFont(new Font("Tahoma", Font.PLAIN, 32));
        creditsPanel.add(dev1Title);
        dev1Title.setBounds(120, 160, 240, 80);
        dev1Title.setVerticalAlignment(SwingConstants.TOP);
        
        JLabel dev2Title = new JLabel("Habil Cangir",SwingConstants.CENTER);
        dev2Title.setFont(new Font("Tahoma", Font.PLAIN, 32));
        creditsPanel.add(dev2Title);
        dev2Title.setBounds(120,280,240,80);
        dev2Title.setVerticalAlignment(SwingConstants.TOP);
        
        JLabel dev3Title = new JLabel("Tunahan Değirmencioğlu",SwingConstants.CENTER);
        dev3Title.setFont(new Font("Tahoma", Font.PLAIN, 32));
        creditsPanel.add(dev3Title);
        dev3Title.setBounds(20,400,440,80);
        dev3Title.setVerticalAlignment(SwingConstants.TOP);
        
        textField = new JTextField("");
		textField.setBounds(40, 200, 120, 40);
		contentPanel.add(textField);
		textField.setColumns(20);
		
        
		ImageIcon mistIcon= new ImageIcon("mistLogo.png");
		Image mistImage = mistIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel mistLabel = new JLabel(new ImageIcon(mistImage));
        mistLabel.setBounds(40,40,120,120);
        contentPanel.add(mistLabel);
		
		
		// Search
		JButton searchBTN = new JButton("Search");
		searchBTN.setBackground(color3);
		searchBTN.setForeground(color2);
		searchBTN.setBounds(40, 260, 120, 40);
		searchBTN.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				moviePanel.setVisible(false);
				moviePanel.removeAll();
				
				myListsPanel.setVisible(false);
	            watchedPanel.setVisible(false);
	            creditsPanel.setVisible(false);
	            moviePanel.setVisible(true);
	            listPanel.setVisible(false);
	            
				String filmStr = textField.getText();
				Film film = csvFilms.searchFilm(filmStr);
			
				try {
					if(film != null) displayFilm(film, user);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				moviePanel.setBackground(color3);
			}
		});
		contentPanel.add(searchBTN);
		
		changeAllLabelsForegroundColor(contentPanel, color2);
	}
	
	void sortList(FilmList list, String type)
	{
		
	}
	
	void displayList(FilmList list, User user) {
		// Filter
		JButton fBTN = new JButton("Sort");
		fBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
		fBTN.setBounds(360, 40, 80, 40);
		fBTN.addActionListener(e -> {
			String type = "";
			
			FilmListController fc = new FilmListController(list.getNameOfList());
			
			JTextField typeTextField = new JTextField();
			
            Object[] message = {"1- Sort by Name", "2- Sort by Relase Date", "3- Sort by IMDB Score", "4- Sort by Duration", typeTextField};
            
            int option = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION);
            
            type = typeTextField.getText();
            
            if (option == JOptionPane.OK_OPTION) {
            	if(type.equals("1")) {
            		fc.sortFilmListByName(list);
            	}
            	else if(type.equals("2")) {
            		fc.sortFilmListByDate(list);
            	}
            	else if(type.equals("3")) {
            		fc.sortFilmListByIMDBScore(list);
            	}
            	else if(type.equals("4")) {
            		fc.sortFilmListByDuration(list);
            	}
            }
			
        	listPanel.setVisible(false);
			listPanel.removeAll();
			listPanel.setBackground(color3);
        	
            myListsPanel.setVisible(false);
            watchedPanel.setVisible(false);
            moviePanel.setVisible(false);
            creditsPanel.setVisible(false);
            listPanel.setVisible(true);

            displayList(list, user);
        });
        listPanel.add(fBTN);
		
		JLabel listTitle = new JLabel(list.getNameOfList(), SwingConstants.CENTER);
        listTitle.setFont(TitleFont);
        listTitle.setBounds(160, 40, 160, 40);
        listTitle.setVerticalAlignment(SwingConstants.CENTER);
        listPanel.add(listTitle);
        
        int k = 120;

        for(int i = 0;i<list.getFilms().size();i++) 
        {
        	String filmN= list.getFilms().get(i).getTitle();
        	Film theFilm= list.getFilms().get(i);
    		
    		JLabel filmNo = new JLabel(String.valueOf(i+1), SwingConstants.CENTER);
    		filmNo.setFont(new Font("Tahoma", Font.BOLD, 8));
    		filmNo.setBounds(40, k, 40, 40);
    		filmNo.setVerticalAlignment(SwingConstants.CENTER);
    		listPanel.add(filmNo);
            
            JLabel movieName = new JLabel(list.getFilms().get(i).getTitle(), SwingConstants.CENTER);
            movieName.setFont(TitleFont);
            movieName.setBounds(80, k, 240, 40);
            movieName.setVerticalAlignment(SwingConstants.CENTER);
            listPanel.add(movieName);
            
            ArrayList<String> dates = list.getDates();
            String date = "";
            
            for(int j = 0;j<dates.size();j++)
            {
            	String[] nameDate = dates.get(i).split("/");
            	
            	if(nameDate[0].equals(filmN)) {
            		date = nameDate[1];
            	}
            }

            JLabel movieDate = new JLabel(date, SwingConstants.CENTER);
            movieDate.setFont(font);
            movieDate.setBounds(320, k, 80, 40);
            movieDate.setVerticalAlignment(SwingConstants.CENTER);
            listPanel.add(movieDate);
            
            JButton xBTN = new JButton("X");
            xBTN.setFont(new Font("Tahoma", Font.BOLD, 10));
            xBTN.setBounds(400, k, 40, 40);
            xBTN.addActionListener(e -> {
            	list.getFilms().remove(Integer.parseInt(filmNo.getText())-1);
            	
            	listPanel.setVisible(false);
    			listPanel.removeAll();
    			listPanel.setBackground(color3);
            	
                myListsPanel.setVisible(false);
                watchedPanel.setVisible(false);
                moviePanel.setVisible(false);
                creditsPanel.setVisible(false);
                listPanel.setVisible(true);
                
                displayList(list, user);
            });
            listPanel.add(xBTN);
            
    		k+=40;
        }
        
        changeAllLabelsForegroundColor(listPanel, color2);
	}
	
	void displayWatchedList(User user) {
		ArrayList<Film> list = user.getWatchedFilms();
		JLabel listTitle = new JLabel("Watched", SwingConstants.CENTER);
        listTitle.setFont(TitleFont);
        listTitle.setBounds(160, 40, 160, 40);
        listTitle.setVerticalAlignment(SwingConstants.CENTER);
        watchedPanel.add(listTitle);
        
        int k = 120;

        for(int i = 0;i<list.size();i++) 
        {
        	String filmN= list.get(i).getTitle();
        	Film theFilm= list.get(i);
    		
    		JLabel filmNo = new JLabel(String.valueOf(i+1), SwingConstants.CENTER);
    		filmNo.setFont(new Font("Tahoma", Font.BOLD, 8));
    		filmNo.setBounds(40, k, 40, 40);
    		filmNo.setVerticalAlignment(SwingConstants.CENTER);
    		watchedPanel.add(filmNo);
            
            JLabel movieName = new JLabel(list.get(i).getTitle(), SwingConstants.CENTER);
            movieName.setFont(TitleFont);
            movieName.setBounds(80, k, 240, 40);
            movieName.setVerticalAlignment(SwingConstants.CENTER);
            watchedPanel.add(movieName);
            
            ArrayList<String> points = user.getPoints();
            String point = "";
            
            for(int j = 0;j<points.size();j++)
            {
            	String[] namePoint = points.get(i).split("/");
            	
            	if(namePoint[0].equals(filmN)) {
            		point = namePoint[1];
            	}
            }

            JLabel moviePoint = new JLabel(point, SwingConstants.CENTER);
            moviePoint.setFont(font);
            moviePoint.setBounds(320, k, 80, 40);
            moviePoint.setVerticalAlignment(SwingConstants.CENTER);
            watchedPanel.add(moviePoint);
            
            /*JButton xBTN = new JButton("X");
            xBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
            xBTN.setBounds(400, k, 40, 40);
            xBTN.addActionListener(e -> {
            	list.remove(Integer.parseInt(filmNo.getText())-1);
            	
            	listPanel.setVisible(false);
    			listPanel.removeAll();
    			listPanel.setBackground(color3);
            	
                myListsPanel.setVisible(false);
                watchedPanel.setVisible(false);
                moviePanel.setVisible(false);
                creditsPanel.setVisible(false);
                listPanel.setVisible(true);
                
                displayWatchedList( user);
            });
            watchedPanel.add(xBTN);*/
            
    		k+=40;
        }
        
        changeAllLabelsForegroundColor(listPanel, color2);
	}
	
	void displayMyLists(User user) {
		JLabel myListsTitle = new JLabel("My Lists", SwingConstants.CENTER);
        myListsTitle.setFont(TitleFont);
        myListsTitle.setBounds(160, 40, 160, 40);
        myListsTitle.setVerticalAlignment(SwingConstants.CENTER);
        myListsPanel.add(myListsTitle);
        
        ArrayList<FilmList> lists = user.getFilmLists();
        
        int k=120;
        
        if(!lists.isEmpty()) {
        	for(int i = 0;i<lists.size();i++)
        	{
        		String listN= lists.get(i).getNameOfList();
        		FilmList theList = lists.get(i);
        		
        		JButton listNoBTN = new JButton(String.valueOf(i+1));
                listNoBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
                listNoBTN.setBounds(40, k, 40, 40);
                listNoBTN.setVerticalAlignment(SwingConstants.CENTER);
                listNoBTN.addActionListener(e -> {
                	listPanel.setVisible(false);
                	listPanel.removeAll();
                	
                	myListsPanel.setVisible(false);
                    watchedPanel.setVisible(false);
                    moviePanel.setVisible(false);
                    creditsPanel.setVisible(false);
                    listPanel.setVisible(true);
                	
                	displayList(theList, user);
                });
                myListsPanel.add(listNoBTN);
                
                JLabel listName = new JLabel(lists.get(i).getNameOfList(), SwingConstants.CENTER);
                listName.setFont(TitleFont);
                listName.setBounds(80, k, 240, 40);
                listName.setVerticalAlignment(SwingConstants.CENTER);
                myListsPanel.add(listName);
                
                JLabel listSize = new JLabel(String.valueOf(lists.get(i).getFilms().size()), SwingConstants.CENTER);
                listSize.setFont(TitleFont);
                listSize.setBounds(320, k, 80, 40);
                listSize.setVerticalAlignment(SwingConstants.CENTER);
                myListsPanel.add(listSize);
                
                JButton xBTN = new JButton("X");
                xBTN.setFont(new Font("Tahoma", Font.BOLD, 8));
                xBTN.setBounds(400, k, 40, 40);
                xBTN.addActionListener(e -> {
                	user.getFilmLists().remove(Integer.parseInt(listNoBTN.getText())-1);
                	
                	myListsPanel.setVisible(false);
        			myListsPanel.removeAll();
        			myListsPanel.setBackground(color3);
                	
                    myListsPanel.setVisible(true);
                    watchedPanel.setVisible(false);
                    moviePanel.setVisible(false);
                    creditsPanel.setVisible(false);
                    listPanel.setVisible(false);
                    
                    displayMyLists(user);
                });
                myListsPanel.add(xBTN);
                
        		k+=40;
        	}
        }
        
        JButton plusBTN = new JButton("Add List");
        plusBTN.setFont(font);
        plusBTN.setBounds(40, k, 400, 40);
        plusBTN.addActionListener(e -> {
        	JTextField textField = new JTextField();
            
            int option = JOptionPane.showConfirmDialog(null, textField, "Input", JOptionPane.OK_CANCEL_OPTION);
            
            if (option == JOptionPane.OK_OPTION) {
                String text = textField.getText();
                //System.out.println("You entered: " + text);
                boolean flag = false;
                
                for(int i = 0;i<user.getFilmLists().size();i++)
                {
                	if(user.getFilmLists().get(i).getNameOfList().equals(text))
                	{
                		flag = true;
                	}
                }
                
                if(!flag) user.getFilmLists().add(new FilmList(text));
                

                /*for(int i = 0;i<user.getFilmLists().size();i++)
                {
                	System.out.println(user.getFilmLists().get(i).getNameOfList());
                }*/
            }
        	
        	myListsPanel.setVisible(false);
			myListsPanel.removeAll();
        	
            myListsPanel.setVisible(true);
            watchedPanel.setVisible(false);
            moviePanel.setVisible(false);
            creditsPanel.setVisible(false);
            listPanel.setVisible(false);
            
            displayMyLists(user);
        });
        myListsPanel.add(plusBTN);
        
        changeAllLabelsForegroundColor(myListsPanel, color2);
	}

	void displayFilm(Film f, User user) throws IOException {
		// Poster
		
		// Title
		JLabel movieTitle = new JLabel(f.getTitle(), SwingConstants.CENTER);
        movieTitle.setFont(TitleFont);
        movieTitle.setBounds(40,40,280,80);
        movieTitle.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(movieTitle);
		
		// Plus
		JButton plusBTN = new JButton("+");
		plusBTN.setFont(BTNFont);
		plusBTN.setBounds(360, 40, 100, 80);
		plusBTN.addActionListener(e -> {			
			JTextField dateTextField = new JTextField();
			JTextField listNameTextField = new JTextField();
            Object[] message = {"Date(DD-MM): ", dateTextField, "List Name: ", listNameTextField};
            int option = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION);
            
            if (option == JOptionPane.OK_OPTION) {
                String dateText = dateTextField.getText();
                String lNameText = listNameTextField.getText();
                
                // Control dateText
                String pattern = "\\d\\d-\\d\\d";
                
                if(Pattern.matches(pattern, dateText))
                {
                	for(int i = 0;i<user.getFilmLists().size();i++) 
                    {
                    	if(user.getFilmLists().get(i).getNameOfList().equals(lNameText)) {
                    		user.getFilmLists().get(i).getDates().add(f.getTitle()+"/"+dateText);
                    		user.getFilmLists().get(i).getFilms().add(f);
                    	}
                    }
                }
            }

            myListsPanel.setVisible(false);
            watchedPanel.setVisible(false);
            moviePanel.setVisible(true);
            creditsPanel.setVisible(false);
            listPanel.setVisible(false);
        });
        moviePanel.add(plusBTN);		
        
        // Watched
        JButton watchedBTN = new JButton("Watched");
        watchedBTN.setFont(BTNFont);
        watchedBTN.setBounds(360, 120, 100, 80);
        watchedBTN.addActionListener(e -> {			
			JTextField pointTextField = new JTextField();
            Object[] message = {"Please rate this film: 1,2,3,4,5", pointTextField};
            int option = JOptionPane.showConfirmDialog(null, message, "Point", JOptionPane.OK_CANCEL_OPTION);
            
            if (option == JOptionPane.OK_OPTION) {
                String pointText = pointTextField.getText();
                int point = Integer.parseInt(pointText);
                
                if(-1<point && 11>point)
                {
                	user.getWatchedFilms().add(f);
                	user.getPoints().add(f.getTitle()+ "/" + pointText);
                }
            }

            myListsPanel.setVisible(false);
            watchedPanel.setVisible(false);
            moviePanel.setVisible(true);
            creditsPanel.setVisible(false);
            listPanel.setVisible(false);
        });
        moviePanel.add(watchedBTN);		
        
        
        // Year
		JLabel year = new JLabel(f.getReleaseDate(), SwingConstants.CENTER);
        year.setFont(TitleFont);
        year.setBounds(40,160,120,40);
        year.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(year);
        
        // Certificate
		JLabel certificate = new JLabel(f.getCertificate().toUpperCase(), SwingConstants.CENTER);
        certificate.setFont(TitleFont);
        certificate.setBounds(200,160,120,40);
        certificate.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(certificate);
        
        // Overview
        JTextArea overview = new JTextArea(f.getDescription());
        overview.setBackground(Color.YELLOW);
        overview.setLineWrap(true);
        overview.setWrapStyleWord(true);
        overview.setFont(textFont);
        overview.setBounds(40,240,400,160);
        moviePanel.add(overview);
        
        // Imdb
        JLabel imdb = new JLabel(String.valueOf(f.getRate()), SwingConstants.CENTER);
        imdb.setFont(TitleFont);
        imdb.setBounds(40,440,80,80);
        imdb.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(imdb);
		
		ImageIcon imdbBGIcon = new ImageIcon("imdbBG.png");
        JLabel imdbBGLabel = new JLabel(imdbBGIcon);
        imdbBGLabel.setBounds(40,440,80,80);
        moviePanel.add(imdbBGLabel);
        
		// MetaScore
        JLabel meta = new JLabel(String.valueOf(f.getMetascore()), SwingConstants.CENTER);
        meta.setFont(TitleFont);
        meta.setForeground(Color.WHITE);
        meta.setBounds(40,520,80,80);
        meta.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(meta);
		
		ImageIcon metaBGIcon = new ImageIcon("metaBG.png");
        JLabel metaBGLabel = new JLabel(metaBGIcon);
        metaBGLabel.setBounds(40,520,80,80);
        moviePanel.add(metaBGLabel);
        
        // Director
        JTextArea director = new JTextArea(String.valueOf(f.getDirector().getName()));
        director.setLineWrap(true);
        director.setWrapStyleWord(true);
        director.setFont(font);
        director.setBounds(160,440,120,40);
        
        moviePanel.add(director);

        // Runtime
		JLabel rtime = new JLabel(String.valueOf(f.getDuration()), SwingConstants.CENTER);
		rtime.setFont(font);
		rtime.setBounds(200,480,80,40);
		rtime.setVerticalAlignment(SwingConstants.CENTER);
		moviePanel.add(rtime);
		
		ImageIcon clockIcon = new ImageIcon("clocksymbol.png");
        Image newClockImage = clockIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel clockLabel = new JLabel(new ImageIcon(newClockImage));
        clockLabel.setBounds(160,480,40,40);
        moviePanel.add(clockLabel);
        
        // Stars
        ArrayList<Star> stars = f.getStars();
        JTextArea[] starTexts = new JTextArea[stars.size()];
        
        for(int i = 0;i<stars.size();i++)
        {
        	starTexts[i] = new JTextArea(String.valueOf(stars.get(i).getName()));
        	starTexts[i].setLineWrap(true);
        	starTexts[i].setWrapStyleWord(true);
        	starTexts[i].setBackground(color3);
        	starTexts[i].setBounds(320,440+(i*40),120,40);
            moviePanel.add(starTexts[i]);
        }
        
        // Gross
        if(f.getGrossRevenue()>averageGross) {
        	ImageIcon greenIcon = new ImageIcon("gross.png");
            Image grossImage1 = greenIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            JLabel grossLabel1 = new JLabel(new ImageIcon(grossImage1));
            grossLabel1.setBounds(200,520,40,40);
            moviePanel.add(grossLabel1);
            
            int the = (int)(((f.getGrossRevenue()-averageGross)/maxGross)*40);
            if(the == 0) {the =1;}
            Image grossImage2 = greenIcon.getImage().getScaledInstance(the, 40, Image.SCALE_SMOOTH);
            JLabel grossLabel2 = new JLabel(new ImageIcon(grossImage2));
            grossLabel2.setBounds(240,520,the,40);
            moviePanel.add(grossLabel2);
        }
        else if (f.getGrossRevenue() != 0) {
        	ImageIcon greenIcon = new ImageIcon("gross.png");
        	int the = (int)((f.getGrossRevenue()/averageGross)*40);
            Image grossImage = greenIcon.getImage().getScaledInstance(the, 40, Image.SCALE_SMOOTH);
            JLabel grossLabel = new JLabel(new ImageIcon(grossImage));
            grossLabel.setBounds(200,520,the,40);
            moviePanel.add(grossLabel);
        }

        ImageIcon grossIcon = new ImageIcon("moneysymbol.png");
        Image newGrossImage = grossIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel grossLabel = new JLabel(new ImageIcon(newGrossImage));
        grossLabel.setBounds(160,520,40,40);
        moviePanel.add(grossLabel);
        
        // Popularity
        if(f.getVoteCount()>averagePop) {
        	ImageIcon yellowIcon = new ImageIcon("pop.png");
            Image popImage1 = yellowIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            JLabel popLabel1 = new JLabel(new ImageIcon(popImage1));
            popLabel1.setBounds(200,560,40,40);
            moviePanel.add(popLabel1);
            
            int the = (int)(((f.getVoteCount()-averagePop)/maxPop)*40);
            if(the == 0) {the =1;}
            Image popImage2 = yellowIcon.getImage().getScaledInstance(the, 40, Image.SCALE_SMOOTH);
            JLabel popLabel2 = new JLabel(new ImageIcon(popImage2));
            popLabel2.setBounds(240,560,the,40);
            moviePanel.add(popLabel2);
        }
        else if (f.getVoteCount() != 0) {
        	ImageIcon popIcon = new ImageIcon("pop.png");
        	int the = (int)((f.getVoteCount()/averagePop)*40);
        	if(the == 0) {the =1;}
            Image popImage = popIcon.getImage().getScaledInstance(the, 40, Image.SCALE_SMOOTH);
            JLabel popLabel = new JLabel(new ImageIcon(popImage));
            popLabel.setBounds(200,560,the,40);
            moviePanel.add(popLabel);
        }
        
		ImageIcon popIcon = new ImageIcon("popsymbol.png");
        Image newPopImage = popIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel popLabel = new JLabel(new ImageIcon(newPopImage));
        popLabel.setBounds(160,560,40,40);
        moviePanel.add(popLabel);
        
        changeAllLabelsForegroundColor(moviePanel, color2);
        meta.setForeground(Color.WHITE);
        plusBTN.setBackground(color4);
        imdb.setForeground(Color.BLACK);
        watchedBTN.setBackground(color4);
        overview.setBackground(color4);
        director.setBackground(color3);
        movieTitle.setForeground(color1);
	}
	
	void getAveragePop()
	{
		double sum = 0;
		int counter = 0;
		
		for(int i = 0;i<csvFilms.allFilms.size();i++)
		{
			Film f = csvFilms.allFilms.get(i);
			
			if(f.getVoteCount() != 0)
			{
				if(f.getVoteCount() > maxPop)
				{
					maxPop = f.getVoteCount();
				}
				sum+=f.getVoteCount();
				counter++;
			}
		}
		
		averagePop = sum/counter;
	}
	
	void getAverageGross()
	{
		double sum = 0;
		int counter = 0;
		
		for(int i = 0;i<csvFilms.allFilms.size();i++)
		{
			Film f = csvFilms.allFilms.get(i);
			
			if(f.getGrossRevenue() != 0)
			{
				if(f.getGrossRevenue() > maxGross)
				{
					maxGross = f.getGrossRevenue();
				}
				sum+=f.getGrossRevenue();
				counter++;
			}
		}
		
		averageGross = sum/counter;
	}
	
	public static void changeAllLabelsForegroundColor(Container container, Color color) {
        for (Component component : container.getComponents()) {
            if (component instanceof JLabel) {
                ((JLabel) component).setForeground(color);
            } else if (component instanceof Container) {
                // Recursively apply to child containers
                changeAllLabelsForegroundColor((Container) component, color);
            }
        }
    }
}
