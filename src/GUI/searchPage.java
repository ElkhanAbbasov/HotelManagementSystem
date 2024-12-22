package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import services.RoomSystem;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class searchPage extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchPage frame = new searchPage();
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
	
	public searchPage() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTextArea resultField = new JTextArea();
		resultField.setBounds(62, 135, 483, 251);
		
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 602, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchField = new JTextField();
		searchField.setBounds(202, 38, 187, 37);
		panel.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String roomNo = searchField.getText();
				resultField.setText(RoomSystem.getSelectedRoom(Integer.parseInt(roomNo)).toString());
				
			}
		});
		
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchButton.setBounds(168, 86, 257, 37);
		panel.add(searchButton);
		panel.add(resultField);
	
	}
}
