package model;

import java.io.File;

public class User {

	private File[] files;
	private String name;
	
	
	public User() {
		
	}
	
	public User(File[] files, String name) {
		this.files = files;
		this.name = name;
	}
	
	public void setFiles(File[] files) {
		this.files = files;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public File[] getFiles() {
		return files;
	}
	
	public File getFile(int index) {
		return files[index];
	}
	
	public String getName() {
		return name;
	}
	
	public void addFile(File file) {
		File tmp[] = new File[files.length + 1];
		for(int i = 0; i < files.length + 1; i++) {
			tmp[i] = files[i];
		}
		tmp[files.length] = file;
		files = tmp;
	}
}
