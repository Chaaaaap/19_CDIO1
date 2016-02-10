package gui;

import java.awt.BorderLayout;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame {

	JFrame frame; 
	
	public void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("CDIO1", pane, 25.0f);
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
	
	public void addPasswordField(Container container){
		
		JPasswordField pass = new JPasswordField(10);
		pass.setEchoChar('*');
		pass.setAlignmentX(Component.CENTER_ALIGNMENT);
		pass.setMaximumSize(new Dimension(200,30));
		pass.addActionListener(new AL());
		container.add(pass, BorderLayout.WEST);
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
	
	public void closeGUI() {	
		
	}
}

class AL implements ActionListener{
	
	private static String password = "pass";

	@Override
	public void actionPerformed(ActionEvent e) {
		JPasswordField input = (JPasswordField) e.getSource();
		char[] passw = input.getPassword();
		String pass = new String(passw);
		if(pass.equals(password))
			JOptionPane.showMessageDialog(null, "Correct");
		else
			JOptionPane.showMessageDialog(null, "Incorrect");		
	}
	
}

