package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	private String fileName;
	private File file;
	
	public ReadFile(String prmFileName) {
		// Cross-platform: use File(parent, child) instead of hardcoded separators
		file = new File("data", prmFileName);
		fileName = file.getPath();
	}
	
	public String readProperties() {
		String content = "";
		
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				content += reader.nextLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	/*
	 * Usage: 
	 * ReadFile read = new ReadFile("plaintext.LibData");
	 * System.out.println(read.readProperties());
	 */
	
}
