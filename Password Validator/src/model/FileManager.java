package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {

	
	public String read(File file) throws IOException {
		String t = "";
		String[] lines = (String[]) Files.lines(file.toPath()).toArray();
		
		for(int i = 0; i < lines.length; i++) {
			t = t + lines[i];
			if(i < lines.length - 1) {
				t = t + "\n";
			}
		}
		return t;
	}
}
