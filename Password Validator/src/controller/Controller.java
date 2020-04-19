package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.User;

public class Controller {

	private User[] users;
	private User currentUser;
	
	public void setUsers(User[] users) {
		this.users = users;
	}
	
	public void setCurrentUser(String name) {
		for(int i = 0; i < users.length; i++) {
			if(users[i].getName().equals(name)) {
				currentUser = users[i];
				return;
			}
		}
	}
}
