package gui;

/*
 * BoxLayoutDemo.java requires no other files.
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame implements ActionListener {

	
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("Afvejningssystem", pane);
		addAButton(pane);


	}

	public static void addLabel(String text, Container container) {
		JLabel field = new JLabel(text);
		field.setAlignmentX(Component.CENTER_ALIGNMENT);
		field.setFont(field.getFont().deriveFont(25.0f));
		container.add(field);
		container.add(Box.createVerticalGlue());

	}


	public static void addAButton(Container container) {


		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new LoginButton());
		loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginBtn.setMaximumSize(new Dimension(100, 30));
		container.add(loginBtn);
		container.add(Box.createVerticalGlue());

		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(new SignUpButton());
		signUpBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		signUpBtn.setMaximumSize(new Dimension(100, 30));
		container.add(signUpBtn);
		container.add(Box.createVerticalGlue());


	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 180);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
