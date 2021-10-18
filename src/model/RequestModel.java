package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RequestModel {
	
	private FileReader fileReader;
	private BufferedReader bufferReader;
	private String fileName;
	private String readerLine;
	
	private FileWriter fileWriter;
	private BufferedWriter bufferWriter;

	public RequestModel() {
		fileName = "requests.data";
		readerLine = null;
		
	}
	
	public BufferedWriter saveRequest() throws IOException{
		
		try {
			fileWriter = new FileWriter(fileName);
			bufferWriter = new BufferedWriter(fileWriter);
			
		} catch (IOException ioE) {
			ioE.printStackTrace();
		}
		
		return bufferWriter;
		
	}

	public BufferedReader loadRequest() throws FileNotFoundException, IOException{
		
		fileReader = new FileReader(fileName);
		bufferReader = new BufferedReader(fileReader);
		
		return bufferReader;
	}
	
	public void closeReader() throws Exception{
		
		bufferReader.close();
		fileReader.close();
		
	}
	
	public void closeWriter() throws Exception{
		
		bufferWriter.close();
		fileWriter.close();
		
	}
	
}
