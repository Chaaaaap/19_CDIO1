package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class SignUpButton implements ActionListener {

	Frame f = new Frame();
	
	private void addComponentsToPane(Container contentPane) {
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		f.addLabel("Sign Up page", contentPane , 25.0f);
		f.addLabel("Desired Username", contentPane, 15.0f);
		f.addTextField(contentPane);
		f.addLabel("Desired Password", contentPane, 15.0f);
		f.addTextField(contentPane);
		f.addAButton(contentPane, "Sign Up", new SignedUpButton());
		
	}
	
	public void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Sign Up Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 250);
		frame.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		createAndShowGUI();
		System.out.println("Sign Up");

	}
}
