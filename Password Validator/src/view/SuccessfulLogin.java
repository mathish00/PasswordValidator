package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class SuccessfulLogin extends JFrame {

	protected final static Dimension size = new Dimension(400, 100);
	protected final static String title = "Login successful!";
	protected JLabel label;
	protected JPanel jp;
	
	public SuccessfulLogin() {
		super(title);
		setSize(size);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		jp = new JPanel();
		add(jp);
		Font font = new Font("Courier", Font.BOLD, 17);
		label = new JLabel("Login has been successful!");
		label.setFont(font);
		jp.add(label);
		
		setVisible(true);
		
	}
}
