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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditMemFormPopUp extends JPanel{
	
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
	
	JLabel lblFName;
	JLabel lblMName;
	JLabel lblLName;
	JLabel lblAddr;
	JLabel lblSex;
	JLabel lblAge;
	JLabel lblCNo;
	JLabel lblEmail;
	
	JTextField txtFName;
	JTextField txtMName;
	JTextField txtLName;
	JTextField txtAddr;
	JComboBox cbxSex;
	JTextField txtAge;
	JTextField txtCNo;
	JTextField txtEmail;
	
	String[] testSexCbxData = {"Male","Female"};
	
	// footer buttons
	JPanel buttons;
	JButton btnEdit;
	JButton btnCancel;
	
	public EditMemFormPopUp(JPanel parentPnl) {
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
		headertitle = new JLabel("Edit Member"); // title here
		headertitle.setFont(new Font("Arial", Font.BOLD, 30));
		headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		headerPanel.add(btnBack);
		headerPanel.add(Box.createRigidArea(new Dimension(50,0)));
		headerPanel.add(headertitle);
		
		btnBack.addActionListener(new EditMemFormHandler());
		
		this.add(headerPanel,BorderLayout.PAGE_START);
		
	}
	
	private void loadContentForm() {
		
		
		JPanel formOuterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		content = new JPanel();
		
		picturebox = new JPanel();
		//picturebox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//Image icon code here (to be replaced)
		ImageIcon image = new ImageIcon("E:\\Eclipse-workspace\\Library Management System\\src\\Member.png");
		JLabel imagelabel = new JLabel(image);
		picturebox.add(imagelabel);
		
		form = new JPanel(new GridLayout(10,2));
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
		
		txtFName = new JTextField("",15);
		txtMName = new JTextField("",15);
		txtLName = new JTextField("",15);
		txtAddr = new JTextField("",15);
		cbxSex = new JComboBox(testSexCbxData);
		txtAge = new JTextField("",15);
		txtCNo = new JTextField("",15);
		txtEmail = new JTextField("",15);
		
		form.add(lblFName); form.add(txtFName);
		form.add(lblMName); form.add(txtMName);
		form.add(lblLName); form.add(txtLName);
		form.add(lblAddr); form.add(txtAddr);
		form.add(lblSex); form.add(cbxSex);
		form.add(lblAge); form.add(txtAge);
		form.add(lblCNo); form.add(txtCNo);
		form.add(lblEmail); form.add(txtEmail);
		
		content.add(picturebox);
		formOuterPanel.add(form);
		content.add(formOuterPanel);
		this.add(content,BorderLayout.CENTER);
	}
	
	private void loadFooterButtons() {
		
		buttons = new JPanel();
		
		buttons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setBorder(new LineBorder(Color.BLACK));
		btnEdit = new JButton("Apply");
		btnCancel = new JButton("Cancel");
		
		btnEdit.setPreferredSize(new Dimension(80,30)); // button size here
		btnEdit.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnEdit.setContentAreaFilled(false);
		
		btnCancel.setPreferredSize(new Dimension(80,30)); // button size here
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15)); // set font here
		btnCancel.setContentAreaFilled(false);
		
		btnEdit.addActionListener(new EditMemFormHandler());
		btnCancel.addActionListener(new EditMemFormHandler());
		
		buttons.add(btnEdit);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));
		buttons.add(btnCancel);
		buttons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.add(buttons,BorderLayout.PAGE_END);
	}
	
	
	private class EditMemFormHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {

			switch (evt.getActionCommand()) {
			case "<":
				parentLayout.show(parentPanel, "EDITVIEWMEMBER");
				break;
			case "Cancel":
				parentLayout.show(parentPanel, "EDITVIEWMEMBER");
				break;
			case "Apply":
				System.out.println("Nothing for now...");
				break;

			default:
				break;
			}
			
		}
		
	}

}
