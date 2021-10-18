package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.BorrowBkTransactController;


public class BorrowBkTransactCard extends JPanel{
	
	JPanel parentPanel;
	CardLayout parentLayout;
	
	JPanel bookPanel;
	JLabel lblbkId;
	JLabel lblbkTitle;
	JLabel lblbkAutWri;
	JLabel lblbkGenre;
	JLabel lblbkQuantity;
	
	JPanel memberPanel;
	JLabel lblmemId;
	JLabel lblmemFirstName;
	JLabel lblmemLastName;
	JLabel lblmemAddress;
	JLabel lblmemEmail;
	Img pic;
	
	Table memberTable;
	
	JPanel footerButtons;
	IDTextField txtId;
	JButton btnFind;
	JButton btnLink;
	JButton btnCancel;
	private BorrowBkTransactController controller; 
	private LinkedHashMap<String, Object> cellValues;
	
	public BorrowBkTransactCard(JPanel parentPnl, LinkedHashMap<String, Object> cellValues){
		setBackground(new Color(255, 250, 250));
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPanel.getLayout();
		this.setLayout(new BoxLayout((JPanel)this, BoxLayout.Y_AXIS));
		this.cellValues = cellValues;
		this.controller = new BorrowBkTransactController();

		loadHeaderPanel();
		loadBkPanel();
		loadMemPanel();
		loadMemTable();
		loadFooterButtons();
	}
	
	private void loadHeaderPanel() {
		HeaderPanel header = new HeaderPanel("Link to Borrower",true);
		
		header.setBackActionListener(new BorrowBkTransactCardHandler());
		
		this.add(header);
	}
	
	private void loadBkPanel() {
		bookPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		bookPanel.setBackground(new Color(255, 250, 250));
		bookPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Book Info"));
		TitledBorder border1 = (TitledBorder) bookPanel.getBorder();
		border1.setTitleFont(new Font("Lucida Sans", Font.BOLD, 14));
		
		JPanel bookPic = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bookPic.setBackground(new Color(255, 250, 250));
		
		//ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Book(100px,119px).png");
		//JLabel imagelabel = new JLabel(image);
		Img pic = new Img("emptyboxSmall");
		pic.setTransactImg(cellValues.get("Img").toString());
		bookPic.add(pic);
		
		JPanel bookInfo = new JPanel();
		bookInfo.setOpaque(false);
		bookInfo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		bookInfo.setLayout(new BoxLayout(bookInfo,BoxLayout.Y_AXIS));
		
		lblbkId = new JLabel("ID: ");
		lblbkId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblbkTitle = new JLabel("Title: ");
		lblbkTitle.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblbkAutWri = new JLabel("Author|Writer: ");
		lblbkAutWri.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblbkGenre = new JLabel("Genre: ");
		lblbkGenre.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblbkQuantity = new JLabel("Quantity: ");
		lblbkQuantity.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		bookInfo.add(lblbkId);
		bookInfo.add(lblbkTitle);
		bookInfo.add(lblbkAutWri);
		bookInfo.add(lblbkGenre);
		bookInfo.add(lblbkQuantity);
		
		
		bookPanel.add(bookPic);
		bookPanel.add(bookInfo);
		
		this.loadBookValues();
		this.add(bookPanel);
	}
	
	private void loadMemPanel() {
		memberPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		memberPanel.setBackground(new Color(255, 250, 250));
		memberPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Member Info"));
		TitledBorder border2 = (TitledBorder) memberPanel.getBorder();
		border2.setTitleFont(new Font("Lucida Sans", Font.BOLD, 14));
		
		JPanel memPic = new JPanel(new FlowLayout(FlowLayout.CENTER));
		memPic.setBackground(new Color(255, 250, 250));
		
		pic = new Img("Member(100px,119px)");
		memPic.add(pic);
		
		JPanel memInfo = new JPanel();
		memInfo.setOpaque(false);
		memInfo.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		memInfo.setLayout(new BoxLayout(memInfo,BoxLayout.Y_AXIS));
		
		lblmemId = new JLabel("ID: ");
		lblmemId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblmemFirstName = new JLabel("First Name: ");
		lblmemFirstName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblmemLastName = new JLabel("Last Name: ");
		lblmemLastName.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblmemAddress = new JLabel("Address: ");
		lblmemAddress.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		lblmemEmail = new JLabel("Email: ");
		lblmemEmail.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		
		memInfo.add(lblmemId);
		memInfo.add(lblmemFirstName);
		memInfo.add(lblmemLastName);
		memInfo.add(lblmemAddress);
		memInfo.add(lblmemEmail);
		
		memberPanel.add(memPic);
		memberPanel.add(memInfo);
		
		this.add(memberPanel);
	}
	
