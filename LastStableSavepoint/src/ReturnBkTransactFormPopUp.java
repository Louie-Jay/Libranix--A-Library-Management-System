import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ReturnBkTransactFormPopUp extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout; /* All of these needs custom work*/
	
	//header
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel formBook;
	JPanel formMember;
	
	//book form
	JLabel lblborrower;
	JLabel lbltitle;
	JLabel lblauthor;
	JLabel lblwriter;
	JLabel lblpublisher;
	JLabel lblisbn;
	JLabel lblgenre;
	JLabel lblquantity;
	JLabel lblrating;
	JLabel lblparentalrating;
	
	JLabel txtborrower;
	JLabel txttitle;
	JLabel txtauthor;
	JLabel txtwriter;
	JLabel txtpublisher;
	JLabel txtisbn;
	JLabel cbxgenre;
	JTextField txtquantity;
	JLabel lblratingcount;
	int rating;
	JLabel cbxparentalrating;
	
	
	String[] testGenreData = {"Novel","Technology","Horror","Science"}; // combobox data here
	String[] testParentalRatingData = {"All ages","Age 2+","Age 5+","Age 8+","Age 10+","Age 13+"};// combobox data here
	
	//member form
	JLabel lblfirstname;
	JLabel lblmiddlename;
	JLabel lbllastname;
	JLabel lblage;
	JLabel lbladdress;
	JLabel lblemail;
	JLabel lblcontactno;
	
	JLabel txtfirstname;
	JLabel txtmiddlename;
	JLabel txtlastname;
	JLabel txtage;
	JLabel txtaddress;
	JLabel txtemail;
	JLabel txtcontactno;
	
	// footer buttons
	JPanel buttons;
	JButton btnReturn;
	JButton btnCancel;
	
	public ReturnBkTransactFormPopUp(JPanel parentPnl) {
		this.parentPanel = parentPnl;
		this.parentLayout = (CardLayout)parentPnl.getLayout();
		
		this.setLayout(new BorderLayout());
		
		loadHeader();
		loadContentForm();
		loadFooterButtons();
		
	}
	
	private void loadHeader() {
		
		headerPanel = new JPanel();
		
		btnBack = new JButton("<");
		btnBack.setPreferredSize(new Dimension(100,60)); // button size here
		btnBack.setFont(new Font("Arial", Font.BOLD, 50)); // set font here
		btnBack.setContentAreaFilled(false);
		headertitle = new JLabel("Return Book"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new ReturnBkTransactFormPopUpHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel(new GridLayout(2,0));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Book.png");
		JLabel imagelabel = new JLabel(image);
		picturebox.add(imagelabel);
		
		formBook = new JPanel(new GridLayout(10,2));
		formBook.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Book"));
		
		formMember = new JPanel(new GridLayout(8,2));
		formMember.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Member"));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));
		
		//form book
		lbltitle = new JLabel("Title: ");
		lblauthor = new JLabel("Author: ");
		lblwriter = new JLabel("Writer: ");
		lblpublisher = new JLabel("Publisher: ");
		lblisbn = new JLabel("ISBN: ");
		lblgenre = new JLabel("Genre: ");
		lblquantity = new JLabel("Quantity: ");
		lblrating = new JLabel("Rating: ");
		lblparentalrating = new JLabel("Parental Rating: ");
		
		txttitle = new JLabel("	N/A");
		txtauthor = new JLabel("	N/A");
		txtwriter = new JLabel("	N/A");
		txtpublisher = new JLabel("	N/A");
		txtisbn = new JLabel("	N/A");
		cbxgenre = new JLabel("	N/A");
		txtquantity = new JTextField("",2);
		lblratingcount = new JLabel("	N/A");
		cbxparentalrating = new JLabel("	N/A");
		
		//r1.setBackground(Color.YELLOW);
		//r1.setOpaque(false);
		
		formBook.add(lbltitle); formBook.add(txttitle);
		formBook.add(lblauthor); formBook.add(txtauthor);
		formBook.add(lblwriter); formBook.add(txtwriter);
		formBook.add(lblpublisher); formBook.add(txtpublisher);
		formBook.add(lblisbn); formBook.add(txtisbn);
		formBook.add(lblgenre); formBook.add(cbxgenre);
		formBook.add(lblquantity); formBook.add(txtquantity);
		formBook.add(lblrating); formBook.add(lblratingcount);
		formBook.add(lblparentalrating); formBook.add(cbxparentalrating);
		
		//form member
		lblfirstname = new JLabel("First Name: ");
		lblmiddlename = new JLabel("Middle Name: ");
		lbllastname = new JLabel("Last Name: ");
		lblage = new JLabel("Age: ");
		lbladdress = new JLabel("Address: ");
		lblemail = new JLabel("Email: ");
		lblcontactno = new JLabel("Contact No: ");
		
		txtfirstname = new JLabel("N/A");
		txtmiddlename = new JLabel("N/A");
		txtlastname = new JLabel("N/A");
		txtage = new JLabel("N/A");
		txtaddress = new JLabel("N/A");
		txtemail = new JLabel("N/A");
		txtcontactno = new JLabel("N/A");
		
		formMember.add(lblfirstname); formMember.add(txtfirstname);
		formMember.add(lblmiddlename); formMember.add(txtmiddlename);
		formMember.add(lbllastname); formMember.add(txtlastname);
		formMember.add(lblage); formMember.add(txtage);
		formMember.add(lbladdress); formMember.add(txtaddress);
		formMember.add(lblemail); formMember.add(txtemail);
		formMember.add(lblcontactno); formMember.add(txtcontactno);
		
		content.add(picturebox);
		formOuterPanel.add(formBook);
		formOuterPanel.add(formMember);
		content.add(formOuterPanel);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnReturn = new JButton("Return");
		btnCancel = new JButton("Cancel");
		
		btnReturn.setPreferredSize(new Dimension(100,30)); // button size here
		btnReturn.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnReturn.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnReturn.addActionListener(new ReturnBkTransactFormPopUpHandler());
		btnCancel.addActionListener(new ReturnBkTransactFormPopUpHandler());
		
		buttons.add(btnReturn);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class ReturnBkTransactFormPopUpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "RETURNBOOK");
				break;
			case "Return":
				System.out.println("Not implemented yet");
				//parentLayout.show(parentPanel, "BOOKTRANSACT");
				break;

			default:
				break;
			}
			
		}
		
	}

}
