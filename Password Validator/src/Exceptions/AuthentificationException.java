package Exceptions;

public class AuthentificationException extends Exception {
	
	LogInError error;
	
	public LogInError getError() {
		return error;
	}

	public AuthentificationException(LogInError error) {
		this.error = error;
	}
}
