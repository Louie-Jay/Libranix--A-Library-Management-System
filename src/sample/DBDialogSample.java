package sample;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DBDialogSample {
	
	public static void main(String[] args) {
			/*DatabaseConnection db = new DatabaseConnection();
			//db.connectDatabase();
			//db.setQuery("INSERT INTO actor VALUES ('202', 'Zerg','Merg', '2006-02-15 00:00:00')");
			//db.executeQuery();
			//displayData(db.getResult());
			db.closeDatabase();*/
		
		//MainWindow go = new MainWindow();
		JFrame test = new JFrame("Dialog main test window");
		test.setSize(500,500);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton open = new JButton("Open");
		test.add(open);
		
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CustomDialog.showMessage(test,"This is a message");
				System.out.println(CustomDialog.showConfirmDialog(test,"Are you sure?"));
				//System.out.println(CustomDialog.getConfirmFlag());
				CustomDialog.showErrorDialog(test,"Error");
				CustomDialog.showWarningDialog(test,"Warning!");
				
			}
			
		});
		
		test.setVisible(true);
		
		

	}
	
	public static void displayData(ResultSet rs) {
		try {
			while(rs.next()) {
				int id = rs.getInt("actor_id");
				String name = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String upd = rs.getString("last_update");
				
				System.out.println(id + " | " + name + " | "+ lastname + " | " + upd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
