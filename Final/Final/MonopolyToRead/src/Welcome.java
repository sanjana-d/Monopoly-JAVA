// imports
import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JFrame current;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//setting current frame to visible 
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		this.current = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//switching Jframe to Board when button clicked
		JButton btnClickToStart = new JButton("CLICK TO START!");
		btnClickToStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClickToStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Board newFrame = new Board(current);
				newFrame.setVisible(true);
				current.setVisible(false);
				
				
				
			}
			
		});
		
		//creating the start button
		btnClickToStart.setBackground(Color.RED);
		btnClickToStart.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		btnClickToStart.setBounds(362, 529, 252, 61);
		contentPane.add(btnClickToStart);
		
		//creating jlabel for the background image
		JLabel backgroundPicLabel = new JLabel("");
		backgroundPicLabel.setBackground(Color.WHITE);
		backgroundPicLabel.setIcon(new ImageIcon(Welcome.class.getResource("/images/2121155_1.jpg")));
		backgroundPicLabel.setBounds(0, 0, 630, 630);
		contentPane.add(backgroundPicLabel);
		setResizable(false); 
	}
}
