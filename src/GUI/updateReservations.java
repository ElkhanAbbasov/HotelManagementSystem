package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class updateReservations extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblOccupied;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblFloorNumber;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_1;
	private JButton btnRemoveReservation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateReservations frame = new updateReservations();
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
	public updateReservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Number:");
		lblNewLabel.setBounds(250, 10, 100, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(360, 18, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblOccupied = new JLabel("Occupied:");
		lblOccupied.setBounds(250, 55, 100, 35);
		contentPane.add(lblOccupied);
		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(360, 62, 140, 21);
		contentPane.add(chckbxNewCheckBox);
		
		lblFloorNumber = new JLabel("Floor Number:");
		lblFloorNumber.setBounds(250, 100, 100, 35);
		contentPane.add(lblFloorNumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(360, 108, 140, 20);
		contentPane.add(textField_2);
		
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setBounds(250, 145, 100, 35);
		contentPane.add(lblRoomType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single Room", "Double Room", "VIP Room"}));
		comboBox.setBounds(360, 152, 140, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add Reservation");
		btnNewButton.setBounds(250, 325, 250, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(250, 235, 100, 35);
		contentPane.add(lblStartDate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(360, 243, 140, 20);
		contentPane.add(textField_3);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(250, 280, 100, 35);
		contentPane.add(lblEndDate);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(360, 288, 140, 20);
		contentPane.add(textField_4);
		
		JLabel lblFloorNumber_1 = new JLabel("Room Members:");
		lblFloorNumber_1.setBounds(250, 190, 100, 35);
		contentPane.add(lblFloorNumber_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(360, 198, 140, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(360, 423, 140, 20);
		contentPane.add(textField_6);
		
		lblNewLabel_1 = new JLabel("Room Number:");
		lblNewLabel_1.setBounds(250, 415, 100, 35);
		contentPane.add(lblNewLabel_1);
		
		btnRemoveReservation = new JButton("Remove Reservation");
		btnRemoveReservation.setBounds(250, 453, 250, 35);
		contentPane.add(btnRemoveReservation);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.setBounds(250, 370, 250, 35);
		contentPane.add(btnClearFields);
	}
}