	private void loadMemTable() {
		memberTable = new Table();
		//JScrollPane tableSP = new JScrollPane(memberTable);
		memberTable.addMouseListener(new BorrowBkTransactCard_TableHandler());
		memberTable.setModel(controller.getDefaultTableModel());
		
		memberTable.getColumnModel().getColumn(6).setMinWidth(0);
		memberTable.getColumnModel().getColumn(6).setMaxWidth(0);
		memberTable.getColumnModel().getColumn(6).setWidth(0);
		
		this.add(memberTable.getTablePane());
	}
	
	
	private void loadFooterButtons() {
		footerButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		footerButtons.setBackground(new Color(255, 250, 250));
		
		JLabel lblId = new JLabel("Member ID: ");
		lblId.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		txtId = new IDTextField("",10);
		btnFind = new JButton("Find");
		btnFind.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnFind.setMinimumSize(new Dimension(65, 25));
		btnFind.setMaximumSize(new Dimension(65, 25));
		btnFind.setPreferredSize(new Dimension(65, 25));
		btnFind.setBackground(new Color(255, 250, 250));
		btnFind.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnFind.setOpaque(false);
		btnLink = new JButton("Link");
		btnLink.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnLink.setMinimumSize(new Dimension(65, 25));
		btnLink.setMaximumSize(new Dimension(65, 25));
		btnLink.setPreferredSize(new Dimension(65, 25));
		btnLink.setBackground(new Color(255, 250, 250));
		btnLink.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnLink.setOpaque(false);
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new LineBorder(new Color(100, 149, 237)));
		btnCancel.setMinimumSize(new Dimension(80, 25));
		btnCancel.setMaximumSize(new Dimension(80, 25));
		btnCancel.setPreferredSize(new Dimension(80, 25));
		btnCancel.setBackground(new Color(255, 250, 250));
		btnCancel.setFont(new Font("Lucida Sans", Font.BOLD, 11));
		btnCancel.setOpaque(false);
		
		btnFind.addActionListener(new BorrowBkTransactCardHandler());
		btnLink.addActionListener(new BorrowBkTransactCardHandler());
		btnCancel.addActionListener(new BorrowBkTransactCardHandler());
		
		btnFind.addMouseListener(new MouseHandler());
		btnLink.addMouseListener(new MouseHandler());
		btnCancel.addMouseListener(new MouseHandler());
		
