package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import services.RoomSystem;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
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
	public mainPage() {
		setTitle("Main Page");
		JTextArea textArea = new JTextArea();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewRoom = new JButton("Update Reservations");
		btnAddNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateReservations ur = new updateReservations();
				ur.setVisible(true);
			}
		});
		btnAddNewRoom.setBounds(90, 445, 160, 45);
		contentPane.add(btnAddNewRoom);
		
		JButton btnShowAllRooms = new JButton("Show All Reservations");
		btnShowAllRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textArea.setText(RoomSystem.getRooms());
				 System.out.println("salam");
			}
		});
		btnShowAllRooms.setBounds(260, 445, 160, 45);
		contentPane.add(btnShowAllRooms);
		
		JButton btnShowEmptyRooms = new JButton("Sort by Price");
		btnShowEmptyRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(RoomSystem.sortByPrice());
			}
		});
		btnShowEmptyRooms.setBounds(430, 445, 129, 45);
		contentPane.add(btnShowEmptyRooms);
		
		
		textArea.setBounds(90, 42, 618, 400);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPage sp = new searchPage();
				sp.setVisible(true);
			}
		});
		btnNewButton.setBounds(569, 446, 139, 43);
		contentPane.add(btnNewButton);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
