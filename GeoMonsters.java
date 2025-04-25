//GeoMonsters.java
//Ritik Shenoy and Anish Khinvasara
//P7 2025


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.JFrame; 
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;



public class GeoMonsters extends JFrame
//holds the cards
{
    private CardLayout cards;

    public GeoMonsters()
    {
        super("GeoMonsters");  //made this thing it's own frame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,100);

        cards = new CardLayout();
        setLayout(cards);
        
        IntroPanel introPanel = new IntroPanel (this, cards);
        HomePanel homePanel = new HomePanel(this, cards);
        GamePanel gamePanel = new GamePanel(this, cards);
        InstructionsPanel instructionsPanel = new InstructionsPanel(this, cards);
        CreditsPanel creditsPanel = new CreditsPanel(this, cards);
        TeamPanel teamPanel = new TeamPanel(this,cards);
        QuestionPanel questionPanel = new QuestionPanel(this,cards);
		AnswerPanel answerPanel = new AnswerPanel(this,cards);

		
        add(introPanel, "Intro");
        add(homePanel, "Home");
        add(gamePanel, "Game");
        add(instructionsPanel, "Instructions");
        add(creditsPanel, "Credits");
        add(teamPanel, "Team");
        add(questionPanel, "Question");
        add(answerPanel, "Answer");
		

        setVisible(true);
    }
    
    public JButton createHomeButton()
    {
        // Create the button
        JButton button = new JButton("Home");
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setBackground(new Color(255,102,102));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 40));

        return button;
    }
    
    public static void main(String[] args)
    {
        new GeoMonsters();
    }
    
    
}

class IntroPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;

    private JCheckBox agreeCheckBox;
    private JButton proceedButton;

    public IntroPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(null);
        cards = cardLayout;
        geoFrame = frame;

        JTextArea introTextArea = new JTextArea();
        
        String rules = new String(
			"Rules:\n\n" +
			"1. This game is designed for Windows 10/11 systems. Any other OS won't be optimized.\n\n" +
			"2. Cheating or using Google to answer is strictly prohibited and will not help you prepare for the iGeo.\n\n" +
			"3. Do not mess with the code of the game/delete any files or you may risk ruining your gaming experience.\n\n" +
			"4. All user progress is saved locally. Uninstalling will erase your data.\n\n" +
			"5. By playing, you agree to our privacy policy and data handling practices.\n\n" +
			"6. Developers are not responsible for any damages caused by this game.\n\n" +
			"7. This game falls under Fair Use, and we will not be happy if Nintendo copyrights us.\n");
        
        introTextArea.setText("Welcome to GeoMonsters!\n" +
				"This game was created by Ritik Shenoy and Anish Khinvasara\n\n" +
				"Please read everything before continuing:\n\n" +
                "In this game, you'll explore the world map, answer regional geography questions, " +
                "and collect different creatures along the way.\n\n" +
                "This educational game is meant to help prepare you for the International Geography Olympiad.\n\n" + rules);
                



        introTextArea.setEditable(false);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);
        introTextArea.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        

        JScrollPane scrollPane = new JScrollPane(introTextArea);
        scrollPane.setBounds(150, 40, 500, 390);
        add(scrollPane);

        agreeCheckBox = new JCheckBox("I agree and wish to continue");
        agreeCheckBox.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        agreeCheckBox.setBounds(175, 450, 450, 30);
        agreeCheckBox.addActionListener(this);
        agreeCheckBox.setFocusPainted(false);
        add(agreeCheckBox);

        proceedButton = new JButton("Proceed");
        proceedButton.setBounds(325, 515, 120, 40);
        proceedButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        proceedButton.setBackground(new Color(255,102,102));
        proceedButton.setForeground(Color.BLACK);
        proceedButton.setFocusPainted(false);
        proceedButton.setPreferredSize(new Dimension(120, 40));

        
        proceedButton.setVisible(false);
        proceedButton.addActionListener(this);
        add(proceedButton);
    }



    public void actionPerformed(ActionEvent e)
    {
        
        if(agreeCheckBox.isSelected())
        {
			proceedButton.setVisible(true);
		}
		else
			proceedButton.setVisible(false);
        
        if (e.getSource() == proceedButton)
        {
            cards.show(geoFrame.getContentPane(), "Home");
        }
    }
}


