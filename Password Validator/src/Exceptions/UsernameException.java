package Exceptions;

public class UsernameException extends Exception {

	String message;
	
	public void printMessage() {
		System.err.print(message);
	}

	public UsernameException(String message) {
		this.message = message;
	}
}
