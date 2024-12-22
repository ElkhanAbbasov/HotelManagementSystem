package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Models.Butler;
import Models.OneRoom;
import Models.TwoRoom;
import services.RoomSystem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateReservations extends JFrame {

    private JPanel contentPane;
    private JTextField textField; // Room Number
    private JCheckBox chckbxNewCheckBox; // Occupied
    private JTextField textField_2; // Floor Number
    private JTextField textField_3; // Start Date
    private JTextField textField_4; // End Date
    private JTextField textField_5; // Room Members
    private JTextField textField_6; // Remove Room Number
    private JLabel lblFeedback; // Feedback label for general actions
    private JLabel lblMemberFeedback; // Feedback label for member addition
    private String[] buts = new String[10]; // VIP-specific additions
    private int nums = 0;
    private String[] members = new String[5]; // Room members
    private int numOfMembers = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                updateReservations frame = new updateReservations();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public updateReservations() {
    	setTitle("Update Rooms");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels and Inputs
        JLabel lblNewLabel = new JLabel("Room Number:");
        lblNewLabel.setBounds(250, 10, 100, 35);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(360, 18, 140, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblOccupied = new JLabel("Occupied:");
        lblOccupied.setBounds(250, 55, 100, 35);
        contentPane.add(lblOccupied);

        chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(360, 62, 140, 21);
        contentPane.add(chckbxNewCheckBox);

        JLabel lblFloorNumber = new JLabel("Floor Number:");
        lblFloorNumber.setBounds(250, 100, 100, 35);
        contentPane.add(lblFloorNumber);

        textField_2 = new JTextField();
        textField_2.setBounds(360, 108, 140, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(250, 145, 100, 35);
        contentPane.add(lblRoomType);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"OneRoom", "TwoRoom", "VipRoom"}));
        comboBox.setBounds(360, 152, 140, 21);
        contentPane.add(comboBox);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(OneRoom.getBedType())); // Default bed types for OneRoom
        comboBox_1.setBounds(599, 150, 108, 27);
        contentPane.add(comboBox_1);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Extra Bed");
        chckbxNewCheckBox_1.setBounds(599, 119, 128, 23);
        contentPane.add(chckbxNewCheckBox_1);
        chckbxNewCheckBox_1.setVisible(false);

        JButton vipButton = new JButton("Add");
        vipButton.setBounds(599, 182, 108, 29);
        contentPane.add(vipButton);
        vipButton.setVisible(false);

        JLabel lblStartDate = new JLabel("Start Date:");
        lblStartDate.setBounds(250, 235, 100, 35);
        contentPane.add(lblStartDate);

        textField_3 = new JTextField();
        textField_3.setBounds(360, 243, 140, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblEndDate = new JLabel("End Date:");
        lblEndDate.setBounds(250, 280, 100, 35);
        contentPane.add(lblEndDate);

        textField_4 = new JTextField();
        textField_4.setBounds(360, 288, 140, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblFloorNumber_1 = new JLabel("Room Members:");
        lblFloorNumber_1.setBounds(250, 190, 100, 35);
        contentPane.add(lblFloorNumber_1);

        textField_5 = new JTextField();
        textField_5.setBounds(360, 198, 140, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JButton memberAdd = new JButton("Add Member");
        memberAdd.setBounds(502, 197, 120, 23);
        contentPane.add(memberAdd);
        memberAdd.setVisible(true); // Ensure visibility

        lblMemberFeedback = new JLabel(""); // Feedback for adding members
        lblMemberFeedback.setBounds(360, 220, 300, 20);
        contentPane.add(lblMemberFeedback);

        JButton btnNewButton = new JButton("Add Reservation");
        btnNewButton.setBounds(250, 325, 250, 35);
        contentPane.add(btnNewButton);

        textField_6 = new JTextField();
        textField_6.setBounds(250, 423, 250, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        lblFeedback = new JLabel(""); // General feedback
        lblFeedback.setBounds(250, 500, 300, 20);
        contentPane.add(lblFeedback);

        JButton btnRemoveReservation = new JButton("Remove Reservation");
        btnRemoveReservation.setBounds(250, 453, 250, 35);
        contentPane.add(btnRemoveReservation);

        JButton btnClearFields = new JButton("Clear Fields");
        btnClearFields.setBounds(250, 370, 250, 35);
        contentPane.add(btnClearFields);

        // Event Listeners
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem().equals("OneRoom")) {
                comboBox_1.setModel(new DefaultComboBoxModel<>(OneRoom.getBedType()));
                chckbxNewCheckBox_1.setVisible(false);
                vipButton.setVisible(false);
            } else if (comboBox.getSelectedItem().equals("TwoRoom")) {
                comboBox_1.setModel(new DefaultComboBoxModel<>(TwoRoom.getBedType()));
                chckbxNewCheckBox_1.setVisible(true);
                vipButton.setVisible(false);
            } else {
                comboBox_1.setModel(new DefaultComboBoxModel<>(Butler.getType()));
                vipButton.setVisible(true);
                chckbxNewCheckBox_1.setVisible(false);
            }
        });

        memberAdd.addActionListener(e -> {
            String roomType = (String) comboBox.getSelectedItem();
            boolean extraBed = chckbxNewCheckBox_1.isSelected();
            int maxGuests = 0;

            if (roomType.equals("OneRoom")) {
                maxGuests = 1; // One guest allowed
            } else if (roomType.equals("TwoRoom")) {
                maxGuests = extraBed ? 3 : 2; // Two guests normally, three with extra bed
            } else if (roomType.equals("VipRoom")) {
                maxGuests = 10; // Arbitrary limit for VIP
            }

            if (numOfMembers < maxGuests) {
                members[numOfMembers] = textField_5.getText();
                numOfMembers++;
                lblMemberFeedback.setText("Member added: " + textField_5.getText());
                textField_5.setText(""); // Clear input field after adding member
            } else {
                lblMemberFeedback.setText("Error: Maximum number of guests exceeded for " + roomType + ".");
            }
        });

        btnNewButton.addActionListener(e -> {
            String startDate = textField_3.getText();
            String endDate = textField_4.getText();

            if (startDate.compareTo(endDate) > 0) {
                lblFeedback.setText("Error: Start date cannot be later than end date.");
                return;
            }

            RoomSystem.addReserve(
                Integer.parseInt(textField.getText()),
                chckbxNewCheckBox.isSelected(),
                Integer.parseInt(textField_2.getText()),
                (String) comboBox_1.getSelectedItem(),
                chckbxNewCheckBox_1.isSelected(),
                members,
                (String) comboBox.getSelectedItem(),
                startDate,
                endDate,
                nums,
                buts
            );
            lblFeedback.setText("Reservation added successfully.");
        });

        btnRemoveReservation.addActionListener(e -> {
            String room_num = textField_6.getText();
            if (RoomSystem.removeReserve(Integer.parseInt(room_num))) {
                lblFeedback.setText("The reservation was deleted.");
            } else {
                lblFeedback.setText("The reservation not found.");
            }
            textField_6.setText("");
        });

        btnClearFields.addActionListener(e -> {
            textField.setText("");
            textField_2.setText("");
            textField_3.setText("");
            textField_4.setText("");
            textField_5.setText("");
            textField_6.setText("");
            lblFeedback.setText("");
            lblMemberFeedback.setText("");
        });

        // Ensure repaint and revalidate to show all components
        contentPane.repaint();
        contentPane.revalidate();
    }
}
