package model;

import java.util.LinkedHashMap;



public class EditBkFormModel {
	
	private DatabaseConnection db;
	private String query;
	private FileDataModel genreItems;
	
	public EditBkFormModel() {
		db = new DatabaseConnection();
	}
	
	public String[] getGenreData() {
		genreItems = new FileDataModel("genre.data");
		return genreItems.getArrayStringData();
	}
	
	
	public String[] getnfData() {
		genreItems = new FileDataModel("nonfictionGenre.data");
		return genreItems.getArrayStringData();
	}
	
	public String[] getfData() {
		genreItems = new FileDataModel("fictionGenre.data");
		return genreItems.getArrayStringData();
	}
	
	public boolean editData(int paramId, LinkedHashMap<String, String> paramInput) {
		
		try {
			db.connectDatabase();
			query = "UPDATE librarydatabase.tbl_bookdetails,librarydatabase.tbl_bookgenre,librarydatabase.tbl_bookquantity \r\n" + 
					"SET tbl_bookdetails.col_BookTitle='"+paramInput.get("Title")+"',tbl_bookdetails.col_BookAuthor='"+paramInput.get("Author")+"',\r\n" + 
					"tbl_bookdetails.col_BookWriter='"+paramInput.get("Writer")+"',tbl_bookdetails.col_BookPublisher='"+paramInput.get("Publisher")+"',\r\n" + 
					"tbl_bookdetails.col_BookIsbn='"+paramInput.get("ISBN")+"',tbl_bookdetails.col_BookType='"+paramInput.get("Type")+"',\r\n" + 
					"tbl_bookdetails.col_BookImg='"+paramInput.get("Img")+"',tbl_bookgenre.col_BookGenre='"+paramInput.get("Genre")+"',tbl_bookquantity.col_BookQuantity= "+paramInput.get("Quantity")+"\r\n" + 
					"WHERE tbl_bookdetails.col_BookId = "+paramId+" && tbl_bookgenre.col_BookId = "+paramId+" && tbl_bookquantity.col_BookId = "+paramId+";";
			db.setQuery(query);
			db.executeQuery();
			db.closeDatabase();
			
		}catch(Exception e){
			return false;
		}
		return true;
	}

} 
