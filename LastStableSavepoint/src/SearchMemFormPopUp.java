import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class SearchMemFormPopUp extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	JPanel contentPanel;
	JTextField txtSearch;
	JButton btnSearch;
	JCheckBox chkFirstName;
	JCheckBox chkLastName;
	JCheckBox chkAddress;
	JCheckBox chkAge;
	JCheckBox chkContactNo;
	JCheckBox chkEmail;
	
	JPanel footerPanel;
	JTable srchResultTable;
	
	
	
	String testdata[][] = { {"1","Amit","Armpit","Darkpit","St.Pit","23","09444432323","darkpit@gmail.com"}, 
			{"2","Shaman","Shaak-Ti","SharkDude","St.SHA","21","09444443223","sharkdude@gmail.com"}, 
			{"3","Lorenflow","Lorenzo","Lokke","St.LockedP","18","09944643223","lokke@gmail.com"}};
	String[] testcolumn={"ID","First Name","Middle Name","Last Name","Address","Age","Contact No.","Email"};
	
	
	
	public SearchMemFormPopUp(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		this.setLayout(new BoxLayout((JPanel)this,BoxLayout.PAGE_AXIS));
		
		loadHeader();
		loadContent();
		loadFooterTable();
		
	}
	
	private void loadHeader() {
		headerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		
		btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		headertitle = new JLabel("Search Members"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new SearchMemFormPopUpHandler());
		
		this.add(headerPanel);
	}
	
	private void loadContent() {
		contentPanel = new JPanel(new GridLayout(2,1,10,0));
		
		JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		txtSearch = new JTextField("",70);
		btnSearch = new JButton("Search");
		btnSearch.setContentAreaFilled(false);
		btnSearch.addActionListener(new SearchMemFormPopUpHandler());
		searchBar.add(txtSearch);
		searchBar.add(btnSearch);
		
		JPanel searchOpt = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		
		chkFirstName = new JCheckBox("First Name");
		chkLastName = new JCheckBox("Last Name");
		chkAddress = new JCheckBox("Address");
		chkAge = new JCheckBox("Age");
		chkContactNo = new JCheckBox("Contact No.");
		chkEmail = new JCheckBox("Email");
		
		searchOpt.add(chkFirstName,true);
		searchOpt.add(chkLastName);
		searchOpt.add(chkAddress);
		searchOpt.add(chkAge);
		searchOpt.add(chkContactNo);
		searchOpt.add(chkEmail);
		
		contentPanel.add(searchBar);
		contentPanel.add(searchOpt);
		searchOpt.setPreferredSize(new Dimension(0,20));
		this.add(contentPanel);
		
	}
	
	private void loadFooterTable() {
		footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		srchResultTable = new JTable(testdata,testcolumn);
		JScrollPane tableScrollPane = new JScrollPane(srchResultTable);
		tableScrollPane.setPreferredSize(new Dimension(1000,560));
		srchResultTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		footerPanel.add(tableScrollPane);
		
		srchResultTable.addMouseListener(new SearchMemFormPopUp_TableHandler());
		
		this.add(footerPanel);
		
	}
	
	private class SearchMemFormPopUpHandler implements ActionListener{
		JButton source;
		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "MAIN");
				break;
			case "Search":
				System.out.println("Nothing for now");
				break;
			default:
				break;
			}

		}
		
	}
	
	
	private class SearchMemFormPopUp_TableHandler extends MouseAdapter{
		
		JTable source;
		public void mouseClicked(MouseEvent mEvt) {
			
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();
				int column = source.getSelectedRow();
				
				parentLayout.show(parentPanel, "INFOSEARCHMEMBER");
			}
			
		}
		
	}
	
	

}