class HomePanel extends JPanel implements ActionListener
{
    private Image globeImage;
    private CardLayout cards;
    private GeoMonsters geoFrame;
    
    public HomePanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
		
		cards = cardLayout;
		geoFrame = frame;
		
        //NORTH: Title and My Team Icon
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.WHITE);

        JPanel filler = new JPanel();
        filler.setPreferredSize(new Dimension(75, 75));
        filler.setBackground(Color.WHITE);

        northPanel.add(filler, BorderLayout.WEST);
        

        JLabel titleLabel = new JLabel("GeoMonsters", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 48)); //serif lowkey looking a bit weird we can change this
        titleLabel.setForeground(Color.BLACK);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        
        //JPanel topLeftPanel = new JPanel();
        //topLeftPanel.setOpaque(false); 
        //topLeftPanel.setLayout(new GridLayout(5, 1));
        JButton myTeamButton = new JButton("");
        myTeamButton.setPreferredSize(new Dimension(80, 80));  //square
        
        //load the image for the button background 
        //credits to StackOverflow, but more credits will be in the credits place

        String teamIconName = "ButtonBackground.jpg";
        try
        {
            Image img = ImageIO.read(new File(teamIconName));
            Image scaledImg = img.getScaledInstance(68, 68, Image.SCALE_SMOOTH);
            myTeamButton.setIcon(new ImageIcon(scaledImg));  // Set the image as the button icon
        }
        catch (IOException e)
        {
            e.printStackTrace();  
            System.err.println("Error opening file: " + teamIconName);
        }
        
        
        //make it less ugly
        myTeamButton.setFocusPainted(false);
        myTeamButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        myTeamButton.addActionListener(this);
        myTeamButton.setBackground(new Color(255,102,102));
        //myTeamButton.setForeground(Color.BLACK);
        //topLeftPanel.add(myTeamButton);
        northPanel.add(myTeamButton, BorderLayout.EAST);
        

        add(northPanel, BorderLayout.NORTH);
       
        
        try
        {
            Image img = ImageIO.read(new File("ButtonBackground.jpg"));
            Image scaledImg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            myTeamButton.setIcon(new ImageIcon(scaledImg));  // Set the image as the button icon
        }
        catch (IOException e)
        {
            e.printStackTrace();  // Handle exception if image loading fails
        }
        
        
        //make it less ugly
        myTeamButton.setFocusPainted(false);
        //myTeamButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        myTeamButton.addActionListener(this);
        myTeamButton.setBackground(new Color(255,102,102));
        //myTeamButton.setForeground(Color.WHITE);
        //topLeftPanel.add(myTeamButton);
        
        
        //add(topLeftPanel, BorderLayout.EAST);
        
        //load the image for the center background
		try
        {
			//load image
            globeImage = ImageIO.read(new File("Globe.jpg"));  
        }
        catch (IOException e)
        {
            e.printStackTrace();  // Handle any errors loading the image
        }

        //SOUTH: Buttons Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setOpaque(false);

		//play button
		JButton playButton = new JButton("PLAY"); 
		playButton.setFont(new Font("SansSerif", Font.BOLD, 28));
		playButton.setBackground(new Color(255,102,102));
		playButton.setForeground(Color.BLACK);
		playButton.setFocusPainted(false);
		playButton.setPreferredSize(new Dimension(200, 60));
		playButton.addActionListener(this);  // Replaced lambda with this

		JPanel playPanel = new JPanel();
		playPanel.setOpaque(false);
		playPanel.add(playButton);
		bottomPanel.add(playPanel, BorderLayout.NORTH);

		//Instructions/Credits buttons
		JButton instructionsButton = new JButton("Instructions");
		JButton creditsButton = new JButton("Credits");

		instructionsButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		creditsButton.setFont(new Font("SansSerif", Font.BOLD, 15));

		instructionsButton.setBackground(new Color(255,102,102));
		creditsButton.setBackground(new Color(255,102,102));
		instructionsButton.setForeground(Color.BLACK);
		creditsButton.setForeground(Color.BLACK);

		instructionsButton.setPreferredSize(new Dimension(140, 40));
		creditsButton.setPreferredSize(new Dimension(140, 40));

		instructionsButton.addActionListener(this);
		creditsButton.addActionListener(this);  
		
		
		//panel for them
		JPanel subButtonsPanel = new JPanel();
		subButtonsPanel.setOpaque(false);
		subButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		subButtonsPanel.add(instructionsButton);
		subButtonsPanel.add(creditsButton);

		bottomPanel.add(subButtonsPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		
		
		//need getContentPane because it's a JFrame not a JPanel
		if (command.equals("PLAY")) 
		{
			//Switch to the "Game" card
			cards.show(geoFrame.getContentPane(), "Game");
		} 
		else if (command.equals("Instructions")) 
		{
			//Switch to the "Instructions" card
			cards.show(geoFrame.getContentPane(), "Instructions");
		} 
		else if (command.equals("Credits")) 
		{
			//Switch to the "Credits" card
			cards.show(geoFrame.getContentPane(), "Credits");
		}
		else if (command.equals(""))  //team one just has a picture
		{
			//Switch to the "Team" card
			cards.show(geoFrame.getContentPane(), "Team");
		}
	}

    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (globeImage != null)
        {
			
			int newWidth = globeImage.getWidth(this) -150;
			int newHeight = globeImage.getHeight(this) -150;
            //image was too big
           
			//center image
            int x = (getWidth() - newWidth) / 2;
            int y = (getHeight() - newHeight) / 2;
            g.drawImage(globeImage, x, y, newWidth, newHeight, this); 
        }
    }
}

