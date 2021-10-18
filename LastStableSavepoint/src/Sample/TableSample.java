package Sample;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableSample extends JFrame{

	JPanel mainPanel;
	JPanel leftPanel;
	JPanel rightPanel;
	JTable mainTable;
	JTextField txtName;
	JTextField txtAddress;
	JButton btnAdd;
	JButton btnDelete;
	
	
	Object[][] tableData = {
		    {"Kathy", "Manila Bay"},
		    {"John", "Tondo City"},
		    {"Sue", "Trash Country"},
		    {"Jane", "Bastards Avenue"},
		    {"Joe", "Freak Street"}
		   };
	
	String[] columnNames = {
			"Name",
            "Address",
            };
	
	DefaultTableModel model;
	
	TableSample(){
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,2));
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		model = new DefaultTableModel(tableData,columnNames);
		mainTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(mainTable);
		leftPanel.add(mainTable.getTableHeader(), BorderLayout.PAGE_START);
		leftPanel.add(mainTable, BorderLayout.CENTER);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		txtName = new JTextField();
		txtName.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtName.setSize(100, 20);
		txtAddress = new JTextField();
		txtAddress.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtAddress.setSize(100, 20);
		btnAdd = new JButton("Add");
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdd.setSize(100, 20);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.insertRow(mainTable.getRowCount(), new Object[] {txtName.getText(), txtAddress.getText()});
				txtName.setText("");
				txtAddress.setText("");
				//model.removeRow();
				
			}
			
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDelete.setSize(100,20);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.removeRow(mainTable.getSelectedRow());
				} catch (ArrayIndexOutOfBoundsException e) {
					//e.printStackTrace();
					if(model.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is empty");
					}else {
						model.removeRow(mainTable.getRowCount()-1);
					}
					
					
				}
				
				
			}
			
		});
		
		rightPanel.add(txtName);
		rightPanel.add(txtAddress);
		rightPanel.add(btnAdd);
		rightPanel.add(btnDelete);
		
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);

		
		this.add(mainPanel);
		this.setSize(1280, 720); // width, height
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
}