		footerButtons.add(lblId);
		footerButtons.add(txtId);
		footerButtons.add(btnFind);
		footerButtons.add(btnLink);
		footerButtons.add(btnCancel);
		this.add(footerButtons);
	}
	
	private void loadBookValues() {
		lblbkId.setText("ID: "+ cellValues.get("ID"));
		lblbkTitle.setText("Title: "+ cellValues.get("Title"));
		if(cellValues.get("Author") == "" ) {
			lblbkAutWri.setText("Author|Writer: "+ (String) cellValues.get("Writer"));
		}else {
			lblbkAutWri.setText("Author|Writer: "+ (String) cellValues.get("Author"));
		}
		lblbkGenre.setText("Genre: "+ cellValues.get("Genre"));
		lblbkQuantity.setText("Quantity :"+ cellValues.get("Quantity"));
		System.out.println("called");
	}
	
	private void loadBookValues(int prmCount) {
		lblbkId.setText("ID: "+ cellValues.get("ID"));
		lblbkTitle.setText("Title: "+ cellValues.get("Title"));
		if(cellValues.get("Author") == "" ) {
			lblbkAutWri.setText("Author|Writer: "+ (String) cellValues.get("Writer"));
		}else {
			lblbkAutWri.setText("Author|Writer: "+ (String) cellValues.get("Author"));
		}
		lblbkGenre.setText("Genre: "+ cellValues.get("Genre"));
		cellValues.put("Quantity", (int)cellValues.get("Quantity") - prmCount);
		lblbkQuantity.setText("Quantity :"+ cellValues.get("Quantity"));
		System.out.println("called");
	}
	
	private class BorrowBkTransactCard_TableHandler extends MouseAdapter{
		JTable source;
		
		public void mouseClicked(MouseEvent mEvt) {
			
			
			if(mEvt.getClickCount() == 1) {
				source = (JTable) mEvt.getSource();
				int row = source.getSelectedRow();
				
				lblmemId.setText("ID: "+ source.getValueAt(row, 0));
				lblmemFirstName.setText("FirstName: "+ source.getValueAt(row, 1));
				lblmemLastName.setText("LastName: "+ source.getValueAt(row, 2));
				lblmemAddress.setText("Address: "+ source.getValueAt(row, 4));
				lblmemEmail.setText("Email: "+ source.getValueAt(row, 5));
				pic.setTransactImg(source.getValueAt(row, 6).toString());
				
			}
			
		}
	}
	
	private class BorrowBkTransactCardHandler implements ActionListener {
		JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
		JButton source;
		Object memberId;

		@Override
		public void actionPerformed(ActionEvent evt) {
			source = (JButton)evt.getSource();
			BorrowBkTableCard borrowBkTable = new BorrowBkTableCard(parentPanel);
			parentPanel.add(borrowBkTable, "BORROWBOOK");
			
			switch (source.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			case "Link":
				try { // checks if at least a member cell selected on the table
					memberId = memberTable.getValueAt(memberTable.getSelectedRow(), 0);
					
					//int borrowCount = Integer.parseInt((String)InputDialog.getInput(parent, "Enter book quantity."));
					Object input = InputDialog.getInput(parent, "Enter book quantity");
					
					if(input instanceof String) {
						int borrowCount = Integer.parseInt((String)input);
						if(controller.borrowBook(memberId,cellValues.get("ID"),cellValues.get("Quantity"),borrowCount)) {
							MessageDialog.showDialog(parent, "Book successfully borroed!", "Success");
							
							loadBookValues(borrowCount);
							//parentLayout.show(parentPanel, "BORROWBOOK");
						}else {
							ErrorDialog.showErrorDialog(parent, "Error linking book.");
						}
					}
					
				} catch (ArrayIndexOutOfBoundsException e) {
					ErrorDialog.showErrorDialog(parent, "Please select a member on the table to link <br>"+e.getMessage());
				} catch (NumberFormatException nfEx) {
					ErrorDialog.showErrorDialog(parent, "Critical error: <br>Invalid format<br>"+nfEx.getMessage());
				}
				break;
			case "Find":
				String srchId = txtId.getText();
				if(controller.isValid(txtId)) {
					memberTable.setModel(controller.getRequestTableModel(srchId, txtId));
					
					memberTable.getColumnModel().getColumn(6).setMinWidth(0);
					memberTable.getColumnModel().getColumn(6).setMaxWidth(0);
					memberTable.getColumnModel().getColumn(6).setWidth(0);
					resetMemberInfo();
				}else {
					ErrorDialog.showErrorDialog(parent, controller.getErrorMsg());
				}
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "BORROWBOOK");
				break;
			default:
				break;
			}
		}
		
		private void resetMemberInfo() {
			lblmemId.setText("ID: ");
			lblmemFirstName.setText("FirstName: ");
			lblmemLastName.setText("LastName: ");
			lblmemAddress.setText("Address: ");
			lblmemEmail.setText("Email: ");
			pic.setTransactImg("Member");
		}
	}
	
	private class MouseHandler extends MouseAdapter{
		JButton btnSource;
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(30, 144, 255));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(255, 250, 250));
			btnSource.setBorder(new LineBorder((Color)new Color(255, 250, 250)));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			btnSource = (JButton) e.getSource();
			btnSource.setBackground(new Color(255, 250, 250));
			btnSource.setOpaque(true);
			btnSource.setForeground(new Color(0, 0, 0));
			btnSource.setBorder(new LineBorder(new Color(30, 144, 255)));
		}
		
	}

}
