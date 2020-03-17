// imports
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JProgressBar;
import java.util.*;
import java.awt.SystemColor;
public class Board extends JFrame {

	private JPanel contentPane;
	private JFrame welcome; 
	private JFrame current;
	private JLabel red;
	private JLabel green;
	
	
	//player variables 
	int count1 = 0;
	int count2 = 0;
	int money1 = 1500;
	int money2 = 1500;
	int whoplays = 0;
	int turn = 30;
	
	//arraylist for coordinates, properties, and locations
	private int [] xcoord = new int [] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 120, 173, 228, 283, 338, 393, 448, 503, 558, 602, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 558, 503, 448, 393, 338, 283, 228, 173, 120} ;
	private int [] ycoord = new int [] {605, 546, 493, 440, 387, 334, 276, 221, 166, 111, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 111, 166, 221, 276, 334, 387, 440, 493, 546, 605, 600, 600, 600, 600, 600, 600, 600, 600, 600} ;
	private ArrayList<Locations> locations=new ArrayList<Locations>();
	private ArrayList<Locations> properties1 = new ArrayList<Locations>();
	private ArrayList<Locations> properties2 = new ArrayList<Locations>();
	
	/**
	 * Launch the application.
	 * @return 
	 */
	
	public Board(JFrame welcome) {
		
		Scanner fileIn = null;
		try
	    {
			fileIn = new Scanner(new File("toRead.txt"));
	    }
	    catch(FileNotFoundException s)
	    {
	    	System.out.println("File does Not Exist Please Try Again: ");
	    }
		
		//file reading to add all the locations objects to the locations arraylist
		while(fileIn.hasNextLine())
	    {
			String nextInput = fileIn.nextLine().trim();
			if (nextInput.equals("Holding")) {
				boolean buy = fileIn.nextBoolean();
				int x = fileIn.nextInt();
				int y = fileIn.nextInt();
				fileIn.nextLine();
				locations.add(new Holding(buy, x, y));
			}
			else if (nextInput.equals("Property")){
				boolean buy = fileIn.nextBoolean();
				int x = fileIn.nextInt();
				int y = fileIn.nextInt();
				int price = fileIn.nextInt();
				int rent = fileIn.nextInt();
				fileIn.nextLine();
				locations.add(new Properties(buy, x, y, price, rent));
				
			}
			else if (nextInput.equals("ChanceComm")){
				boolean buy = fileIn.nextBoolean();
				int x = fileIn.nextInt();
				int y = fileIn.nextInt();
				fileIn.nextLine();
				locations.add(new ChanceComm(buy, x, y));
			}
			else if (nextInput.equals("Tax")){
				boolean buy = fileIn.nextBoolean();
				int x = fileIn.nextInt();
				int y = fileIn.nextInt();
				int amount = fileIn.nextInt();
				fileIn.nextLine();
				locations.add(new Tax(buy, x, y, amount));
			}
			else if (nextInput.equals("Jail")){
				boolean buy = fileIn.nextBoolean();
				int x = fileIn.nextInt();
				int y = fileIn.nextInt();
				boolean inside = fileIn.nextBoolean();
				fileIn.nextLine();
				locations.add(new Jail(buy, x, y, inside));
			}
  
	    }
		
		//for switching to the current jframe from the welcome jframe
		this.welcome = welcome;
		this.current = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label that displays the winner
		JLabel winnerLabel = new JLabel("");
		winnerLabel.setBounds(104, 430, 492, 167);
		contentPane.add(winnerLabel);
		setResizable(false); 
		winnerLabel.setVisible(false);
		
		//display label for all moves
		JLabel updateLabel = new JLabel("Welcome to Monopoly!");
		updateLabel.setBounds(127, 162, 464, 27);
		contentPane.add(updateLabel);
		
		//player 1 money update label
		JLabel player1_1 = new JLabel("");
		player1_1.setText("Player 1: " + money1);
		player1_1.setBounds(144, 116, 108, 35);
		contentPane.add(player1_1);
		player1_1.setVisible(true);
		
		//player 2 money update label
		JLabel player2_1 = new JLabel("");
		player2_1.setText("Player 2: " + money2);
		player2_1.setBounds(278, 116, 108, 35);
		contentPane.add(player2_1);
		player2_1.setVisible(true);
		
		//buy button 1
		JButton buyButton1 = new JButton("BUY 1");
		buyButton1.setBackground(new Color(240, 240, 240));
		buyButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		buyButton1.setForeground(new Color(0, 0, 0));
		buyButton1.setEnabled(false);
		buyButton1.setBounds(327, 499, 117, 35);
		contentPane.add(buyButton1);
		//adding the event handler to detect a click, and buying the property
		buyButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				money1 = money1 - locations.get(count1).getPrice();
				properties1.add(locations.get(count1));
				player1_1.setText("Player 1: " + money1);
				buyButton1.setEnabled(false);
				locations.get(count1).setBuyable(false);
			}
		});
		
		//buy button two
		JButton buyButton2 = new JButton("BUY 2");
		buyButton2.setForeground(Color.BLACK);
		buyButton2.setBackground(new Color(240, 240, 240));
		buyButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		buyButton2.setEnabled(false);
		buyButton2.setBounds(187, 499, 117, 35);
		contentPane.add(buyButton2);
		//adding the event handler to detect a click, and buying the property
		buyButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent b) {
				money2 = money2 - locations.get(count2).getPrice();
				properties2.add(locations.get(count2));
				player2_1.setText("Player 2: " + money2);
				buyButton2.setEnabled(false);
				locations.get(count2).setBuyable(false);
				
			}
		});
		
		// Progress Bar for displaying turns left 
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setString("Turns left: "+ turn);
		progressBar.setEnabled(false);
		progressBar.setValue(30);
		progressBar.setForeground(Color.BLACK);
		progressBar.setToolTipText("Turns Left:");
		progressBar.setMaximum(30);
		progressBar.setBackground(Color.BLACK);
		progressBar.setBounds(385, 550, 160, 27);
		contentPane.add(progressBar);
		
		// Green Pawn 
		JLabel green = new JLabel("");
		green.setIcon(new ImageIcon(Board.class.getResource("/images/green.png")));
		green.setBounds(35, 605, 25, 47);
		contentPane.add(green);
		
		// Red Pawn
		JLabel red = new JLabel("");
		red.setIcon(new ImageIcon(Board.class.getResource("/images/red.png")));
		red.setBounds(0, 605, 25, 47);
		contentPane.add(red);
		
		// Button for roll	
		JButton rollButton = new JButton("ROLL");
		rollButton.setForeground(SystemColor.desktop);
		rollButton.setBackground(SystemColor.menu);
		rollButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		rollButton.setBounds(474, 499, 117, 35);
		contentPane.add(rollButton);
		rollButton.addMouseListener(new MouseAdapter() {
			
		//creating the two player objects
		Player player1 = new Player(money1, properties1);
		Player player2 = new Player(money2, properties2);
		
		@Override
		//Method for roll, when button is clicked if turn is more than 0 then roll
		public void mouseClicked(MouseEvent e) {
			if (turn > 0){
				// Red player
				if (whoplays == 0) {
					buyButton2.setEnabled(false);
					int roll1=(int)(Math.random()*12+1);
					//adding money when player passes go
					if(count1 + roll1>40) {
						money1 = money1 + 200;
						updateLabel.setText("Its payday! You just got your $200 salary for passing go.");
						player1_1.setText("Player 1: " + money1);
					}
					count1 = (count1 + roll1)%40;
					//updating the updateLabel
					updateLabel.setText("Player 1 rolls: " + roll1);
					//placing the pieces beside each other when on the same spot and moving the piece
					if (count1==count2) {
						if (count1<10|| (count1>20 && count1<30)) {
							red.setBounds(xcoord[count1]+35, ycoord[count1], 25, 47);
						}
						else if((count1>=10 && count1<=20)|| (count1>=30 && count1<=40)) {
							red.setBounds(xcoord[count1], ycoord[count1]+50, 25, 47);	
						}
						
					}
					//moving the piece based on the roll
					else {
						red.setBounds(xcoord[count1], ycoord[count1], 25, 47);
					}
					
					//checking if property is buyable, and setting the button to true
					if (locations.get(count1).getBuyable() == true) {
						buyButton1.setEnabled(true);
						updateLabel.setText("Click buy to buy this property. It costs $" + locations.get(count1).getPrice() + ".");
					}
					//if not buyable, determining what it is
					else {
						buyButton1.setEnabled(false);
						if (locations.get(count1) instanceof Jail) {
							red.setBounds(0, 0, 25, 47);
							updateLabel.setText("You're in Jail for doing bad! Pay a fine of $200.");
							//taking away $200 from the money and updating the updateLabel
							money1 = money1 - 200; 
							player1_1.setText("Player 1: " + money1);
							count1 = 10;
						}
						else if(locations.get(count1) instanceof ChanceComm) {
							//checking if chance, and subtracting money
							if (count1 == 7 || count1 == 22 || count1 == 36) {
								money1 = money1 - (roll1*10);
								updateLabel.setText("Bad luck! You lose $" + roll1*10 + ".");
								player1_1.setText("Player 1: " + money1);
							}
							//checking if community chest and adding money
							else {
								money1 = money1 + (roll1*10);
								updateLabel.setText("Congrats! You just earned a chest of money worth $" + roll1*10 + ".");
								player1_1.setText("Player 1: " + money1);
							}
						}
						else if (locations.get(count1) instanceof Tax) {
							updateLabel.setText("Its your unlucky day, pay a $" + locations.get(count1).getDeduct() + " tax." );
							//deducting a tax fee from the total money 
							money1 = money1 - locations.get(count1).getDeduct();
							player1_1.setText("Player 1: " + money1);
						}
						else if(locations.get(count1) instanceof Properties) {
							//checking if owned property is owned by other player, and charging rent
							if (properties2.contains(locations.get(count1))){
								money1 = money1 - (locations.get(count1).getRent());
								money2 = money2 + (locations.get(count1).getRent());
								player1_1.setText("Player 1: " + money1);
								player2_1.setText("Player 2: " + money2);
								updateLabel.setText("You paid player two $" + locations.get(count1).getRent() +  "\t in rent for landing on their property");
							}
							else {
								updateLabel.setText("You landed on your own property. It's vacation time!");
							}
						}
						else if (locations.get(count1) instanceof Holding) {
							//adding $200 if on free parking
							if (count1 == 20) {
								money1 = money1 + 200;
								updateLabel.setText("You just found $200 at a free parking, how lucky!"); 
								player1_1.setText("Player 1: " + money1);
							}
						}
						
					}
					
					//changing the turn to player two
					whoplays = 1;
					//subtracting number of turns left
					turn = turn - 1;
					progressBar.setValue(turn);
					progressBar.setString("Turns left: "+ turn);
					
				}
				
				
				// Green player
				else if (whoplays == 1) {
					buyButton1.setEnabled(false);
					int roll2 = (int)(Math.random()*12+1);
					//adding money when player passes go
					if(count2 + roll2>40) {
						money2 = money2 + 200;
						updateLabel.setText("Its payday! You just got your $200 salary for passing go.");
						player2_1.setText("Player 2: " + money2);
					}
					count2 = (count2 + roll2)%40;
					//updating the updateLabel
					updateLabel.setText("Player 2 rolls: " + roll2);
					//placing the pieces beside each other when on the same spot and moving the piece
					if (count1==count2) {
						if (count2<10|| (count2>20 && count2<30)) {
							green.setBounds(xcoord[count2]+35, ycoord[count2], 25, 47);
						}
						else if((count2>=10 && count2<=20)|| (count2>=30 && count2<=40)) {
							green.setBounds(xcoord[count2], ycoord[count2]+50, 25, 47);	
						}
					}
					//moving the piece based on the roll
					else {
						green.setBounds(xcoord[count2], ycoord[count2], 25, 47);
					}
					
					//checking if property is buyable, and setting the button to true
					if (locations.get(count2).getBuyable() == true) {
						buyButton2.setEnabled(true);
						updateLabel.setText("Click buy to buy this property. It costs $" + locations.get(count2).getPrice() + ".");
					}
					
					//if not buyable, determining what it is
					else {
						buyButton2.setEnabled(false);
						if (locations.get(count2) instanceof Jail) {
							//taking away $200 from the money and updating the updateLabel
							green.setBounds(30, 0, 25, 47);
							updateLabel.setText("You're in Jail for doing bad! Pay a fine of $200.");
							money2 = money2 -200; 
							player2_1.setText("Player 2: " + money2);
							count2 = 10;
						}
						else if(locations.get(count2) instanceof ChanceComm) {
							//checking if chance, and subtracting money
							if (count2 == 7 || count2 == 22 || count2 == 36) {
								money2 = money2 - (roll2*10);
								updateLabel.setText("Bad luck! You lose $" + roll2*10 + ".");
								player2_1.setText("Player 2: " + money2);
							}
							//checking if community chest and adding money
							else {
								money2 = money2 + (roll2*10);
								updateLabel.setText("Congrats! You just earned a chest of money worth $" + roll2*10 + ".");
								player2_1.setText("Player 2: " + money2);
							}
						}
						else if (locations.get(count2) instanceof Tax) {
							updateLabel.setText("Its your unlucky day, pay a $" + locations.get(count2).getDeduct() + " tax." );
							//deducting a tax fee from the total money 
							money2 = money2 - locations.get(count2).getDeduct();
							player2_1.setText("Player 2: " + money2);
						}
						else if(locations.get(count2) instanceof Properties) {
							//checking if owned property is owned by other player, and charging rent
							if (properties1.contains(locations.get(count2))){
								money2 = money2 - (locations.get(count2).getRent());
								money1 = money1 + (locations.get(count2).getRent());
								player1_1.setText("Player 1: " + money1);
								player2_1.setText("Player 2: " + money2);
								updateLabel.setText("You paid player one $" + locations.get(count2).getRent() +  "\t in rent for landing on their property");
							}
							else {
								updateLabel.setText("You landed on your own property. Its vacation time!"); 
							}
						}
						else if (locations.get(count2) instanceof Holding) {
							//adding $200 if on free parking
							if (count2 == 20) {
								money2 = money2 + 200;
								updateLabel.setText("You just found $200 at a free parking, how lucky!"); 
								player2_1.setText("Player 2: " + money2);
							}
						}
					}
					
					//changing the turn to player one
					whoplays = 0;
					//subtracting number of turns left
					turn = turn - 1;
					progressBar.setValue(turn);
					progressBar.setString("Turns left: "+ turn);
				}
				
				//if money becomes negative, game ends, and winner is displayed
				if (money1 < 0) {
					rollButton.setVisible(false);
					buyButton1.setVisible(false);
					buyButton2.setVisible(false);
					rollButton.setVisible(false);
					winnerLabel.setText("Player 2 wins. Congratulations!");
					winnerLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
					winnerLabel.setVisible(true);
				}
				//if money becomes negative, game ends, and winner is displayed
				else if (money2 < 0) {
					rollButton.setVisible(false);
					buyButton1.setVisible(false);
					buyButton2.setVisible(false);
					rollButton.setVisible(false);
					winnerLabel.setText("Player 1 wins. Congratulations!");
					winnerLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
					winnerLabel.setVisible(true);
				}
			}
			
			//if turns become 0, determine winner
			else if (turn == 0) {
				
				//liquidating assets for each player
				for (int i = 0; i<properties1.size(); i ++) {
					money1 = money1 + properties1.get(i).getPrice();
				}
				for (int i = 0; i<properties2.size(); i ++) {
					money2 = money2 + properties2.get(i).getPrice();
				}
				
				//checking to see which player has the most money, and displaying the winner
				if (money1>money2) {
					rollButton.setVisible(false);
					buyButton1.setVisible(false);
					buyButton2.setVisible(false);
					winnerLabel.setText("Player 1 wins. Congratulations!");
					winnerLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
					winnerLabel.setVisible(true);
				}
				else {
					rollButton.setVisible(false);
					buyButton1.setVisible(false);
					buyButton2.setVisible(false);
					winnerLabel.setText("Player 2 wins. Congratulations!");
					winnerLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
					winnerLabel.setVisible(true);
				}
				
			}
		}
		});
		
		
		//jlabel for the background picture
		JLabel boardPictureLabel = new JLabel("");
		boardPictureLabel.setForeground(SystemColor.menu);
		boardPictureLabel.setBounds(0, 0, 701, 701);
		boardPictureLabel.setIcon(new ImageIcon(Board.class.getResource("/images/E4MmKbest.jpg")));
		contentPane.add(boardPictureLabel);
		
		
		
		
		
		
		
		
		

	}
}
