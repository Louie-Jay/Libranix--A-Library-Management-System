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


public class SearchBkFormPopUp extends JPanel{
	
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
	JCheckBox chkTitle;
	JCheckBox chkAuthor;
	JCheckBox chkWriter;
	JCheckBox chkPublisher;
	
	JPanel footerPanel;
	JTable srchResultTable;
	
	
	
	String testdata[][] = { {"1","Amit","Armpit","Darkpit","Pit.Co","Novel","3"}, 
			{"2","Shaman","Shaak-Ti","SharkDude","SHA.Co","Technology","2"}, 
			{"3","Lorenflow","Lorenzo","Lokke","LockedP.Co","Horror","5"}};
	String[] testcolumn={"ID","Title","Author","Writer","Publisher","Genre","Count"};
	
	
	
	public SearchBkFormPopUp(JPanel parentPnl) {
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
		headertitle = new JLabel("Search Books"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new SearchBkFormPopUpHandler());
		
		this.add(headerPanel);
	}
	
	private void loadContent() {
		contentPanel = new JPanel(new GridLayout(2,1,10,0));
		
		JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		txtSearch = new JTextField("",70);
		btnSearch = new JButton("Search");
		btnSearch.setContentAreaFilled(false);
		btnSearch.addActionListener(new SearchBkFormPopUpHandler());
		searchBar.add(txtSearch);
		searchBar.add(btnSearch);
		
		JPanel searchOpt = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		
		chkTitle = new JCheckBox("Title");
		chkAuthor = new JCheckBox("Author");
		chkWriter = new JCheckBox("Writer");
		chkPublisher = new JCheckBox("Publisher");
		
		searchOpt.add(chkTitle,true);
		searchOpt.add(chkAuthor);
		searchOpt.add(chkWriter);
		searchOpt.add(chkPublisher);
		
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
		
		srchResultTable.addMouseListener(new SearchBkFormPopUp_TableHandler());
		
		this.add(footerPanel);
		
	}
	
	private class SearchBkFormPopUpHandler implements ActionListener{
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
	
	
	private class SearchBkFormPopUp_TableHandler extends MouseAdapter{
		
		JTable source;
		public void mouseClicked(MouseEvent mEvt) {
			
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();
				int column = source.getSelectedRow();
				
				parentLayout.show(parentPanel, "INFOSEARCHBOOK");
			}
			
		}
		
	}
	
	

}