class GamePanel extends JPanel implements ActionListener, MouseListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
    private Image mapImage;

    public GamePanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());  // Use BorderLayout to organize the components

        cards = cardLayout;
        geoFrame = frame;
		
		addMouseListener(this);
		requestFocusInWindow();
		
        // Load the world map image
        try
        {
            mapImage = ImageIO.read(new File("world_map.jpg")); // Replace with your map image
        }
        catch (IOException e)
        {
            e.printStackTrace(); // Handle image loading error
            System.err.println("Error opening map image file.");
        }

        // Create a JPanel at the top with a JLabel for instructions
        JPanel topPanel = new JPanel();
        JLabel instructionsLabel = new JLabel("Click anywhere on the map!");
        instructionsLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        topPanel.add(instructionsLabel);
        topPanel.setOpaque(false);  // Make the top panel transparent
        add(topPanel, BorderLayout.NORTH);  // Add the top panel at the top

        // Home button at the bottom
        JButton homeButton = geoFrame.createHomeButton();
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false); // Make the bottom panel transparent
        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(this);
    }

    // Paint the map image on the panel
    
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (mapImage != null)
		{
			// Get the panel dimensions
			int panelWidth = getWidth();
			int panelHeight = getHeight();

			// Define the height reserved for the JLabel at the top of the screen
			int labelHeight = 50;  // You can change this based on the actual height of the JLabel

			// Height available for the map (panel height minus the space for the JLabel)
			int availableHeight = panelHeight - labelHeight;

			// Scale the map image to take up the entire available height while maintaining aspect ratio
			int newWidth = panelWidth;
			int newHeight = (mapImage.getHeight(null) * panelWidth) / mapImage.getWidth(null);

			// If the scaled height is smaller than the available height, adjust the width to fit
			if (newHeight < availableHeight) 
			{
				newHeight = availableHeight; // Make the image fit the available height
				newWidth = (mapImage.getWidth(null) * availableHeight) / mapImage.getHeight(null);
			}

			// Position the image to start drawing from below the JLabel
			int x = (panelWidth - newWidth) / 2;  // Center horizontally
			int y = labelHeight;  // Start drawing just below the label

			g.drawImage(mapImage, x, y, newWidth, newHeight, this);
		}
	}

	public void mouseClicked(MouseEvent e) 
	{
		cards.show(geoFrame.getContentPane(), "Question");
		
    }

   
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}


    public void actionPerformed(ActionEvent e)
    
    {
        cards.show(geoFrame.getContentPane(), "Home");
    }
}

class InstructionsPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
   
    public InstructionsPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());
		
		
		cards = cardLayout;
		geoFrame = frame;
		
		//JTextArea for the instructions
		JTextArea instructionsTextArea = new JTextArea();
		
		String instructions = new String(
			"Instructions:\n\n" +
			"1. Please run this program on Windows 10/11 for the best experience.\n\n" +
			"2. "); //lets put the instructions here
		
		instructionsTextArea.setText("Welcome to GeoMonsters!\n\n" +
                "In this game, you'll explore the world map, answer regional geography questions, " +
                "and collect different creatures along the way.\n\n" +
                "This educational game is meant to help prepare you for the International Geography Olympiad.\n\n" + instructions);
		instructionsTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
		instructionsTextArea.setEditable(false);
		instructionsTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(instructionsTextArea);
		scrollPane.setPreferredSize(new Dimension(600, 400));  //set a preferred size for the scroll panel
		
		add(scrollPane, BorderLayout.CENTER);
		
        // Home button
        JButton homeButton = geoFrame.createHomeButton();
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
		cards.show(geoFrame.getContentPane(), "Home");
	}
}


class CreditsPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
   
    public CreditsPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());
		
		
		cards = cardLayout;
		geoFrame = frame;
		
		//JTextArea for the credits
		JTextArea creditsTextArea = new JTextArea();
		creditsTextArea.setText("Credits:\n\nStackOverflow - adding ImageIcon to JButton, setOpaque\nOracle - SwingConstants\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		creditsTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
		creditsTextArea.setEditable(false);
		creditsTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(creditsTextArea);
		scrollPane.setPreferredSize(new Dimension(600, 400));  //set a preferred size for the scroll panel

		add(scrollPane, BorderLayout.CENTER);

        // Home button
        JButton homeButton = geoFrame.createHomeButton();
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
		cards.show(geoFrame.getContentPane(), "Home");
	}
}

class TeamPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
   
    public TeamPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());
		
		
		cards = cardLayout;
		geoFrame = frame;
		
        //Placeholder for right now
        JLabel label = new JLabel("This is the Team Panel", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        //home button
        JButton homeButton = geoFrame.createHomeButton();
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
		cards.show(geoFrame.getContentPane(), "Home");
	}
}


class QuestionPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
    private JLabel timerLabel;
    private JPanel imagePanel;
    private JButton skipButton;
    private JButton answerButton1;
    private JButton answerButton2;
    private JButton answerButton3;
    private JButton answerButton4;
    private Timer countdownTimer;
    private int timeRemaining = 15;
    private ImageIcon clockImage;	
    private JButton backButton;
   
    public QuestionPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(null);
        
        cards = cardLayout;
        geoFrame = frame;

        // top question bar
        JLabel questionLabel = new JLabel("Question: ", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBounds(10, 10, 780, 30);
        questionLabel.setOpaque(true);
        questionLabel.setBackground(new Color(230, 230, 230)); //gray
        add(questionLabel);
        
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBounds(10, 50, 780, 350);
        contentPanel.setBackground(new Color(240, 240, 240));
        contentPanel.setOpaque(true);
        add(contentPanel);
        
        //anonymous inner class (credits to StackOverflow)
        JPanel timerPanel = new JPanel(null)
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                if (clockImage != null)
                {
                    g.drawImage(clockImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                    //clockImage is an ImageIcon
                }
            }
        };
        timerPanel.setBounds(20, 120, 80, 80);
        timerPanel.setOpaque(false);
        contentPanel.add(timerPanel);
        
        try
        {
            clockImage = new ImageIcon("clock.jpg");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error loading clock image: " + e.getMessage());
        }
        
        timerLabel = new JLabel("" + timeRemaining); //int to string
        timerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setForeground(Color.RED);
        timerLabel.setBounds(0, 0, 80, 80);
        
		//timer label is transparent allowing the image behind to work
        timerLabel.setOpaque(false);
        timerPanel.add(timerLabel);
        
        // Create countdown timer (1 second intervals)
        countdownTimer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timeRemaining--;
                timerLabel.setText("" + timeRemaining);
                
                if (timeRemaining <= 5)
                //timer turns red when timer is low
                {
                    timerLabel.setForeground(Color.RED);
                }
                
                //stop when it ends
                if (timeRemaining <= 0)
                {
                    countdownTimer.stop();
                }
                repaint();
            }
        });
        
        //center image
        imagePanel = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        };
        
        imagePanel.setBounds(120, 20, 560, 310);
        contentPanel.add(imagePanel);
        
        skipButton = new JButton("SKIP");
        skipButton.setBounds(690, 20, 80, 35);
        skipButton.setBackground(new Color(255,102,102));
        skipButton.setForeground(Color.BLACK);
        skipButton.setOpaque(true);
        skipButton.setFocusPainted(false);
        skipButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        skipButton.addActionListener(this); // Skip button action
        contentPanel.add(skipButton);

        answerButton1 = new JButton("Red");
        answerButton1.setBounds(10, 410, 380, 50);
        answerButton1.setBackground(new Color(255,102,102));
        answerButton1.setForeground(Color.BLACK);
        answerButton1.setFocusPainted(false);
        answerButton1.setFont(new Font("SansSerif", Font.BOLD, 14));
        answerButton1.addActionListener(this); // Answer button action
        add(answerButton1);

        answerButton2 = new JButton("Blue");
        answerButton2.setBounds(400, 410, 380, 50);
        answerButton2.setBackground(Color.BLUE);
        answerButton2.setForeground(Color.BLACK);
        answerButton2.setFocusPainted(false);
        answerButton2.setFont(new Font("SansSerif", Font.BOLD, 14));
        answerButton2.addActionListener(this); // Answer button action
        add(answerButton2);

        answerButton3 = new JButton("Yellow");
        answerButton3.setBounds(10, 465, 380, 50);
        answerButton3.setBackground(Color.YELLOW);
        answerButton3.setForeground(Color.BLACK);
        answerButton3.setFocusPainted(false);
        answerButton3.setFont(new Font("SansSerif", Font.BOLD, 14));
        answerButton3.addActionListener(this); // Answer button action
        add(answerButton3);

        answerButton4 = new JButton("Green");
        answerButton4.setBounds(400, 465, 380, 50);
        answerButton4.setBackground(Color.GREEN);
        answerButton4.setForeground(Color.BLACK);
        answerButton4.setFocusPainted(false);
        answerButton4.setFont(new Font("SansSerif", Font.BOLD, 14));
        answerButton4.addActionListener(this); // Answer button action
        add(answerButton4);

        backButton = geoFrame.createHomeButton();
        backButton.setActionCommand("BACK");
        backButton.setText("BACK"); // back to map
        backButton.setBounds(325, 520, 120, 40);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(backButton);
        backButton.addActionListener(this);
    }
    
    public void setVisible(boolean visible)
    {
		//method only starts the timer when the panel is shown
        super.setVisible(visible);
        if (visible)
        {
            startTimer(); 
        }
        else
        {
            stopTimer();
        }
    }
    
    public void startTimer()
    {
        timeRemaining = 15;
        timerLabel.setText("" + timeRemaining); //string to work
        timerLabel.setForeground(Color.BLACK);
        countdownTimer.start();
    }
    
	//when panel isnt visible this runs
	public void stopTimer()
    {
        if (countdownTimer.isRunning())
        {
            countdownTimer.stop();
            timeRemaining = 15; //reset
        }
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(10, 50, 780, 350);
        g.drawRect(9, 49, 782, 352);
        //double line border
    }
    
    public void actionPerformed(ActionEvent e)
    {
        stopTimer();
        //when you click any button you will leave the Panel so we stop timer
        
        if (e.getSource() == backButton)
		{
		
			cards.show(geoFrame.getContentPane(), "Game");
		}
        else
			cards.show(geoFrame.getContentPane(), "Answer");
		}
}


class AnswerPanel extends JPanel implements ActionListener
{
    private CardLayout cards;
    private GeoMonsters geoFrame;
   
    public AnswerPanel(GeoMonsters frame, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());
		
		
		cards = cardLayout;
		geoFrame = frame;
		
        //Placeholder for right now
        JLabel label = new JLabel("This is the Answer Panel", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // Home button
        JButton homeButton = geoFrame.createHomeButton();
        homeButton.setText("MAP");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        homeButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
		cards.show(geoFrame.getContentPane(), "Game");
	}
}
