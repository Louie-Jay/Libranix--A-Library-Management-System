import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class EditViewBkFormPopUp extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	//content center
	JPanel content;
	JTable editViewBkTable; //test datas over here
	String testdata[][] = { {"1","Amit","Armpit","Darkpit","Pit.Co","Novel","3"}, 
							{"2","Shaman","Shaak-Ti","SharkDude","SHA.Co","Technology","2"}, 
							{"3","Lorenflow","Lorenzo","Lokke","LockedP.Co","Horror","5"}};
	String[] testcolumn={"ID","Title","Author","Writer","Publisher","Genre","Count"};
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkAll;
	JCheckBox chkId;
	JTextField txtId;
	JCheckBox chkBorrowed;
	JCheckBox chkAvailable;
	JCheckBox chkGenre;
	JComboBox cbxGenre;
	JCheckBox chkCondition;
	JComboBox cbxCondition;
	JCheckBox chkPRating;
	JComboBox cbxPRating;
	
	//sort by rating on the table (optional)
	
	String[] testGenreData = {"Technology","Horror","Novel","Science"}; // combobox data here
	String[] testConditionData = {"New","Good","Fair","Old","Damaged"};
	String[] testParentalRatingData = {"All ages","Age 2+","Age 5+","Age 8+","Age 10+","Age 13+"};
	
	public EditViewBkFormPopUp(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BorderLayout());
		
		loadHeader();
		loadContentTable();
		loadFooterOptions();
		
		
	}
	
	private void loadHeader() {
		headerPanel = new JPanel();
		
		btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		headertitle = new JLabel("Edit Books"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new EditViewBkFormPopUpHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		editViewBkTable = new JTable(testdata,testcolumn);
		JScrollPane tableScrollPane = new JScrollPane(editViewBkTable);
		tableScrollPane.setPreferredSize(new Dimension(1000,560));
		editViewBkTable.addMouseListener(new EditViewBkFormPopUp_TableHandler());
		editViewBkTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		content.add(tableScrollPane);
		formOuterPanel.add(content);
		
		this.add(content,BorderLayout.CENTER);
		
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkAll = new JCheckBox("All");
		chkId = new JCheckBox("ID:");
		txtId = new JTextField("",10);
		chkBorrowed = new JCheckBox("Borrowed");
		chkAvailable = new JCheckBox("Available");
		chkGenre = new JCheckBox("Genre:");
		cbxGenre = new JComboBox(testGenreData);
		chkCondition = new JCheckBox("Condition: ");
		cbxCondition = new JComboBox(testConditionData);
		chkPRating = new JCheckBox("P-Rating");
		cbxPRating = new JComboBox(testParentalRatingData);
		
		optionsPane.add(chkAll);
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkBorrowed);
		optionsPane.add(chkAvailable);
		optionsPane.add(chkGenre);
		optionsPane.add(cbxGenre);
		optionsPane.add(chkCondition);
		optionsPane.add(cbxCondition);
		optionsPane.add(chkPRating);
		optionsPane.add(cbxPRating);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class EditViewBkFormPopUpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			parentLayout.show(parentPanel, "MAIN");
			
		}
		
	}
	
	
	private class EditViewBkFormPopUp_TableHandler extends MouseAdapter{
		JTable source;
		public void mouseClicked(MouseEvent mEvt) {
			
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();
				int column = source.getSelectedRow();
				
				parentLayout.show(parentPanel, "EDITBOOK");
			}
			
		}
		
	}

}
