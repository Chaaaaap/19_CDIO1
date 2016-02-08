package gui;
 
/*
 * BoxLayoutDemo.java requires no other files.
 */
 
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class Frame {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        addLabel(pane);
        addAButton("Login", pane);
        addAButton("Sign Up", pane);
        
       
    }
 
    private static void addLabel(Container container) {
       	JLabel field = new JLabel("Operator Administration");
       	field.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setFont(field.getFont().deriveFont(25.0f));
    	container.add(field);
    }
    
    
    private static void addAButton(String text, Container container) {
 
    	
    	JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(100, 30));
        
        container.add(button);
        
        
        
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Operator Administration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 180);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    
}
