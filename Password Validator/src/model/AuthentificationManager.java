package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Exceptions.AuthentificationException;
import Exceptions.LogInError;
import Exceptions.UnmatchingPasswordsException;
import Exceptions.UsernameException;
import view.*;

public class AuthentificationManager {

	private File userFolder = new File(".\\.\\Users");
	int numberOfUsers;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws IOException
	 * @throws UsernameException
	 * @throws UnmatchingPasswordsException 
	 */
	public void createUser(String username, String password, String confirmation) throws IOException, UsernameException, UnmatchingPasswordsException {
		if(password.equals(confirmation)) {
			for(int i = 0; i < userFolder.list().length; i++) {
				Path currentPath = Paths.get(userFolder + "\\" + userFolder.list()[i]);
				if(Files.lines(currentPath).toArray(String[]::new)[0].equals(username)) {
					throw new UsernameException("Username does already exist. Please choose another one!");
					
				}
				numberOfUsers++;
			}
			numberOfUsers++;
			File userData = new File(".\\.\\Users\\user" + numberOfUsers + ".txt");
			userData.createNewFile();
			FileWriter writer = new FileWriter(userData);
			writer.write(username + "\n");
			writer.write(password);
			writer.close();
		}
		else {
			throw new UnmatchingPasswordsException();
		}
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws AuthentificationException
	 * @throws IOException
	 */
	public boolean check (String username, String password) throws AuthentificationException, IOException  {
		for(int i = 0; i < userFolder.list().length; i++) {
			Path currentPath = Paths.get(userFolder + "\\" + userFolder.list()[i]);
			if(Files.lines(currentPath).toArray(String[]::new)[0].equals(username)) {
				if(Files.lines(currentPath).toArray(String[]::new)[1].equals(password)) {
					return true;
				}
				else {
					throw new AuthentificationException(LogInError.PASSWORD);
				}
			}
		}
		throw new AuthentificationException(LogInError.USERNAME);
	}
}
