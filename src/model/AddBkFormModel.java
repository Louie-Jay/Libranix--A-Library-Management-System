package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AddBkFormModel {
	
	private DatabaseConnection db;
	private ArrayList<String> queries;
	private FileDataModel genreItems;
	
	
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
	
	
	public boolean toDatabase(LinkedHashMap<String,String> inputs) {
		queries = new ArrayList<String>();
		db = new DatabaseConnection();
		db.connectDatabase();
		queries.add("INSERT INTO `librarydatabase`.`tbl_bookdetails` (`col_BookTitle`, `col_BookAuthor`, `col_BookWriter`, `col_BookPublisher`, `col_BookIsbn`, `col_BookType`, `col_BookImg`) VALUES ('"+inputs.get("Title")+"', '"+inputs.get("Author")+"', '"+inputs.get("Writer")+"', '"+inputs.get("Publisher")+"', '"+inputs.get("ISBN")+"', '"+inputs.get("Type")+"', '"+inputs.get("Img")+"')");
		queries.add("INSERT INTO `librarydatabase`.`tbl_bookgenre` (`col_BookGenre`) VALUES ('"+inputs.get("Genre")+"')");
		queries.add("INSERT INTO `librarydatabase`.`tbl_bookquantity` (`col_BookQuantity`) VALUES ('"+inputs.get("Quantity")+"')");
		System.out.println(queries.toString());
		if(db.executeMultiQuery(queries)) {
			db.closeDatabase();
			return true;
		}else {
			db.closeDatabase();
		}
		return false;
	}

}
