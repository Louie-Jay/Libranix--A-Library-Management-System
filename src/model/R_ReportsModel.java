package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class R_ReportsModel {
	
	DatabaseConnection db;
	XWPFDocument doc;
	RequestModel rqstModel;
	
	public R_ReportsModel() {
	}
	
	public void writeReport(File prmFPath, ArrayList<FileInputStream> prmPics) throws FileNotFoundException, Exception{
		
		doc = new XWPFDocument();
		rqstModel = new RequestModel();
		
		FileOutputStream out = new FileOutputStream(new File(prmFPath,"reports.docx"));
		
		this.loadHeader();
		this.loadImageContentBody(prmPics);
		this.loadRequestFooter(rqstModel.loadRequest());
		
		doc.write(out);
		out.close();
		
		System.out.println("Writes at: "+prmFPath.getAbsolutePath());
	}
	
	private void loadHeader() {
		
		XWPFParagraph heading = doc.createParagraph();
		XWPFRun run = heading.createRun();
		run.setBold(true);
		run.setFontSize(20);
		run.setFontFamily("Lucida Sans");
		run.setText("Library Management System: Reports");
		run.addBreak();
		
	}
	
	private void loadImageContentBody(ArrayList<FileInputStream> prmCharts) {
		
		XWPFParagraph chartParagraph = doc.createParagraph();
		XWPFRun run = chartParagraph.createRun();
		
		try {
			for(FileInputStream fileImg : prmCharts) {
				run.addPicture(fileImg, XWPFDocument.PICTURE_TYPE_JPEG, (fileImg.toString()), Units.toEMU(225), Units.toEMU(200));
				System.out.println(fileImg.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		run.addBreak();
		
	}
	
	private void loadRequestFooter(BufferedReader prmRqstText) {
		XWPFParagraph headerRequestFooter = doc.createParagraph();
		XWPFRun headerRun = headerRequestFooter.createRun();
		headerRun.setItalic(true);
		headerRun.setUnderline(UnderlinePatterns.DASH);
		headerRun.setFontFamily("Calibri");
		headerRun.setFontSize(12);
		headerRun.setText("Request:");
		
		XWPFParagraph textRequestFooter = doc.createParagraph();
		XWPFRun textRun = textRequestFooter.createRun();
		textRun.setFontFamily("Calibri");
		textRun.setFontSize(11);
		
		
		String line;
		try {
			while( (line = prmRqstText.readLine() ) != null) {
				textRun.setText(line);
				textRun.addBreak();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getBorrowCount() {
		db = new DatabaseConnection();
		String sql = "SELECT tbl_borrowedbooks.col_BookQuantity FROM librarydatabase.tbl_borrowedbooks;"; // borrowed count
		
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		int count = 0;
		try {
			while(rs.next()) {
				count += rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getBkCount() {
		db = new DatabaseConnection();
		String sql = "SELECT tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookquantity;";// total books
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		int count = 0;
		try {
			while(rs.next()) {
				count += rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getMbrCount() {
		db = new DatabaseConnection();
		String sql = "SELECT COUNT(1) FROM librarydatabase.tbl_memberdetails INNER JOIN librarydatabase.tbl_membercontacts ON tbl_memberdetails.col_MemberId = tbl_membercontacts.col_MemberId;"; // membercount
		
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		int rows = 0;
		try {
			rs.next();
			rows = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public Map<Integer, List<String>> getBkQuantity() {
		db = new DatabaseConnection();
		String sql = "SELECT tbl_bookdetails.col_BookTitle, tbl_bookquantity.col_BookQuantity FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_bookquantity ON tbl_bookdetails.col_BookId = tbl_bookquantity.col_BookId;"; // book quantities
		
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
		List<String> rowData;
		int row = 0;
		try {
			while(rs.next()) {
				rowData = new ArrayList<String>();
				rowData.add(rs.getString("col_BookTitle"));
				rowData.add(String.valueOf(rs.getInt("col_BookQuantity")));
				data.put(row++, rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public Map<Integer, List<String>> getMostBorrowed() {
		db = new DatabaseConnection();
		String sql = "SELECT tbl_bookdetails.col_BookTitle, count(*) AS Total FROM librarydatabase.tbl_bookdetails INNER JOIN librarydatabase.tbl_borrowedbooks ON tbl_bookdetails.col_BookId = tbl_borrowedbooks.col_BookId GROUP BY tbl_bookdetails.col_BookId;"; // book quantities
		
		db.connectDatabase();
		
		db.setQuery(sql);
		
		db.executeQuery();
		ResultSet rs = db.getResult();
		Map<Integer, List<String>> data = new HashMap<Integer, List<String>>();
		List<String> rowData;
		int row = 0;
		try {
			while(rs.next()) {
				rowData = new ArrayList<String>();
				rowData.add(rs.getString("col_BookTitle"));
				rowData.add(String.valueOf(rs.getInt("Total")));
				data.put(row++, rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
}
