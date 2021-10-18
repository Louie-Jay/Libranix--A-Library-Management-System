package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	private String fileName;
	private File file;
	
	public WriteFile(String prmFileName) {
		
		fileName = "data\\"+prmFileName;
		
		try {
			file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void writeProperties(String prmStr) {
		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(prmStr);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public File getFile() {
		return file;
	}
	
	
	/*
	 * Usage: 
	 * WriteFile writer = new WriteFile("plaintext.LibData");
	 * writer.writeProperties("Hello World!");
	 */

}
