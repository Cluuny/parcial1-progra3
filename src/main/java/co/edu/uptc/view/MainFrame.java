package co.edu.uptc.view;

import javax.swing.*;
import co.edu.uptc.model.structure.SimpleLinkedList;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private SimpleLinkedList<String> departmentList;

    public MainFrame(ActionListener actionListener1, ActionListener actionListener2) {
        // Window settings
        setTitle("Swing Example with Panels");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons
        JButton button1 = new JButton("Show Departments");
        JButton button2 = new JButton("Show Deparments and Cities");

        // Add action listeners to buttons
        button1.addActionListener(actionListener1);
        button2.addActionListener(actionListener2);

        // Add buttons to the button panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Create dynamic panel where other panels will be added
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS));

        // Add panels to the main container
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(dynamicPanel, BorderLayout.CENTER);

        // Set up the frame with the main panel
        setContentPane(mainPanel);
    }

    public void displayDepartments(SimpleLinkedList<String> departmentList) {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        for (String department : departmentList) {
            panel1.add(new JLabel(department));
        }

        // Create a JScrollPane to make the panel scrollable
        JScrollPane scrollPane = new JScrollPane(panel1);
        scrollPane.setPreferredSize(new Dimension(300, 200)); // Set the preferred size for the scroll pane

        // Open the panel in a new window
        JFrame newFrame = new JFrame("Departments");
        newFrame.setSize(300, 200);
        newFrame.setLocationRelativeTo(null);
        newFrame.add(scrollPane); // Add the scroll pane to the frame
        newFrame.setVisible(true);
    }

    public void displayMunicipalities(SimpleLinkedList<String> municipalities) {
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        for (String municipality : municipalities) {
            panel2.add(new JLabel(municipality));
        }

        // Create a JScrollPane to make the panel scrollable
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setPreferredSize(new Dimension(300, 200)); // Set the preferred size for the scroll pane

        // Open the panel in a new window
        JFrame newFrame = new JFrame("Municipalities");
        newFrame.setSize(300, 200);
        newFrame.setLocationRelativeTo(null);
        newFrame.add(scrollPane); // Add the scroll pane to the frame
        newFrame.setVisible(true);
    }
}
