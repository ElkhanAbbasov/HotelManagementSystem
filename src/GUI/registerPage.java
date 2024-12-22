package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registerPage extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldPassword;
    private JLabel lblNewLabel; // Added JLabel

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Database.initializeDatabase();
                registerPage frame = new registerPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public registerPage() {
        setTitle("Register Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 925, 530);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
        emailLabel.setBounds(379, 80, 244, 50);
        contentPane.add(emailLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 35));
        passwordLabel.setBounds(355, 214, 244, 50);
        contentPane.add(passwordLabel);

        lblNewLabel = new JLabel(""); // Initialize JLabel for messages
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setBounds(204, 350, 476, 30);
        contentPane.add(lblNewLabel);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String password = textFieldPassword.getText();

                if (email.isEmpty() || password.isEmpty()) {
                    lblNewLabel.setText("Please fill all fields."); // Show error on JLabel
                } else if (Database.registerUser(email, password)) {
                    System.out.println("Registration successful!");

                    // Hide and dispose of the current window
                    setVisible(false);
                    dispose();

                    // Redirect to the loginPage
                    GUI.loginPage loginPage = new GUI.loginPage();
                    loginPage.setVisible(true);
                } else {
                    // Show error if registration fails
                    lblNewLabel.setText("Registration failed. Email might already be registered.");
                }
            }
        });
        registerButton.setFont(new Font("Mongolian Baiti", Font.BOLD, 27));
        registerButton.setBounds(313, 394, 262, 57);
        contentPane.add(registerButton);
    }
}
