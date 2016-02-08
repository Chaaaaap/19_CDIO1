package gui;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {

	public Frame (String title) { 
		super(title);
		getContentPane().setLayout(new BoxLayout(, defaultCloseOperation));
		setSize(525, 250);
		setLocationRelativeTo(null);
		addComponents(); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}

	private void addComponents() { 	
		// Alt hvad der er i denne metode er det der bliver vist i GUI
		// i den rækkefølge som det er skrevet i.



		JLabel info = new JLabel("Overskrift");
		info.setFont(info.getFont().deriveFont(14.0f));
		getContentPane().add(info);

		JButton login = new JButton("Login");
		login.addActionListener(this);
		getContentPane().add(login);
		getRootPane().setDefaultButton(login);

		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(this);
		getContentPane().add(signUp);
		getRootPane().setDefaultButton(signUp);
		
		JButton changePswd = new JButton("Change Password");
		changePswd.addActionListener(this);
		getContentPane().add(changePswd);
		getRootPane().setDefaultButton(changePswd);
		
		JButton weighing = new JButton("Weighing");
		weighing.addActionListener(this);
		getContentPane().add(weighing);
		getRootPane().setDefaultButton(weighing);
		
		JButton close = new JButton("Close");
		close.addActionListener(this);
		getContentPane().add(close);
		getRootPane().setDefaultButton(close);



	}

	@Override
	public void actionPerformed(ActionEvent arg0) {


	}




}
