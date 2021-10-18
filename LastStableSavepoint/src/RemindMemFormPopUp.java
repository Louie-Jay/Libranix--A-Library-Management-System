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
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RemindMemFormPopUp extends JPanel{
	
	//parent properties
	JPanel parentPanel;
	CardLayout parentLayout;
	
	//header
	JPanel headerPanel;
	JButton btnBack;
	JLabel headertitle;
	
	//content
	JPanel content;
	
	JPanel picturebox;
	JPanel form;
	JEditorPane txtAreaMessage;
	
	JLabel lblFName;
	JLabel lblMName;
	JLabel lblLName;
	JLabel lblAddr;
	JLabel lblSex;
	JLabel lblAge;
	JLabel lblCNo;
	JLabel lblEmail;
	JLabel lblBooks;
	
	JLabel txtFName;
	JLabel txtMName;
	JLabel txtLName;
	JLabel txtAddr;
	JLabel cbxSex;
	JLabel txtAge;
	JLabel txtCNo;
	JLabel txtEmail;
	JLabel txtBooks;
	
	// footer buttons
	JPanel buttons;
	JCheckBox chkSMS;
	JCheckBox chkEmail;
	JButton btnSend;
	JButton btnCancel;
	
	public RemindMemFormPopUp(JPanel parentPnl) {
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
		headertitle = new JLabel("Remind Member"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new RemindMemFormCardHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel(new GridLayout(2,0));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Member.png");
		JLabel imagelabel = new JLabel(image);
		picturebox.add(imagelabel);
		
		form = new JPanel(new GridLayout(10,2,0,10));
		//form.setBorder(BorderFactory.createLineBorder(Color.RED));
		content.setLayout(new GridLayout(0,2));

		lblFName = new JLabel("First Name: ");
		lblMName = new JLabel("Middle Name: ");
		lblLName = new JLabel("Last Name: ");
		lblAddr = new JLabel("Address: ");
		lblSex = new JLabel("Sex: ");
		lblAge = new JLabel("Age: ");
		lblCNo = new JLabel("Contact Number: ");
		lblEmail = new JLabel("Email: ");
		lblBooks = new JLabel("Borrowed Books: ");
		
		txtFName = new JLabel("N/A");
		txtMName = new JLabel("N/A");
		txtLName = new JLabel("N/A");
		txtAddr = new JLabel("N/A");
		cbxSex = new JLabel("N/A");
		txtAge = new JLabel("N/A");
		txtCNo = new JLabel("N/A");
		txtEmail = new JLabel("N/A");
		txtBooks = new JLabel("N/A, N/A, N/A");
		
		form.add(lblFName); form.add(txtFName);
		form.add(lblMName); form.add(txtMName);
		form.add(lblLName); form.add(txtLName);
		form.add(lblAddr); form.add(txtAddr);
		form.add(lblSex); form.add(cbxSex);
		form.add(lblAge); form.add(txtAge);
		form.add(lblCNo); form.add(txtCNo);
		form.add(lblEmail); form.add(txtEmail);
		form.add(lblBooks); form.add(txtBooks);
		
		txtAreaMessage = new JEditorPane();
		
		JScrollPane spMessage = new JScrollPane(txtAreaMessage);
		spMessage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtAreaMessage.setText("Hi,"+txtFName.getText()+". Sorry to interrupt but the alloted time "
				+ "to return the book is done. \nPlease return the book to the library thank you.");
		spMessage.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Message:"));
		
		content.add(picturebox);
		formOuterPanel.add(form);
		formOuterPanel.add(spMessage);
		content.add(formOuterPanel);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		chkSMS = new JCheckBox("SMS");
		chkEmail = new JCheckBox("Email");
		btnSend = new JButton("Send");
		btnCancel = new JButton("Cancel");
		
		btnSend.setPreferredSize(new Dimension(80,30)); // button size here
		btnSend.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnSend.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnSend.addActionListener(new RemindMemFormCardHandler());
		btnCancel.addActionListener(new RemindMemFormCardHandler());
		buttons.add(chkSMS);
		buttons.add(chkEmail);
		buttons.add(btnSend);
		buttons.add(btnCancel);
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class RemindMemFormCardHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "REMINDVIEWMEMBER");
				break;
			case "Remind":
				System.out.println("Nothing for now...");
				break;

			default:
				break;
			}
			
		}
		
	}

}
