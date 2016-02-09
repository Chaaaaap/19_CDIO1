package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class LoginButton implements ActionListener {

	Frame f = new Frame();
	
	private void addComponentsToPane(Container contentPane) {
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		f.addLabel("Login page", contentPane, 25.0f);
		f.addLabel("Username", contentPane, 15.0f);
		f.addTextField(contentPane);
		f.addLabel("Password", contentPane, 15.0f);
		f.addTextField(contentPane);
		f.addAButton(contentPane, "Enter", new EnterButton());
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		createAndShowGUI();
		
	}
		
		public void createAndShowGUI() {
			//Create and set up the window.
			JFrame frame = new JFrame("Login Menu");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Set up the content pane.
			addComponentsToPane(frame.getContentPane());

			//Display the window.
			frame.pack();
			frame.setVisible(true);
			frame.setSize(600, 250);
			frame.setLocationRelativeTo(null);
		}

	
}

