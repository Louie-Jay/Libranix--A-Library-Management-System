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

public class EditViewMemFormPopUp extends JPanel{
	
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
	String testdata[][] = { {"1","Amit","Armpit","Darkpit","St.Pit","23","09444432323","darkpit@gmail.com"}, 
							{"2","Shaman","Shaak-Ti","SharkDude","St.SHA","21","09444443223","sharkdude@gmail.com"}, 
							{"3","Lorenflow","Lorenzo","Lokke","St.LockedP","18","09944643223","lokke@gmail.com"}};
	String[] testcolumn={"ID","First Name","Middle Name","Last Name","Address","Age","Contact No.","Email"};
	
	// footer buttons
	JPanel optionsPane;
	JCheckBox chkId;
	JTextField txtId;
	JCheckBox chkFName;
	JTextField txtFName;
	JCheckBox chkLName;
	JTextField txtLName;
	JCheckBox chkNo;
	JTextField txtNo;
	
	
	public EditViewMemFormPopUp(JPanel parentPnl) {
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
		headertitle = new JLabel("Edit Members"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new EditViewMemFormPopUpHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
	}
	
	private void loadContentTable() {
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		editViewBkTable = new JTable(testdata,testcolumn);
		JScrollPane tableScrollPane = new JScrollPane(editViewBkTable);
		tableScrollPane.setPreferredSize(new Dimension(1000,560));
		editViewBkTable.addMouseListener(new EditViewMemFormPopUp_TableHandler());
		editViewBkTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		content.add(tableScrollPane);
		formOuterPanel.add(content);
		
		this.add(content,BorderLayout.CENTER);
		
	}
	
	private void loadFooterOptions() {
		
		optionsPane = new JPanel();
		
		optionsPane.setLayout(new FlowLayout(FlowLayout.LEADING));
		//this.setBorder(new LineBorder(Color.BLACK));
		
		
		chkId = new JCheckBox("ID:");
		txtId = new JTextField("",10);
		chkFName = new JCheckBox("First Name: ");
		txtFName = new JTextField("",15);
		chkLName = new JCheckBox("Last Name: ");
		txtLName = new JTextField("",15);
		chkNo = new JCheckBox("Contact No: ");
		txtNo = new JTextField("",15);
		
		optionsPane.add(chkId);
		optionsPane.add(txtId);
		optionsPane.add(chkFName);
		optionsPane.add(txtFName);
		optionsPane.add(chkLName);
		optionsPane.add(txtLName);
		optionsPane.add(chkNo);
		optionsPane.add(txtNo);
		
		this.add(optionsPane,BorderLayout.PAGE_END);
	}
	
	private class EditViewMemFormPopUpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			parentLayout.show(parentPanel, "MAIN");
			
		}
		
	}
	
	
	private class EditViewMemFormPopUp_TableHandler extends MouseAdapter{
		JTable source;
		public void mouseClicked(MouseEvent mEvt) {
			
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();
				int column = source.getSelectedRow();
				
				parentLayout.show(parentPanel, "EDITMEMBER");
			}
			
		}
		
	}

}
