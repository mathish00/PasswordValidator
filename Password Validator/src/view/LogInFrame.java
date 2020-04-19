package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.AuthentificationException;
import Exceptions.LogInError;
import Exceptions.UnmatchingPasswordsException;
import Exceptions.UsernameException;
import controller.Controller;
import model.AuthentificationManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	private JPanel registerPanel;
	private JTextField newUsername;
	private JPasswordField newPassword;
	private JPasswordField conNewPassword;
	private JLabel newPwLabel;
	
	private AuthentificationManager manager = new AuthentificationManager();

	/**
	 * Create the frame.
	 */
	public LogInFrame(Controller c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 430);
		
		try {
			BufferedImage icon = ImageIO.read(new File(".\\.\\Icon\\access-512.png"));
			setIconImage(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel(" Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setBounds(15, 15, 144, 40);
		contentPane.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		usernameField.setBounds(15, 55, 320, 40);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel(" Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setBounds(15, 110, 144, 40);
		contentPane.add(passwordLabel);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(221, 215, 115, 30);
		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(manager.check(usernameField.getText(), passwordField.getText())) {
						new MainFrame();
						c.setCurrentUser(usernameField.getText());
						dispose();
						
					}
				} 
				catch (AuthentificationException e1) {
					if(e1.getError().equals(LogInError.PASSWORD)) {
						
					}
					else {
						
					}
				} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(15, 215, 115, 30);  
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				registerPanel.setVisible(true);
			}
			
		});
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBounds(15, 150, 320, 40);
		contentPane.add(passwordField);
		getContentPane().add(contentPane);
		setVisible(true);
		
		/**
		 * Registry view
		 */
		registerPanel = new JPanel();
		registerPanel.setVisible(false);
		registerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		registerPanel.setLayout(null);
		JLabel lblNewUsername = new JLabel(" Choose your username");
		lblNewUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewUsername.setBounds(15, 15, 222, 40);
		registerPanel.add(lblNewUsername);
		 
		newUsername = new JTextField();
		newUsername.setFont(new Font("Tahoma", Font.PLAIN, 19));
		newUsername.setColumns(10);
		newUsername.setBounds(15, 55, 320, 40);
		registerPanel.add(newUsername);
		
		JLabel lblNewPassword = new JLabel(" Choose your password");
		lblNewPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewPassword.setBounds(15, 110, 222, 40);
		registerPanel.add(lblNewPassword);
		
		newPassword = new JPasswordField();
		newPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		newPassword.setBounds(15, 150, 320, 40);
		registerPanel.add(newPassword);
		
		JLabel lblConfirmYourPassword = new JLabel(" Confirm your password");
		lblConfirmYourPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConfirmYourPassword.setBounds(15, 205, 222, 40);
		registerPanel.add(lblConfirmYourPassword);
		
		conNewPassword = new JPasswordField();
		conNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		conNewPassword.setBounds(15, 245, 320, 40);
		registerPanel.add(conNewPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerPanel.setVisible(false);
				contentPane.setVisible(true);
			}
			
		});
		btnBack.setBounds(15, 310, 115, 30);
		registerPanel.add(btnBack);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	 
				try {
					manager.createUser(newUsername.getText(), newPassword.getText(), conNewPassword.getText());
					new SuccessfulCreation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return;
				} catch (UsernameException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					return;
				} catch (UnmatchingPasswordsException e3) {
					
				}
			}
		});
		btnSubmit.setBounds(171, 310, 165, 30);
		registerPanel.add(btnSubmit);
		getContentPane().add(registerPanel);
		/**
		 * End of registry view
		 */
	}
}
