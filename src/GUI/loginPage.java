package GUI;
import java.awt.EventQueue;
import services.HotelMain;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	int a = 25;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
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
	public loginPage() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 0, 0));
		mainPanel.setBounds(917, 498, -930, -487);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(204, 141, 476, 64);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(204, 275, 476, 64);
		contentPane.add(textFieldPassword);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
		emailLabel.setBounds(381, 90, 244, 50);
		contentPane.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
		passwordLabel.setBounds(351, 225, 244, 50);
		contentPane.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String email = textFieldEmail.getText();
		        String password = textFieldPassword.getText();
		        
		        if (email.isEmpty() || password.isEmpty()) {
		            System.out.println("Please fill all fields.");
		        } else if (Database.loginUser(email, password)) {
		            System.out.println("Login successful!");
		            setVisible(false); // Hide the login page
		            dispose();         // Dispose of the current frame

		            // Redirect to HotelMain logic
		            services.HotelMain.main(null); 
		        } else {
		            System.out.println("Invalid email or password.");
		        }
		    }
		});




		loginButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 27));
		loginButton.setBounds(310, 364, 262, 57);
		contentPane.add(loginButton);
	}
}
