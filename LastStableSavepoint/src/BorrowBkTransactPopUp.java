import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class BorrowBkTransactPopUp extends JPanel{
	
	JPanel parentPanel;
	CardLayout parentLayout;
	
	JPanel bookPanel;
	JLabel lblbkId;
	JLabel lblbkTitle;
	JLabel lblbkGenre;
	JLabel lblbkPRating;
	
	JPanel memberPanel;
	JLabel lblmemId;
	JLabel lblmemFirstName;
	JLabel lblmemLastName;
	JLabel lblmemAddress;
	JLabel lblmemAge;
	
	JTable memberTable;
	String testdata[][] = { {"1","FirstName1","MiddleName1","LastName2","Address1","21","ContactNo1","email1@gmail.com"}, 
			{"2","FirstName2","MiddleName2","LastName2","Address2","22","ContactNo2","email2@gmail.com"}, 
			{"3","FirstName3","MiddleName3","LastName3","Address3","23","ContactNo3","email3@gmail.com"}};
	String[] testcolumn={"ID","First Name","Middle Name","Last Name","Address","Age","Contact No.","Email"};
	
	JPanel footerButtons;
	JTextField txtId;
	JButton btnLink;
	JButton btnCancel;
	
	public BorrowBkTransactPopUp(JPanel parentPnl){
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPanel.getLayout();
		this.setLayout(new BoxLayout((JPanel)this, BoxLayout.Y_AXIS));
		loadHeaderPanel();
		loadBkPanel();
		loadMemPanel();
		loadMemTable();
		loadFooterButtons();
	}
	
	private void loadHeaderPanel() {
		JPanel headerPanel = new JPanel();
		
		JButton btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		JLabel headertitle = new JLabel("Link Book to Borrower"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new BorrowBkTransactPopUpHandler());
		
		this.add(headerPanel);
	}
	
	private void loadBkPanel() {
		bookPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		bookPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Book Info"));
		
		JPanel bookPic = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Book(100px,119px).png");
		JLabel imagelabel = new JLabel(image);
		bookPic.add(imagelabel);
		
		JPanel bookInfo = new JPanel();
		bookInfo.setLayout(new BoxLayout(bookInfo,BoxLayout.Y_AXIS));
		
		lblbkId = new JLabel("ID: ");
		lblbkTitle = new JLabel("Title: ");
		lblbkGenre = new JLabel("Genre: ");
		lblbkPRating = new JLabel("P-Rating: ");
		
		bookInfo.add(lblbkId);
		bookInfo.add(lblbkTitle);
		bookInfo.add(lblbkGenre);
		bookInfo.add(lblbkPRating);
		
		bookPanel.add(bookPic);
		bookPanel.add(bookInfo);
		
		this.add(bookPanel);
	}
	
	private void loadMemPanel() {
		memberPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		memberPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Member Info"));
		
		JPanel memPic = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Member(100px,119px).png");
		JLabel imagelabel = new JLabel(image);
		memPic.add(imagelabel);
		
		
		JPanel memInfo = new JPanel();
		memInfo.setLayout(new BoxLayout(memInfo,BoxLayout.Y_AXIS));
		
		lblmemId = new JLabel("ID: ");
		lblmemFirstName = new JLabel("First Name: ");
		lblmemLastName = new JLabel("Last Name: ");
		lblmemAddress = new JLabel("Address: ");
		lblmemAge = new JLabel("Age: ");
		
		memInfo.add(lblmemId);
		memInfo.add(lblmemFirstName);
		memInfo.add(lblmemLastName);
		memInfo.add(lblmemAddress);
		memInfo.add(lblmemAge);
		
		memberPanel.add(memPic);
		memberPanel.add(memInfo);
		
		this.add(memberPanel);
	}
	
	private void loadMemTable() {
		JTable memberTable = new JTable(testdata,testcolumn);
		JScrollPane tableSP = new JScrollPane(memberTable);
		this.add(tableSP);
	}
	
	private void loadFooterButtons() {
		footerButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		JLabel lblId = new JLabel("Member ID: ");
		txtId = new JTextField("",10);
		btnLink = new JButton("Link");
		btnCancel = new JButton("Cancel");
		
		btnLink.addActionListener(new BorrowBkTransactPopUpHandler());
		btnCancel.addActionListener(new BorrowBkTransactPopUpHandler());
		
		footerButtons.add(lblId);
		footerButtons.add(txtId);
		footerButtons.add(btnLink);
		footerButtons.add(btnCancel);
		this.add(footerButtons);
	}
	
	private class BorrowBkTransactPopUpHandler implements ActionListener {
		JButton source;

		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "INFOBORROWBOOK");
				break;
			case "Link":
				System.out.println("Nothing for now");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;

			default:
				break;
			}
			
		}
	}

}
