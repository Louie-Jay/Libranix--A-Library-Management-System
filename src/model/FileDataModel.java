package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataModel {
	
	private FileReader reader;
	private BufferedReader dataFile;
	private List<String> data;
	private String[] arrayData;
	
	public FileDataModel(String file) {
		
		String programPath = (new File("").getAbsolutePath());
		String path = programPath.concat("\\src\\props\\"+file);
		
		this.reader = this.setDataPath(path);
		this.dataFile = new BufferedReader(reader);
		this.data = new ArrayList<String>();
		this.processData();
	}
	
	public String[] getArrayStringData() {
		return arrayData;
	}
	
	public void processData() {
		String tempdata = null;
		
		try {
			
			while((tempdata = dataFile.readLine()) != null) {
				data.add(tempdata);
			}
			arrayData = data.toArray(new String[] {});
			dataFile.close();
			
		} catch (IOException e) {
			System.out.println("File corrupted");
		}
	}
	
	public FileReader setDataPath(String path) {
		
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("File path: "+path+ " not found.");
			
		}
		
		return reader;
		
	}

}
