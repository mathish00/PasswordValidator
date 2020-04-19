package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SuccessfulCreation extends JFrame {

	protected final static String title = "Successful!";
	private final static Dimension size = new Dimension(400, 100);
	
	private JLabel main;
	private JPanel jp;
	
	public SuccessfulCreation() {
		super(title);
		setSize(size);
		
		
		
		jp = new JPanel();
		add(jp);
		Font font = new Font("Courier", Font.BOLD, 17);
		main = new JLabel("User has been created successfully!");
		main.setFont(font);
		
		jp.add(main);
		
		setVisible(true);
		
	}
}
