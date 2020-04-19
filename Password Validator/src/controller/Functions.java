package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.User;

public class Functions {
	
	private static File userFolder = new File(".\\.\\Users");

	public static void loadUsers(Controller c) throws IOException {
		User[] users = new User[userFolder.list().length];
		for(int i = 0; i < userFolder.list().length; i++) {
			Path currentPath = Paths.get(userFolder + "\\" + userFolder.list()[i]);
			users[i] = new User();
			users[i].setName(Files.lines(currentPath).toArray(String[]::new)[0]);
			
			//TODO
			//SET USERFILES
		}
		c.setUsers(users);
		
	}
}
