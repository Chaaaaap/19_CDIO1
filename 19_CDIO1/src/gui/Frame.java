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

public class Frame {

	
	public void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("Afvejningssystem", pane, 25.0f);
		addAButton(pane, "Login", new LoginButton());
		addAButton(pane, "Sign Up", new SignUpButton());


	}

	public void addLabel(String text, Container container, Float fontSize) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(label.getFont().deriveFont(fontSize));
		container.add(label);
		container.add(Box.createVerticalGlue());

	}


	public void addAButton(Container container, String btnName, ActionListener event) {


		JButton button = new JButton(btnName);
		button.addActionListener(event);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(100, 30));
		container.add(button);
		container.add(Box.createVerticalGlue());

	}
	
	public void addTextField(Container container) {
		JTextField field = new JTextField();
		field.setAlignmentX(Component.CENTER_ALIGNMENT);
		field.setMaximumSize(new Dimension(200,30));
		container.add(field);
		container.add(Box.createVerticalGlue());
	}


	public void createAndShowGUI(String title) {
		//Create and set up the window.
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		//Display the window.
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 180);
		frame.setLocationRelativeTo(null);
	}
}
